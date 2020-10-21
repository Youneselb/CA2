package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String email;
    private String lName;
    private String fName;
    //skal have annotation her.
    private String phonenumber;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="hobby_person", joinColumns={@JoinColumn(name="persons_ID")}, inverseJoinColumns={@JoinColumn(name="Hobby_ID")})
    private Hobby hobby;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Address address;
    //skal have annotation her.
    private String city;

    public Person() {
    }

    public Person(String email, String fName, String lName) {
        this.email = email;
        this.lName = fName;
        this.fName = lName;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        if (hobby != null) {
            this.hobby = hobby;
            hobby.addPerson(this);
        } else {
            this.hobby = null;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if (address != null) {
            this.address = address;
            address.addPerson(this);
        } else {
            this.address = null;
        }
    }

}
