package com.eisenhower.matrix.controller;

import com.eisenhower.matrix.model.Task;
import com.eisenhower.matrix.serviceImpl.TaskServiceImpl;
import com.eisenhower.matrix.services.ITaskService;
import com.eisenhower.matrix.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/matrix")
public class GraphController {
    @Autowired
    private ITaskService taskService;

    @GetMapping("/list-items")
    public String getTaskItems(Model theModel){
        theModel.addAttribute("taskList", taskService.findAll());
        return Constants.EISENHOWER_PAGE;
    }
}
