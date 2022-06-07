package com.kocsma.model.superclass;

import com.kocsma.model.GetterFunctionName;

public abstract class Item {
    // TODO: kicserelni az aktualis adatbazisra
    public static final String database = "placeholder.csv";

    @GetterFunctionName(name="getName")
    private String name;

    public Item(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
