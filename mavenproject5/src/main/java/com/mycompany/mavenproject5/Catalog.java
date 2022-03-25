/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author cretu
 */
public class Catalog {

    private String nume;
    private List<Item> itemList = new ArrayList<>();

    public Catalog(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItem(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void add(Item item) {
        itemList.add(item);
    }

    public void save() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        String jsonFile = null;
        try {
            jsonFile = mapper.writeValueAsString(itemList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try (FileWriter file = new FileWriter("catalog.json")) {
            file.write(jsonFile);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

 public void load() throws org.json.simple.parser.ParseException {
        JSONParser json = new JSONParser();

        try (FileReader reader = new FileReader("catalog.json")) {
            Object obj = json.parse(reader);

            JSONArray items = (JSONArray) obj;

            for (var index : items) {
                JSONObject object = (JSONObject) index;
                String id = (String) object.get("id");
                System.out.println(id);
                String title = (String) object.get("title");
                System.out.println(title);
                String location = (String) object.get("location");
                System.out.println( location);
                String year = (String) object.get("year");
                System.out.println(year);
                String author = (String) object.get("author");
                System.out.println(author);
                String type = (String) object.get("type");
                System.out.println(type);
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    
    @Override
    public String toString() {
        return "Catalog{" + "nume=" + nume + ", itemList=" + itemList + '}';
    }

}
