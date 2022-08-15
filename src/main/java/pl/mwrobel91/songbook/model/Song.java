package pl.mwrobel91.songbook.model;


import pl.mwrobel91.songbook.dto.SongDTO;
import pl.mwrobel91.songbook.enums.Category;

import javax.persistence.*;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String lyrics;
    private int duration;

    public Song() {
    }

    public Song(final SongDTO songDTO) {
        this.title = songDTO.getTitle();
        this.category = Category.valueOf(songDTO.getCategory());
        this.lyrics = songDTO.getLyrics();
        this.duration = songDTO.getDuration();
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(final String lyrics) {
        this.lyrics = lyrics;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }
}
