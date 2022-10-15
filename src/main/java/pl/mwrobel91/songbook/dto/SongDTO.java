package pl.mwrobel91.songbook.dto;

import pl.mwrobel91.songbook.model.Song;

public class SongDTO {
    private final int id;
    private final String title;
    private final CategoryDTO category;
    private final String lyrics;
    private final int duration;

    private SongDTO(final SongDTOBuilder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.category = builder.category;
        this.lyrics = builder.lyrics;
        this.duration = builder.duration;
    }
    // populator Constructor
    public SongDTO(final Song song) {
        this.id = song.getId();
        this.title = song.getTitle();
        this.category = new CategoryDTO(song.getCategory());
        this.lyrics = song.getLyrics();
        this.duration = song.getDuration();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public String getLyrics() {
        return lyrics;
    }

    public int getDuration() {
        return duration;
    }

    public static class SongDTOBuilder {
        private int id;
        private String title;
        private CategoryDTO category;
        private String lyrics;
        private int duration;

        public SongDTOBuilder title (final String title) {
            this.title = title;
            return this;
        }
        public SongDTOBuilder category (final CategoryDTO category) {
            this.category = category;
            return this;
        }
        public SongDTOBuilder lyrics (final String lyrics) {
            this.lyrics = lyrics;
            return this;
        }
        public SongDTOBuilder duration (final int duration) {
            this.duration = duration;
            return this;
        }

        public SongDTO build() {
            return new SongDTO(this);
        }

    }
}
