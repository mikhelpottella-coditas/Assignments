package com.evaluation.week8evaluationtask.controller;

import com.evaluation.week8evaluationtask.annotations.ManagerOnly;
import com.evaluation.week8evaluationtask.dto.CreateTaskDto;
import com.evaluation.week8evaluationtask.entity.Task;
import com.evaluation.week8evaluationtask.enums.Roles;
import com.evaluation.week8evaluationtask.enums.Status;
import com.evaluation.week8evaluationtask.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("task")
@ManagerOnly
public class AssignTaskController {

    private final TaskService taskService;

    @PostMapping("/createTask")
    public Task createTask(@RequestBody CreateTaskDto task) {
        return taskService.createTask(task);
    }

    @PatchMapping("/UpdateTaskStatusById/{id}")
    public Task updateTaskStatus(@RequestBody Status status, @PathVariable Long id) {
        return taskService.updateTaskStatusById(status,id);
    }

    @DeleteMapping("deleteTaskById/{id}")
    public String deleteTaskById(@PathVariable Long id) {
        taskService.deleteById(id);
        return "task deleted successfully";

    }

}
