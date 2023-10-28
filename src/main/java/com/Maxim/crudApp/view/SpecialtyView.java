package com.Maxim.crud_app.view;


import com.Maxim.crud_app.base.BaseView;
import com.Maxim.crud_app.model.Specialty;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SpecialtyView implements BaseView {
    private HashMap<String, String> outputSpecialtyData = new HashMap<>();

    public void outputDataAllSpecialty(List<Specialty> specialties) {
        try {
            for (Specialty specialty : specialties) {
                System.out.println("id: " + specialty.getId() + ", Specialty: " + specialty.getName()+", Status: "+specialty.getStatus());
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

    public void outputDataAboutSpecialtyById(Specialty specialty) {
        try {
            System.out.println("id: " + specialty.getId() + ", Specialty: " + specialty.getName()+", Status: "+specialty.getStatus());
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

    public HashMap<String,String> getDataNewSpecialty() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите specialty");
            outputSpecialtyData.put("specialty",scanner.nextLine());
            return outputSpecialtyData;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }

        return null;
    }

    public HashMap<String, String> requestDataForUpdateSpecialty() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите id записи");
            outputSpecialtyData.put("id", scanner.nextLine());
            System.out.println("Укажите новое значение специльности");
            outputSpecialtyData.put("newValueSpecialty", scanner.nextLine());
            return outputSpecialtyData;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
        return null;
    }
}
