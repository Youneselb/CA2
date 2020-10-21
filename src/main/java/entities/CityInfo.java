package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
public class CityInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 4)
    private String zipCode;
    @Column(length = 35)
    private String city;
    @OneToMany(mappedBy = "cityinfo")
     @JoinColumn(name = "address_id")
    private List<Address> addresses;
    
    public CityInfo() {
    }

    public CityInfo(String zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
        addresses = new ArrayList<>();
    }

    public void addAddress(Address address){
        if(address != null){
            addresses.add(address);
        }
    }
    
    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
