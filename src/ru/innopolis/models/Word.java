package ru.innopolis.models;

import java.util.ArrayList;

/**
 * Created by Kuznetsov on 06/04/2017.
 */
public class Word {

    private String wordValue;
    private long count;

    private ArrayList<Word> wordsList;

    /*
    public Word() {
        //this.wordValue = wordValue;
        //this.count = 1;
    }
    */



    // Добавление слова в список
    public void addWord(String value) {

        System.out.println("Я из addWord:" + value);

        /*
        try {

            Word newWord = new Word();

            newWord.setWordValue(value);
            newWord.setCount(1);

            if (!this.wordsList.contains(newWord)) {

                this.wordsList.add(newWord);

                //System.out.println(newWord); // Real-time output

            } else {

                // Наверное, не оптимально, но по-другому пока не придумал
                int tempId = this.wordsList.indexOf(newWord);
                Word tempWord = this.wordsList.get(tempId);
                long c = tempWord.getCount() + 1;
                tempWord.setCount(c);
                this.wordsList.set(tempId, tempWord);

                //System.out.println(tempWord); // Real-time output

            }
        } catch (NullPointerException e) {
            System.out.println("Хрень");
            e.printStackTrace();
        }
        */
    }

    public ArrayList<Word> getWordsList() {
        return wordsList;
    }

    @Override
    public String toString() {
        return "Word{" +
                "wordValue='" + wordValue + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public int hashCode() {
        return wordValue.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof Word))
            return false;

        if (!wordValue.equals(((Word) obj).wordValue))
            return false;

        return true;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void setWordValue(String wordValue) {
        this.wordValue = wordValue;
    }
}