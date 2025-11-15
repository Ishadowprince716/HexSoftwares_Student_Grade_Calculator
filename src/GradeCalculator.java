/**
 * GradeCalculator.java
 * Main class for managing students and calculating grades
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeCalculator {
    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║   Welcome to Student Grade Calculator     ║");
        System.out.println("║   HexSoftwares Internship Project          ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");
        
        // Initialize with sample students
        initializeStudents();
        
        // Display main menu
        try {
            displayMainMenu();
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Initialize with sample students
     */
    private static void initializeStudents() {
        System.out.println("Initializing with sample students...\n");
        
        Student student1 = new Student("S001", "Rajesh Kumar");
        student1.addGrade(85.5);
        student1.addGrade(90.0);
        student1.addGrade(78.5);
        students.add(student1);
        
        Student student2 = new Student("S002", "Priya Singh");
        student2.addGrade(95.0);
        student2.addGrade(92.5);
        student2.addGrade(88.0);
        students.add(student2);
        
        Student student3 = new Student("S003", "Arjun Patel");
        student3.addGrade(65.0);
        student3.addGrade(72.5);
        student3.addGrade(68.0);
        students.add(student3);
        
        System.out.println("✓ 3 sample students loaded\n");
    }
    
    /**
     * Display main menu
     */
    private static void displayMainMenu() {
        boolean running = true;
        
        while (running) {
            System.out.println("\n╔════════════════════════════════════════════════╗");
            System.out.println("║             Main Menu                       ║");
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║ 1. Create New Student                     ║");
            System.out.println("║ 2. Add Grades to Student                  ║");
            System.out.println("║ 3. View Student Grades                    ║");
            System.out.println("║ 4. View Student Performance               ║");
            System.out.println("║ 5. View All Students                      ║");
            System.out.println("║ 6. Calculate Class Average                ║");
            System.out.println("║ 7. Class Statistics                       ║");
            System.out.println("║ 8. Demo: Sample Data                      ║");
            System.out.println("║ 9. Exit                                   ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1:
                        createNewStudent();
                        break;
                    case 2:
                        addGradesToStudent();
                        break;
                    case 3:
                        viewStudentGrades();
                        break;
                    case 4:
                        viewStudentPerformance();
                        break;
                    case 5:
                        viewAllStudents();
                        break;
                    case 6:
                        calculateClassAverage();
                        break;
                    case 7:
                        displayClassStatistics();
                        break;
                    case 8:
                        performDemo();
                        break;
                    case 9:
                        running = false;
                        System.out.println("\nThank you for using Grade Calculator. Goodbye!");
                        break;
                    default:
                        System.out.println("✗ Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("✗ Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
    
    /**
     * Create a new student
     */
    private static void createNewStudent() {
        System.out.println("\n--- Create New Student ---");
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        
        // Check if student already exists
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                System.out.println("✗ Student with ID " + studentId + " already exists!");
                return;
            }
        }
        
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        
        Student newStudent = new Student(studentId, name);
        students.add(newStudent);
        System.out.println("✓ Student \"" + name + "\" created successfully!");
    }
    
    /**
     * Add grades to a student
     */
    private static void addGradesToStudent() {
        System.out.println("\n--- Add Grades ---");
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        
        Student student = findStudent(studentId);
        if (student == null) {
            System.out.println("✗ Student not found!");
            return;
        }
        
        System.out.println("Enter grades (0-100). Enter -1 to stop.");
        
        try {
            while (true) {
                System.out.print("Enter grade: ");
                double grade = scanner.nextDouble();
                
                if (grade == -1) break;
                
                student.addGrade(grade);
                System.out.println("✓ Grade " + grade + " added successfully!");
            }
            scanner.nextLine(); // Consume newline
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Error: " + e.getMessage());
            scanner.nextLine();
        }
    }
    
    /**
     * View grades for a specific student
     */
    private static void viewStudentGrades() {
        System.out.println("\n--- View Student Grades ---");
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        
        Student student = findStudent(studentId);
        if (student == null) {
            System.out.println("✗ Student not found!");
            return;
        }
        
        student.displayGrades();
    }
    
    /**
     * View performance summary for a student
     */
    private static void viewStudentPerformance() {
        System.out.println("\n--- View Student Performance ---");
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        
        Student student = findStudent(studentId);
        if (student == null) {
            System.out.println("✗ Student not found!");
            return;
        }
        
        try {
            student.displayPerformanceSummary();
        } catch (IllegalStateException e) {
            System.out.println("✗ " + e.getMessage());
        }
    }
    
    /**
     * View all students in the system
     */
    private static void viewAllStudents() {
        System.out.println("\n=== All Students ===");
        
        if (students.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                Student s = students.get(i);
                String status = "N/A";
                if (s.getGradesCount() > 0) {
                    status = s.hasPassed() ? "PASSED" : "FAILED";
                }
                System.out.println((i + 1) + ". " + s.getName() + " (ID: " + s.getStudentId() + ") - " + status);
            }
        }
        System.out.println("===================");
    }
    
    /**
     * Calculate class average
     */
    private static void calculateClassAverage() {
        System.out.println("\n--- Class Average Calculation ---");
        
        if (students.isEmpty()) {
            System.out.println("No students in the class.");
            return;
        }
        
        double totalAverage = 0;
        int studentsWithGrades = 0;
        
        for (Student s : students) {
            if (s.getGradesCount() > 0) {
                totalAverage += s.calculateAverage();
                studentsWithGrades++;
            }
        }
        
        if (studentsWithGrades == 0) {
            System.out.println("No students have grades yet.");
        } else {
            double classAverage = totalAverage / studentsWithGrades;
            System.out.println("Class Average: " + String.format("%.2f", classAverage));
            System.out.println("Number of Students with Grades: " + studentsWithGrades);
        }
    }
    
    /**
     * Display class statistics
     */
    private static void displayClassStatistics() {
        System.out.println("\n=== Class Statistics ===");
        System.out.println("Total Students: " + students.size());
        
        if (students.isEmpty()) {
            System.out.println("No students in the class.");
            return;
        }
        
        int passedCount = 0;
        int failedCount = 0;
        double totalAverage = 0;
        int studentsWithGrades = 0;
        double highestClassAverage = Double.MIN_VALUE;
        double lowestClassAverage = Double.MAX_VALUE;
        
        for (Student s : students) {
            if (s.getGradesCount() > 0) {
                double avg = s.calculateAverage();
                totalAverage += avg;
                studentsWithGrades++;
                
                if (avg > highestClassAverage) {
                    highestClassAverage = avg;
                }
                if (avg < lowestClassAverage) {
                    lowestClassAverage = avg;
                }
                
                if (s.hasPassed()) {
                    passedCount++;
                } else {
                    failedCount++;
                }
            }
        }
        
        System.out.println("Students with Grades: " + studentsWithGrades);
        System.out.println("Passed: " + passedCount);
        System.out.println("Failed: " + failedCount);
        
        if (studentsWithGrades > 0) {
            System.out.println("Class Average: " + String.format("%.2f", totalAverage / studentsWithGrades));
            System.out.println("Highest Average: " + String.format("%.2f", highestClassAverage));
            System.out.println("Lowest Average: " + String.format("%.2f", lowestClassAverage));
        }
        
        System.out.println("=======================\n");
    }
    
    /**
     * Perform demo operations
     */
    private static void performDemo() {
        System.out.println("\n=== Demo: Displaying All Student Data ===");
        
        for (Student s : students) {
            s.displayPerformanceSummary();
            s.displayGrades();
        }
        
        System.out.println();
        displayClassStatistics();
        
        System.out.println("✓ Demo completed!");
    }
    
    /**
     * Find student by ID
     * @param studentId The student ID to search for
     * @return Student if found, null otherwise
     */
    private static Student findStudent(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                return s;
            }
        }
        return null;
    }
}
