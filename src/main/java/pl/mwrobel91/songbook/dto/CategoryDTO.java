package pl.mwrobel91.songbook.dto;

import pl.mwrobel91.songbook.model.Category;

import java.util.List;

public class CategoryDTO {

    private int id;
    private String name;
    private List<SongDTO> songs;

    public CategoryDTO(final Category category) {
        this.id = category.getId();
        this.name = category.getName();;
    }

    public CategoryDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<SongDTO> getSongs() {
        return songs;
    }

    public void setSongs(final List<SongDTO> songs) {
        this.songs = songs;
    }
}
