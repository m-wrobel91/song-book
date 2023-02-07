package pl.mwrobel91.songbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwrobel91.songbook.model.MainCategory;
import pl.mwrobel91.songbook.repository.MainCategoryRepository;
import pl.mwrobel91.songbook.service.MainCategoryService;

import java.util.List;

@Service
public class MainCategoryServiceImpl implements MainCategoryService {

    @Autowired
    private final MainCategoryRepository mainCategoryRepository;

    public MainCategoryServiceImpl(final MainCategoryRepository mainCategoryRepository) {
        this.mainCategoryRepository = mainCategoryRepository;
    }

    @Override
    public List<MainCategory> getMainCategories() {
        return mainCategoryRepository.getMainCategoriesCategories();
    }
}
