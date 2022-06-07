package com.kocsma.controller;

import com.kocsma.model.Drink;
import com.kocsma.model.Food;
import com.kocsma.model.enumerator.DrinkType;
import com.opencsv.CSVReader;

import java.io.FileReader;

public class FileInit {
    public static Drink[] loadDrinkData() {
        try {
            int index = 0;
            FileReader f = new FileReader(Drink.database);
            CSVReader r = new CSVReader(f);

            while(r.readNext() != null){
                index++;
            }

            Drink[] drinkList = new Drink[index];
            index = 0;

            f.close();
            r.close();

            FileReader file = new FileReader(Drink.database);
            CSVReader reader = new CSVReader(file);

            String[] record;

            while((record = reader.readNext()) != null){
                drinkList[index] = new Drink(record[0], DrinkType.valueOf(record[1]), Float.valueOf(record[2]), Integer.valueOf(record[3]));
                index++;
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

    public static Food[] loadFoodData(){
        try {
            int index = 0;
            FileReader f = new FileReader(Food.database);
            CSVReader r = new CSVReader(f);

            while(r.readNext() != null){
                index++;
            }

            Food[] foodList = new Food[index];
            index = 0;

            f.close();
            r.close();

            FileReader file = new FileReader(Food.database);
            CSVReader reader = new CSVReader(file);

            String[] record;

            while((record = reader.readNext()) != null){
                foodList[index] = new Food(record[0], Integer.valueOf(record[1]), Integer.valueOf(record[2]));
                index++;
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