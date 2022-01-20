package day04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VowelStatisticsTest {
    VowelStatistics vowelStatistics = new VowelStatistics();

    @Test
    void countFileContent() {
        Map<Character, Integer> vowelMap = vowelStatistics.countFileContent(Path.of("src/test/resources/day04/english.txt"));
        System.out.println(vowelMap);
        assertTrue(vowelMap.keySet().size() > 0);
        assertEquals(null, vowelMap.get('i'));
    }
}