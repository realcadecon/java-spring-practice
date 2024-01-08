package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String submitForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormV2")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        String name = request.getParameter("studentName");
        name = name.toUpperCase();

        model.addAttribute("message", "Yo " + name);

        return "helloworld";
    }

    @PostMapping("/processFormV3")
    public String letsShoutDude(@RequestParam("studentName") String name, Model model) {

        name = name.toUpperCase();
        model.addAttribute("message", "Yo " + name + ", this is a message from V3.");

        return "helloworld";
    }
}
