package com.example.translator.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TranslatorService {

    public File reverseorder(String inputFileName, String outputFileName) throws IOException {

        File outputFile = new File(outputFileName);
        InputStream in = new FileInputStream(inputFileName);
        OutputStream out = new FileOutputStream(outputFile);
        String x = new BufferedReader(
                new InputStreamReader(in, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

        String[] estrofas = x.split("\n\n");


        String sCadenaInvertida = "";
        for(int i=estrofas.length-1; i>=0;i--){
            sCadenaInvertida = sCadenaInvertida + estrofas[i];
            sCadenaInvertida = sCadenaInvertida + "\n\n";

        }
        StreamUtils.copy(sCadenaInvertida, StandardCharsets.UTF_8, out);
        return  outputFile;
    }

    public File statistics (String inputFileName, String outputFileName) throws IOException{
        File outputFile = new File(outputFileName);
        InputStream in = new FileInputStream(inputFileName);
        OutputStream out = new FileOutputStream(outputFile);
        String x = new BufferedReader(
                new InputStreamReader(in, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

        String[] estrofas = x.split("\n\n");
        String totalEstrofas = "total estrofas: " + estrofas.length + "\n";


        String[] palabras = x.split("\\s");
        Map<String, Integer> occurrences = new HashMap<String, Integer>();

        for ( String Word : palabras ) {
            Integer oldCount = occurrences.get(Word);
            if ( oldCount == null ) {
                oldCount = 0;
            }
            occurrences.put(Word, oldCount + 1);
        }

        System.out.println(occurrences.toString());
        int maxEntry = 0;
        String word = "";
        for (Map.Entry<String,Integer> entry : occurrences.entrySet())
        {
            if (entry.getValue().compareTo(maxEntry) > 0)
            {
                maxEntry = entry.getValue();
                word = entry.getKey();
            }
        }


        String palabraRepetida = "Palabra mas repetida " + word + " numero de veces " + maxEntry + "\n";
        String statistics = totalEstrofas + palabraRepetida;
        StreamUtils.copy(statistics, StandardCharsets.UTF_8, out);
        return outputFile;
    }

    public File replace(String inputFileName, String outputFileName) throws IOException{
        File outputFile = new File(outputFileName);
        InputStream in = new FileInputStream(inputFileName);
        OutputStream out = new FileOutputStream(outputFile);
        String x = new BufferedReader(
                new InputStreamReader(in, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

        String reemplazar = x.replaceAll("I'm", "you");
        StreamUtils.copy(reemplazar, StandardCharsets.UTF_8, out);
        return outputFile;
    }
}
