package pl.mwrobel91.songbook.dto;

import pl.mwrobel91.songbook.model.Category;

import java.util.List;

public class CategoryDTO {

    private int id;
    private String name;
    private List<SongDTO> songs;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();;
    }

    public CategoryDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SongDTO> getSongs() {
        return songs;
    }

    public void setSongs(List<SongDTO> songs) {
        this.songs = songs;
    }
}
