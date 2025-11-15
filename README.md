# HexSoftwares Student Grade Calculator

## Project Overview

This is a comprehensive **Student Grade Calculator** project built in Java as part of the HexSoftwares Internship Program. The system manages student records, tracks grades, calculates academic metrics, and provides comprehensive analysis of student performance and class statistics.

## Features

### Core Functionality
- ✅ **Create Student Records** - Add students with unique IDs
- ✅ **Add Grades** - Record multiple grades (up to 10) per student
- ✅ **Calculate Average** - Compute average grade for each student
- ✅ **Pass/Fail Determination** - Determine status based on 40% passing score
- ✅ **Letter Grades** - Assign letter grades (A-F) based on average
- ✅ **Highest/Lowest Grades** - Track best and worst grades
- ✅ **Class Analytics** - Calculate class-wide statistics
- ✅ **Performance Reports** - Generate detailed performance summaries
- ✅ **Input Validation** - Prevent invalid grade entries
- ✅ **Interactive Menu** - User-friendly command-line interface

## Project Structure

```
HexSoftwares_Student_Grade_Calculator/
├── src/
│   ├── Student.java              # Student class with grade management
│   ├── GradeCalculator.java      # Main class with interactive menu
│   └── GradeCalculatorTest.java  # Unit tests (optional)
├── README.md                   # Project documentation
└── .gitignore                  # Git ignore file
```

## Class Description

### Student.java
Represents a student with the following methods:
- `addGrade(double grade)` - Add grade to student's record
- `calculateAverage()` - Calculate average of all grades
- `getHighestGrade()` - Get the maximum grade
- `getLowestGrade()` - Get the minimum grade
- `hasPassed()` - Determine if student passed (avg >= 40)
- `getLetterGrade()` - Get letter grade (A/B/C/D/F)
- `displayGrades()` - Show all grades
- `displayPerformanceSummary()` - Show complete performance report

**Grading Scale:**
- A: 90-100
- B: 80-89
- C: 70-79
- D: 60-69
- F: 0-59

### GradeCalculator.java
Main application class with these features:
- Interactive menu-driven interface
- Student management (create, search)
- Grade management operations
- Individual student analysis
- Class-wide statistics
- Performance reporting
- Demo functionality with sample data

## How to Use

### Compilation
```bash
# Navigate to src directory
cd src

# Compile all Java files
javac *.java
```

### Execution
```bash
# Run the main program
java GradeCalculator
```

### Main Menu Options
```
1. Create New Student       - Add a new student to the system
2. Add Grades to Student    - Record grades for a student
3. View Student Grades      - Display all grades for a student
4. View Student Performance - Show performance summary
5. View All Students        - List all registered students
6. Calculate Class Average  - Compute average across all students
7. Class Statistics         - Show comprehensive class analytics
8. Demo: Sample Data        - Run demonstration with sample data
9. Exit                     - Close the application
```

## Usage Example

```java
// Create a student
Student student = new Student("S001", "Rajesh Kumar");

// Add grades
student.addGrade(85.5);
student.addGrade(90.0);
student.addGrade(78.5);

// Get performance metrics
double average = student.calculateAverage();      // Returns 84.67
char letterGrade = student.getLetterGrade();      // Returns 'B'
boolean passed = student.hasPassed();             // Returns true

// Display details
student.displayPerformanceSummary();
student.displayGrades();
```

## Grading Criteria

### Pass/Fail
- **Passing Score:** 40 or above
- **Failing Score:** Below 40

### Letter Grade Assignment
| Grade Range | Letter Grade |
|-------------|---------------|
| 90-100      | A             |
| 80-89       | B             |
| 70-79       | C             |
| 60-69       | D             |
| 0-59        | F             |

## Error Handling Examples

### Invalid Grade
```
✗ Error: Grade must be between 0 and 100
```

### Student Not Found
```
✗ Student not found!
```

### Maximum Grades Reached
```
✗ Error: Maximum grade limit reached (10 grades)
```

### Duplicate Student ID
```
✗ Student with ID S001 already exists!
```

## Sample Data

The system initializes with 3 sample students:

1. **Rajesh Kumar** (S001)
   - Grades: 85.5, 90.0, 78.5
   - Average: 84.67
   - Status: PASSED
   - Letter Grade: B

2. **Priya Singh** (S002)
   - Grades: 95.0, 92.5, 88.0
   - Average: 91.83
   - Status: PASSED
   - Letter Grade: A

3. **Arjun Patel** (S003)
   - Grades: 65.0, 72.5, 68.0
   - Average: 68.50
   - Status: PASSED
   - Letter Grade: C

## Demo Feature

The demo option displays:
- Complete performance summary for each student
- All grades for each student
- Class-wide statistics including:
  - Total number of students
  - Number of students who passed/failed
  - Class average
  - Highest and lowest individual averages

## Requirements

- **Java Version:** JDK 8 or higher
- **IDE:** Any Java IDE (Eclipse, IntelliJ IDEA, NetBeans) or command-line compiler
- **Operating System:** Windows, macOS, or Linux

## Key Concepts Demonstrated

- **Object-Oriented Programming (OOP)**
  - Encapsulation
  - Data validation
  - Class design
  - Getter/Setter methods

- **Data Structures**
  - Arrays for storing grades
  - ArrayList for managing students
  - Proper data organization

- **Algorithms**
  - Average calculation
  - Maximum/Minimum determination
  - Conditional logic for grading

- **User Interface**
  - Menu-driven interface
  - Input validation
  - Formatted output
  - Error handling

## Constraints

- Maximum 10 grades per student
- Grades must be between 0 and 100
- Student ID must be unique
- Passing score is 40 or above

## Extension Ideas

Potential features to extend this system:
- Subject-wise grades and analysis
- Grade history tracking
- Improvement tracking across semesters
- Student rankings
- Attendance integration
- Teacher comments and feedback
- Parent/Guardian notification system
- GPA calculation
- Transcript generation
- Database integration for persistence
- GUI implementation using Swing/JavaFX
- Export to PDF/Excel

## Testing

The application has been tested for:
- ✓ Grade entry validation (0-100 range)
- ✓ Average calculation accuracy
- ✓ Pass/fail determination
- ✓ Letter grade assignment
- ✓ Highest/lowest grade tracking
- ✓ Class average calculation
- ✓ Multiple student management
- ✓ Error handling for edge cases

## Performance Metrics

The system provides:
- Individual student performance analysis
- Class-wide performance metrics
- Pass rate statistics
- Grade distribution analysis
- Performance trends and comparisons

## Author

**Rahul Singh Kushwah**
- GitHub: [@Ishadowprince716](https://github.com/Ishadowprince716)
- Email: patelmrrahul199@gmail.com
- Institution: RGPV University, Bhopal

## License

This project is created for educational purposes as part of the HexSoftwares Internship Program.

## Contact

For questions or suggestions about this project:
- **Email:** info@hexsoftwares.tech
- **Phone:** +91 9695040540
- **Website:** www.hexsoftwares.tech

## Acknowledgments

- HexSoftwares for providing the internship opportunity
- Thanks to all mentors and instructors for guidance

---

**Last Updated:** November 15, 2025
**Version:** 1.0.0
