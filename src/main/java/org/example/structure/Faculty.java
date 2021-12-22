package org.example.structure;

import org.example.constans.Faculties;
import org.example.constans.Subjects;
import org.example.exception.NullGroupsInFacultyException;

import java.util.*;

public class Faculty {
    private Faculties nameFaculty;
    private Set<Group> groupList;

    public Faculty(Faculties nameFaculty, Set<Group> groupList) throws NullGroupsInFacultyException {

        this.nameFaculty = nameFaculty;
        this.groupList = groupList;
        if (groupList == null || groupList.isEmpty()) {
            throw new NullGroupsInFacultyException();
        }
    }
    public Set<Student> getAllStudentsForFaculty() {
        Set<Student> allStudentsInFaculty = new HashSet<>();
        for (Group group : groupList) {
            allStudentsInFaculty.addAll(group.getStudentList());
        }
        return allStudentsInFaculty;
    }
    public double getOverageScoreBySubjectForFaculty(Subjects subject){
        double overageScore = 0;
        int numberGroupsHasSubject = 0;
        for (Group group : groupList) {
            if (group.checkHasSubjectInGroup(subject)) {
                overageScore = group.getOverageScoreBySubjectForGroup(subject);
                numberGroupsHasSubject++;
            }
        }
        return overageScore / numberGroupsHasSubject;
    }
}
