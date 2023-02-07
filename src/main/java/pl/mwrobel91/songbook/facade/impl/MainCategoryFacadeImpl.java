package pl.mwrobel91.songbook.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mwrobel91.songbook.converter.Converter;
import pl.mwrobel91.songbook.dto.MainCategoryDTO;
import pl.mwrobel91.songbook.facade.MainCategoryFacade;
import pl.mwrobel91.songbook.model.MainCategory;
import pl.mwrobel91.songbook.service.MainCategoryService;

import java.util.List;

@Component
public class MainCategoryFacadeImpl implements MainCategoryFacade {

    @Autowired
    private final MainCategoryService mainCategoryService;

    private final Converter<MainCategory, MainCategoryDTO> mainCategoryConverter;

    public MainCategoryFacadeImpl(final MainCategoryService mainCategoryService,
                                  final Converter<MainCategory, MainCategoryDTO> mainCategoryConverter) {
        this.mainCategoryService = mainCategoryService;
        this.mainCategoryConverter = mainCategoryConverter;
    }

    @Override
    public List<MainCategoryDTO> getMainCategories() {
        return mainCategoryConverter.convertAll(mainCategoryService.getMainCategories());
    }
}
