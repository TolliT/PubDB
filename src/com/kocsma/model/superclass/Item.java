package com.kocsma.model.superclass;

import com.kocsma.model.GetterFunctionName;

public abstract class Item {
    // TODO: kicserelni az aktualis adatbazisra
    public static final String database = "placeholder.csv";

    @GetterFunctionName(name="getID")
    private Integer id;
    @GetterFunctionName(name="getName")
    private String name;

    public Item(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getID(){
        return id;
    }

    public String getName(){
        return name;
    }
}
