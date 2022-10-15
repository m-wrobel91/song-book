package pl.mwrobel91.songbook.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mwrobel91.songbook.dto.SongDTO;
import pl.mwrobel91.songbook.facade.SongFacade;
import pl.mwrobel91.songbook.model.Song;
import pl.mwrobel91.songbook.service.SongService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class SongFacadeImpl implements SongFacade {

    @Autowired
    private final SongService songService;

    public SongFacadeImpl(final SongService songService) {
        this.songService = songService;
    }

    @Override
    public List<SongDTO> getSongs() {
        return songService.getSongs()
                .stream()
                .filter(Objects::nonNull)
                .map(SongDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<SongDTO> getSongsByCategory(final int categoryId) {
        return songService.getSongsByCategory(categoryId)
                .stream()
                .filter(Objects::nonNull)
                .map(SongDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void create(final SongDTO songDTO) {
        final Song song = new Song(songDTO);
        songService.create(song);
    }

    @Override
    public SongDTO getRandomSong() {
        final Song randomSong = songService.getRandomSong();
        return new SongDTO(randomSong);
    }

    @Override
    public SongDTO getSong(final int id) {
        final Song song = songService.getSong(id);
        return new SongDTO(song);
    }

    @Override
    public List<SongDTO> getSongByPhrase(final String searchPhrase) {
        final List<Song> songList = songService.getSongByPhrase(searchPhrase);
        return songList.stream().map(SongDTO::new).collect(Collectors.toList());
    }
}
