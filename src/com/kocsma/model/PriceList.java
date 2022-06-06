package com.kocsma.model;

public class PriceList {
    // TODO: kicserelni az aktualis adatbazisra / kulon DB minden kocsmanak??
    // public static final String database = "testPricelist.xml";
    public static final String database = "./resources/priceDB.csv";

    @GetterFunctionName(name="getPub")
    private Pub pub;
    @GetterFunctionName(name="getDrink")
    private Drink drink;

    @GetterFunctionName(name="getDrinkSize")
    private Float drinkSize;
    @GetterFunctionName(name="getPrice")
    private Integer price;


    public PriceList(Pub pub, Drink drink, Float drinkSize, Integer price) {
        this.pub = pub;
        this.drink = drink;
        this.drinkSize = drinkSize;
        this.price = price;
    }


    public Pub getPub() {
        return pub;
    }

    public Drink getDrink() {
        return drink;
    }

    public Float getDrinkSize() {
        return drinkSize;
    }

    public Integer getPrice() {
        return price;
    }

    public void saveData(){
        FileIO<PriceList> f = new FileIO<PriceList>();
        f.saveData(this);
    }

    public void readData(){
        FileIO<PriceList> f = new FileIO<PriceList>();
        f.readData(this);
    }
}
