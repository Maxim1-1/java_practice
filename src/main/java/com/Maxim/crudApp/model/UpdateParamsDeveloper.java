package com.Maxim.crudApp.model;

import com.Maxim.crudApp.repository.gson.GsonDeveloperRepositoryImpl;
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
