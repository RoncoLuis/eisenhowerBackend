package com.eisenhower.matrix.controller;

import com.eisenhower.matrix.services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class RestTaskController {
    @Autowired
    private ITaskService taskService;
//    @PostMapping("/delete/{id}")
//    public String deleteTask(@PathVariable("id") Integer id) {
//        return taskService.deleteTask(id);
//    }
}
