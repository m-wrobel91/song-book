package pl.mwrobel91.songbook.facade;

import pl.mwrobel91.songbook.dto.SongDTO;

import java.util.List;

public interface SongFacade {

    List<SongDTO> getSongs();

    List<SongDTO> getSongsByCategory(int categoryId);

    void create(SongDTO songDTO);

    SongDTO getRandomSong();

    SongDTO getSong(int id);

    List<SongDTO> getSongByPhrase(String searchPhrase);
}
