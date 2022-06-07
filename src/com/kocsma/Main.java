package com.kocsma;

import com.kocsma.controller.FileInit;
import com.kocsma.model.Drink;
import com.kocsma.model.Food;
import com.kocsma.model.enumerator.DrinkType;
import com.kocsma.view.UserInterface;

public class Main {

    public static void main(String[] args) {
        // TESTING

        UserInterface screen = new UserInterface(500,500);
        Drink testDrink = new Drink("Teszt Ital2", DrinkType.BEER, 0.50f, 1000);
        System.out.println(testDrink.getDrinkPrice());

        Drink[] drinkList = FileInit.loadDrinkData();
        Food[] foodList = FileInit.loadFoodData();

        screen.ShowDrinks(drinkList);
        screen.ShowDrinks(drinkList);

        // test print

        assert drinkList != null;
        for (Drink drink : drinkList) {
            System.out.println(drink.getName());
        }

        assert foodList != null;
        for (Food food: foodList){
            System.out.println(food.getName());
        }

        //testDrink.saveData();
    }
}
