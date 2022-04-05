package com.cg.apps.tataskyapp.service;

import com.cg.apps.tataskyapp.entities.Pack;

import java.util.List;

public interface PackService {
    void addPack(Pack pack);

    void removePack(Pack pack);

    Pack update(Pack pack);

    Pack findPackById(Long packId);

    List<Pack> findPacksGreaterThanAmount(double amount);

    List<Pack> findPacksInAscendingOrderByCost();

    List<Pack> findPacksInAscendingOrderByDaysValidity();

    List<Pack> popularPacks();

    void deleteByPackId(Long packId);
}
