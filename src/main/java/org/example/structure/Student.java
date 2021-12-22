package org.example.structure;

import org.example.constans.Groups;
import org.example.constans.Subjects;
import org.example.exception.NullSubjectsForStudentException;

import java.util.*;

public class Student {
    private String studentName;
    private Groups group;
    private Set<Subject> subjectSet;

    public Student(String studentName, Groups group, Set<Subject> subjectSet) throws NullSubjectsForStudentException {
        this.studentName = studentName;
        this.group = group;
        if (subjectSet == null || subjectSet.isEmpty()) {
            throw new NullSubjectsForStudentException();
        }
        this.subjectSet = subjectSet;
    }

    public double getOverageScoreByAllSubjects() {
        double sumScore = 0;
        int countSubjectsWithScores = 0;
        for (Subject subject : subjectSet) {
            if (subject.getScores() != null && !subject.getScores().isEmpty()) {
                sumScore += subject.getOverageScore();
                countSubjectsWithScores++;
            }
        }
        return sumScore / countSubjectsWithScores;
    }

    public double getOverageScoreBySubject(Subjects currentSubject) {
        double overageScore = 0;
        for (Subject subject : subjectSet) {
            if (subject.getNameSubject().equals(currentSubject)) {
                overageScore = subject.getOverageScore();
            }
        }
        return overageScore;
    }

    public boolean checkHasSubject(Subjects currentSubject) {
        for (Subject subject : subjectSet) {
            if (subject.getNameSubject().equals(currentSubject)) {
                return true;
            }
        }
        return false;
    }
}
