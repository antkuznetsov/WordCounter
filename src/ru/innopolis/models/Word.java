package ru.innopolis.models;

/**
 * Created by Kuznetsov on 06/04/2017.
 */
public class Word {

    private String wordValue;
    private long count;

    public Word(String wordValue) {
        this.wordValue = wordValue;
        this.count = 1;
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
}