package ru.innopolis;

import ru.innopolis.models.WordsList;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        WordsList list = new WordsList(); // Создадим базу слов

        //Получим список файлов
        for (int i = 0; i < args.length; i++) {

            // Если начинается с -l, то ссылка
            if (args[i].startsWith("-l"))
            {
                i++;
                new WordsCounter(args[i], list, true);
                //System.out.println(args[i]);

            } else {
                new WordsCounter(args[i], list, false);
                //System.out.println(args[i]);
            }

        }

        Thread.currentThread().sleep(5000);

        list.showResultList(); // Покажем итоговый результат
    }
}