package pl.mwrobel91.songbook.populator.impl;

import pl.mwrobel91.songbook.dto.CategoryDTO;
import pl.mwrobel91.songbook.model.Category;
import pl.mwrobel91.songbook.populator.Populator;

import java.util.Objects;

public class CategoryNamePopulator implements Populator<Category, CategoryDTO> {
    @Override
    public void populate(final Category source, final CategoryDTO target) {
        Objects.requireNonNull(source);
        Objects.requireNonNull(target);
        target.setName(source.getName());
    }
}
