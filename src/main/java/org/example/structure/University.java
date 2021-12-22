package org.example.structure;

import org.example.constans.Subjects;
import org.example.exception.NullFacultyInUniversityException;
import org.example.exception.ScoreOutOfBoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class University {
    Set<Faculty> facultyList;

    public University(Set<Faculty> facultyList) throws NullFacultyInUniversityException {
        this.facultyList = facultyList;
        if (facultyList == null || facultyList.isEmpty()) {
            throw new NullFacultyInUniversityException();
        }
    }
    public List<Student> getAllStudentsOfUniversity() {
        List<Student> allStudentsInUniversity = new ArrayList<>();
        for (Faculty faculty : facultyList) {
            allStudentsInUniversity.addAll(faculty.getAllStudentsForFaculty());
        }
        return allStudentsInUniversity;
    }

    public double getOverageScoreBySubjectForUniversity(Subjects subject) {
        double overageScoreBySubjectInGroup = 0;
        int numberOfStudentsHaveSubject = 0;
        for (Student student : getAllStudentsOfUniversity()) {
            if(student.checkHasSubject(subject)){
            overageScoreBySubjectInGroup += student.getOverageScoreBySubject(subject);
            numberOfStudentsHaveSubject++;
            }
        }
        return overageScoreBySubjectInGroup / numberOfStudentsHaveSubject;

    }


}
