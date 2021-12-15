public class StudentsObjectClass {
    //Example: U101,Janet,Jackson,CSC,30
    private String uNum;;
    private String firstName;
    private String lastName;
    private String major;
    private int creditHours;

    //Constructor
    public StudentsObjectClass(String uNum, String firstName, String lastName, String major, int creditHours) {
        this.uNum = uNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.creditHours = creditHours;
    }

    //Getters
    public String getuNum() {
        return uNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMajor() {
        return major;
    }

    public int getCreditHours() {
        return creditHours;
    }

    
    //Setters
    public void setuNum(String uNum) {
        this.uNum = uNum;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }
}
