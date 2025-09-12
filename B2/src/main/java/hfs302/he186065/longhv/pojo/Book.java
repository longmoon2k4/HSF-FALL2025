package hfs302.he186065.longhv.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title", length = 30)
    private String title;

    private String author;
    private String isbn;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    public Book() { super(); }

    public Book(String title, String author, String isbn) {
        super();
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public Book(Book book) {
        super();
        this.title = book.title;
        this.author = book.author;
        this.isbn = book.isbn;
    }

    public String getTitle() { return title; }

    public void setStudent(Student student) {
        this.student = student;
    }
}
