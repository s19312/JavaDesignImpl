package edu.pl.mas.s19312.mp2.qualified;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MusicStorage {
    private MusicType type;

    private Map<Long,Music> musicMap = new HashMap<>();

    public MusicStorage(MusicType type) {
        setType(type);
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

    public Map<Long, Music> getMusicMap() {
        return Collections.unmodifiableMap(musicMap);
    }

    public void addMusic(Music music) {
        if(music == null){
            throw new RuntimeException("Music cannot be null!");
        }
        if(this.musicMap.containsKey(music.getIdMusic())){
            return;
        }
        if(this.type != music.getType()){
            throw new RuntimeException("Music Type must be the same as Music List Type");
        }
        this.musicMap.put(music.getIdMusic(),music);
        music.setStorage(this);
    }

    public void removeMusic(Music music) {
        if(music == null){
            throw new RuntimeException("Music cannot be null!");
        }
        if(!this.musicMap.containsKey(music.getIdMusic())){
            return;
        }
        this.musicMap.remove(music.getIdMusic());
        music.removeStorage();
    }
}
