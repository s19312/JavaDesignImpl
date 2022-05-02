package edu.pl.mas.s19312.mp4.ordered;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;

    private List<Phone> testPhones = new ArrayList<>();
    private List<Phone> ownedPhones = new ArrayList<>();

    public User(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.trim().equals("")){
            throw new RuntimeException("FirstName cannot be null or empty!");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.trim().equals("")){
            throw new RuntimeException("LastName cannot be null or empty!");
        }
        this.lastName = lastName;
    }

    public List<Phone> getTestPhones() {
        return Collections.unmodifiableList(testPhones);
    }

    public void addTestPhones(Phone phone) {
        if(phone == null){
            throw new RuntimeException("Phone cannot be null!");
        }
        if(testPhones.contains(phone)){
            return;
        }
        testPhones.add(phone);
        phone.setTester(this);
    }

    public List<Phone> getOwnedPhones() {
        return Collections.unmodifiableList(ownedPhones);
    }

    public void addOwnedPhones(Phone phone) {
        if(phone == null){
            throw new RuntimeException("Phone cannot be null!");
        }
        if(ownedPhones.contains(phone)){
            return;
        }
        ownedPhones.add(phone);
        phone.setOwner(this);
    }

    public void removeTestPhone(Phone phone){
        if(phone == null){
            throw new RuntimeException("Phone cannot be null!");
        }
        if(!testPhones.contains(phone)){
            return;
        }
        testPhones.remove(phone);
        phone.removeTester();
    }

    public void removeOwnedPhone(Phone phone){
        if(phone == null){
            throw new RuntimeException("Phone cannot be null!");
        }
        if(!ownedPhones.contains(phone)){
            return;
        }
        ownedPhones.remove(phone);
        phone.removeTester();
    }
}
