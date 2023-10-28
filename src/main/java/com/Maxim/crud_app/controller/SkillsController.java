package com.Maxim.crud_app.controller;


import com.Maxim.crud_app.model.Skill;
import com.Maxim.crud_app.repository.gson.GsonSkillRepositoryImpl;
import com.Maxim.crud_app.view.SkillsView;


import java.util.*;
import java.util.stream.Collectors;

public class SkillsController {

    public void getSkillById() {
        try {
            SkillsView skillsView = new SkillsView();
            GsonSkillRepositoryImpl gsonSkillRepository = new GsonSkillRepositoryImpl();

            Skill skillId = gsonSkillRepository.getById(skillsView.getIdFromConsole());
            skillsView.outputSkillById(skillId);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

    public void getAllSkills() {
        try {
            SkillsView skillsView = new SkillsView();
            GsonSkillRepositoryImpl gsonSkillRepository = new GsonSkillRepositoryImpl();

            skillsView.outputDataAllSkills(gsonSkillRepository.getAll());
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

    public void deleteSkillsById() {
        try {
            SkillsView skillsView = new SkillsView();
            GsonSkillRepositoryImpl gsonSkillRepository = new GsonSkillRepositoryImpl();

            gsonSkillRepository.deleteById(skillsView.getIdFromConsole());
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

    public void addNewSkill() {
        try {
            SkillsView skillsView = new SkillsView();
            GsonSkillRepositoryImpl gsonSkillRepository= new GsonSkillRepositoryImpl();

            List<String> skillsDeveloper = Arrays.asList(skillsView.getDataNewSkill().get("skills").split(","));
            List<Skill> skills = skillsDeveloper.stream().
                    map(skillName -> {
                        Skill skill = new Skill();
                        skill.setSkill(skillName);
                        return skill;
                    })
                    .collect(Collectors.toList());

            for (Skill skill:skills) {
                gsonSkillRepository.save(skill);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

    public void updateSkillsById() {
        try {
            SkillsView skillsView = new SkillsView();
            GsonSkillRepositoryImpl gsonSkillRepository = new GsonSkillRepositoryImpl();
            HashMap<String, String> dataFromConsole = skillsView.requestDataForUpdateSkill();
            Integer updateId = Integer.valueOf(dataFromConsole.get("id"));

            for (Skill skill : gsonSkillRepository.getAll()) {
                if (skill.getId() == updateId) {
                    skill.setSkill(dataFromConsole.get("newValueSkill"));
                    gsonSkillRepository.update(skill);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

}
