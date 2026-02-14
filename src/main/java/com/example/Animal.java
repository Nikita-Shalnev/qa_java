package com.example;

import java.util.List;

public class Animal {

    public Animal(String animalType) {
    }

    public List<String> getFood(String animalKind) throws Exception {
        if (animalKind == null) {
            throw new Exception("Некорректный тип животного");
        }
        if (animalKind.isEmpty()) {
            throw new Exception("Некорректный тип животного");
        }
        switch (animalKind) {
            case "Травоядное":
                return List.of("Трава", "Различные растения");
            case "Хищник":
                return List.of("Мясо");
            default:
                throw new Exception("Неизвестный тип животного");
        }
    }

    public String getFamily() {
        return "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    }
}