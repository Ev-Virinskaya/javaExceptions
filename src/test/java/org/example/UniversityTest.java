package org.example;


import org.example.constans.Subjects;
import org.example.exception.NullFacultyInUniversityException;
import org.example.structure.University;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashSet;

class UniversityTest extends AbstractAppTest {

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