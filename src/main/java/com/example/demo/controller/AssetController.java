package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;

@Controller
@RequestMapping("/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    /**
     * 資産一覧
     */
    @GetMapping
    public String assetList(Model model) {

        model.addAttribute(
                "assets",
                assetService.findAll());

        return "asset-list";
    }

    /**
     * 資産詳細
     */
    @GetMapping("/{id}")
    public String assetDetail(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "asset",
                assetService.findById(id));

        return "asset-detail";
    }

    /**
     * 資産登録画面
     */
    @GetMapping("/new")
    public String showRegisterForm(Model model) {

        model.addAttribute(
                "asset",
                new Asset());

        return "asset-create";
    }

    /**
     * 資産登録処理
     */
    @PostMapping("/new")
    public String registerAsset(
            @ModelAttribute Asset asset) {

        assetService.create(asset);

        return "redirect:/assets";
    }

    /**
     * 編集画面
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "asset",
                assetService.findById(id));

        return "asset-edit";
    }

    /**
     * 更新処理
     */
    @PostMapping("/edit/{id}")
    public String updateAsset(
            @PathVariable Long id,
            @ModelAttribute Asset asset) {

        assetService.update(id, asset);

        return "redirect:/assets";
    }

    /**
     * 削除処理
     */
    @GetMapping("/delete/{id}")
    public String deleteAsset(
            @PathVariable Long id) {

        assetService.delete(id);

        return "redirect:/assets";
    }
}