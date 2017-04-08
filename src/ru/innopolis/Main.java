package ru.innopolis;

public class Main {

    public static void main(String[] args) {

        WordCounter counter = new WordCounter("text.txt");
        WordCounter counter2 = new WordCounter("text2.txt");

        System.out.println("---");
        //counter.showResultList();

        //System.out.println("-");
        //counter2.showResultList();
    }
}