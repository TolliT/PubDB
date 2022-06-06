package com.kocsma.model;

import com.kocsma.model.enumerator.DrinkType;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

public class FileIO <T> {
    public void saveData(T entity) {
        String splitter = "\t";

        Class<?> clazz = entity.getClass();
        Class<?> superClazz = clazz.getSuperclass();

        try {
            // osztalynak megfelelo database ertek lekerese
            Object val = clazz.getField("database").get(clazz);

            FileWriter f = new FileWriter(val.toString());
            CSVWriter writer = new CSVWriter(f);

            StringBuilder record = null;

            Field[] properties = clazz.getDeclaredFields();
            Field[] sProperties = superClazz.getDeclaredFields();

            System.out.println(Arrays.toString(properties));
            System.out.println(Arrays.toString(sProperties));

            // Super class mezok
            for (Field sProperty : sProperties) {
                if (sProperty.getAnnotation(GetterFunctionName.class) != null) {
                    String gfn = sProperty.getAnnotation(GetterFunctionName.class).name();
                    Method gm = clazz.getMethod(gfn);

                    String varName = sProperty.getName();
                    String value = gm.invoke(entity).toString();

                    System.out.println(varName + " = " + value);

                    if(record == null){
                        record = new StringBuilder(value);
                    }
                    else{
                        record.append(splitter).append(value);
                    }
                }
            }

            // Class mezok
            for (Field property : properties) {
                if (property.getAnnotation(GetterFunctionName.class) != null) {
                    String gfn = property.getAnnotation(GetterFunctionName.class).name();
                    Method gm = clazz.getMethod(gfn);

                    String varName = property.getName();
                    String value;

                    if(varName.equals("sizes")){
                        Float[] temp = (Float[]) gm.invoke(entity);
                        value = Arrays.toString(temp);
                    }
                    else{
                        value = gm.invoke(entity).toString();
                    }

                    System.out.println(varName + " = " + value);

                    assert record != null;
                    record.append(splitter).append(value);
                }
            }

            System.out.println(record);

            assert record != null;
            String[] toWrite = record.toString().split(splitter);

            System.out.println(Arrays.toString(toWrite));

            writer.writeNext(toWrite);
            writer.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // placehodler
    public Drink readData(){
        HashMap<Float, Integer> prices2 = new HashMap<Float, Integer>();
        prices2.put(0.30f, 800);
        prices2.put(0.50f, 1000);

        Drink testDrinkBeer = new Drink(2, "szar sor", DrinkType.BEER, 0.04f, prices2);
        return testDrinkBeer;
    }
}
