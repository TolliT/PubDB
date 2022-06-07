package com.kocsma.controller;

import java.util.Random;
import com.kocsma.model.Drink;
import com.kocsma.model.Food;

import java.util.ArrayList;



public class DrinkChooser {


public static Integer foodprices=0;
  public static void drinkChooser(ArrayList<Drink> filteredList, ArrayList<Food> foodList, Boolean wantsToEat, Integer limit){



      ArrayList<Drink> generatedList= new ArrayList<>();
      ArrayList<Food> generatedFood=new ArrayList<>();
      ArrayList<Drink> newGeneratedList= new ArrayList<>();
      ArrayList<Food> newGeneratedFood=new ArrayList<>();
      Integer currPrice=0;

      Random rand= new Random();


      if(wantsToEat && foodprices+currPrice<=limit){
          Food firstFood=foodList.get(rand.nextInt(foodList.size()));
          generatedFood.add(firstFood);
          currPrice+=foodprices;
      }



      while(currPrice<limit){


            if(wantsToEat && rand.nextInt(101)<25){
            newGeneratedFood=foodPicker(newGeneratedFood, foodList, currPrice, limit);
         }

        else{
            newGeneratedList=drinkPicker(filteredList, currPrice, limit);
        }

        if(newGeneratedList.isEmpty()&& newGeneratedFood.isEmpty()){
            break;
        }

          generatedList.addAll(newGeneratedList);
          generatedFood.addAll(newGeneratedFood);
        currPrice=priceCounter(generatedList, generatedFood);


      }

      for (Drink drink : generatedList) {
          System.out.println(drink.getName() + " " + drink.getDrinkPrice() + " Ft");
      }
      System.out.println("Limit: " + limit+ " Ft\n"+ "Aktuális ár: " + currPrice+ " Ft");
  }

   static ArrayList<Drink> drinkPicker(ArrayList<Drink> filteredList, Integer currPrice, Integer limit){
        Random rand= new Random();
        int tries;
        ArrayList<Drink> newGeneratedList=new ArrayList<>();

        for(tries=0; tries<=10;tries++){

            Drink current=filteredList.get(rand.nextInt(filteredList.size()));
            if(current.getDrinkPrice()+currPrice<=limit){
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
          if(filteredList.get(i).getDrinkPrice()>maxFittingPrice && filteredList.get(i).getDrinkPrice() + currPrice<=limit ){
              maxIndex=i;
              maxFittingPrice=filteredList.get(i).getDrinkPrice();

          }
        }

      if(maxFittingPrice!=0){
          newGeneratedList.add(filteredList.get(maxIndex));
          currPrice+=maxFittingPrice;
          newGeneratedList=lastDrinkTry(newGeneratedList, filteredList, currPrice, limit);
      }


      return newGeneratedList;
    }


  static  ArrayList<Food> foodPicker( ArrayList<Food> newGeneratedFood, ArrayList<Food> foodList, Integer currPrice, Integer limit){
        Random rand= new Random();
        int tries;


        for(tries=0; tries<=10;tries++){

            Food current=foodList.get(rand.nextInt(foodList.size()));
            if(foodprices+currPrice<=limit){
                newGeneratedFood.add(current);
                currPrice+=foodprices;
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
            if(foodprices>maxFittingPrice && foodprices + currPrice<=limit ){
                maxIndex=i;

                maxFittingPrice=foodprices;
            }
        }

        if(maxFittingPrice!=0){
            foodList.add(foodList.get(maxIndex));
            currPrice+=maxFittingPrice;
            newGeneratedFood=lastFoodTry(foodList, newGeneratedFood,  currPrice, limit);
        }


        return newGeneratedFood;




    }

   static Integer priceCounter(ArrayList<Drink> generatedList, ArrayList<Food> generatedFood){
       Integer currPrice = 0;
       for (Drink drink : generatedList) {
           currPrice += drink.getDrinkPrice();
       }
        for(int i=0; i<generatedFood.size(); i++){
            currPrice +=foodprices;
        }


        return currPrice;
    }
}

