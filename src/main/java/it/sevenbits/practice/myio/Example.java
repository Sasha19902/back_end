package it.sevenbits.practice.myio;

public final class Example {

    public static int getLongestLineCharsCount(MyStringReader fileReader) throws MyFileReaderException {
        int maxLength = 0;
        int bufferLength = 0;

        while (fileReader.hasMoreLines()) {
            bufferLength = fileReader.readLine().length();

            if (bufferLength > maxLength) {
                maxLength = bufferLength;
            }
        }

        return maxLength;
    }
}
