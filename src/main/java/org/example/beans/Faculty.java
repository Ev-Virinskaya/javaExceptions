package org.example.beans;

import org.example.constans.Faculties;
import org.example.constans.Subjects;
import org.example.exception.NullGroupsInFacultyException;

import java.util.HashSet;
import java.util.Set;

public class Faculty {
    private Faculties nameFaculty;
    private final Set<Group> groupSet;

    public Faculty(Set<Group> groupList) throws NullGroupsInFacultyException {
        this.groupSet = groupList;
        if (groupList == null || groupList.isEmpty()) {
            throw new NullGroupsInFacultyException();
        }
    }

    public Faculty(Faculties nameFaculty, Set<Group> groupSet) throws NullGroupsInFacultyException {
        this (groupSet);
        this.nameFaculty = nameFaculty;
    }

    public Set<Student> getAllStudentsForFaculty() {
        Set<Student> allStudentsInFaculty = new HashSet<>();
        for (Group group : groupSet) {
            allStudentsInFaculty.addAll(group.getStudentSet());
        }
        return allStudentsInFaculty;
    }
    public double getAverageScoreBySubjectForFaculty(Subjects subject) {
        double averageScore = 0;
        int numberGroupsHasSubject = 0;
        for (Group group : groupSet) {
          if (group.checkHasSubjectInGroup(subject)) {
                averageScore = group.getAverageScoreBySubjectForGroup(subject);
                numberGroupsHasSubject++;
            }
        }
        return averageScore / numberGroupsHasSubject;
    }
}
