package Design_Patterns;

import java.util.*;

// Model/Entity class
class Student {
    private int id;
    private String name;
    private String email;
    private String course;
    
    public Student(int id, String name, String email, String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', email='" + email + "', course='" + course + "'}";
    }
}

// DAO Interface
interface StudentDAO {
    void addStudent(Student student);
    Student getStudent(int id);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void deleteStudent(int id);
}

// Concrete DAO Implementation (simulating database with in-memory storage)
class StudentDAOImpl implements StudentDAO {
    private List<Student> students;
    
    public StudentDAOImpl() {
        students = new ArrayList<>();
        // Add some sample data
        students.add(new Student(1, "John Doe", "john@email.com", "Computer Science"));
        students.add(new Student(2, "Jane Smith", "jane@email.com", "Mathematics"));
        students.add(new Student(3, "Mike Johnson", "mike@email.com", "Physics"));
    }
    
    @Override
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added: " + student.getName());
    }
    
    @Override
    public Student getStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        System.out.println("Student with ID " + id + " not found");
        return null;
    }
    
    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
    
    @Override
    public void updateStudent(Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == updatedStudent.getId()) {
                students.set(i, updatedStudent);
                System.out.println("Student updated: " + updatedStudent.getName());
                return;
            }
        }
        System.out.println("Student with ID " + updatedStudent.getId() + " not found for update");
    }
    
    @Override
    public void deleteStudent(int id) {
        students.removeIf(student -> {
            if (student.getId() == id) {
                System.out.println("Student deleted: " + student.getName());
                return true;
            }
            return false;
        });
    }
}

public class DataAccessObject {
    public static void main(String[] args) {
        System.out.println("=== Data Access Object Pattern Demo ===\n");
        
        // Create DAO instance
        StudentDAO studentDAO = new StudentDAOImpl();
        
        // 1. Display all students
        System.out.println("1. All Students:");
        displayAllStudents(studentDAO);
        
        // 2. Get a specific student
        System.out.println("\n2. Getting student with ID 2:");
        Student student = studentDAO.getStudent(2);
        if (student != null) {
            System.out.println("Found: " + student);
        }
        
        // 3. Add a new student
        System.out.println("\n3. Adding a new student:");
        Student newStudent = new Student(4, "Alice Brown", "alice@email.com", "Biology");
        studentDAO.addStudent(newStudent);
        
        // 4. Update a student
        System.out.println("\n4. Updating student with ID 1:");
        Student updatedStudent = new Student(1, "John Doe Updated", "john.updated@email.com", "Computer Science");
        studentDAO.updateStudent(updatedStudent);
        
        // 5. Display all students after changes
        System.out.println("\n5. All Students after changes:");
        displayAllStudents(studentDAO);
        
        // 6. Delete a student
        System.out.println("\n6. Deleting student with ID 3:");
        studentDAO.deleteStudent(3);
        
        // 7. Final display
        System.out.println("\n7. Final student list:");
        displayAllStudents(studentDAO);
        
        // 8. Try to get deleted student
        System.out.println("\n8. Trying to get deleted student (ID 3):");
        studentDAO.getStudent(3);
    }
    
    private static void displayAllStudents(StudentDAO dao) {
        List<Student> students = dao.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found");
        } else {
            for (Student s : students) {
                System.out.println("  " + s);
            }
        }
    }
}
