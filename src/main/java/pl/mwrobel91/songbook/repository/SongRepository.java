package pl.mwrobel91.songbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.mwrobel91.songbook.model.Song;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {

    //@Query("SELECT s FROM songs s")

    @Query(value = "SELECT * FROM songs", nativeQuery = true)
    List<Song> getSongs();

    @Query(value ="SELECT * FROM songs s WHERE s.category = :category", nativeQuery = true)
    List<Song> getSongsByCategory(@Param("category") String category);

    @Query(value = "SELECT COUNT (id) FROM songs", nativeQuery = true)
    int countSongs();

    @Query(value = "SELECT * FROM songs s WHERE s.id = :id", nativeQuery = true)
    Song getSongById(@Param("id") long id);

    @Query(value = "SELECT * FROM songs s ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Song getRandomSong();
}

