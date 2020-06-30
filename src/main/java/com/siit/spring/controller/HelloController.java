package com.siit.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/user")
    public String hello(Model model) {

        model.addAttribute("username", "Johnny");
        return "index";
    }

    @PostMapping
    public String getAddressPost(Model model, HttpServletRequest request) {
        var address = (String) request.getParameter("address");
        System.out.println("address parameter = " + address);

        model.addAttribute("address", address);
        return "details";
    }

    @GetMapping
    public String getAddressGet(Model model, HttpServletRequest request) {
        var address = (String) request.getParameter("address");
        System.out.println("address parameter = " + address);

        model.addAttribute("address", address);
        return "details";
    }
}
