package org.example.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("arthur");
        names.add("sol");
        names.add("renzo");
        List<String> nameUpperCase = new ArrayList<>();
        names.stream().forEach(name ->{
            name = name.toUpperCase();
            nameUpperCase.add(name);
            System.out.println(name);
        });
        //______________________________________
        List<String> nameUpperCasev2 =  names.stream()
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(nameUpperCasev2);
    }
}
