package org.example;

import org.example.constans.Groups;
import org.example.constans.Subjects;
import org.example.exception.NullFacultyInUniversityException;
import org.example.exception.NullSubjectsForStudentException;
import org.example.structure.Student;
import org.example.structure.University;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest extends AbstractAppTest {

    @Test
    void shouldGetOverageScoreByAllSubjects() {
        double expectedOverageScore = 6;
        double actualOverageScore = student.getOverageScoreByAllSubjects();
        Assertions.assertEquals(expectedOverageScore,actualOverageScore);
    }

    @Test
    void shouldGetOverageScoreBySubject() {
        double expectedOverageScore = 7.5;
        double actualOverageScore = student.getOverageScoreBySubject(Subjects.MATHS);
        Assertions.assertEquals(expectedOverageScore,actualOverageScore);

    }
    @Test
    void shouldThrowExceptionForGetEmptySubjectsSet() {
        Assertions.assertThrows(NullSubjectsForStudentException.class, () -> new Student("Fedya", Groups.FIVE, new HashSet<>()));
    }
    @Test
    void shouldThrowExceptionForGetSubjectsSetNullValue() {
        Assertions.assertThrows(NullSubjectsForStudentException.class, () -> new Student("Fedya", Groups.FIVE, null));
    }
}