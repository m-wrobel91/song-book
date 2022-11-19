package pl.mwrobel91.songbook.populator.impl;

import pl.mwrobel91.songbook.converter.Converter;
import pl.mwrobel91.songbook.dto.CategoryDTO;
import pl.mwrobel91.songbook.dto.SongDTO;
import pl.mwrobel91.songbook.model.Category;
import pl.mwrobel91.songbook.model.Song;
import pl.mwrobel91.songbook.populator.Populator;

import java.util.Objects;

public class SongIdTitleAndCategoryPopulator implements Populator<Song, SongDTO> {

    private final Converter<Category, CategoryDTO> categoryWithoutSongsConverter;

    public SongIdTitleAndCategoryPopulator(final Converter<Category, CategoryDTO> categoryWithoutSongsConverter) {
        this.categoryWithoutSongsConverter = categoryWithoutSongsConverter;
    }

    @Override
    public void populate(final Song source, final SongDTO target) {
        Objects.requireNonNull(source);
        Objects.requireNonNull(target);
        target.setId(source.getId());
        target.setTitle(source.getTitle());
        if(source.getCategory() != null) {
            target.setCategory(categoryWithoutSongsConverter.convert(source.getCategory()));
        }
    }
}
