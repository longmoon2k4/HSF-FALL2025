package hfs302.he186065.longhv.pojo;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int marks;

    public Student() {
    }

    public Student(String firstName, String lastName, int marks) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.marks = marks;
    }

    // Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}

