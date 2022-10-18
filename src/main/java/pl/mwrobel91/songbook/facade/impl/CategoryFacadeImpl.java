package pl.mwrobel91.songbook.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mwrobel91.songbook.converter.Converter;
import pl.mwrobel91.songbook.dto.CategoryDTO;
import pl.mwrobel91.songbook.facade.CategoryFacade;
import pl.mwrobel91.songbook.model.Category;
import pl.mwrobel91.songbook.service.CategoryService;

import java.util.List;

@Component
public class CategoryFacadeImpl implements CategoryFacade {

    @Autowired
    private final CategoryService categoryService;

    private final Converter<Category, CategoryDTO> categoryWithoutSongsConverter;

    public CategoryFacadeImpl(CategoryService categoryService, Converter<Category, CategoryDTO> categoryWithoutSongsConverter) {
        this.categoryService = categoryService;
        this.categoryWithoutSongsConverter = categoryWithoutSongsConverter;
    }

    @Override
    public List<CategoryDTO> getCategories() {
        return categoryWithoutSongsConverter.convertAll(categoryService.getCategories());
    }

    @Override
    public CategoryDTO getCategory(int categoryId) {
        Category category = categoryService.getCategory(categoryId);
        return  new CategoryDTO(category);
    }
}
