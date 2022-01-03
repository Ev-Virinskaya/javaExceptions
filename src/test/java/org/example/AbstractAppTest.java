package org.example;

import org.example.constans.Faculties;
import org.example.constans.Groups;
import org.example.constans.Subjects;
import org.example.exception.*;
import org.example.beans.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;

abstract class AbstractAppTest {
    University university;
    Faculty faculty;
    Group group;
    Student student;
    Subject subject;

    @BeforeEach
    void setUp() {
        try {
            university = new University(getFacultyList());
            faculty = new Faculty(Faculties.FACULTY_ONE, getGroupList(Faculties.FACULTY_ONE));
            group = new Group(Groups.ONE, getStudentsList(Groups.ONE));
            student = new Student("Ivanov", getSubjectSet("Ivanov"));
            subject = new Subject(Subjects.MATHS, Arrays.asList(2, 7, 4));
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    Set<Faculty> getFacultyList() {
        Set<Faculty> facultyList = new HashSet<>();
        try {
            facultyList.add(new Faculty(Faculties.FACULTY_ONE, getGroupList(Faculties.FACULTY_ONE)));
            facultyList.add(new Faculty(Faculties.FACULTY_TWO, getGroupList(Faculties.FACULTY_TWO)));
        } catch (NullGroupsInFacultyException e) {
            e.printStackTrace();
        }
        return facultyList;
    }

    Set<Group> getGroupList(Faculties faculties) {
        Set<Group> groupList = new HashSet<>();
        try {
            if (faculties.equals(Faculties.FACULTY_ONE)) {
                groupList.add(new Group(Groups.ONE, getStudentsList(Groups.ONE)));
                groupList.add(new Group(Groups.TWO, getStudentsList(Groups.TWO)));
            } else if (faculties.equals(Faculties.FACULTY_TWO)) {
                groupList.add(new Group(Groups.FOUR, getStudentsList(Groups.FOUR)));
                groupList.add(new Group(Groups.TREE, getStudentsList(Groups.TREE)));
            }
        } catch (NullStudentsInGroupException e) {
            e.printStackTrace();
        }
        return groupList;
    }

    Set<Student> getStudentsList(Groups groups) {
        Set<Student> studentsList = new HashSet<>();
        try {
            if (groups.equals(Groups.ONE)) {
                studentsList.add(new Student("Ivanov", getSubjectSet("Ivanov")));
                studentsList.add(new Student("Ruban", getSubjectSet("Ruban")));
                studentsList.add(new Student("Petrov", getSubjectSet("Petrov")));
            } else if (groups.equals(Groups.TWO)) {
                studentsList.add(new Student("Sidorov", getSubjectSet("Sidorov")));
                studentsList.add(new Student("Kuznecov", getSubjectSet("Kuznecov")));
            } else if (groups.equals(Groups.TREE)) {
                studentsList.add(new Student("Virinsky", getSubjectSet("Virinsky")));
                studentsList.add(new Student("Rukan", getSubjectSet("Rukan")));
            } else if (groups.equals(Groups.FOUR)) {
                studentsList.add(new Student("Pupkin", getSubjectSet("Pupkin")));
            }
        } catch (NullSubjectsForStudentException e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    Set<Subject> getSubjectSet(String studentName) {
        Set<Subject> subjectSet = new HashSet<>();
        try {
            switch (studentName) {
                case "Ivanov":
                    subjectSet.add(new Subject(Subjects.MATHS, Arrays.asList(10, 5)));
                    subjectSet.add(new Subject(Subjects.BIOLOGY, new ArrayList<>()));
                    subjectSet.add(new Subject(Subjects.ECONOMY, Arrays.asList(0, 9)));
                    break;
                case "Ruban":
                    subjectSet.add(new Subject(Subjects.MATHS, Arrays.asList(2, 5)));
                    subjectSet.add(new Subject(Subjects.BIOLOGY, Collections.singletonList(5)));
                    subjectSet.add(new Subject(Subjects.ECONOMY, Arrays.asList(10, 0)));
                    break;
                case "Petrov":
                    subjectSet.add(new Subject(Subjects.MATHS, Arrays.asList(2, 3, 4)));
                    subjectSet.add(new Subject(Subjects.BIOLOGY, Arrays.asList(2, 5)));
                    subjectSet.add(new Subject(Subjects.ECONOMY, Arrays.asList(1, 5)));
                    break;
                case "Sidorov":
                    subjectSet.add(new Subject(Subjects.PHILOSOPHIC, Arrays.asList(5, 8)));
                    subjectSet.add(new Subject(Subjects.ECONOMY, Arrays.asList(10, 0)));
                    break;
                case "Kuznecov":
                    subjectSet.add(new Subject(Subjects.PHILOSOPHIC, Collections.singletonList(9)));
                    subjectSet.add(new Subject(Subjects.ECONOMY, Arrays.asList(10, 5)));
                    break;
                case "Virinsky":
                    subjectSet.add(new Subject(Subjects.MATHS, Arrays.asList(4, 9)));
                    break;
                case "Rukan":
                    subjectSet.add(new Subject(Subjects.MATHS, Collections.singletonList(2)));
                    break;
                case "Pupkin":
                    subjectSet.add(new Subject(Subjects.ECONOMY, Arrays.asList(0, 9)));
                    break;
            }
        } catch (ScoreOutOfBoundException e) {
            e.printStackTrace();
        }
        return subjectSet;
    }
}
