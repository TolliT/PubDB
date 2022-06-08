package com.kocsma.view;

import javax.swing.*;

import com.kocsma.controller.ExceptionHandler;
import com.kocsma.model.Drink;
import com.kocsma.model.Food;
import com.kocsma.model.enumerator.DrinkType;

import java.util.ArrayList;

import com.kocsma.Main;

import static com.kocsma.controller.DrinkChooser.drinkChooser;

/**
 * Ez az oldal felel a megjelenésért.
 */

public class UserInterface extends JFrame {

    //Az alap ablak ami végül a nyugta is lesz


    private final DefaultListModel<String> lm = new DefaultListModel<>();
    private final JList<String> jl = new JList<>(lm);
    private final JScrollPane scroll = new JScrollPane(jl);

    //Az ablak jobb alsó sarkában a "Mégegyszer" gomb arra jó ha újra akarjuk generálni a random rendelést.




    public UserInterface(int width, int height){
        setTitle("Sorsolt italok az estére");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width,height);
        setLocationRelativeTo(null);
        setVisible(true);
        //A címe "Sorsolt italok az estére" a bal felső sarokban jelenik meg.
        JButton OK_Button = new JButton("OK");
        OK_Button.setSize(500,50);
        //OK gomb az ablak bal alsó sarkában ami leokézza a rendelést
        JButton re_Filter_Button = new JButton("Mégegyszer");
        re_Filter_Button.setSize(500,50);
        OK_Button.setLocation(0,400);
        re_Filter_Button.setLocation(500,400);
        add(OK_Button);
        add(re_Filter_Button);
        add(scroll);
        OK_Button.addActionListener(e -> System.exit(0));
        re_Filter_Button.addActionListener(e -> drinkChooser(Main.drinkList, Main.foodList, Main.ui));
        setVisible(true);






    }

    //Itt kapja meg, hogy a sör vagy bor gonbot nyomjuk
    public static DrinkType isBeer(){
        String[] buttons = { "Bort", "Sört"};
        int returnValue = JOptionPane.showOptionDialog(null, "Bort vagy sört szeretne inni?", "",
                JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE, null, buttons, buttons[0]);
        if(returnValue==1){
            return DrinkType.WINE;
        }

        else{
            return DrinkType.BEER;
        }
    }

    //itt érzékeli h kértünk e shot-ot
    public static Boolean isShot(){
        String[] buttons = { "Igen", "Nem"};
        int returnValue = JOptionPane.showOptionDialog(null, "Szeretne felest inni?", "",
                JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE, null, buttons, buttons[0]);
        return (returnValue == 0);

    }

    //Itt, hogy kérünk e ételt
    public static Boolean isFood(){
        String[] buttons = { "Igen", "Nem"};
        int returnValue = JOptionPane.showOptionDialog(null, "Szeretne enni is?", "",
                JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE, null, buttons, buttons[0]);
        return (returnValue == 0);
    }

    //itt adjuk meg az ár limitet
    public static Integer Cash(){
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(null, "Mennyit szeretne költeni?", "",
                    JOptionPane.PLAIN_MESSAGE));
        } catch (Exception ex){
            ExceptionHandler.errorData(ex);
        }
        return 0;
    }

    //a nyugtán kiírja a limitet Ft-ba amit megadtunk
    //És hogy mennyi a végösszeg ami legfeljebb annyi mint a megadott limit
    public void ShowDrinks(ArrayList<Drink> drinks, ArrayList<Food> food, Integer currPrice, Integer limit){
        lm.removeAllElements();
        this.lm.addElement("limit: "+ limit + " Ft");
        this.lm.addElement("Az este összege: "+ currPrice+ " Ft");
        if(drinks.isEmpty() && food.isEmpty()){
            this.lm.addElement("Ebben az árkategóriában most nem sikerült opciót találni, próbálja újra");
        }

        else if(drinks.isEmpty()){
            this.lm.addElement("Úgy látszik, nem került alkohol a listára. Gratulálunk, megvan az esti sofőr!");
        }
        for (Drink drink : drinks) {
            this.lm.addElement(drink.getName() + " " + drink.getPrice() + "Ft " +
                    drink.getAlcoholPercentage() + "%");
        }

        for (Food value : food) {
            this.lm.addElement(value.getName() + " " + value.getPrice() + "Ft " +
                    value.getCalories() + "kcal");
        }


        scroll.setSize(1000,400);
        scroll.setLocation(0,0);
        add(scroll);

    }


}
