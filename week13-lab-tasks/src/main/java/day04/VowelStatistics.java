package day04;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VowelStatistics {
    private static final String VOWELS = "aAeEiIoOuU";
    public Map<Character, Integer> countFileContent(Path path) {
        Map<Character, Integer> vowels = new TreeMap<>();
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line: lines) {
                for (Character ch : line.toCharArray()) {
                    if (VOWELS.contains(ch.toString())) {
                        ch = Character.toLowerCase(ch);
                        Integer count = vowels.get(ch);
                        vowels.put(ch, count != null ? count + 1 : 1);
                    }
                }
            }
        } catch (IOException exception) {
            throw new IllegalStateException("Can not read file!", exception);
        }
        return vowels;
    }
}
