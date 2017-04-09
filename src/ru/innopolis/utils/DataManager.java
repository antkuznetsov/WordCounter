package ru.innopolis.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Kuznetsov on 09/04/2017.
 */

public class DataManager {

    private Scanner myText;

    public DataManager(String fileName, Boolean link) {

        if (link) {

            URL url = null;

            try {

                url = new URL(fileName);

            } catch (MalformedURLException e) {

                System.err.println(fileName + " is not a valid URL");
                //e.printStackTrace();

            }

            InputStream is = null;

            try {

                is = url.openStream();

            } catch (IOException e) {

                e.printStackTrace();

            }

            this.myText = new Scanner(is);

        } else {

            try {

                this.myText = new Scanner(new File(fileName));

            } catch (FileNotFoundException e) {

                System.out.println("File not found");
                //e.printStackTrace();

            }

        }


    }

    public Scanner getText() {

        return myText;

    }
}