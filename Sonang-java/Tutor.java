public class Tutor extends Teacher {
    // Additional attributes
    private double tutorSalary; 
    private String tutorSpecialization; 
    private String tutorAcademicQualifications; 
    private int tutorPerformanceIndex; 
    private boolean isTutorCertified; 

    // Constructor and passing formal parameters
    public Tutor(int teacherId, String teacherName, String teacherAddress, String workingType, String employmentStatus,
                 int workingHours, double tutorSalary, String tutorSpecialization, String tutorAcademicQualifications, int tutorPerformanceIndex) {
        super(teacherId, teacherName, teacherAddress, workingType, employmentStatus);
        setWorkingHours(workingHours);
        this.tutorSalary = tutorSalary; 
        this.tutorSpecialization = tutorSpecialization; 
        this.tutorAcademicQualifications = tutorAcademicQualifications; 
        this.tutorPerformanceIndex = tutorPerformanceIndex; 
        this.isTutorCertified = false; 
    }

    // Accessor methods
    public double getTutorSalary() { 
        return tutorSalary; 
    }

    public String getTutorSpecialization() { 
        return tutorSpecialization; 
    }

    public String getTutorAcademicQualifications() { 
        return tutorAcademicQualifications; 
    }

    public int getTutorPerformanceIndex() { 
        return tutorPerformanceIndex; 
    }

    public boolean isTutorCertified() { 
        return isTutorCertified; 
    }

    // Mutator method for salary
    public void setTutorSalary(double tutorSalary, int tutorPerformanceIndex) { 
        if (!isTutorCertified) {
            if (tutorPerformanceIndex > 5 && getWorkingHours() > 20) {
                double appraisal = 0;

                if (tutorPerformanceIndex >= 5 && tutorPerformanceIndex <= 7) {
                    appraisal = 0.05;
                } else if (tutorPerformanceIndex >= 8 && tutorPerformanceIndex <= 9) {
                    appraisal = 0.10;
                } else if (tutorPerformanceIndex == 10) {
                    appraisal = 0.20;
                }

                double approvedSalary = tutorSalary + (appraisal * tutorSalary);
                this.tutorSalary = approvedSalary;
                this.tutorPerformanceIndex = tutorPerformanceIndex; 
                isTutorCertified = true; 
            } else {
                System.out.println("Salary cannot be approved. Performance index or working hours do not meet criteria.");
            }
        } else {
            System.out.println("Salary cannot be modified for a certified tutor.");
        }
    }

    // Method to remove tutor
    public void removeTutor() {
        if (!isTutorCertified) {
            tutorSalary = 0.0; 
            tutorSpecialization = ""; 
            tutorAcademicQualifications = ""; 
            tutorPerformanceIndex = 0; 
            isTutorCertified = false; 
        } else {
            System.out.println("Certified tutors cannot be removed.");
        }
    }
    
    

    // Display method
    public void displayTutorInfo() { 
        super.displayTeacherInfo();

        if (isTutorCertified) { 
            System.out.println("Salary: $" + tutorSalary); 
            System.out.println("Specialization: " + tutorSpecialization); 
            System.out.println("Academic Qualifications: " + tutorAcademicQualifications); 
            System.out.println("Performance Index: " + tutorPerformanceIndex); 
        } else {
            System.out.println("Certification Status: Not Certified");
        }
    }
}
