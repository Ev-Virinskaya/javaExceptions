package org.example.structure;

import org.example.exception.NullGroupsInFacultyException;

import java.util.*;

public class Faculty {
    private Set<Group> groupList;

    public Faculty(Set<Group> groupList) throws NullGroupsInFacultyException {
        this.groupList = groupList;
        if (groupList == null || groupList.isEmpty()) {
            throw new NullGroupsInFacultyException();
        }
    }

    public Set<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(Set<Group> groupList) {
        this.groupList = groupList;
    }

    public Set<Student> getAllStudentsOfFaculty() {
        Set<Student> allStudentsInFaculty = new HashSet<>();
        for (Group group : groupList) {
            allStudentsInFaculty.addAll(group.getStudentList());
        }
        return allStudentsInFaculty;
    }
}
