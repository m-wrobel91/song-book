package pl.mwrobel91.songbook.populator.impl;

import pl.mwrobel91.songbook.dto.MainCategoryDTO;
import pl.mwrobel91.songbook.model.MainCategory;
import pl.mwrobel91.songbook.populator.Populator;

import java.util.Objects;

public class MainCategoryPopulator implements Populator<MainCategory, MainCategoryDTO> {
    @Override
    public void populate(final MainCategory source, final MainCategoryDTO target) {
        Objects.requireNonNull(source);
        Objects.requireNonNull(target);
        target.setId(source.getId());
        target.setName(source.getName());
    }
}
