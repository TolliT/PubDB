package com.kocsma.model;

import com.kocsma.model.superclass.Item;
import com.kocsma.model.enumerator.DrinkType;

import java.util.HashMap;

public class Drink extends Item {
    public static final String database = "./resources/drinkDB.csv";

    public final Float MAX_A_PERCENT = 100.0f;
    public final Float MIN_A_PERCENT = 0.0f;

    public final Float MIN_D_SIZE = 0.02f;
    public final Float MAX_D_SIZE = 1.00f;

    @GetterFunctionName(name="getDrinkType")
    private DrinkType drinkType;
    @GetterFunctionName(name="getAlcoholPercentage")
    private Float alcoholPercentage;
    @GetterFunctionName(name="getDrinkSizes")
    private Float[] sizes; // literben TODO: normalisabb valtozonev maybe??
    //private HashMap<Float, Integer> prices; // urmertek - ar parokat tarolja el

    public Drink(Integer id, String name, DrinkType drinkType, Float alcoholPercentage, Float[] sizes){
        super(id, name);
        // TODO: tesztelni az enum letezeset
        this.drinkType = drinkType;

        this.alcoholPercentage = alcoholPercentage;
        // Alkoholszazalek limitalasa
        if(this.alcoholPercentage > MAX_A_PERCENT) this.alcoholPercentage = MAX_A_PERCENT;
        else if(this.alcoholPercentage <  MIN_A_PERCENT) this.alcoholPercentage = MIN_A_PERCENT;

        this.sizes = sizes;
        // urmertek limitalasa
        for(int i = 0; i < sizes.length; i++) {
            if (this.sizes[i] > MAX_D_SIZE) this.sizes[i] = MAX_D_SIZE;
            else if (this.sizes[i] < MIN_D_SIZE) this.sizes[i] = MIN_D_SIZE;
        }
        //this.prices = prices;
    }

    public DrinkType getDrinkType(){
        return this.drinkType;
    }

    public Float getAlcoholPercentage(){
        return this.alcoholPercentage;
    }

    public Float[] getDrinkSizes(){
        return this.sizes;
    }

    public void saveData(){
        FileIO<Drink> f = new FileIO<Drink>();
        f.saveData(this);
    }

    public String[] readData(){
        FileIO<Drink> f = new FileIO<Drink>();
        //f.readData(this);
        return  f.readData(this);
    }

    /*
    public Integer getPrice(Float size){
        // returneli a valuet vagy nullat ha nem letezik a kulcs
        return this.prices.getOrDefault(size, 0);
    }

    public HashMap<Float, Integer> getPriceList(){
        return this.prices;
    }
    */
}