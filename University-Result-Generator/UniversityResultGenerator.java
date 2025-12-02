// 9️⃣ University Result Generator
// Class Student:
// •	name, roll
// •	List<Subject>
// Subject:
// •	subjectName, marks
// ResultCalculator:
// •	calculateGrade()
// •	calculateCGPA()
// Task:
// Use encapsulation to protect marks and only allow controlled updates.

import java.util.*;

class Subject {
    private String subjectName;
    private int marks;

    Subject(String subjectName, int marks) {
        this.subjectName = subjectName;
        setMarks(marks);
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int newMarks) {
        if (newMarks >= 0 && newMarks <= 100) {
            this.marks = newMarks;
        } else {
            System.out.println("Marks must be between 0–100.");
        }
    }
}

class Student {
    private String name;
    private int roll;
    private List<Subject> subjects = new ArrayList<>();

    Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }

    public void addSubject(Subject sub) {
        subjects.add(sub);
    }

    public List<Subject> getSubjects() { // Corrected name
        return subjects;
    }
}

class ResultCalculator {

    public String calculateGrade(int marks) {
        if (marks >= 90) return "A";
        else if (marks >= 80) return "B";
        else if (marks >= 70) return "C";
        else if (marks >= 60) return "D";
        else if (marks >= 50) return "E";
        else return "F";
    }

    public double calculateCGPA(Student student) {
        double total = 0;
        for (Subject s : student.getSubjects()) {
            total += s.getMarks();
        }
        return total / (student.getSubjects().size() * 10);  // Correct formula
    }
}

public class UniversityResultGenerator {
    public static void main(String[] args) {

        // Subjects
        Subject s1 = new Subject("Maths", 95);
        Subject s2 = new Subject("Physics", 89);
        Subject s3 = new Subject("Chemistry", 87);

        // Student
        Student st = new Student("Anjali", 101);

        st.addSubject(s1);
        st.addSubject(s2);
        st.addSubject(s3);

        ResultCalculator rc = new ResultCalculator();

        System.out.println("---------------------------");
        System.out.println("Name : " + st.getName());
        System.out.println("Roll : " + st.getRoll());
        System.out.println("---------------------------");

        for (Subject s : st.getSubjects()) {
            System.out.println(
                s.getSubjectName() + " : " + s.getMarks() +
                " | Grade: " + rc.calculateGrade(s.getMarks())
            );
        }

        System.out.println("---------------------------");
        System.out.println("CGPA : " + rc.calculateCGPA(st));
    }
}
