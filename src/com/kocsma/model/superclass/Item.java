package com.kocsma.model.superclass;

import com.kocsma.model.GetterFunctionName;

public abstract class Item {
    public static final String invoice = "./resources/invoice.csv";
    // TODO: kicserelni az aktualis adatbazisra

    @GetterFunctionName(name="getName")
    private String name;
    @GetterFunctionName(name="getPrice")
    private Integer price;

    public Item(String name, Integer price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public Integer getPrice(){
        return price;
    }
}
