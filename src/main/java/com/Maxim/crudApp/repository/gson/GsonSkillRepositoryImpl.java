package com.Maxim.crud_app.repository.gson;

import com.Maxim.crud_app.base.Status;
import com.Maxim.crud_app.model.Skill;
import com.Maxim.crud_app.repository.SkillRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class GsonSkillRepositoryImpl implements SkillRepository {
    String skillRepositoryPath = "src/main/java/com/Maxim/crud_app/data" + File.separator + "skill.json";

    @Override
    public Skill getById(Integer skillId) {
        try {
            return getAll().stream()
                    .filter(skill -> skill.getId() == skillId)
                    .findFirst()
                    .orElse(null);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
        return null;
    }

    @Override
    public List<Skill> getAll() {
        try {
            Gson gson = new Gson();
            String jsonString = read(skillRepositoryPath);
            Type type = new TypeToken<List<Skill>>() {
            }.getType();
            List<Skill> skills = gson.fromJson(jsonString, type);
            return skills;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
        return null;
    }

    @Override
    public void save(Skill skill) {
        try {
            List<Skill> skills;
            skills = getAll();
            if (skills == null) {
                skills = new ArrayList<>();
            }
            skills.add(skill);

            write(skills, skillRepositoryPath);
            System.out.println("Skill successfully added");
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

    @Override
    public void update(Skill updateSkill) {
        try {
            List<Skill> allSkills;
            allSkills = getAll();
            for (int skill = 0; skill < allSkills.size(); skill++) {
                {
                    if (allSkills.get(skill).getId() == updateSkill.getId()) {
                        allSkills.set(skill, updateSkill);
                    }
                }
                write(allSkills, skillRepositoryPath);
                System.out.println("Update success");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

    @Override
    public void deleteById(Integer deleteId) {
        try {
            List<Skill> skills = getAll();
            for (Skill skill : skills) {
                if (skill.getId() == deleteId) {
                    skill.setStatus(Status.DELETED);
                }
            }
            write(skills, skillRepositoryPath);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }
}
