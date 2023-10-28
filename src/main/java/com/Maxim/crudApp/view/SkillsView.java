package com.Maxim.crud_app.view;

import com.Maxim.crud_app.base.BaseView;
import com.Maxim.crud_app.model.Skill;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SkillsView implements BaseView {
    private HashMap<String, String> outputSkillData = new HashMap<>();

    public void outputDataAllSkills(List<Skill> skills) {
        for (Skill skill : skills) {
            outputSkillById(skill);
        }
    }

    public void outputSkillById(Skill skill) {
        try {
            System.out.println("id: " + skill.getId() + ", Skills: " + skill.getSkill()+", Status: "+skill.getStatus());
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

    public HashMap<String,String> getDataNewSkill() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите skills через запятую");
            outputSkillData.put("skills",scanner.nextLine());
            return outputSkillData;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
        return null;
    }

    public HashMap<String, String> requestDataForUpdateSkill() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите id записи");
            outputSkillData.put("id", scanner.nextLine());
            System.out.println("Укажите новое значение скила");
            outputSkillData.put("newValueSkill", scanner.nextLine());
            return outputSkillData;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
        return null;
    }
}
