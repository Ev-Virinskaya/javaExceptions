package org.example;

import org.example.constans.Faculties;
import org.example.constans.Groups;
import org.example.constans.Subjects;
import org.example.exception.NullGroupsInFacultyException;
import org.example.exception.NullStudentsInGroupException;
import org.example.exception.ScoreOutOfBoundException;
import org.example.structure.Faculty;
import org.example.structure.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class FacultyTest extends AbstractAppTest {

    @Test
    void getOverageScoreBySubjectForFaculty() throws ScoreOutOfBoundException {
        double expectedOverageScore = 4.666666666666667;
        double actualOverageScore = faculty.getOverageScoreBySubjectForFaculty(Subjects.MATHS);
        Assertions.assertEquals(expectedOverageScore,actualOverageScore);
    }

    @Test
    void shouldThrowExceptionForGetEmptyStudentsSet() {
        Assertions.assertThrows(NullGroupsInFacultyException.class, () -> new Faculty(Faculties.FACULTY_ONE, new HashSet<>()));
    }
    @Test
    void shouldThrowExceptionForGetStudentsSetNullValue() {
        Assertions.assertThrows(NullGroupsInFacultyException.class, () -> new Faculty(Faculties.FACULTY_ONE,null));
    }
}