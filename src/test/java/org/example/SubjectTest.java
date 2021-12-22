package org.example;

import org.example.AbstractAppTest;
import org.example.constans.Groups;
import org.example.constans.Subjects;
import org.example.exception.NullFacultyInUniversityException;
import org.example.exception.ScoreOutOfBoundException;
import org.example.structure.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class SubjectTest extends AbstractAppTest {

    @Test
    void shouldGetOverageScore() {
        double expectedOverageScore = 4.333333333333333;
        double actualOverageScore = subject.getOverageScore();
        Assertions.assertEquals(expectedOverageScore,actualOverageScore);

    }
    @Test
    void shouldThrowExceptionForScoreLessThanNull() {
        Assertions.assertThrows(ScoreOutOfBoundException.class, () ->  new Subject(Subjects.MATHS, Arrays.asList(-1, 0, 2)));
    }

    @Test
    void shouldThrowExceptionForScoreBiggerThanTen() {
        Assertions.assertThrows(ScoreOutOfBoundException.class, () ->  new Subject(Subjects.MATHS, Arrays.asList(11, 0, 2)));
    }
}