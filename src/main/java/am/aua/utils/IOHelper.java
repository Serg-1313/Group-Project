package am.aua.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOHelper {
    public static String playerFilePath = "src/main/am/aua/db/players.txt";

    public static void createFile(String path) throws IOException {
        Files.createFile(Paths.get(path));
    }

    public static void deleteFile(String path) throws IOException {
        Path modifiedPath = Paths.get(path);

        if (Files.exists(modifiedPath)) Files.delete(modifiedPath);
    }

    public static <T> void writeToFile(String path, T[] content) throws IOException {
        Path modifiedPath = Paths.get(path);
        if (!Files.exists(modifiedPath)) createFile(path);

        for (T line : content) {
            Files.writeString(modifiedPath, line.toString(), StandardCharsets.UTF_8);
        }
    }

    public static String[] getFromFile(String path) throws IOException {
        return Files.readAllLines(Paths.get((path))).toArray(new String[0]);
    }}
