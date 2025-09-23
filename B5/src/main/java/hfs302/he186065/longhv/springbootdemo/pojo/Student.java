package hfs302.he186065.longhv.springbootdemo.pojo;

public class Student {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private int marks;

    public Student() {
        super();
    }

    public Student(String firstName, String lastName, int marks) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setMarks(marks);
    }

    public Student(String email, String password, String firstName, String lastName, int marks) {
        super();
        this.setEmail(email);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setMarks(marks);
    }

    public Student(int id, String email, String password, String firstName, String lastName, int marks) {
        super();
        this.setId(id);
        this.setEmail(email);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setMarks(marks);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks = marks; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student other = (Student) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
