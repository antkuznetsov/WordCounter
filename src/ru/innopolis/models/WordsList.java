package ru.innopolis.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kuznetsov on 06/04/2017.
 */

public class WordsList {

    private Map<String, Integer> list = new HashMap<>();

    synchronized public void addWord(String value) {

        try {

            if (!list.containsKey(value)) {

                list.put(value, 1); //Если слова нет, добавляем его

            } else {

                list.put(value, list.get(value) + 1); //Если слово есть, обновляем счетчик

            }

            System.out.println(value + " " + list.get(value)); //Real-time output

        } catch (NullPointerException e) {

            System.out.println("Something is wrong");

        }
    }

    public void showResultList() {

        System.out.println("+--------------------+");
        System.out.println("| Итоговый результат |");
        System.out.println("+--------------------+");

        for (Map.Entry entry : list.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}