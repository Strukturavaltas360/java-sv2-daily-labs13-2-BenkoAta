package day01;

import java.util.*;

public class ClassNoteBook {
    Map<Student, List<Integer>> students = new TreeMap<>();

    public void addStudent(Student student) {
        if (students.containsKey(student)) {
            throw new IllegalArgumentException("Student already has been added! " + student);
        }
        students.put(student, new ArrayList<>());
    }

    public void addMark(int id, int mark) {
        Student dummy = new Student(id, "");
        if (!students.containsKey(dummy)) {
            throw new IllegalArgumentException("Can not find student with id:" + id);
        }
        List<Integer> marks = students.get(dummy);
        marks.add(mark);
    }

    public Map<Student, List<Integer>> getStudentsAndMarks() {
        return students;
    }
}
