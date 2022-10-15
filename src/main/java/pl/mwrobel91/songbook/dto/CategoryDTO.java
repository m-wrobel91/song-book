package pl.mwrobel91.songbook.dto;

import pl.mwrobel91.songbook.model.Category;
import pl.mwrobel91.songbook.repository.CategoryRepository;

public class CategoryDTO {

    private int id;
    private String name;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();;
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
}
