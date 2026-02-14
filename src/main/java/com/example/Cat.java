package com.example;

import java.util.Arrays;
import java.util.List;

public abstract class Cat implements Predator {
    @Override
    public List<String> getFood() {
        return Arrays.asList("Рыба", "Молоко");
    }
}