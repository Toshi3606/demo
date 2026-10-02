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

    public List<Asset> findAll() {
        return assetRepository.findAll();
    }

    public Asset findById(Long id) {

        return assetRepository.findById(id)
                .orElse(null);
    }

    public Asset create(Asset asset) {

        asset.setCreatedAt(LocalDateTime.now());
        asset.setUpdatedAt(LocalDateTime.now());

        return assetRepository.save(asset);
    }

    public Asset update(Long id, Asset asset) {

        Asset currentAsset =
                assetRepository.findById(id)
                        .orElse(null);

        if (currentAsset == null) {
            return null;
        }

        currentAsset.setAssetName(asset.getAssetName());
        currentAsset.setAssetType(asset.getAssetType());
        currentAsset.setAmount(asset.getAmount());
        currentAsset.setDepositDate(asset.getDepositDate());
        currentAsset.setMaturityDate(asset.getMaturityDate());
        currentAsset.setInterestRate(asset.getInterestRate());

        currentAsset.setUpdatedAt(LocalDateTime.now());

        return assetRepository.save(currentAsset);
    }

    public void delete(Long id) {
        assetRepository.deleteById(id);
    }
}