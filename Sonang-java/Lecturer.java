public class Lecturer extends Teacher {
    // Additional attributes
    private String lecturerDepartment; 
    private int lecturerYearsOfExperience; 
    private int lecturerGradedScore;
    private boolean hasLecturerGraded; 
    // Constructor
    public Lecturer(int teacherId, String teacherName, String address, String workingType, String employmentStatus,
                    String department, int yearsOfExperience) {
        super(teacherId, teacherName, address, workingType, employmentStatus);
        this.lecturerDepartment = department; 
        this.lecturerYearsOfExperience = yearsOfExperience; 
        this.lecturerGradedScore = 0; 
        this.hasLecturerGraded = false; 
    }

    // Accessor methods
    public String getLecturerDepartment() { 
        return lecturerDepartment; 
    }

    public int getLecturerYearsOfExperience() { 
        return lecturerYearsOfExperience; 
    }

    public int getLecturerGradedScore() { 
        return lecturerGradedScore; 
    }

    public boolean hasLecturerGraded() { 
        return hasLecturerGraded; 
    }

    // Mutator method for gradedScore
    public void setLecturerGradedScore(int gradedScore) { 
        this.lecturerGradedScore = gradedScore; 
    }
    

    // Method to grade assignments
    public void gradeAssignment(int gradedScore, String department, int studentYearsOfExperience) {
        String grade;
        if (lecturerYearsOfExperience >= 5 ) { 
            if (gradedScore >= 70) {
                grade = "A";
            } else if (gradedScore >= 60) {
                grade = "B";
            } else if (gradedScore >= 50) {
                grade = "C";
            } else if (gradedScore >= 40) {
                grade = "D";
            } else {
                grade = "E";
            }
            System.out.println("The grade= " + grade);

            hasLecturerGraded = true; 
        } else {
            System.out.println("Lecturer has already graded or does not meet grading criteria.");
        }
    }

    // Display method
    public void displayLecturerInfo() { 
        super.displayTeacherInfo();
        System.out.println("Department: " + lecturerDepartment); 
        System.out.println("Years of Experience: " + lecturerYearsOfExperience); 

        if (hasLecturerGraded) { 
            System.out.println("Graded Score: " + lecturerGradedScore); 
        } else {
            System.out.println("Graded Score: Not graded yet");
        }
    }
}
