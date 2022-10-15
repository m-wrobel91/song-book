package pl.mwrobel91.songbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.mwrobel91.songbook.model.Song;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {

    @Query(value = "SELECT * FROM songs", nativeQuery = true)
    List<Song> getSongs();

    @Query(value ="SELECT * FROM songs s WHERE s.category_id = :category", nativeQuery = true)
    List<Song> getSongsByCategory(@Param("category") int category); // todo int? long?

    @Query(value = "SELECT COUNT (id) FROM songs", nativeQuery = true)
    int countSongs();

    @Query(value = "SELECT * FROM songs s WHERE s.id = :id", nativeQuery = true)
    Song getSongById(@Param("id") int id);

    @Query(value = "SELECT * FROM songs s ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Song getRandomSong();

    @Query(value = "SELECT * FROM songs s WHERE LOWER(s.title) LIKE LOWER(CONCAT('%', :searchPhrase, '%')) " +
            " OR LOWER(s.lyrics) LIKE LOWER(CONCAT('%', :searchPhrase, '%'))", nativeQuery = true)
    List<Song> getSongByPhrase(@Param("searchPhrase") final String searchPhrase);
}

