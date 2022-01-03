package org.example;

import org.example.constans.Subjects;
import org.example.exception.ScoreOutOfBoundException;
import org.example.beans.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SubjectTest extends AbstractAppTest {

    @Test
    public void shouldGetOverageScore() {
        double expectedOverageScore = 4.333333333333333;
        double actualOverageScore = subject.getAverageScore();
        Assertions.assertEquals(expectedOverageScore,actualOverageScore);
    }
    @Test
    public void shouldThrowExceptionForScoreLessThanNull() {
        Assertions.assertThrows(ScoreOutOfBoundException.class, () ->  new Subject(Subjects.MATHS, Arrays.asList(-1, 0, 2)));
    }
    @Test
    public void shouldThrowExceptionForScoreBiggerThanTen() {
        Assertions.assertThrows(ScoreOutOfBoundException.class, () ->  new Subject(Subjects.MATHS, Arrays.asList(11, 0, 2)));
    }
}