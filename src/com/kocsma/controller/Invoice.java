package com.kocsma.controller;

import com.kocsma.model.Drink;
import com.kocsma.model.Food;
import com.kocsma.model.superclass.Item;

import java.io.FileWriter;
import java.util.ArrayList;

public class Invoice {
    public static void CreateInvoice(ArrayList<Drink> drinkList, ArrayList<Food> foodList){
        try {
            // Delete file contents
            FileWriter f = new FileWriter(Item.invoice, false);
            f.close();

            for (Drink drink : drinkList) {
                drink.saveData();
                System.out.println(drink.getName());
            }


            for (Food food : foodList) {
                food.saveData();
                System.out.println(food.getName());
            }
        }catch (Exception ex) {
            // TODO: hibakezelo fuggveny
            ex.printStackTrace();
        }

    }
}
