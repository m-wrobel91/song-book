package pl.mwrobel91.songbook.dto;

import pl.mwrobel91.songbook.model.Category;

import java.util.List;

public class MainCategoryDTO {

    private int id;
    private String name;
    private List<CategoryDTO> categories;

    public MainCategoryDTO(final Category category) {
        this.id = category.getId();
        this.name = category.getName();;
    }

    public MainCategoryDTO() {
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

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(final List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
