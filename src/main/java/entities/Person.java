package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String lName;
    private String fName;
    //skal have annotation her.
    private String phonenumber;
    
    private Hobby hobby;
    @ManyToOne(cascade = {CascadeType.PERSIST}) 
    private String address;
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

    public void setHobby(Hobby hobby){
        if(hobby != null){
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
        this.address = address;
        if(address != null) {
            address.addPerson(this);
        }
    }
    
    
   
}
