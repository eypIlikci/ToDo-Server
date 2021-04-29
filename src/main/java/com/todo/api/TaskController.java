package com.todo.api;

import com.todo.dto.CreateTaskDto;
import com.todo.dto.TaskDto;
import com.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/")
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "tasks")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getTasks(){
        return ResponseEntity.ok(taskService.findTasksByUser());
    }

    @PostMapping(value = "tasks")
    public ResponseEntity<?> insert(@RequestBody CreateTaskDto taskDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(taskDto));
    }

    @DeleteMapping(value = "tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(value = "id")Long id){
        taskService.deleteById(id);
    }

    @PutMapping("tasks")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(@RequestBody TaskDto taskDto){
          taskService.update(taskDto);
          return ResponseEntity.ok(taskDto);
    }



}
