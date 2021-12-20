package org.example.structure;

import org.example.constans.Faculties;
import org.example.constans.Groups;
import org.example.exception.NullStudentsInGroupException;
import java.util.Set;

public class Group {
    private Groups nameGroup;
    private Faculties faculty;
    private Set<Student> studentList;

    public Group(Groups nameGroup, Faculties faculty, Set<Student> studentList) throws NullStudentsInGroupException {
        this.nameGroup = nameGroup;
        this.faculty = faculty;
        this.studentList = studentList;
        if (studentList == null || studentList.isEmpty()) {
            throw new NullStudentsInGroupException();
        }
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public Set<Student> getStudentList() {
        return studentList;
    }

    public Groups getNameGroup() {
        return nameGroup;
    }

    public void addNewStudent(Student newStudent) {
        if (newStudent.getGroup().equals(nameGroup)) {
            studentList.add(newStudent);
        }
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
    }
}
