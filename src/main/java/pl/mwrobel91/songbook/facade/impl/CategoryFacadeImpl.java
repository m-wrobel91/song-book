package pl.mwrobel91.songbook.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mwrobel91.songbook.dto.CategoryDTO;
import pl.mwrobel91.songbook.facade.CategoryFacade;
import pl.mwrobel91.songbook.service.CategoryService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CategoryFacadeImpl implements CategoryFacade {

    @Autowired
    private final CategoryService categoryService;

    public CategoryFacadeImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public List<CategoryDTO> getCategories() {
        return categoryService.getCategories()
                .stream()
                .filter(Objects::nonNull)
                .map(CategoryDTO::new)
                .collect(Collectors.toList());
    }
}
