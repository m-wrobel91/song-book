package pl.mwrobel91.songbook.populator.impl;

import pl.mwrobel91.songbook.dto.SongDTO;
import pl.mwrobel91.songbook.model.Song;
import pl.mwrobel91.songbook.populator.Populator;

import java.util.Objects;

public class SongLyricsAndDurationPopulator implements Populator<Song, SongDTO> {

    @Override
    public void populate(final Song source, final SongDTO target) {
        Objects.requireNonNull(source);
        Objects.requireNonNull(target);
        target.setLyrics(source.getLyrics());
        target.setDuration(source.getDuration());
    }
}
