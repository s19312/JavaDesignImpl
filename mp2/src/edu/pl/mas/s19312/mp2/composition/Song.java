package edu.pl.mas.s19312.mp2.composition;

public class Song {
    private String title;
    private Album album;

    public Song(String title, Album album) {
        setTitle(title);
        setAlbum(album);
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

    public Album getAlbum() {
        return album;
    }

    private void setAlbum(Album album) {
        if(album == null){
            throw new RuntimeException("Album cannot be null");
        }
        if(this.album == album){
            return;
        }
        this.album = album;
        album.addSongs(this);
    }

    public void removeAlbum() {
        if(this.album == null){
            return;
        }
        Album tmp = this.album;
        this.album = null;
        tmp.removeSongs(this);
    }
}
