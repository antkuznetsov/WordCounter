package ru.innopolis;

import ru.innopolis.models.WordsList;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        WordsList list = new WordsList(); // Создадим базу слов

        WordsCounter counter1 = new WordsCounter("text1.txt", list); // Счетчик по 1 файлу
        WordsCounter counter2 = new WordsCounter("text2.txt", list); // Счетчик по 2 файлу
        WordsCounter counter3 = new WordsCounter("text3.txt", list); // Счетчик по 3 файлу

        counter1.t.join();
        counter2.t.join();
        counter3.t.join();

        list.showResultList(); // Покажем итоговый результат
    }
}