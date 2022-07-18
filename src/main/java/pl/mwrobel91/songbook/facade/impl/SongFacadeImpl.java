package pl.mwrobel91.songbook.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mwrobel91.songbook.dto.SongDTO;
import pl.mwrobel91.songbook.facade.SongFacade;
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
    public List<SongDTO> getSongsByCategory(String category) {
        return songService.getSongsByCategory(category)
                .stream()
                .filter(Objects::nonNull)
                .map(SongDTO::new)
                .collect(Collectors.toList());
    }
}
