package com.mr3nz1.productManagementSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Logger {
    public static void log(String log) {
        try {
            Files.write(Paths.get("logs.txt"), log.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
