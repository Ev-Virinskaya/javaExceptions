package org.example.structure;

import org.example.constans.Faculties;
import org.example.constans.Groups;
import org.example.exception.NullSubjectsForStudentException;
import org.example.exception.ScoreOutOfBoundException;

import java.util.Set;

public class Student {
    private Faculties faculty;
    private Groups group;
    private Set<Subject> subjects;

    public Student(Faculties faculty, Groups group, Set<Subject> subjects) throws NullSubjectsForStudentException, ScoreOutOfBoundException {
        this.faculty = faculty;
        this.group = group;
        this.subjects = subjects;
        if (subjects == null || subjects.isEmpty()) {
            throw new NullSubjectsForStudentException();
        }
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public Groups getGroup() {
        return group;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public int getOverageScoreByAllSubjects(Set<Subject> subjects) {
        int overageScore = 0;
        for (Subject subject : subjects) {
            overageScore += getOverageScoreBySubject(subject);
        }
        return overageScore / subjects.size();
    }

    public int getOverageScoreBySubject(Subject subject) {
        int overageScore = 0;
        for (Subject sub : subjects) {
            if (sub.equals(subject)) {
                overageScore += sub.getOverageScore();
            }
        }
        return overageScore / subjects.size();
    }
}
