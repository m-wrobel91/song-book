package pl.mwrobel91.songbook;

import org.mockito.Mockito;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.mwrobel91.songbook.facade.CategoryFacade;
import pl.mwrobel91.songbook.validator.NewSongValidator;

@Profile("test")
@Configuration
public class SonBookTestConfiguration {

    NewSongValidator newSongValidator() {
        return Mockito.mock(NewSongValidator.class);
    }

    CategoryFacade categoryFacade() {
        return Mockito.mock(CategoryFacade.class);
    }
}
