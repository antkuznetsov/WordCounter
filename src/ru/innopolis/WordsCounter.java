package ru.innopolis;

import ru.innopolis.models.WordsList;
import ru.innopolis.utils.DataManager;
import java.util.Scanner;

/**
 * Created by Kuznetsov on 06/04/2017.
 */

public class WordsCounter implements Runnable {

    private WordsList list;
    private Scanner myText;
    private String fileName;

    Thread t = new Thread(this, "Counter");

    public WordsCounter(String fileName, WordsList list, Boolean link) {

        this.fileName = fileName;
        this.list = list;

        myText = new DataManager(fileName, link).getText();

        t.start();
    }

    @Override
    public void run() {

        System.out.println("Поток " + t.getName() + " " + fileName + " начался");

        try {
            while (myText.hasNext()) {

                String word = myText.next();
                word = word.replaceAll("[^A-Za-zА-Яа-я]", ""); // Clear string

                try {

                    list.addWord(word);

                } catch (NullPointerException e) {

                    System.out.println("Something is wrong");

                }
            }
            myText.close();

        } catch (NullPointerException e) {

            System.out.println("Something is wrong");

        }

        System.out.println("Поток " + t.getName() + " " + fileName + " закончился");

    }
}