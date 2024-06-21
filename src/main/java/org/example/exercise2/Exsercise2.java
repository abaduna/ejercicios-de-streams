package org.example.exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exsercise2 {
    public static void main(String[] args) {
        List<Integer> listCelsius = new ArrayList<>();
        listCelsius.add(354);
        listCelsius.add(65);
        listCelsius.add(21);
        List<Integer> listFarengith = listCelsius.stream().map(c -> {
            int f = (int)(c * (9.0/5) + 32);
            return f;
        }).toList();
        System.out.println(listFarengith);
    }
}
