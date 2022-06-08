package com.kocsma.model;

import com.kocsma.controller.FileIO;
import com.kocsma.model.superclass.Item;

/**
 *
 */

public class Food extends Item {
    public static final String database = "./resources/foodDB.csv";

    @GetterFunctionName(name="getCalories")
    public Integer calories;

    public Food(String name, Integer calories, Integer price){
        super(name, price);

        this.calories = calories;

        if(this.calories < 0) this.calories = 0;
    }

    public Integer getCalories(){
        return this.calories;
    }

    public void saveData(){
        FileIO<Food> f = new FileIO<>();
        f.saveData(this);
    }
}