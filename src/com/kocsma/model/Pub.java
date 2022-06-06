package com.kocsma.model;

import java.time.LocalTime;

public class Pub {
    public static final String database = "./resources/pubDB.csv";

    @GetterFunctionName(name="getName")
    private String name;
    @GetterFunctionName(name="getOpenFrom")
    private LocalTime openFrom;
    @GetterFunctionName(name="getOpenUntil")
    private LocalTime openUntil;

    public Pub(String name, LocalTime openFrom, LocalTime openUntill) {
        this.name = name;
        this.openFrom = openFrom;
        this.openUntil = openUntill;
    }

    public String getName(){
        return this.name;
    }

    public LocalTime getOpenFrom(){
        return this.openFrom;
    }

    public LocalTime getOpenUntill(){
        return this.openUntil;
    }

    // teszteleshez
    // TODO: hibakezeles
    public void setOpenTime(LocalTime oTime, LocalTime cTime){
        this.openFrom = oTime;
        this.openUntil = cTime;
    }

    public void saveData(){
        FileIO<Pub> f = new FileIO<Pub>();
        f.saveData(this);
    }

    public void readData(){
        FileIO<Pub> f = new FileIO<Pub>();
        f.readData(this);
    }
}
