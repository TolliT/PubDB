package com.kocsma.controller;

import com.kocsma.model.Drink;
import com.kocsma.model.Food;
import com.kocsma.model.superclass.Item;

import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Nyugtát hoz létre csw fileba, kiírja a választott italokat/ételeket.
 *
 */
public class Invoice {
    public static void CreateInvoice(ArrayList<Drink> drinkList, ArrayList<Food> foodList){
        //bekéri a létrehozott kistákat és kiíratja az adatbázisba

        try {
            // Delete file contents
            FileWriter f = new FileWriter(Item.invoice, false);
            f.close();

            for (Drink drink : drinkList) {
                drink.saveData();

            }


            for (Food food : foodList) {
                food.saveData();

            }
        }catch (Exception ex) {
            // TODO: hibakezelo fuggveny
            ex.printStackTrace();
        }

    }
}
