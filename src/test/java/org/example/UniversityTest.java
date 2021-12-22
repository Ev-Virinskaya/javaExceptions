package org.example;

import org.example.constans.Faculties;
import org.example.constans.Subjects;
import org.example.exception.NullFacultyInUniversityException;
import org.example.exception.ScoreOutOfBoundException;
import org.example.structure.Faculty;
import org.example.structure.University;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UniversityTest extends AbstractAppTest {

    @Test
    void testGetFacultyList() {
    }

    @Test
    void setFacultyList() {
    }

    @Test
    void shouldGetOverageScoreBySubjectForUniversity() {
        double expectedOverageScore = 4.5;
        double actualOverageScore = university.getOverageScoreBySubjectForUniversity(Subjects.MATHS);

        Assertions.assertEquals(expectedOverageScore,actualOverageScore);
    }
    @Test
    void shouldThrowExceptionForGetFacultyListNull() {
        Assertions.assertThrows(NullFacultyInUniversityException.class, () -> new University(null));
    }

    @Test
    void shouldThrowExceptionForGetEmptyFacultyList() {
        Assertions.assertThrows(NullFacultyInUniversityException.class, () -> new University(new HashSet<>()));
    }
}