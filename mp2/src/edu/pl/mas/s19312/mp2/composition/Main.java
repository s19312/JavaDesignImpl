package edu.pl.mas.s19312.mp2.composition;

public class Main {

    public static void main(String[] args) {
        Album a1 = new Album("something");
        Album a2 = new Album("something2");

        Song s1 = new Song("Best Life1", a1);
        System.out.println("Album a1 size: " + a1.getSongs().size());

//        Song s3 = new Song("Best Life1", a1);
//        a2.addSongs(s3);

        Song s2 = new Song("Best Life2", a1);
        System.out.println("Album a1 size: " + a1.getSongs().size());

        s2.removeAlbum();
        System.out.println("Album a1 size: " + a1.getSongs().size());

        a1.removeSongs(s1);
        System.out.println("Album a1 size: " + a1.getSongs().size());

    }
}
