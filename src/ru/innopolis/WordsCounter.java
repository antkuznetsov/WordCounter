package ru.innopolis;

import ru.innopolis.models.WordsList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Kuznetsov on 06/04/2017.
 */

public class WordsCounter implements Runnable {

    private WordsList list;
    private Scanner myText;
    private String fileName;

    Thread t = new Thread(this, "Counter");

    public WordsCounter(String fileName, WordsList list) {

        this.fileName = fileName;
        this.list = list;

        try {

            myText = new Scanner(new File(fileName));

        } catch (FileNotFoundException e) {

            System.out.println("File not found");

        }
        t.start();
    }

    public WordsCounter(String fileName, WordsList list, Boolean link) throws IOException {

        this.fileName = fileName;
        this.list = list;

        URL url = new URL(fileName);

        // Retrieve the InputStream from the URL
        InputStream is = url.openStream();

        myText = new Scanner(is);

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