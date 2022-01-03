package org.example.beans;

import org.example.constans.Groups;
import org.example.constans.Subjects;
import org.example.exception.NullStudentsInGroupException;

import java.util.Set;

public class Group {
    private Groups nameGroup;
    private final Set<Student> studentSet;

    public Group(Set<Student> studentList) throws NullStudentsInGroupException {
        if (studentList == null || studentList.isEmpty()) {
            throw new NullStudentsInGroupException();
        }
        this.studentSet = studentList;
    }

    public Group(Groups nameGroup, Set<Student> studentSet) throws NullStudentsInGroupException {
        this(studentSet);
        this.nameGroup = nameGroup;

    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public double getAverageScoreBySubjectForGroup(Subjects subject) {
        double averageScore = 0;
        if (checkHasSubjectInGroup(subject)) {
            for (Student student : studentSet) {
                averageScore += student.getAverageScoreBySubject(subject);
            }
        }
        return averageScore / studentSet.size();
    }

    public boolean checkHasSubjectInGroup(Subjects subject) {
        return studentSet.stream().allMatch(student -> student.checkHasSubject(subject));
    }
}
