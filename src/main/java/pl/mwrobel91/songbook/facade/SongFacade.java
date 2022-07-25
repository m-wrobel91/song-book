package pl.mwrobel91.songbook.facade;

import pl.mwrobel91.songbook.dto.SongDTO;

import java.util.List;

public interface SongFacade {

    List<SongDTO> getSongs();

    List<SongDTO> getSongsByCategory(String category);

    void create(SongDTO songDTO);

    SongDTO getRandomSong();
}
