package org.example;

import org.example.constans.Groups;
import org.example.constans.Subjects;
import org.example.exception.NullStudentsInGroupException;
import org.example.beans.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class GroupTest extends AbstractAppTest {
    @Test
    public void getOverageScoreBySubjectForGroup() {
        double expectedOverageScore = 4.666666666666667;
        double actualOverageScore = group.getAverageScoreBySubjectForGroup(Subjects.MATHS);
        Assertions.assertEquals(expectedOverageScore,actualOverageScore);
    }
    @Test
    public void shouldThrowExceptionForGetEmptyStudentsSet() {
        Assertions.assertThrows(NullStudentsInGroupException.class, () -> new Group(Groups.FIVE, new HashSet<>()));
    }
    @Test
    public void shouldThrowExceptionForGetStudentsSetNullValue() {
        Assertions.assertThrows(NullStudentsInGroupException.class, () -> new Group(Groups.FIVE, null));
    }
}