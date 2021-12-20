package org.example.structure;

import org.example.exception.NullFacultyInUniversityException;

import java.util.HashSet;
import java.util.Set;


public class University {
    Set<Faculty> facultyList;

    public University(Set<Faculty> facultyList) throws NullFacultyInUniversityException {
        this.facultyList = facultyList;
        if (facultyList == null || facultyList.isEmpty()) {
            throw new NullFacultyInUniversityException();
        }
    }

    public Set<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(Set<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    public Set<Student> getAllStudentsOfUniversity() {
        Set<Student> allStudentsInUniversity = new HashSet<>();
        for (Faculty faculty : facultyList) {
            allStudentsInUniversity.addAll(faculty.getAllStudentsOfFaculty());
        }
        return allStudentsInUniversity;
    }

    public int getOverageScoreBySubject(Set<Student> students, Subject subject) {
        int overageScoreBySubjectInGroup = 0;
        for (Student student : students) {
            overageScoreBySubjectInGroup += student.getOverageScoreBySubject(subject);
        }
        return overageScoreBySubjectInGroup / students.size();

    }

}
