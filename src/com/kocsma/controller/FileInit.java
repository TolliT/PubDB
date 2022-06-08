package com.kocsma.controller;

import com.kocsma.model.Drink;
import com.kocsma.model.Food;
import com.kocsma.model.enumerator.DrinkType;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.sql.Array;
import java.util.ArrayList;

public class FileInit {
    public static ArrayList<Drink> loadDrinkData() {
        try {

            ArrayList<Drink> drinkList = new ArrayList<>();

            FileReader file = new FileReader(Drink.database);
            CSVReader reader = new CSVReader(file);

            String[] record;

            while((record = reader.readNext()) != null){
                drinkList.add(new Drink(record[0], DrinkType.valueOf(record[1]), Float.valueOf(record[2]), Integer.valueOf(record[3])));
            }

            reader.close();
            file.close();

            return drinkList;
        } catch (Exception ex) {
            // TODO: hibakezelo fuggveny
            ex.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Food> loadFoodData(){
        try {

            ArrayList<Food> foodList = new ArrayList<>();

            FileReader file = new FileReader(Food.database);
            CSVReader reader = new CSVReader(file);

            String[] record;

            while((record = reader.readNext()) != null){
                foodList.add( new Food(record[0], Integer.valueOf(record[1]), Integer.valueOf(record[2])));

            }

            reader.close();
            file.close();

            return foodList;
        } catch (Exception ex) {
            // TODO: hibakezelo fuggveny
            ex.printStackTrace();
        }
        return null;
    }
}