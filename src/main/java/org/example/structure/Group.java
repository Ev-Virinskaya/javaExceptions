package org.example.structure;

import org.example.constans.Faculties;
import org.example.constans.Groups;
import org.example.constans.Subjects;
import org.example.exception.NullStudentsInGroupException;

import java.util.Set;

public class Group {
    private Groups nameGroup;
    private Faculties faculty;
    private Set<Student> studentList;

    public Group(Groups nameGroup, Faculties faculty, Set<Student> studentList) throws NullStudentsInGroupException {
        this.nameGroup = nameGroup;
        this.faculty = faculty;
        if (studentList == null || studentList.isEmpty()) {
            throw new NullStudentsInGroupException();
        }
        this.studentList = studentList;
    }
    public Set<Student> getStudentList() {
        return studentList;
    }

    public double getOverageScoreBySubjectForGroup(Subjects subject) {
        double overageScore = 0;
        if (checkHasSubjectInGroup(subject)) {
            for (Student student : studentList) {
                overageScore += student.getOverageScoreBySubject(subject);
            }
        }
        return overageScore / studentList.size();
    }

    public boolean checkHasSubjectInGroup(Subjects subject) {
        return studentList.stream().allMatch(student -> student.checkHasSubject(subject));
    }
}
