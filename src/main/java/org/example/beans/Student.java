package org.example.beans;

import org.example.constans.Subjects;
import org.example.exception.NullSubjectsForStudentException;

import java.util.Set;

public class Student {
    private final String studentName;
    private final Set<Subject> subjectSet;

    public Student(String studentName, Set<Subject> subjectSet) throws NullSubjectsForStudentException {
        this.studentName = studentName;
        if (subjectSet == null || subjectSet.isEmpty()) {
            throw new NullSubjectsForStudentException();
        }
        this.subjectSet = subjectSet;
    }

    public double getAverageScoreByAllSubjects() {
        double sumScore = 0;
        int countSubjectsWithScores = 0;
        for (Subject subject : subjectSet) {
            if (subject.getScores() != null && !subject.getScores().isEmpty()) {
                sumScore += subject.getAverageScore();
                countSubjectsWithScores++;
            }
        }
        return sumScore / countSubjectsWithScores;
    }

    public double getAverageScoreBySubject(Subjects currentSubject) {
        double averageScore = 0;
        for (Subject subject : subjectSet) {
            if (subject.getNameSubject().equals(currentSubject)) {
                averageScore = subject.getAverageScore();
            }
        }
        return averageScore;
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
