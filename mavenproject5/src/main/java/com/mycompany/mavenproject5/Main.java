/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject5;

import org.json.simple.parser.ParseException;

/**
 *
 * @author cretu
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        
        Item item1=new Book("knuth67",
                "The Art of computer Programming",
                "d:/books/programming/tacp.ps",
                "1967",
                "Donald E. Knuth"
                            );
        Item item2= new Article("java17",
                               "The Java Language Specification",
                               "https://docs.oracle.com/javase/specs/jls/se17/html/index.html",
                               "2021",
                               "James Gosling & others"
                               );
        Catalog catalog=new Catalog("Catalog");
        catalog.add(item1);
        catalog.add(item2);
        //System.out.println(catalog.toString());
        catalog.save();
        catalog.load();
        
        
    }
}
