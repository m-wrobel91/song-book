package pl.mwrobel91.songbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwrobel91.songbook.model.Song;
import pl.mwrobel91.songbook.repository.SongRepository;
import pl.mwrobel91.songbook.service.SongService;

import java.rmi.NoSuchObjectException;
import java.text.MessageFormat;
import java.util.List;
import java.util.NoSuchElementException;

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
    public List<Song> getSongsByCategory(final int categoryId) {
        return songRepository.getSongsByCategory(categoryId);
    }

    @Override
    public void create(final Song song) {
        songRepository.save(song);
    }

    @Override
    public Song getRandomSong() {
        return songRepository.getRandomSong();
    }

    @Override
    public Song getSong(final int id) {
        return songRepository.getSongById(id);
    }

    @Override
    public List<Song> getSongByPhrase(final String searchPhrase) {
        return songRepository.getSongByPhrase(searchPhrase);
    }
}
