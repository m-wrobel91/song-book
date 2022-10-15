package pl.mwrobel91.songbook.service;

import pl.mwrobel91.songbook.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();

    Category getCategory(int categoryId);
}
