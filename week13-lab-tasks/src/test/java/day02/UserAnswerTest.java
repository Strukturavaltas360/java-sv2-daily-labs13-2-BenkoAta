package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserAnswerTest {
    UserAnswer answer = new UserAnswer("user");

    @BeforeEach
    void init() {
        answer.addAnswer('A');
        answer.addAnswer('B');
        answer.addAnswer('C');
        answer.addAnswer('D');
        answer.addAnswer('X');
    }

    @Test
    void isRightAnswer() {
        List<Character> solution = List.of('B', 'B', 'B', 'B', 'B');
        assertTrue(answer.isRightAnswer(solution, 2));
        assertFalse(answer.isRightAnswer(solution, 1));
    }

    @Test
    void isRightAnswerExceptionTest() {
        List<Character> solution = List.of('B', 'B', 'B', 'B', 'B');
        assertThrows(IllegalArgumentException.class, () -> answer.isRightAnswer(solution, 0));
        assertThrows(IllegalArgumentException.class, () -> answer.isRightAnswer(solution, 6));
    }

    @Test
    void calculatePoints() {
        List<Character> solution1 = List.of('B', 'B', 'B', 'B', 'B');
        List<Character> solution2 = List.of('A', 'B', 'C', 'B', 'B');
        assertEquals(-4, answer.calculatePoints(solution1));
        assertEquals(4, answer.calculatePoints(solution2));
    }
}