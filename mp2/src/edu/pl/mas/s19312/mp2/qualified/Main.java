package edu.pl.mas.s19312.mp2.qualified;

import edu.pl.mas.s19312.mp2.composition.Album;
import edu.pl.mas.s19312.mp2.composition.Song;

public class Main {

    public static void main(String[] args) {
        Music music1 = new Music(1, "Best1", MusicType.POP);
        Music music2 = new Music(2, "Best2", MusicType.POP);
        Music music3 = new Music(3, "Best3", MusicType.RAP);

        MusicStorage ms1 = new MusicStorage(MusicType.POP);
        MusicStorage ms2 = new MusicStorage(MusicType.POP);

        ms1.addMusic(music1);
        System.out.println("MusicStorage1 size: " + ms1.getMusicMap().size());

        music2.setStorage(ms1);
        System.out.println("MusicStorage1 size: " + ms1.getMusicMap().size());

        music2.setStorage(ms2);
        System.out.println("MusicStorage1 size: " + ms1.getMusicMap().size());
        System.out.println("MusicStorage2 size: " + ms1.getMusicMap().size());

        ms1.removeMusic(music1);
        System.out.println("MusicStorage1 size: " + ms1.getMusicMap().size());

        music2.removeStorage();
        System.out.println("MusicStorage2 size: " + ms1.getMusicMap().size());



    }
}
