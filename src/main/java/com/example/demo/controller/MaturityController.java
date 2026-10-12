package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.AssetService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MaturityController {

    @Autowired
    private AssetService assetService;

    @GetMapping("/maturity")
    public String maturity(
            Model model,
            HttpSession session) {

        if (session.getAttribute("loginUser") == null) {
            return "redirect:/login";
        }

        model.addAttribute(
                "assets",
                assetService.findAll());

        return "maturity";
    }
}