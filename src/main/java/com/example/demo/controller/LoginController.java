package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String authenticate(
            @RequestParam String loginId,
            @RequestParam String password,
            Model model) {

        User user =
                loginService.authenticate(
                        loginId,
                        password);

        if (user != null) {
            return "redirect:/top";
        }

        model.addAttribute(
                "errorMessage",
                "ログインIDまたはパスワードが正しくありません");

        return "login";
    }
}