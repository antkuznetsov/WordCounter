package ru.innopolis.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.innopolis.models.WordsList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Kuznetsov on 10/04/2017.
 */

public class MainTest {

    private static WordsList list;

    @BeforeClass
    public static void init() {

        list = new WordsList();

    }

    @Test
    public void addWordTest() {

        String testWord = "Тестовое слово";

        list.addWord(testWord);

        assertEquals(1, list.getList().size());

        assertTrue(list.getList().containsKey(testWord));

        assertTrue(list.getList().get(testWord) == 1);

        list.addWord(testWord);

        assertEquals(1, list.getList().size());

        assertTrue(list.getList().get(testWord) == 2);

    }

    @AfterClass
    public static void clear() {

        list = new WordsList();

    }
}