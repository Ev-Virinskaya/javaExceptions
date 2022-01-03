package org.example;

import org.example.constans.Faculties;
import org.example.constans.Subjects;
import org.example.exception.NullGroupsInFacultyException;
import org.example.beans.Faculty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class FacultyTest extends AbstractAppTest {
    @Test
    public void shouldGetAverageScoreBySubjectForFaculty() {
        double expectedAverageScore = 4.666666666666667;
        double actualAverageScore = faculty.getAverageScoreBySubjectForFaculty(Subjects.MATHS);
        Assertions.assertEquals(expectedAverageScore, actualAverageScore);
    }

    @Test
    public void shouldThrowExceptionForGetEmptyStudentsSet() {
        Assertions.assertThrows(NullGroupsInFacultyException.class, () -> new Faculty(Faculties.FACULTY_ONE, new HashSet<>()));
    }

    @Test
    public void shouldThrowExceptionForGetStudentsSetNullValue() {
        Assertions.assertThrows(NullGroupsInFacultyException.class, () -> new Faculty(Faculties.FACULTY_ONE, null));
    }
}