package com.kocsma.controller;

import java.util.Random;
import com.kocsma.model.Drink;
import com.kocsma.model.Food;
import com.kocsma.view.UserInterface;

import java.util.ArrayList;

import static com.kocsma.controller.Filters.wineBeerFilter;
import static com.kocsma.view.UserInterface.Cash;
import static com.kocsma.view.UserInterface.isFood;

/**A DrinkChooser-ben az adott ár limithez és a választáshoz képest Összeállít egy itallapot a listákból.
 *
 */

public class DrinkChooser {



  public static void drinkChooser(ArrayList<Drink>  drinkList,ArrayList<Food> foodList, UserInterface ui){




        //Új listákat generál amiket feltölt a Drink és Food osztályokból, listákból.
      ArrayList<Drink> filteredList=wineBeerFilter(drinkList);

      boolean wantsToEat=isFood();
      Integer limit=Cash();

      ArrayList<Drink> generatedList= new ArrayList<>();
      ArrayList<Food> generatedFood=new ArrayList<>();
      ArrayList<Drink> newGeneratedList= new ArrayList<>();
      ArrayList<Food> newGeneratedFood=new ArrayList<>();
      Integer currPrice=0;

      Random rand= new Random();

        //Ha enni is szeretne valaki akkor pluszban abból a listából is választ egyet random

      if(wantsToEat){
          Food firstFood=foodList.get(rand.nextInt(foodList.size()));
          if(firstFood.getPrice()+currPrice<=limit){
              generatedFood.add(firstFood);
              currPrice+=firstFood.getPrice();
          }
      }

      // és belekalkulálja és akkor az italfogyasztás lesz kevesebb
      while(currPrice<limit){

            //étel választásnál 1:4-hez arányban adja az ételt az italhoz tehát nem lehet többet enni, mint inni
            if(wantsToEat && rand.nextInt(101)<20){
            newGeneratedFood=foodPicker(foodList, currPrice, limit);
         }

        else{
            newGeneratedList=drinkPicker(filteredList, currPrice, limit);
        }

        if(newGeneratedList.isEmpty()&& newGeneratedFood.isEmpty()){
            break;
        }

          generatedList.addAll(newGeneratedList);
        if(!newGeneratedFood.isEmpty()) {
            generatedFood.addAll(newGeneratedFood);
        }
        currPrice=priceCounter(generatedList, generatedFood);
          newGeneratedList= new ArrayList<>();
          newGeneratedFood=new ArrayList<>();

      }



      ui.ShowDrinks(generatedList, generatedFood, currPrice, limit);

  }
        //random választ az italok közül a generált listából
   public static ArrayList<Drink> drinkPicker(ArrayList<Drink> filteredList, Integer currPrice, Integer limit){
        Random rand= new Random();
        int tries;
        ArrayList<Drink> newGeneratedList=new ArrayList<>();

        for(tries=0; tries<=10;tries++){

            Drink current=filteredList.get(rand.nextInt(filteredList.size()));
            if(current.getPrice()+currPrice<=limit){
                newGeneratedList.add(current);

                break;
            }

        }

        if(tries==11){
            newGeneratedList=lastDrinkTry(newGeneratedList, filteredList, currPrice, limit);
        }


      return newGeneratedList;
    }



   static ArrayList<Drink> lastDrinkTry(ArrayList<Drink> newGeneratedList,ArrayList<Drink> filteredList, Integer currPrice, Integer limit ){

      int maxFittingPrice=0, maxIndex=0;

      for(int i=0; i<filteredList.size(); i++){
          if(filteredList.get(i).getPrice()>maxFittingPrice && filteredList.get(i).getPrice() + currPrice<=limit ){
              maxIndex=i;
              maxFittingPrice=filteredList.get(i).getPrice();

          }
        }

      if(maxFittingPrice!=0){
          newGeneratedList.add(filteredList.get(maxIndex));
          currPrice+=maxFittingPrice;
          newGeneratedList=lastDrinkTry(newGeneratedList, filteredList, currPrice, limit);
      }


      return newGeneratedList;
    }


  static  ArrayList<Food> foodPicker(ArrayList<Food> foodList, Integer currPrice, Integer limit){
        Random rand= new Random();
        int tries;
      ArrayList<Food> newGeneratedFood= new ArrayList<>();

        for(tries=0; tries<=10;tries++){

            Food current=foodList.get(rand.nextInt(foodList.size()));
            if(current.getPrice()+currPrice<=limit){
                newGeneratedFood.add(current);

                break;
            }
        }

        if(tries==11){
            newGeneratedFood=lastFoodTry(newGeneratedFood, foodList, currPrice, limit);
        }


        return newGeneratedFood;
    }

   static ArrayList<Food> lastFoodTry( ArrayList<Food> newGeneratedFood, ArrayList<Food> foodList, Integer currPrice, Integer limit){

        int maxFittingPrice=0, maxIndex=0;

        for(int i=0; i<foodList.size(); i++){
            if(foodList.get(i).getPrice()>maxFittingPrice && foodList.get(i).getPrice() + currPrice<=limit ){
                maxIndex=i;

                maxFittingPrice=foodList.get(i).getPrice();
            }
        }

        if(maxFittingPrice!=0){
            newGeneratedFood.add(foodList.get(maxIndex));
            currPrice+=maxFittingPrice;
            newGeneratedFood=lastFoodTry(foodList, newGeneratedFood,  currPrice, limit);
        }


        return newGeneratedFood;




    }

   static Integer priceCounter(ArrayList<Drink> generatedList, ArrayList<Food> generatedFood){
       Integer currPrice = 0;
       for (Drink drink : generatedList) {
           currPrice += drink.getPrice();
       }
       for (Food food : generatedFood) {
           currPrice += food.getPrice();
       }


        return currPrice;
    }
}

