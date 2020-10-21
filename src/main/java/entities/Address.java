package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Address.deleteAllRows", query = "DELETE from Address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String street;
    private String additionalInfo;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CityInfo cityinfo;
    @OneToMany(mappedBy = "address", cascade = CascadeType.PERSIST)
    private List<Person> persons;

    public Address() {
    }

    public Address(String street, String additionalInfo) {
        this.street = street;
        this.additionalInfo = additionalInfo;
        persons = new ArrayList<>();
    }

    public CityInfo getCityInfo() {
        return cityinfo;
    }

    public void setCityInfo(CityInfo cityinfo) {
        if (cityinfo != null) {
            this.cityinfo = cityinfo;
            cityinfo.addAddress(this);
        } else {
            this.cityinfo = null;
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public void addPerson(Person person) {
        if (person != null) {
            persons.add(person);
        }
    }

}
