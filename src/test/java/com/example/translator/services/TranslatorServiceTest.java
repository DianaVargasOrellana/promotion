package com.example.translator.services;

import org.testng.annotations.Test;
import org.springframework.util.StreamUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TranslatorServiceTest {

    @Test
    void reverseorder() throws IOException {
        TranslatorService t = new TranslatorService();
        String inputFileName = "src/main/resources/text/original.txt";
        String outputFileName = "src/main/resources/text/estrofasEnOrdenInverso.txt";
         File outputFile = t.reverseorder(inputFileName, outputFileName);
        assertTrue(outputFile.exists());

    }
    @Test
    void statistics() throws IOException {
        TranslatorService t = new TranslatorService();
        String inputFileName = "src/main/resources/text/estrofasEnOrdenInverso.txt";
        String outputFileName = "src/main/resources/text/statistics.txt";
        File outputFile = t.statistics(inputFileName,outputFileName);
        assertTrue(outputFile.exists());
    }
    @Test
    void replace() throws IOException {
        TranslatorService t = new TranslatorService();
        String inputFileName = "src/main/resources/text/output.txt";
        String outputFileName = "src/main/resources/text/finalOutput.txt";
        File outputFile = t.replace(inputFileName,outputFileName);
        assertTrue(outputFile.exists());

    }
}