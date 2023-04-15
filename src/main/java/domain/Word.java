package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Word {
    private final String word;

    public Word(String word) {
        if (word.length() != 5) {
            throw new IllegalArgumentException("단어는 다섯글자로만 입력 가능합니다");
        }
        this.word = word;
    }

    public List<Color> compareWith(Word input) {
        List<Color> result = new ArrayList<>();
        char[] answerArray = word.toCharArray();
        char[] inputArray = input.word.toCharArray();

        for (int i = 0; i < answerArray.length; i++) {
            result.add(mapped(answerArray[i], inputArray[i]));
        }

        return result;
    }

    private Color mapped(char answer, char input) {
        if (answer == input) {
            return Color.GREEN;
        }
        if (isContains2(input)) {
            return Color.YELLOW;
        }
        return Color.GREY;
    }

    private boolean isContains2(char c) {
        return this.word.contains(String.valueOf(c));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

}