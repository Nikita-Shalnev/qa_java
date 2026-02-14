package com.example;

import java.util.List;

public class Feline extends Animal implements Predator {

    public Feline(String хищник) {
        super(хищник);
    }

    @Override
    public List<String> getFood() throws Exception {
        // По умолчанию возвращаем пустой список
        return List.of();
    }

    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    public List<String> getFood(String kind) throws Exception {
        return getFood();  // Вызов без параметра или расширенная логика
    }

    public String getFamily() {
        return "Кошачьи";
    }

    public int getKittens() {
        return getKittens(1);
    }

    public int getKittens(int kittensCount) {
        return kittensCount;
    }
}