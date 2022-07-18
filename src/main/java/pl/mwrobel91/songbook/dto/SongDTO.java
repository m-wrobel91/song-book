package pl.mwrobel91.songbook.dto;

import pl.mwrobel91.songbook.model.Song;

public class SongDTO {

    private String title;
    private String category;
    private String lyrics;
    private int duration;

    public SongDTO() {
    }

    public SongDTO(String title, String category, String lyrics, int duration) {
        this.title = title;
        this.category = category;
        this.lyrics = lyrics;
        this.duration = duration;
    }
    // populator Constructor
    public SongDTO(Song song) {
        this.title = song.getTitle();
        this.category = song.getCategory().getCategory();
        this.lyrics = song.getLyrics();
        this.duration = song.getDuration();
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
