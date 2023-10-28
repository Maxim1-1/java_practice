package com.Maxim.crud_app.repository;

import com.google.gson.Gson;

import java.io.*;
import java.util.List;

public interface GenericRepository<T, ID> {

    T getById(ID id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void deleteById(ID id);

    default String read (String path) {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String json = "";
            String line = null;

            while ((line = reader.readLine()) != null) {
                json += line;
            }
            return json;

        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
            return String.format("IOException: %s%n", x);
        }

    }

    default  void write (List<T> t, String path) {
        Gson gson = new Gson();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(gson.toJson(t));

        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);

        }
    }

}
