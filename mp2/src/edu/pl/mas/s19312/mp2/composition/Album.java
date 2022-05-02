package edu.pl.mas.s19312.mp2.composition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Album {
    private String title;

    private List<Song> songs = new ArrayList<>();

    public Album(String title) {
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.trim().equals("")){
            throw new RuntimeException("Title cannot be null or empty");
        }
        this.title = title;
    }

    public List<Song> getSongs() {
        return Collections.unmodifiableList(songs);
    }

    public void addSongs(Song song) {
        if(song == null){
            throw new RuntimeException("Song cannot be null");
        }
        if(song.getAlbum() != this && song.getAlbum() != null){
            throw new RuntimeException("Song sign to another Album");
        }
        if(songs.contains(song)){
            return;
        }
        songs.add(song);
    }

    public void removeSongs(Song song) {
        if(song == null){
            throw new RuntimeException("Song cannot be null");
        }
        if(!songs.contains(song)){
            return;
        }
        songs.remove(song);
        song.removeAlbum();
    }
}

