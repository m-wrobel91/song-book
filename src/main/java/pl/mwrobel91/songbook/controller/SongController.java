package pl.mwrobel91.songbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import pl.mwrobel91.songbook.dto.SongDTO;
import pl.mwrobel91.songbook.facade.SongFacade;

import java.util.List;

import static pl.mwrobel91.songbook.constant.CrossOriginConstants.ALLOWED_ORIGIN;

@RestController
@CrossOrigin(origins = ALLOWED_ORIGIN)
@RequestMapping("/song")
public class SongController extends BaseController {

    @Autowired
    private final SongFacade songFacade;

    @Autowired
    private final Validator newSongValidator;


    private SongController(final SongFacade songFacade, final Validator newSongValidator) {
        this.songFacade = songFacade;
        this.newSongValidator = newSongValidator;
    }


    @GetMapping(value = "/all")
    public List<SongDTO> getSongs() {
        return songFacade.getSongs();
    }
    @GetMapping(value = "/category/{category}")
    public List<SongDTO> getSongsByCategory(@PathVariable final String category) {
        return songFacade.getSongsByCategory(category);
    }
    @GetMapping(value = "/{id}")
    public SongDTO getSong(@PathVariable final int id) {
        return songFacade.getSong(id);
    }

    @GetMapping(value = "/search/{searchPhrase}")
    public List<SongDTO> getSongByPhrase(@PathVariable final String searchPhrase) {
        return songFacade.getSongByPhrase(searchPhrase);
    }
    @GetMapping(value = "/random")
    public SongDTO getRandomSong() {
        return songFacade.getRandomSong();
    }

    @PostMapping(value = "/")
    public void create(@RequestBody final SongDTO songDTO) {
        validate(songDTO, "SongDTO", newSongValidator);
        songFacade.create(songDTO);
    }
}
