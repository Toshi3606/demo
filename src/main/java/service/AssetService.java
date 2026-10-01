package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Asset;
import com.example.demo.repository.AssetRepository;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    // 一覧取得
    public List<Asset> findAll() {
        return assetRepository.findAll();
    }

    // 1件取得
    public Asset findById(Long id) {
        return assetRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("資産が見つかりません"));
    }

    // 新規登録
    public Asset create(Asset asset) {

    asset.setCreatedAt(LocalDateTime.now());
    asset.setUpdatedAt(LocalDateTime.now());

        System.out.println("createdAt  = " + asset.getCreatedAt());
    System.out.println("updatedAt  = " + asset.getUpdatedAt());

    return assetRepository.save(asset);
}

    // 更新
    public Asset update(Long id, Asset request) {

        Asset asset = findById(id);

        asset.setAssetName(request.getAssetName());
        asset.setAssetType(request.getAssetType());
        asset.setAmount(request.getAmount());
        asset.setDepositDate(request.getDepositDate());
        asset.setMaturityDate(request.getMaturityDate());
        asset.setInterestRate(request.getInterestRate());

        asset.setUpdatedAt(LocalDateTime.now());

        return assetRepository.save(asset);
    }

    // 削除
    public void delete(Long id) {
        assetRepository.deleteById(id);
    }
}