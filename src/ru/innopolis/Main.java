package ru.innopolis;

import ru.innopolis.models.WordsList;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        WordsList list = new WordsList(); // Создадим базу слов

        ArrayList<WordsCounter> arrCounter = new ArrayList<>();

        // Получим список файлов или ссылок на них
        for (int i = 0; i < args.length; i++) {

            // Если начинается с -l, то ссылка
            if (args[i].startsWith("-l")) {

                i++;
                arrCounter.add(new WordsCounter(args[i], list, true));

            } else {

                arrCounter.add(new WordsCounter(args[i], list, false));

            }

        }

        for (WordsCounter counter : arrCounter) {

            counter.t.join();

        }

        list.showResultList(); // Покажем итоговый результат

    }
}