package ru.innopolis;

import ru.innopolis.models.Word;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Kuznetsov on 06/04/2017.
 */

public class WordCounter {

    private ArrayList<Word> wordsList;

    public WordCounter(String fileName) {

        wordsList = new ArrayList<>(4048);

        try {

            String word;
            Scanner myText = new Scanner(new File(fileName));

            while (myText.hasNext()) {

                word = myText.next();

                word = word.replaceAll("[^A-Za-zА-Яа-я]", ""); // Clear string

                this.addWord(word); // Add word to collection
            }

            myText.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found");

        }

    }

    public void addWord(String value) {

        Word newWord = new Word(value);

        if (!wordsList.contains(newWord)) {

            wordsList.add(newWord);

            System.out.println(newWord); // Real-time output

        } else {

            // Наверное, не оптимально, но по-другому пока не придумал
            int tempId = wordsList.indexOf(newWord);
            Word tempWord = wordsList.get(tempId);
            long c = tempWord.getCount() + 1;
            tempWord.setCount(c);
            wordsList.set(tempId, tempWord);

            System.out.println(tempWord); // Real-time output

        }
    }

    public void showResultList() {
        for (Word word : wordsList) {

            System.out.println(word);

        }
    }
}