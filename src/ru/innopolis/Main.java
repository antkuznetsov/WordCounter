package ru.innopolis;

public class Main {

    public static void main(String[] args) {

        WordCounter counter = new WordCounter("text.txt");

        counter.showResultList();
    }
}