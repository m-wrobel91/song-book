package pl.mwrobel91.songbook.service;

import pl.mwrobel91.songbook.model.Song;

import java.util.Collection;
import java.util.List;

public interface SongService {

    List<Song> getSongs();

    List<Song> getSongsByCategory(int categoryId);

    void create(Song song);

    Song getRandomSong();

    Song getSong(int id);

    List<Song> getSongByPhrase(String searchPhrase);
}
