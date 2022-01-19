package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuizResultTest {
    @Test
    void createTest() {
        QuizResult result = new QuizResult("src/test/resources/day02/result.txt");
        assertEquals(List.of('A', 'B', 'A', 'C', 'D'), result.getSolution());
        assertEquals(4, result.getUserAnswers().keySet().size());
        assertEquals(List.of('A', 'C', 'C', 'B', 'X'), result.getUserAnswers().get("AB123").getAnswers());
    }

    @Test
    void isRightUserAnswer() {
        QuizResult result = new QuizResult("src/test/resources/day02/result.txt");
        assertTrue(result.isRightUserAnswer("AB123", 1));
        assertFalse(result.isRightUserAnswer("AB123", 4));
    }

    @Test
    void isRightUserAnswerExceptionTest() {
        QuizResult result = new QuizResult("src/test/resources/day02/result.txt");
        assertThrows(IllegalArgumentException.class, ()-> result.isRightUserAnswer("AB123", 0));
        assertThrows(IllegalArgumentException.class, ()-> result.isRightUserAnswer("AB123", 6));
    }

    @Test
    void getWinner() {
        QuizResult result = new QuizResult("src/test/resources/day02/result.txt");
        assertEquals("GH1234", result.getWinner());
    }
}