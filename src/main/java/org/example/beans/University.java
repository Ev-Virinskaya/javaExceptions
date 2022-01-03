package org.example.beans;

import org.example.constans.Subjects;
import org.example.exception.NullFacultyInUniversityException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class University {
    private final Set<Faculty> facultySet;

    public University(Set<Faculty> facultySet) throws NullFacultyInUniversityException {
        this.facultySet = facultySet;
        if (facultySet == null || facultySet.isEmpty()) {
            throw new NullFacultyInUniversityException();
        }
    }
    public List<Student> getAllStudentsOfUniversity() {
        List<Student> allStudentsInUniversity = new ArrayList<>();
        for (Faculty faculty : facultySet) {
            allStudentsInUniversity.addAll(faculty.getAllStudentsForFaculty());
        }
        return allStudentsInUniversity;
    }

    public double getAverageScoreBySubjectForUniversity(Subjects subject) {
        double averageScoreBySubjectInGroup = 0;
        int numberOfStudentsHaveSubject = 0;
        for (Student student : getAllStudentsOfUniversity()) {
            if(student.checkHasSubject(subject)){
            averageScoreBySubjectInGroup += student.getAverageScoreBySubject(subject);
            numberOfStudentsHaveSubject++;
            }
        }
        return averageScoreBySubjectInGroup / numberOfStudentsHaveSubject;

    }


}
