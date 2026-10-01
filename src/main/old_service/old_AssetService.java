package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Asset;
import com.example.demo.repository.AssetRepository;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public List<Asset> findAll() {
        return assetRepository.findAll();
    }

    public Asset findById(Long id) {
        return assetRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("資産が見つかりません"));
    }

    public Asset create(Asset asset) {
        return assetRepository.save(asset);
    }

    public Asset update(Long id, Asset request) {

        Asset asset = findById(id);

        asset.setAssetName(request.getAssetName());
        asset.setAssetType(request.getAssetType());
        asset.setAmount(request.getAmount());

        return assetRepository.save(asset);
    }

    public void delete(Long id) {
        assetRepository.deleteById(id);
    }
}