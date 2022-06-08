package com.kocsma.controller;

import com.kocsma.model.GetterFunctionName;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class FileIO <T> {

    public void saveData(T entity) {
        Class<?> clazz = entity.getClass();
        Class<?> superClazz = clazz.getSuperclass();

        try {
            // osztalynak megfelelo database ertek lekerese
            Object val = superClazz.getField("invoice").get(clazz);

            FileWriter f = new FileWriter(val.toString(), true);
            CSVWriter writer = new CSVWriter(f);

            StringBuilder record = null;

            Field[] properties = clazz.getDeclaredFields();
            Field[] sProperties = superClazz.getDeclaredFields();



            // Super class mezok
            String separator = "\t";
            for (Field sProperty : sProperties) {
                if (sProperty.getAnnotation(GetterFunctionName.class) != null) {
                    String gfn = sProperty.getAnnotation(GetterFunctionName.class).name();
                    Method gm = clazz.getMethod(gfn);

                    String value = gm.invoke(entity).toString();



                    if(record == null){
                        record = new StringBuilder(value);
                    }
                    else{
                        record.append(separator).append(value);
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



                    assert record != null;
                    record.append(separator).append(value);
                }
            }



            assert record != null;
            String[] toWrite = record.toString().split(separator);



            writer.writeNext(toWrite);
            writer.close();


        } catch (Exception ex) {
            ExceptionHandler.errorData(ex);
        }
    }
}
