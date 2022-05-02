package edu.pl.mas.s19312.mp2.withAttribute;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Owner {
    private int idOwner;
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfBirth;
    private String pesel;

    private List<CarDocuments> details = new ArrayList<>();

    public Owner(int idOwner, String firstName, String lastName, LocalDateTime dateOfBirth, String pesel) {
        setIdOwner(idOwner);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setPesel(pesel);
    }

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.trim().equals("")){
            throw new RuntimeException("firstName cannot be null or empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.trim().equals("")){
            throw new RuntimeException("lastName cannot be null or empty");
        }
        this.lastName = lastName;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        if(dateOfBirth == null){
            throw new RuntimeException("lastName cannot be null or empty");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        if(pesel == null || pesel.trim().equals("")){
            throw new RuntimeException("pesel cannot be null or empty");
        }
        this.pesel = pesel;
    }

    public List<CarDocuments> getCarDocuments() {
        return Collections.unmodifiableList(details);
    }

    public void addCarDocuments(CarDocuments carDocuments) {
        if(carDocuments == null){
            throw new RuntimeException("Car Document cannot be null");
        }
        if(carDocuments.getCar() == null && carDocuments.getOwner() == null){
            throw new RuntimeException("This Car Documents cannot be used!");
        }
        if(carDocuments.getOwner() != this && carDocuments.getOwner() != null){
            throw new RuntimeException("This Car Document assign to another Owner");
        }
        if(this.details.contains(carDocuments)){
            return;
        }
        this.details.add(carDocuments);
    }

    public void removeCarDocuments(CarDocuments carDocuments) {
        if(carDocuments == null){
            throw new RuntimeException("Car Document cannot be null");
        }
        if(!this.details.contains(carDocuments)){
            return;
        }
        this.details.remove(carDocuments);
        carDocuments.remove();
    }
}
