/**
 * Student.java
 * Represents a student with grades and academic performance metrics
 */

public class Student {
    private String studentId;
    private String name;
    private double[] grades;
    private int gradesCount;
    private static final int MAX_GRADES = 10;
    private static final double PASSING_SCORE = 40.0;
    
    /**
     * Constructor to create a new student
     * @param studentId Unique student ID
     * @param name Name of the student
     */
    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.grades = new double[MAX_GRADES];
        this.gradesCount = 0;
    }
    
    /**
     * Add a grade for the student
     * @param grade The grade to add (0-100)
     * @throws IllegalArgumentException if grade is invalid or array is full
     */
    public void addGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
        
        if (this.gradesCount >= MAX_GRADES) {
            throw new IllegalArgumentException("Maximum grade limit reached (10 grades)");
        }
        
        this.grades[this.gradesCount] = grade;
        this.gradesCount++;
    }
    
    /**
     * Calculate average grade
     * @return Average grade
     * @throws IllegalStateException if no grades added
     */
    public double calculateAverage() {
        if (this.gradesCount == 0) {
            throw new IllegalStateException("No grades to calculate average");
        }
        
        double sum = 0;
        for (int i = 0; i < this.gradesCount; i++) {
            sum += this.grades[i];
        }
        
        return sum / this.gradesCount;
    }
    
    /**
     * Get highest grade
     * @return Maximum grade
     * @throws IllegalStateException if no grades added
     */
    public double getHighestGrade() {
        if (this.gradesCount == 0) {
            throw new IllegalStateException("No grades to determine highest");
        }
        
        double max = this.grades[0];
        for (int i = 1; i < this.gradesCount; i++) {
            if (this.grades[i] > max) {
                max = this.grades[i];
            }
        }
        
        return max;
    }
    
    /**
     * Get lowest grade
     * @return Minimum grade
     * @throws IllegalStateException if no grades added
     */
    public double getLowestGrade() {
        if (this.gradesCount == 0) {
            throw new IllegalStateException("No grades to determine lowest");
        }
        
        double min = this.grades[0];
        for (int i = 1; i < this.gradesCount; i++) {
            if (this.grades[i] < min) {
                min = this.grades[i];
            }
        }
        
        return min;
    }
    
    /**
     * Determine if student has passed
     * @return true if average is >= 40, false otherwise
     */
    public boolean hasPassed() {
        if (this.gradesCount == 0) {
            return false;
        }
        
        return calculateAverage() >= PASSING_SCORE;
    }
    
    /**
     * Get letter grade based on average
     * @return Letter grade (A, B, C, D, F)
     */
    public char getLetterGrade() {
        if (this.gradesCount == 0) {
            return 'N';
        }
        
        double average = calculateAverage();
        
        if (average >= 90) return 'A';
        if (average >= 80) return 'B';
        if (average >= 70) return 'C';
        if (average >= 60) return 'D';
        return 'F';
    }
    
    /**
     * Display all grades for the student
     */
    public void displayGrades() {
        System.out.println("\n--- Grades for " + this.name + " ---");
        
        if (this.gradesCount == 0) {
            System.out.println("No grades recorded.");
        } else {
            System.out.println("Subject/Assessment Grades:");
            for (int i = 0; i < this.gradesCount; i++) {
                System.out.println("  " + (i + 1) + ". Grade: " + String.format("%.2f", this.grades[i]));
            }
        }
        System.out.println("----------------------------");
    }
    
    /**
     * Display student performance summary
     */
    public void displayPerformanceSummary() {
        System.out.println("\n=== Performance Summary ===");
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Name: " + this.name);
        System.out.println("Number of Grades: " + this.gradesCount);
        
        if (this.gradesCount > 0) {
            System.out.println("Average Grade: " + String.format("%.2f", calculateAverage()));
            System.out.println("Highest Grade: " + String.format("%.2f", getHighestGrade()));
            System.out.println("Lowest Grade: " + String.format("%.2f", getLowestGrade()));
            System.out.println("Letter Grade: " + getLetterGrade());
            System.out.println("Status: " + (hasPassed() ? "PASSED" : "FAILED"));
        } else {
            System.out.println("No grades recorded yet.");
        }
        System.out.println("===========================");
    }
    
    // Getters
    public String getStudentId() {
        return studentId;
    }
    
    public String getName() {
        return name;
    }
    
    public int getGradesCount() {
        return gradesCount;
    }
    
    public double[] getGrades() {
        double[] result = new double[this.gradesCount];
        for (int i = 0; i < this.gradesCount; i++) {
            result[i] = this.grades[i];
        }
        return result;
    }
}
