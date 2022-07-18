package pl.mwrobel91.songbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mwrobel91.songbook.dto.SongDTO;
import pl.mwrobel91.songbook.facade.SongFacade;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    private final SongFacade songFacade;

    public SongController(final SongFacade songFacade) {
        this.songFacade = songFacade;
    }


    @GetMapping(value = "/all")
    public List<SongDTO> getSongs() {
        return songFacade.getSongs();
    }
    @GetMapping(value = "/{category}")
    public List<SongDTO> getSongsByCategory(@PathVariable final String category) {
        return songFacade.getSongsByCategory(category);
    }

}
