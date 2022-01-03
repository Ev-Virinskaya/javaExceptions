package org.example;


import org.example.constans.Subjects;
import org.example.exception.NullFacultyInUniversityException;
import org.example.beans.University;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashSet;

public class UniversityTest extends AbstractAppTest {

    @Test
    public void shouldGetOverageScoreBySubjectForUniversity() {
        double expectedOverageScore = 4.5;
        double actualOverageScore = university.getAverageScoreBySubjectForUniversity(Subjects.MATHS);
        Assertions.assertEquals(expectedOverageScore,actualOverageScore);
    }
    @Test
    public void shouldThrowExceptionForGetFacultyListNull() {
        Assertions.assertThrows(NullFacultyInUniversityException.class, () -> new University(null));
    }
    @Test
    public void shouldThrowExceptionForGetEmptyFacultyList() {
        Assertions.assertThrows(NullFacultyInUniversityException.class, () -> new University(new HashSet<>()));
    }
}