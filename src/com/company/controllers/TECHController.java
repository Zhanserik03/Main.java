package com.company.controllers;


import com.company.entities.TECH;
import com.company.repositories.interfaces.ITECHRepositories;



import java.util.List;

public class TECHController {
    private final ITECHRepositories repo;

    public TECHController(ITECHRepositories repo){
    this.repo=repo;
    }

public String getTech(int ID){
    TECH TECH = repo.getTECH(ID);
        return (TECH == null ? "Laptop was not found!" : TECH.toString());
}
public String getAllTechs(){
    List <TECH> TECH = repo.getAllTECH();
    return TECH.toString();
}
    public String getTechByName(String name){
        List<TECH> TECH = repo.getTECHByNAME(name);

        return (TECH.size() == 0 ? "Laptop was not found!" : TECH.toString());
    }
    public String removeTechByID(int ID){
        boolean check = repo.removeTECHByID(ID);

        return (check ? "TECH device was removed!" : "TECH device by this ID was not found!");
    }
    public String getTechByPrice(int price1, int price2){
        List <TECH> TECH = repo.getTechByPrice(price1,price2);

        return TECH.toString();
    }
}

