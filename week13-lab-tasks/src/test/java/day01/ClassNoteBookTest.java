package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {
    Student s1 = new Student(1, "s1");
    Student s2 = new Student(2, "s2");
    Student s3 = new Student(3, "s3");
    Student s4 = new Student(4, "s4");

    ClassNoteBook cnb = new ClassNoteBook();

    @BeforeEach
    void init() {
        cnb.addStudent(s4);
        cnb.addStudent(s2);
        cnb.addStudent(s3);
        cnb.addStudent(s1);
    }

    @Test
    void addMark() {
        cnb.addMark(1, 5);
        cnb.addMark(1, 3);
        cnb.addMark(2, 2);

        Map<Student, List<Integer>> studentsAndMarks = cnb.getStudentsAndMarks();
        assertEquals(List.of(5, 3), studentsAndMarks.get(s1));
        assertEquals(List.of(), studentsAndMarks.get(s3));
        System.out.println(cnb.getStudentsAndMarks());
    }

    @Test
    void addMarkExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> cnb.addMark(5, 5));
    }

    @Test
    void addStudentExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> cnb.addStudent(new Student(1, "teszt")));
    }

    @Test
    void addStudentOrderSet() {
        assertEquals(List.of(s1, s2, s3, s4), new ArrayList<>(cnb.getStudentsAndMarks().keySet()));
    }
}