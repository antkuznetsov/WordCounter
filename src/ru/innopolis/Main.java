package ru.innopolis;

import ru.innopolis.models.WordsList;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        WordsList list = new WordsList(); // Создадим базу слов

        //Получим список файлов
        for (int i = 0; i < args.length; i++) {

            new WordsCounter(args[i], list);

        }

        Thread.currentThread().sleep(3000);

        list.showResultList(); // Покажем итоговый результат
    }
}