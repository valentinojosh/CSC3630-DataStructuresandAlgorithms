public class courseObject {
    private String Course;
    private String Section;
    private String Title;
    private int NStudents;
    private int NSeats;
    private String Instructor;
    private int Year;

    public courseObject(String course, String section, String title, int NStudents, int NSeats, String instructor, int year) {
        Course = course;
        Section = section;
        Title = title;
        this.NStudents = NStudents;
        this.NSeats = NSeats;
        Instructor = instructor;
        Year = year;
    }

    public String getCourse() {
        return Course;
    }

    public String getSection() {
        return Section;
    }

    public String getTitle() {
        return Title;
    }

    public int getNStudents() {
        return NStudents;
    }

    public int getNSeats() {
        return NSeats;
    }

    public String getInstructor() {
        return Instructor;
    }

    public int getYear() {
        return Year;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public void setSection(String section) {
        Section = section;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setNStudents(int NStudents) {
        this.NStudents = NStudents;
    }

    public void setNSeats(int NSeats) {
        this.NSeats = NSeats;
    }

    public void setInstructor(String instructor) {
        Instructor = instructor;
    }

    public void setYear(int year) {
        Year = year;
    }
}
