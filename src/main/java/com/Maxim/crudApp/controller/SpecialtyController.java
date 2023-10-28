
package com.Maxim.crud_app.controller;


import com.Maxim.crud_app.model.Specialty;
import com.Maxim.crud_app.repository.gson.GsonSpecialtyRepositoryImpl;
import com.Maxim.crud_app.view.SpecialtyView;

import java.util.HashMap;

public class SpecialtyController {
    public void getAllSpecialty() {
        try {
            SpecialtyView specialtyView = new SpecialtyView();
            GsonSpecialtyRepositoryImpl gsonSpecialtyRepository = new GsonSpecialtyRepositoryImpl();

            specialtyView.outputDataAllSpecialty(gsonSpecialtyRepository.getAll());
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

    public void getSpecialtyById() {
        try {
            SpecialtyView specialtyView = new SpecialtyView();
            GsonSpecialtyRepositoryImpl gsonSpecialtyRepository = new GsonSpecialtyRepositoryImpl();

            Specialty specialtyId = gsonSpecialtyRepository.getById(specialtyView.getIdFromConsole());
            specialtyView.outputDataAboutSpecialtyById(specialtyId);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

    public void deleteSpecialtyById() {
        try {
            SpecialtyView specialtyView = new SpecialtyView();
            GsonSpecialtyRepositoryImpl gsonSkillRepository = new GsonSpecialtyRepositoryImpl();

            gsonSkillRepository.deleteById(specialtyView.getIdFromConsole());
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

    public void addNewSpecialty() {
        try {
            SpecialtyView specialtyView = new SpecialtyView();
            GsonSpecialtyRepositoryImpl gsonSpecialtyRepository = new GsonSpecialtyRepositoryImpl();

            Specialty specialty = new Specialty();
            specialty.setName(specialtyView.getDataNewSpecialty().get("specialty"));
            gsonSpecialtyRepository.save(specialty);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

    public void updateSpecialtyById() {
        try {
            SpecialtyView specialtyView = new SpecialtyView();
            GsonSpecialtyRepositoryImpl gsonSpecialtyRepository = new GsonSpecialtyRepositoryImpl();
            HashMap<String, String> dataFromConsole = specialtyView.requestDataForUpdateSpecialty();
            Integer updateId = Integer.valueOf(dataFromConsole.get("id"));

            for (Specialty spec : gsonSpecialtyRepository.getAll()) {
                if (spec.getId() == updateId) {
                    spec.setName(dataFromConsole.get("newValueSpecialty"));
                    gsonSpecialtyRepository.update(spec);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }
}