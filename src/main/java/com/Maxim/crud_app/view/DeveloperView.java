package com.Maxim.crud_app.view;


import com.Maxim.crud_app.base.BaseView;
import com.Maxim.crud_app.model.Developer;
import com.Maxim.crud_app.model.Skill;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DeveloperView implements BaseView {

    private HashMap<String, String> outputUserData = new HashMap<>();

    public void outputDataAllDevelopers(List<Developer> developers) {
        try {
            StringBuilder skills = new StringBuilder();
            for (Developer developer : developers) {
                String specialty = developer.getSpecialty().getName();
                for (Skill skill : developer.getSkills()) {
                    skills.append(skill.getSkill()).append(",");
                }
                System.out.println("id: " + developer.getId() + ", First Name: " + developer.getFirstName() + ", Last Name: " + developer.getLastName() + ", Specialty: " + specialty + ", Skills: " + skills
                        +", Status: "+developer.getStatus());
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

    public void outputDataAboutDeveloperById(Developer developer) {
        try {
            StringBuilder skills = new StringBuilder();
            for (Skill skill : developer.getSkills()) {
                skills.append(skill.getSkill()).append(",");
            }
            System.out.println("id: " + developer.getId() + ", First Name: " + developer.getFirstName() + ", Last Name: "
                    + developer.getLastName() + ", Specialty: " + developer.getSpecialty().getName() + ", Skills: " + skills+", Status: "+developer.getStatus());
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

    public HashMap<String, String> requestDataForUpdateDeveloper() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите id записи");
            outputUserData.put("id", scanner.nextLine());

            System.out.println("Выберите из списка один или несколько параметров(через запятую) для изменения: firstName, lastName, specialty, replace skills, add new skills");
            String[] params = scanner.nextLine().split(",");
            for (String param : params) {
                System.out.printf("Новое значение для %s%n", param);
                outputUserData.put(param, scanner.nextLine());
            }
            return outputUserData;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
        return null;
    }

    public HashMap<String, String> getDataNewDeveloper() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите first Name");
            outputUserData.put("firstName", scanner.nextLine());
            System.out.println("Введите last Name");
            outputUserData.put("lastName", scanner.nextLine());
            System.out.println("Введите specialty");
            outputUserData.put("specialty", scanner.nextLine());
            System.out.println("Введите skills через запятую");
            outputUserData.put("skills", scanner.nextLine());
            return outputUserData;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
        return null;
    }

}
