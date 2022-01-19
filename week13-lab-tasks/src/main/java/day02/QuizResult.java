package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuizResult {
    private List<Character> solution;
    private Map<String, UserAnswer> userAnswers = new HashMap<>();

    public QuizResult(String filename) {
        try {
            readResults(Path.of(filename));
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file!", e);
        }
    }

    public boolean isRightUserAnswer(String userId, int numberOfAnswer) {
        return userAnswers.get(userId).isRightAnswer(solution, numberOfAnswer);
    }

    public String getWinner() {
        Optional<UserAnswer> winner = userAnswers.entrySet().stream()
                .map(stringUserAnswerEntry -> stringUserAnswerEntry.getValue())
                .sorted(Comparator.comparing(userAnswer -> userAnswer.calculatePoints(solution), Comparator.reverseOrder()))
                .findFirst();
        if (winner.isEmpty()) {
            throw new IllegalStateException("Can not find winner!");
        }
        return winner.get().getUserId();
    }

    private void readResults(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        if (lines.size() < 2) {
            throw new IllegalStateException("Invalid file!");
        }
        readSolution(lines.get(0));
        lines.remove(0);
        readUserAnswers(lines);
    }

    private void readUserAnswers(List<String> lines) {
        for (String line : lines) {
            String[] parts = line.trim().split(" ");
            addUserAnswer(parts[0].trim(), parts[1].trim().charAt(0));
        }
    }

    private void addUserAnswer(String userId, Character answer) {
        UserAnswer userAnswer = userAnswers.get(userId);
        if (userAnswer == null) {
            userAnswer = new UserAnswer(userId);
            userAnswers.put(userId, userAnswer);
        }
        userAnswer.addAnswer(answer);
    }

    private void readSolution(String line) {
        solution = Stream
                .iterate(0, i -> i < line.length(), i -> i + 1)
                .map(i -> line.charAt(i))
                .collect(Collectors.toList());
    }

    public List<Character> getSolution() {
        return solution;
    }

    public Map<String, UserAnswer> getUserAnswers() {
        return userAnswers;
    }
}
