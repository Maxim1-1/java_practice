package com.Maxim.crud_app.model;

import com.Maxim.crud_app.repository.gson.GsonDeveloperRepositoryImpl;
import java.util.function.Consumer;


public class UpdateParamsDeveloper {
    public  Developer performOperationOnDeveloper(int expectedId, Consumer<Developer> operation) {

        GsonDeveloperRepositoryImpl gsonDeveloperRepository = new GsonDeveloperRepositoryImpl();
        for (Developer developer : gsonDeveloperRepository.getAll()) {
            if (developer.getId() == expectedId) {
                operation.accept(developer);
                return developer;
            }
        }
        return null;
    }

}
