package pl.mwrobel91.songbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwrobel91.songbook.model.Song;
import pl.mwrobel91.songbook.repository.SongRepository;
import pl.mwrobel91.songbook.service.SongService;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private final SongRepository songRepository;

    public SongServiceImpl(final SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> getSongs() {
        return songRepository.getSongs();
    }

    @Override
    public List<Song> getSongsByCategory(String category) {
        requireNonNull(category);
        return songRepository.getSongsByCategory(category);
    }

    @Override
    public void create(Song song) {
        songRepository.save(song);
    }
}
