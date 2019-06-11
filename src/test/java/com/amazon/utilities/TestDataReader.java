package com.amazon.utilities;

import lombok.extern.log4j.Log4j2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Log4j2
public class TestDataReader {

    // Base class to read data from test data file

    private static TestDataReader reader;

    private Properties testData;

    private TestDataReader() {

        try {
            testData = new Properties();
            testData.load(getClass().getClassLoader().getResourceAsStream("test_data_files/testData.properties"));
        } catch (FileNotFoundException e) {
            log.error("File testData.properties not found:" + e.getMessage());
            log.debug(e.getMessage(), e);
        } catch (IOException e) {
            log.error("Error reading testData.properties:" + e.getMessage());
            log.debug(e.getMessage(), e);
        }
    }

    public String getData(String key) {

        return testData.getProperty(key);
    }

    public static TestDataReader getDataReader() {
        if (null == reader) {
            reader = new TestDataReader();
        }
        return reader;
    }
}