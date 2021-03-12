package com.company.entities;

import java.sql.Date;


public class TECH {
    private int ID;

    private String NAME;
    private String MANUFACTURER;
    private Date DATE;
    private String CHARACTERS;
    private int PRICE;

    public TECH(){

    }

    public TECH(String NAME, String MANUFACTURER, Date DATE, String CHARACTERS, int PRICE){
        setNAME(NAME);
        setMANUFACTURER(MANUFACTURER);
        setDATE(DATE);
        setCHARACTERS(CHARACTERS);
        setPRICE(PRICE);
    }
    public TECH(int ID, String NAME, String MANUFACTURER, Date DATE, String CHARACTERS, int PRICE) {
        setID(ID);
        setNAME(NAME);
        setMANUFACTURER(MANUFACTURER);
        setDATE(DATE);
        setCHARACTERS(CHARACTERS);
        setPRICE(PRICE);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getMANUFACTURER() {
        return MANUFACTURER;
    }

    public void setMANUFACTURER(String MANUFACTURER) {
        this.MANUFACTURER = MANUFACTURER;
    }

    public Date getDATE() {
        return DATE;
    }

    public void setDATE(Date DATE) {
        this.DATE = DATE;
    }

    public String getCHARACTERS() {
        return CHARACTERS;
    }

    public void setCHARACTERS(String CHARACTERS) {
        this.CHARACTERS = CHARACTERS;
    }

    public int getPRICE() {
        return PRICE;
    }

    public void setPRICE(int PRICE) {
        this.PRICE = PRICE;
    }

    @Override
    public String toString() {
        return "\nTechs{" +
                "ID=" + ID +
                ", name='" + NAME + '\'' +
                ", price=" + PRICE +
                ", date=" + DATE +
                ", manufacturer='" + MANUFACTURER + '\'' +
                '}' ;
    }
}
