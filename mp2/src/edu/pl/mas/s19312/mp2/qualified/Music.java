package edu.pl.mas.s19312.mp2.qualified;

public class Music {
    private long idMusic;
    private String musicName;
    private MusicType type;
    private MusicStorage storage;

    public Music(long idMusic, String musicName, MusicType type) {
        setIdMusic(idMusic);
        setMusicName(musicName);
        setType(type);
    }

    public long getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(long idMusic) {
        this.idMusic = idMusic;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        if(musicName == null || musicName.trim().equals("")){
            throw new RuntimeException("Music Name cannot be null or empty!");
        }
        this.musicName = musicName;
    }

    public MusicType getType() {
        return type;
    }

    public void setType(MusicType type) {
        if(type == null){
            throw new RuntimeException("Music type cannot be null!");
        }
        this.type = type;
    }

    public MusicStorage getStorage() {
        return storage;
    }

    public void setStorage(MusicStorage storage) {
        if(storage == null){
            throw new RuntimeException("Storage cannot be null!");
        }
        if(this.storage != null && this.storage != storage){
            this.removeStorage();
        }
        if(storage == this.storage){
            return;
        }
        this.storage = storage;
        storage.addMusic(this);
    }

    public void removeStorage() {
        if(this.storage == null){
            return;
        }
        MusicStorage tmp = this.storage;
        this.storage = null;
        tmp.removeMusic(this);
    }
}
