package hfs302.he186065.longhv.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "firstName", nullable = false, unique = true)
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "marks")
    private int marks;

    public Student() {
    }

    public Student(String firstName, String lastName, int marks) {
        super();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setMarks(marks);
    }

    public Student(int id, String firstName, String lastName, int marks) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setMarks(marks);
    }

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
