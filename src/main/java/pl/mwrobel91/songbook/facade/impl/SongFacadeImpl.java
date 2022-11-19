package pl.mwrobel91.songbook.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mwrobel91.songbook.converter.Converter;
import pl.mwrobel91.songbook.dto.SongDTO;
import pl.mwrobel91.songbook.facade.SongFacade;
import pl.mwrobel91.songbook.model.Song;
import pl.mwrobel91.songbook.service.SongService;

import java.util.List;

@Component
public class SongFacadeImpl implements SongFacade {

    @Autowired
    private final SongService songService;

    @Autowired
    private final Converter<Song,SongDTO> songConverter;

    public SongFacadeImpl(final SongService songService, final Converter<Song, SongDTO> songConverter) {
        this.songService = songService;
        this.songConverter = songConverter;
    }

    @Override
    public List<SongDTO> getSongs() {
        final List<Song> songs = songService.getSongs();
        return songConverter.convertAll(songs);
    }

    @Override
    public List<SongDTO> getSongsByCategory(final int categoryId) {
        final List<Song> songs = songService.getSongsByCategory(categoryId);
        return songConverter.convertAll(songs);
    }

    @Override
    public void create(final SongDTO songDTO) {
        final Song song = new Song(songDTO); // todo: add reverse converter
        songService.create(song);
    }

    @Override
    public SongDTO getRandomSong() {
        final Song randomSong = songService.getRandomSong();
        return songConverter.convert(randomSong);
    }

    @Override
    public SongDTO getSong(final int id) {
        final Song song = songService.getSong(id);
        return songConverter.convert(song);
    }

    @Override
    public List<SongDTO> getSongByPhrase(final String searchPhrase) {
        final List<Song> songList = songService.getSongByPhrase(searchPhrase);
        return songConverter.convertAll(songList);
    }
}
