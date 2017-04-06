package ru.innopolis;

import ru.innopolis.models.Word;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Kuznetsov on 06/04/2017.
 */

public class WordCounter {

    private ArrayList<Word> wordsList;

    public WordCounter() {

        wordsList = new ArrayList<>(4048);

    }

    public void addWord(String value) {

        Word newWord = new Word(value);

        if (!wordsList.contains(newWord)) {

            wordsList.add(newWord);

        } else {

            // Наверное, не оптимально, но по-другому пока не придумал
            int tempId = wordsList.indexOf(newWord);
            Word tempWord = wordsList.get(tempId);
            long c = tempWord.getCount() + 1;
            tempWord.setCount(c);
            wordsList.set(tempId, tempWord);

        }
    }

    public void showResultList() {
        for (Word word : wordsList) {

            System.out.println(word);

        }
    }
}