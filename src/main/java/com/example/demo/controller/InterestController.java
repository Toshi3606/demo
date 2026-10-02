package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.AssetService;

@Controller
public class InterestController {

    @Autowired
    private AssetService assetService;

    @GetMapping("/interest")
    public String interest(Model model) {

        model.addAttribute(
                "assets",
                assetService.findAll());

        return "interest";
    }
}