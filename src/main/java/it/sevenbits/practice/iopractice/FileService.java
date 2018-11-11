package it.sevenbits.practice.iopractice;

import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public final class FileService {

    private FileService() {

    }

    public static File createFile(final String path) throws IOException, MyFileServiceException {

        File toCreate = new File(path);

        if (toCreate.exists()) {
            return toCreate;
        }

        if (!toCreate.createNewFile()) {
            throw new MyFileServiceException("File not created");
        }

        return toCreate;
    }

    public static void rewriteIntoFile(final String from, final String to) throws IOException {

        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(to));
             BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(from))) {

            bufferedOutputStream.write(bufferedInputStream.readAllBytes());
        }
    }

    public static void addWordIntoFile(final String file, final String word) throws IOException {

        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, true))) {
            bufferedOutputStream.write(word.getBytes());
        }
    }
}
