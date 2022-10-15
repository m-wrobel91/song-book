package pl.mwrobel91.songbook.facade;

import pl.mwrobel91.songbook.dto.CategoryDTO;

import java.util.List;

public interface CategoryFacade {
    List<CategoryDTO> getCategories();

    CategoryDTO getCategory(int categoryId);

}
