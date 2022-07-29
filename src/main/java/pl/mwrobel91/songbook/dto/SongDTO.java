package pl.mwrobel91.songbook.dto;

import pl.mwrobel91.songbook.model.Song;

public class SongDTO {
    private int id;
    private String title;
    private String category;
    private String lyrics;
    private int duration;

    public SongDTO() {
    }

    public SongDTO(int id, String title, String category, String lyrics, int duration) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.lyrics = lyrics;
        this.duration = duration;
    }
    // populator Constructor
    public SongDTO(Song song) {
        this.id = song.getId();
        this.title = song.getTitle();
        this.category = song.getCategory().getCategory();
        this.lyrics = song.getLyrics();
        this.duration = song.getDuration();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
