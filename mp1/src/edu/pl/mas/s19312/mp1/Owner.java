package edu.pl.mas.s19312.mp1;

import java.io.Serializable;

public class Owner implements Serializable {
    private String firstName;
    private String lastName;
    private String idPassport;

    public Owner(String firstName, String lastName, String idPassport) {
        setFirstName(firstName);
        setLastName(lastName);
        setIdPassport(idPassport);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.trim().equals("")){
            throw new RuntimeException("Owner FirstName cannot be null or empty!");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.trim().equals("")){
            throw new RuntimeException("Owner LastName cannot be null or empty!");
        }
        this.lastName = lastName;
    }

    public String getIdPassport() {
        return idPassport;
    }

    public void setIdPassport(String idPassport) {
        if(idPassport == null || idPassport.trim().equals("")){
            throw new RuntimeException("Owner idPassport cannot be null or empty!");
        }
        this.idPassport = idPassport;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idPassport='" + idPassport + '\'' +
                '}';
    }
}
