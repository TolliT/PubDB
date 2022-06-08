package com.kocsma;

import com.kocsma.controller.FileInit;
import com.kocsma.model.Drink;
import com.kocsma.model.Food;
import com.kocsma.model.enumerator.DrinkType;
import com.kocsma.view.UserInterface;


import java.util.ArrayList;


import static com.kocsma.controller.DrinkChooser.drinkChooser;


public class Main {



    public static void main(String[] args) {
        // TESTING


        Drink testDrink = new Drink("Teszt Ital2", DrinkType.BEER, 0.50f, 1000);
        System.out.println(testDrink.getPrice());
        drinkChooser();

        //screen.ShowDrinks(drinkList);
        //screen.ShowDrinks(drinkList);


       /* assert drinkCopy!=null;
        for (Drink drink : drinkCopy) {
            System.out.println(drink.getName());

        }
        assert foodCopy!=null;
        for (Food food : foodCopy) {
            System.out.println(food.getName());

        }


        */

       



        // test print

       /* assert drinkList != null;
        for (Drink drink : drinkList) {
            drink.saveData();
            System.out.println(drink.getName());
        }

        assert foodList != null;
        for (Food food: foodList){
            food.saveData();
            System.out.println(food.getName());
        }

        //testDrink.saveData();
    }*/
    }


}
