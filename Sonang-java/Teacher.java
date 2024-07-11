public class Teacher {
    
    // Given attributes for Teacher
    private int teacherId;
    private String teacherName;
    private String teacherAddress; 
    private String workingType;
    private String employmentStatus;
    private int workingHours;

    // Constructors and passing formal parameters
    public Teacher(int teacherId, String teacherName, String address, String workingType, String employmentStatus) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherAddress = address;
        this.workingType = workingType;
        this.employmentStatus = employmentStatus;
    }

    // Accessor methods
    public int getTeacherId() {
        return teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getAddress() {
    return teacherAddress; 
    }

    public String getWorkingType() {
        return workingType;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    // Method to set working hours
    public void setWorkingHours(int newWorkingHours) {
        workingHours = newWorkingHours;
    }
    

    // Display method
    public void displayTeacherInfo() {
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Teacher Name: " + teacherName);
        System.out.println("Address: " + teacherAddress); 
        System.out.println("Working Type: " + workingType);
        System.out.println("Employment Status: " + employmentStatus);

        if (workingHours > 0) {
            System.out.println("Working Hours: " + workingHours);
        } else {
            System.out.println("Working Hours: Not assigned");
        }
    }
}
