package com.cybertek.controller;

import com.cybertek.dto.TaskDTO;
import com.cybertek.enums.Status;
import com.cybertek.service.ProjectService;
import com.cybertek.service.TaskService;
import com.cybertek.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @GetMapping("/create")
    public String createTask(Model model){

        model.addAttribute("task",new TaskDTO());
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("employees",userService.findEmployees());
        model.addAttribute("tasks",taskService.findAll());
        return "/task/create";
    }

    @PostMapping("/create")
    public String insertTask(Model model, TaskDTO taskDTO){

        taskDTO.setTaskStatus(Status.OPEN);
        taskDTO.setAssignDate(LocalDate.now());
        taskDTO.setId(UUID.randomUUID().getMostSignificantBits());
        System.out.println("Auto Generated ID :  "+ taskDTO.getId());
        taskService.save(taskDTO);

        return "redirect:/task/create";
    }


    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long taskID){


        taskService.deleteById(taskID);

        return "redirect:/task/create";
    }

    /*
    This method will link with the Update button in the view(Task/create.html) like bellow :
    th:href="@{/task/update/{id} (id=${task.id})}
     */
    @GetMapping("/update/{id}")
    public String editTask(@PathVariable("id") Long id, Model model){

        model.addAttribute("task",taskService.findById(id));
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("employees",userService.findEmployees());
        model.addAttribute("tasks",taskService.findAll());

        return "task/update";
    }

    /*
     This method working with Save Bottom in the View,
     and we can call it in the Form action like bellow :
     th:action="@{/task/update/{id} (id=${task.getId()})}"
     */
    @PostMapping("/update/{id}")
    public String updateTask(Long id,TaskDTO task,  Model model){

        taskService.update(task);

        return "redirect:/task/create";
    }

}
