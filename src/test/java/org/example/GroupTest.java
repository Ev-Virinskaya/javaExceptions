package org.example;

import org.example.constans.Faculties;
import org.example.constans.Groups;
import org.example.constans.Subjects;
import org.example.exception.NullStudentsInGroupException;
import org.example.structure.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class GroupTest extends AbstractAppTest {
    @Test
    void getOverageScoreBySubjectForGroup() {
        double expectedOverageScore = 4.666666666666667;
        double actualOverageScore = group.getOverageScoreBySubjectForGroup(Subjects.MATHS);
        Assertions.assertEquals(expectedOverageScore,actualOverageScore);
    }
    @Test
    void shouldThrowExceptionForGetEmptyStudentsSet() {
        Assertions.assertThrows(NullStudentsInGroupException.class, () -> new Group(Groups.FIVE, Faculties.FACULTY_ONE, new HashSet<>()));
    }
    @Test
    void shouldThrowExceptionForGetStudentsSetNullValue() {
        Assertions.assertThrows(NullStudentsInGroupException.class, () -> new Group(Groups.FIVE, Faculties.FACULTY_ONE, null));
    }
}