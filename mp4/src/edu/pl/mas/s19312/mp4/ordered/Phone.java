package edu.pl.mas.s19312.mp4.ordered;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Phone {
    private String phoneSerialNumber;
    private User owner;
    private User tester;

    private static List<Phone> phonesExtent = new ArrayList<>();

    public Phone(String phoneSerialNumber) {
        setPhoneSerialNumber(phoneSerialNumber);
    }

    public static void removePhone() {
        if (phonesExtent.size() < 1) {
            throw new RuntimeException("No Phones to remove!");
        }
        phonesExtent.get(phonesExtent.size() - 1).removeOwner();
    }

    public static List<Phone> getPhonesExtent(){
        return Collections.unmodifiableList(phonesExtent);
    }

    public String getPhoneSerialNumber() {
        return phoneSerialNumber;
    }

    public void setPhoneSerialNumber(String phoneSerialNumber) {
        if (phoneSerialNumber == null || phoneSerialNumber.trim().equals("")) {
            throw new RuntimeException("Phone serial number cannot be null or empty!");
        }
        for (Phone ph : phonesExtent) {
            if (ph.getPhoneSerialNumber().equals(phoneSerialNumber)) {
                throw new RuntimeException("This serial already exists!");
            }
        }
        this.phoneSerialNumber = phoneSerialNumber;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        if (owner == null) {
            throw new RuntimeException("Owner cannot be null!");
        }
        if (this.owner == owner) {
            return;
        }
        if (this.owner != null) {
            removeOwner();
        }
        this.owner = owner;
        owner.addOwnedPhones(this);
        phonesExtent.add(this);
    }

    public User getTester() {
        return tester;
    }

    public void setTester(User tester) {
        if (tester == null) {
            throw new RuntimeException("tester cannot be null!");
        }
        if (this.tester == tester) {
            return;
        }
        if (this.owner != tester && this.owner != null) {
            throw new RuntimeException("Cannot change to new tester");
        }
        this.tester = tester;
        tester.addTestPhones(this);
    }

    public void removeTester() {
        if (this.tester == null) {
            return;
        }
        User tmpT = this.tester;
        this.tester = null;
        tmpT.removeTestPhone(this);
    }

    public void removeOwner() {
        if (this.owner == null) {
            return;
        }
        User tmp = this.owner;
        this.owner = null;
        tmp.removeOwnedPhone(this);
        removeTester();
        phonesExtent.remove(this);
    }
}
