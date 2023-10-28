package com.Maxim.crud_app.repository.gson;

import com.Maxim.crud_app.base.Status;
import com.Maxim.crud_app.model.Developer;
import com.Maxim.crud_app.repository.DeveloperRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository {
    String developerRepositoryPath = "src/main/java/com/Maxim/crud_app/data" + File.separator + "developer.json";


    @Override
    public Developer getById(Integer id) {

        try {
            return getAll().stream()
                    .filter(developer -> developer.getId() == id)
                    .findFirst()
                    .orElse(null);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }

        return null;
    }

    @Override
    public List<Developer> getAll() {
        try {
            Gson gson = new Gson();
            String jsonString = read(developerRepositoryPath);
            Type type = new TypeToken<List<Developer>>() {
            }.getType();

            List<Developer> developers = gson.fromJson(jsonString, type);

            return developers;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
        return null;
    }

    @Override
    public void save(Developer developer) {
        try {
            List<Developer> developers;
            developers = getAll();
            if (developers == null) {
                developers = new ArrayList<>();
            }
            developers.add(developer);

            write(developers, developerRepositoryPath);
            System.out.println("Developer successfully added");
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

    @Override
    public void update(Developer developer) {
        try {
            List<Developer> developers;
            developers = getAll();
            for (int dev = 0; dev < developers.size(); dev++) {
                {
                    if (developers.get(dev).getId() == developer.getId()) {
                        developers.set(dev, developer);
                    }
                }
                write(developers, developerRepositoryPath);
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
            List<Developer> developers = getAll();

            for (Developer developer : developers) {
                if (developer.getId() == deleteId) {
                    developer.setStatus(Status.DELETED);
                }
            }
            write(developers, developerRepositoryPath);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Хранилище пусто");
        }
    }

}

