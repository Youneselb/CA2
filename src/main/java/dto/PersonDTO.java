/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Person;

/**
 *
 * @author Marks
 */
public class PersonDTO {
    private long id;
    private String email;
    private String fName;
    private String lName;

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
    
}
