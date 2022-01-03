package org.example;

import org.example.constans.Subjects;
import org.example.exception.NullSubjectsForStudentException;
import org.example.beans.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class StudentTest extends AbstractAppTest {
    @Test
    public void shouldGetOverageScoreByAllSubjects() {
        double expectedOverageScore = 6;
        double actualOverageScore = student.getAverageScoreByAllSubjects();
        Assertions.assertEquals(expectedOverageScore,actualOverageScore);
    }
    @Test
    public void shouldGetOverageScoreBySubject() {
        double expectedOverageScore = 7.5;
        double actualOverageScore = student.getAverageScoreBySubject(Subjects.MATHS);
        Assertions.assertEquals(expectedOverageScore,actualOverageScore);
    }
    @Test
    public void shouldThrowExceptionForGetEmptySubjectsSet() {
        Assertions.assertThrows(NullSubjectsForStudentException.class, () -> new Student("Fedya", new HashSet<>()));
    }
    @Test
    public void shouldThrowExceptionForGetSubjectsSetNullValue() {
        Assertions.assertThrows(NullSubjectsForStudentException.class, () -> new Student("Fedya", null));
    }
}