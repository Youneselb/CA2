package dto;

import entities.Person;

public class PersonDTO {
    private long id;
    private String email;
    private String fName;
    private String lName;
    private String hobby;

    public PersonDTO() {
    }

    public PersonDTO(int id, String email, String fName, String lName) {
        this.id = id;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
    }
    
    public PersonDTO(Person person) {
        this.id = person.getId();
        this.email = person.getEmail();
        this.fName = person.getfName();
        this.lName = person.getlName();
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
    
    
}
