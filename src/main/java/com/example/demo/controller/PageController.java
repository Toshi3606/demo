package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;

@Controller
public class PageController {

    private final AssetService assetService;

    public PageController(AssetService assetService) {
        this.assetService = assetService;
    }

    // 一覧画面
    @GetMapping("/assets-page")
    public String index(Model model) {

        List<Asset> assets = assetService.findAll();

        model.addAttribute("assets", assets);

        return "asset-list";
    }

    // 詳細画面
    @GetMapping("/asset/{id}")
    public String detail(
            @PathVariable Long id,
            Model model) {

        Asset asset = assetService.findById(id);

        model.addAttribute("asset", asset);

        return "asset-detail";
    }

    // 編集画面
    @GetMapping("/asset/edit/{id}")
    public String edit(
            @PathVariable Long id,
            Model model) {

        Asset asset = assetService.findById(id);

        model.addAttribute("asset", asset);

        return "asset-edit";
    }

    // 更新処理
    @PostMapping("/asset/update/{id}")
    public String update(
            @PathVariable Long id,
            @ModelAttribute Asset asset) {

        assetService.update(id, asset);

        return "redirect:/";
    }

    // 新規登録画面
    @GetMapping("/asset/new")
    public String createForm(Model model) {

        model.addAttribute("asset", new Asset());

        return "asset-create";
    }

    // 登録処理
    @PostMapping("/asset/create")
    public String create(
            @ModelAttribute Asset asset) {

        assetService.create(asset);

        return "redirect:/";
    }
    
    // 削除処理
@PostMapping("/asset/delete/{id}")
public String delete(@PathVariable Long id) {

    assetService.delete(id);

    return "redirect:/";
}
}



