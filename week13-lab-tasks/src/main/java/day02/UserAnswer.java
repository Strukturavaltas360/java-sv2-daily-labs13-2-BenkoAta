package day02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserAnswer {
    private String userId;
    private List<Character> answers = new ArrayList<>();

    public UserAnswer(String userId) {
        this.userId = userId;
    }

    public boolean isRightAnswer(List<Character> solution, int numberOfAnswer) {
        if (numberOfAnswer < 1 || numberOfAnswer > solution.size()) {
            throw new IllegalArgumentException("numberOfAnswer is out of range!");
        }
        Character goodAnswer = solution.get(numberOfAnswer - 1);
        if (numberOfAnswer < answers.size()) {
            return goodAnswer.equals(answers.get(numberOfAnswer - 1));
        }
        return false;
    }

    public int calculatePoints(List<Character> solution) {
        int result = 0;
        for (int i = 0; i < solution.size() && i < answers.size(); i++) {
            Character answer = answers.get(i);
            if (solution.get(i).equals(answer)) {
                result += i + 1;
            } else if (!answer.equals('X')) {
                result -= 2;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAnswer that = (UserAnswer) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    public void addAnswer(Character answer) {
        answers.add(answer);
    }

    @Override
    public String toString() {
        return "UserAnswer{" +
                "userId='" + userId + '\'' +
                ", answers=" + answers +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public List<Character> getAnswers() {
        return answers;
    }
}
