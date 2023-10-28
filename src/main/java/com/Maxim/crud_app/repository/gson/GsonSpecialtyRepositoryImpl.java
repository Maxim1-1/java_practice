package com.Maxim.crud_app.repository.gson;

import com.Maxim.crud_app.base.Status;
import com.Maxim.crud_app.model.Specialty;
import com.Maxim.crud_app.repository.SpecialtyRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonSpecialtyRepositoryImpl implements SpecialtyRepository {

    String specialtyRepositoryPath = "src/main/java/com/Maxim/crud_app/data" + File.separator + "specialty.json";


    @Override
    public Specialty getById(Integer specialtyId) {
        try {
            return getAll().stream()
                    .filter(specialty -> specialty.getId() == specialtyId)
                    .findFirst()
                    .orElse(null);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
        return null;
    }

    @Override
    public List<Specialty> getAll() {
        try {
            Gson gson = new Gson();
            String jsonString = read(specialtyRepositoryPath);
            Type type = new TypeToken<List<Specialty>>() {
            }.getType();
            List<Specialty> specialties = gson.fromJson(jsonString, type);
            return specialties;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
        return null;
    }

    @Override
    public void save(Specialty specialty) {
        try {
            List<Specialty> specialties;
            specialties = getAll();
            if (specialties == null) {
                specialties = new ArrayList<>();
            }
            specialties.add(specialty);

            write(specialties, specialtyRepositoryPath);
            System.out.println("Specialty successfully added");
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }

    }

    @Override
    public void update(Specialty specialty) {
        try {
            List<Specialty> allSpecialty;
            allSpecialty = getAll();

            for (int spec = 0; spec < allSpecialty.size(); spec++) {
                {
                    if (allSpecialty.get(spec).getId() == specialty.getId()) {
                        allSpecialty.set(spec, specialty);
                    }
                }
                write(allSpecialty, specialtyRepositoryPath);
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
            List<Specialty> specialties = getAll();
            for (Specialty specialty : specialties) {
                if (specialty.getId() == deleteId) {
                    specialty.setStatus(Status.DELETED);
                }
            }
            write(specialties, specialtyRepositoryPath);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }
}

