package hsf302longhvhe186065.pojo;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "FirstName isn't empty")
    private String firstName;

    @NotEmpty(message = "LastName isn't empty")
    private String lastName;

    @NotEmpty(message = "Email isn't empty")
    @Email(message = "Email isn't valid")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "password isn't empty")
    @Size(min = 6, message = "password is greater than 6 characters")
    private String password;

    @NotEmpty(message = "gender isn't empty")
    private String gender;

    @ElementCollection
    @CollectionTable(name = "user_hobbies", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "hobby")
    private List<String> hobbies;

    @NotEmpty(message = "province isn't empty")
    private String province;

    @NotNull(message = "birthday isn't empty")
    @Past(message = "birthday must in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    public User() {}

    public User(String firstName, String lastName, String email, String password,
                String gender, List<String> hobbies, String province, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.hobbies = hobbies;
        this.province = province;
        this.birthday = birthday;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public List<String> getHobbies() { return hobbies; }
    public void setHobbies(List<String> hobbies) { this.hobbies = hobbies; }
    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }
    public Date getBirthday() { return birthday; }
    public void setBirthday(Date birthday) { this.birthday = birthday; }
}
