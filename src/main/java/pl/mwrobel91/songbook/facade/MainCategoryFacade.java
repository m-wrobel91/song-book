package pl.mwrobel91.songbook.facade;

import pl.mwrobel91.songbook.dto.MainCategoryDTO;

import java.util.List;

public interface MainCategoryFacade {

    List<MainCategoryDTO> getMainCategories();
}
