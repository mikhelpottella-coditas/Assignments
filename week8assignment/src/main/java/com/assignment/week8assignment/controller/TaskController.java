package com.assignment.week8assignment.controller;

import com.assignment.week8assignment.dto.TaskRequestDto;
import com.assignment.week8assignment.entity.Priority;
import com.assignment.week8assignment.entity.Status;
import com.assignment.week8assignment.entity.Task;
import com.assignment.week8assignment.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }



    //    POST /tasks
    @PostMapping()
    public String createTask(@Valid @RequestBody TaskRequestDto taskDto){
        return  taskService.createTask(taskDto);
    }

//   Get All Tasks
    @GetMapping()
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }


    // Get Task By ID

    @GetMapping("{id}")
    public Task getTaskById(@PathVariable Long id){
        return  taskService.getById(id);
    }


    // update task status
    @PatchMapping("{id}/{status}")
    public void updateStatusById(@PathVariable Long id, @PathVariable Status status){
        taskService.updateStatusById(id,status);
    }

    // update the priority
    @PatchMapping("{id}/{priority}")
    public void  updatePriorityById(@PathVariable Long id, @PathVariable Priority priority){
        taskService.updatePriorityById(id,priority);
    }


    //7️⃣Get Tasks by Status
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@Valid @PathVariable Status status){
        return  taskService.getTaskByStatus(status);
    }

// delete task by id

    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable Long id){
        taskService.deleteTaskById(id);
    }

//    9️⃣Search Tasks by Priority
    @GetMapping("/byPriority/{priority}")
    public List<Task> getTasksByPriority(@PathVariable Priority priority){
        return taskService.getByPriority(priority);
    }



}
