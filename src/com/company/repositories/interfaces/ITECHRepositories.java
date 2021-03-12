package com.company.repositories.interfaces;

import com.company.entities.TECH;

import java.util.List;

public interface ITECHRepositories {

    public List<TECH> getTechByPrice(int price1, int price2);
    TECH getTECH(int ID);
    List<TECH> getAllTECH();
    public List<TECH> getTECHByNAME(String NAME);
    public boolean removeTECHByID(int ID);
}
