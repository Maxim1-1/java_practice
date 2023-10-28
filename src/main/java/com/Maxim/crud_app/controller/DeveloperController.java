package com.Maxim.crud_app.controller;


import com.Maxim.crud_app.model.Developer;
import com.Maxim.crud_app.model.Skill;
import com.Maxim.crud_app.model.Specialty;
import com.Maxim.crud_app.model.UpdateParamsDeveloper;
import com.Maxim.crud_app.repository.gson.GsonDeveloperRepositoryImpl;
import com.Maxim.crud_app.view.DeveloperView;

import java.util.*;
import java.util.stream.Collectors;

public class DeveloperController {


    public void getAllDevelopers() {
        try {
            DeveloperView developerView = new DeveloperView();
            GsonDeveloperRepositoryImpl gsonDeveloperRepository = new GsonDeveloperRepositoryImpl();

            developerView.outputDataAllDevelopers(gsonDeveloperRepository.getAll());
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }

    }

    public void getDeveloperById() {
        try {
            DeveloperView developerView = new DeveloperView();
            GsonDeveloperRepositoryImpl gsonDeveloperRepository = new GsonDeveloperRepositoryImpl();

            Developer developerId = gsonDeveloperRepository.getById(developerView.getIdFromConsole());
            developerView.outputDataAboutDeveloperById(developerId);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }

    }

    public void deleteDeveloperById() {
        try {
            DeveloperView developerView = new DeveloperView();
            GsonDeveloperRepositoryImpl gsonDeveloperRepository = new GsonDeveloperRepositoryImpl();
            gsonDeveloperRepository.deleteById(developerView.getIdFromConsole());
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

    public void updateDeveloperById() {
        try {
            DeveloperView developerView = new DeveloperView();
            GsonDeveloperRepositoryImpl gsonDeveloperRepository = new GsonDeveloperRepositoryImpl();
            UpdateParamsDeveloper updateParamsDeveloper = new UpdateParamsDeveloper();
            HashMap<String, String> dataFromConsole = developerView.requestDataForUpdateDeveloper();
            Integer updateId = Integer.valueOf(dataFromConsole.get("id"));

            for (Map.Entry<String, String> param : dataFromConsole.entrySet()) {

                switch (param.getKey()) {
                    case "firstName":
                        Developer updateDeveloperFirstName = updateParamsDeveloper.performOperationOnDeveloper(updateId, developer -> developer.setFirstName(dataFromConsole.get("firstName")));
                        gsonDeveloperRepository.update(updateDeveloperFirstName);
                        break;
                    case "lastName":
                        Developer updateDeveloperLastName = updateParamsDeveloper.performOperationOnDeveloper(updateId, developer -> developer.setLastName(dataFromConsole.get("lastName")));
                        gsonDeveloperRepository.update(updateDeveloperLastName);
                        break;
                    case "specialty":
                        Specialty specialty = new Specialty();
                        specialty.setName(dataFromConsole.get("specialty"));
                        Developer updateDeveloperSpecialty = updateParamsDeveloper.performOperationOnDeveloper(updateId, developer -> developer.setSpecialty(specialty));
                        gsonDeveloperRepository.update(updateDeveloperSpecialty);
                        break;
                    case "replace skills":
                        String[] skills = dataFromConsole.get("replace skills").split(",");
                        List<Skill> skillList = new ArrayList<>();
                        for (String skill : skills) {
                            Skill newSkill = new Skill();
                            newSkill.setSkill(skill);
                            skillList.add(newSkill);
                        }
                        Developer updateDeveloperSkills = updateParamsDeveloper.performOperationOnDeveloper(updateId, developer -> developer.setSkills(skillList));
                        gsonDeveloperRepository.update(updateDeveloperSkills);
                        break;
                    case "add new skills":
                        String[] newSkills = dataFromConsole.get("add new skills").split(",");
                        List<Skill> oldSkillsDeveloper = gsonDeveloperRepository.getById(updateId).getSkills();
                        List<Skill> newSkillList = new ArrayList<>();
                        for (String skill : newSkills) {
                            Skill newSkill = new Skill();
                            newSkill.setSkill(skill);
                            newSkillList.add(newSkill);
                        }
                        newSkillList.addAll(oldSkillsDeveloper);
                        Developer updateDeveloperNewSkills = updateParamsDeveloper.performOperationOnDeveloper(updateId, developer -> developer.setSkills(newSkillList));
                        gsonDeveloperRepository.update(updateDeveloperNewSkills);
                        break;
                    case "id":
                        break;
                    default:
                        System.out.println("Вы ввели неверное значение");
                }
            }
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

    public void addNewDeveloper() {
        try {
            DeveloperView developerView = new DeveloperView();
            GsonDeveloperRepositoryImpl gsonDeveloperRepository = new GsonDeveloperRepositoryImpl();
            Specialty specialty = new Specialty();

            List<Skill> skills;
            HashMap<String, String> dataNewDeveloperFromConsole = developerView.getDataNewDeveloper();

            String firstNameDeveloper = dataNewDeveloperFromConsole.get("firstName");
            String lastNameDeveloper = dataNewDeveloperFromConsole.get("lastName");
            specialty.setName(dataNewDeveloperFromConsole.get("specialty"));
            List<String> skillsDeveloper = Arrays.asList(dataNewDeveloperFromConsole.get("skills").split(","));
            skills = skillsDeveloper.stream().
                    map(skillName -> {
                        Skill skill = new Skill();
                        skill.setSkill(skillName);
                        return skill;
                    })
                    .collect(Collectors.toList());

            Developer developer = new Developer(firstNameDeveloper, lastNameDeveloper);
            developer.setSpecialty(specialty);
            developer.setSkills(skills);

            gsonDeveloperRepository.save(developer);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }
}
