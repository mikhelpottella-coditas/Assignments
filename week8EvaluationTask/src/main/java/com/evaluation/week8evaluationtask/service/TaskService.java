package com.evaluation.week8evaluationtask.service;

import com.evaluation.week8evaluationtask.dao.TaskDao;
import com.evaluation.week8evaluationtask.dto.CreateTaskDto;
import com.evaluation.week8evaluationtask.entity.Employee;
import com.evaluation.week8evaluationtask.entity.Task;
import com.evaluation.week8evaluationtask.enums.Priority;
import com.evaluation.week8evaluationtask.enums.Status;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskService {

    private final TaskDao taskDao;
    private final EmployeeService employeeService;

    public Task createTask(CreateTaskDto createTaskDto) {

        Employee employee = employeeService.getById(createTaskDto.getEmployeeId());

        Task task = new Task();

        task.setTitle(createTaskDto.getTitle());
        task.setDescription(createTaskDto.getDescription());
        task.setEmployee(employee);
        task.setStatus(Status.valueOf(createTaskDto.getStatus()));
        task.setPriority(Priority.valueOf(createTaskDto.getPriority()));
        return taskDao.save(task);
    }

    public Task getTaskById(Long id) {
        return taskDao.findById(id).orElseThrow(()-> new RuntimeException("task not found with the given id"));
    }

    public Task updateTaskStatusById(Status status, Long id) {
        Task task = getTaskById(id);

        if(task.getStatus() == status) throw new RuntimeException("task is up to date with status");

        if(task.getStatus() == Status.TODO && status == Status.IN_PROGRESS) task.setStatus(Status.IN_PROGRESS);
        else if(task.getStatus() == Status.IN_PROGRESS && status == Status.DONE) task.setStatus(Status.DONE);
        else throw new RuntimeException("task is up to date with status");

        return taskDao.save(task);

    }

    public void deleteById(Long id) {
        Task task = getTaskById(id);
        taskDao.delete(task);
    }
}
