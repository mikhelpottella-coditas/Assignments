package com.assignment.week8assignment.service;

import com.assignment.week8assignment.dao.TaskRepository;
import com.assignment.week8assignment.dto.TaskRequestDto;
import com.assignment.week8assignment.entity.Priority;
import com.assignment.week8assignment.entity.Status;
import com.assignment.week8assignment.entity.Task;
import com.assignment.week8assignment.exception.ExceptionHandle;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public String createTask(TaskRequestDto taskDto) {

        Task task = new Task();
        task.setEmployeeName(taskDto.getEmployeeName());
        task.setEmployeeEmail(taskDto.getEmployeeEmail());
        task.setTaskDescription(taskDto.getTaskDescription());
        task.setTaskTitle(taskDto.getTaskTitle());
        task.setPriority(taskDto.getPriority());
        task.setCreatedDate(LocalDateTime.now());
        taskRepository.save(task);
        return "task created";
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getById(Long id) {
        return taskRepository.findById(id).orElseThrow(()->new ExceptionHandle(HttpStatus.NOT_FOUND,"task not found the the given ID"));
    }

    @Transactional
    public void updateStatusById(Long id, Status status) {
        Task task =  getById(id);
        task.setStatus(status);
        taskRepository.save(task);
    }

    @Transactional
    public void updatePriorityById(Long id, Priority priority) {
        Task task =  getById(id);
        task.setPriority(priority);
        taskRepository.save(task);
    }

    public List<Task> getTaskByStatus(Status status) {
        return taskRepository.findByStatus(status);
    }

    public void deleteTaskById(Long id) {
        Task task = getById(id);
        taskRepository.delete(task);
    }

    public List<Task> getByPriority(Priority priority) {
        return taskRepository.findByPriority(priority);
    }
}
