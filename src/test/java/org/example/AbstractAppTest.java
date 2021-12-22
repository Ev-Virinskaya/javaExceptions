package org.example;

import org.example.constans.Faculties;
import org.example.constans.Groups;
import org.example.constans.Subjects;
import org.example.exception.*;
import org.example.structure.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

abstract class AbstractAppTest {
    protected University university;
    protected Faculty faculty;
    protected Group group;
    protected Student student;
    protected Subject subject;

    @BeforeEach
    protected void setUp() {
        try {
            university = new University(getFacultyList());
            faculty = new Faculty(Faculties.FACULTY_ONE, getGroupList(Faculties.FACULTY_ONE));
            group = new Group(Groups.ONE, Faculties.FACULTY_ONE, getStudentsList(Groups.ONE));
            student = new Student("Ivanov", Groups.ONE, getSubjectSet("Ivanov"));
            subject = new Subject(Subjects.MATHS, Arrays.asList(2, 7, 4));
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    protected Set<Faculty> getFacultyList() {
        Set<Faculty> facultyList = new HashSet<>();
        try {
            facultyList.add(new Faculty(Faculties.FACULTY_ONE, getGroupList(Faculties.FACULTY_ONE)));
            facultyList.add(new Faculty(Faculties.FACULTY_TWO, getGroupList(Faculties.FACULTY_TWO)));
        } catch (NullGroupsInFacultyException e) {
            e.printStackTrace();
        }
        return facultyList;
    }

    protected Set<Group> getGroupList(Faculties faculties) {
        Set<Group> groupList = new HashSet<>();
        try {
            if (faculties.equals(Faculties.FACULTY_ONE)) {
                groupList.add(new Group(Groups.ONE, faculties, getStudentsList(Groups.ONE)));
                groupList.add(new Group(Groups.TWO, faculties, getStudentsList(Groups.TWO)));
            } else if (faculties.equals(Faculties.FACULTY_TWO)) {
                groupList.add(new Group(Groups.FOUR, faculties, getStudentsList(Groups.FOUR)));
                groupList.add(new Group(Groups.TREE, faculties, getStudentsList(Groups.TREE)));
            }
        } catch (NullStudentsInGroupException e) {
            e.printStackTrace();
        }
        return groupList;
    }

    protected Set<Student> getStudentsList(Groups groups) {
        Set<Student> studentsList = new HashSet<>();
        try {
            if (groups.equals(Groups.ONE)) {
                studentsList.add(new Student("Ivanov", groups, getSubjectSet("Ivanov")));
                studentsList.add(new Student("Ruban", groups, getSubjectSet("Ruban")));
                studentsList.add(new Student("Petrov", groups, getSubjectSet("Petrov")));
            } else if (groups.equals(Groups.TWO)) {
                studentsList.add(new Student("Sidorov", groups, getSubjectSet("Sidorov")));
                studentsList.add(new Student("Kuznecov", groups, getSubjectSet("Kuznecov")));
            } else if (groups.equals(Groups.TREE)) {
                studentsList.add(new Student("Virinsky", groups, getSubjectSet("Virinsky")));
                studentsList.add(new Student("Rukan", groups, getSubjectSet("Rukan")));
            } else if (groups.equals(Groups.FOUR)) {
                studentsList.add(new Student("Pupkin", groups, getSubjectSet("Pupkin")));
            }
        } catch (NullSubjectsForStudentException e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    protected Set<Subject> getSubjectSet(String studentName) {
        Set<Subject> subjectSet = new HashSet<>();
        try {
            if (studentName.equals("Ivanov")) {
                subjectSet.add(new Subject(Subjects.MATHS, Arrays.asList(10, 5)));
                subjectSet.add(new Subject(Subjects.BIOLOGY, new ArrayList<>()));
                subjectSet.add(new Subject(Subjects.ECONOMY, Arrays.asList(0, 9)));
            } else if (studentName.equals("Ruban")) {
                subjectSet.add(new Subject(Subjects.MATHS, Arrays.asList(2, 5)));
                subjectSet.add(new Subject(Subjects.BIOLOGY, Arrays.asList(5)));
                subjectSet.add(new Subject(Subjects.ECONOMY, Arrays.asList(10, 0)));
            } else if (studentName.equals("Petrov")) {
                subjectSet.add(new Subject(Subjects.MATHS, Arrays.asList(2, 3, 4)));
                subjectSet.add(new Subject(Subjects.BIOLOGY, Arrays.asList(2, 5)));
                subjectSet.add(new Subject(Subjects.ECONOMY, Arrays.asList(1, 5)));
            } else if (studentName.equals("Sidorov")) {
                subjectSet.add(new Subject(Subjects.PHILOSOPHIC, Arrays.asList(5, 8)));
                subjectSet.add(new Subject(Subjects.ECONOMY, Arrays.asList(10, 0)));
            } else if (studentName.equals("Kuznecov")) {
                subjectSet.add(new Subject(Subjects.PHILOSOPHIC, Arrays.asList(9)));
                subjectSet.add(new Subject(Subjects.ECONOMY, Arrays.asList(10, 5)));
            } else if (studentName.equals("Virinsky")) {
                subjectSet.add(new Subject(Subjects.MATHS, Arrays.asList(4, 9)));
            } else if (studentName.equals("Rukan")) {
                subjectSet.add(new Subject(Subjects.MATHS, Arrays.asList(2)));
            } else if (studentName.equals("Pupkin")) {
                subjectSet.add(new Subject(Subjects.ECONOMY, Arrays.asList(0, 9)));
            }
        } catch (ScoreOutOfBoundException e) {
            e.printStackTrace();
        }
        return subjectSet;
    }
}
