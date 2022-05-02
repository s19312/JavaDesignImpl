package edu.pl.mas.s19312.mp4.ordered;

public class Main {

    public static void main(String[] args) {
        Phone ph1 = new Phone("1155g456");
        User o1 = new User("Jan", "Smith");
        User o2 = new User("Jan", "Smith");
        ph1.setOwner(o1);
        o1.addTestPhones(ph1);

        o2.addOwnedPhones(ph1);
        o2.addTestPhones(ph1);

        ph1.removeOwner();
        System.out.println("owner : " + ph1.getOwner() + "\ntester: " + ph1.getTester());
        ph1.setOwner(o2);
        ph1.removeTester();
        System.out.println("owner : " + ph1.getOwner() + "\ntester: " + ph1.getTester());

        Phone.removePhone();
        System.out.println(Phone.getPhonesExtent().size());

    }
}
