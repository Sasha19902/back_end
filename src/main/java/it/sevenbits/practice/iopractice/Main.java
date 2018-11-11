package it.sevenbits.practice.iopractice;

import java.io.File;
import java.io.IOException;

public class Main {

    private static final String MY_HOMEWROK_TXT = "MyHomework3.txt";
    private static final String HOMEWORK_TXT = "Homework3.txt";
    private static final String MY_SECOND_NAME = "Ковалёв";

    public static void main(String[] args) throws IOException, MyFileServiceException {
        File file = FileService.createFile(MY_HOMEWROK_TXT);

        FileService.rewriteIntoFile(HOMEWORK_TXT, file.getPath());
        FileService.addWordIntoFile(MY_HOMEWROK_TXT, MY_SECOND_NAME);

    }
}
