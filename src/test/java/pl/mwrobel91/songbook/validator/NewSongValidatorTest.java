package pl.mwrobel91.songbook.validator;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import pl.mwrobel91.songbook.SongBookApplication;
import pl.mwrobel91.songbook.dto.CategoryDTO;
import pl.mwrobel91.songbook.dto.SongDTO;
import pl.mwrobel91.songbook.facade.CategoryFacade;
import pl.mwrobel91.songbook.model.Category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SongBookApplication.class)
class NewSongValidatorTest {

    @Autowired
    private NewSongValidator newSongValidator;
    @Autowired
    private CategoryFacade categoryFacade;
    private static final String OBJECT_NAME = "songDTO";
    private static final String FIELD_CATEGORY = "category";
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_DURATION = "duration";

    @Test
    void testNewSongValidatorValidCategory() {
        final SongDTO songDTO = new SongDTO.SongDTOBuilder()
                .title("title")
                .category(categoryFacade.getCategory(11))
                .lyrics("lyrics")
                .duration(60)
                .build();
        final Errors errors = new BeanPropertyBindingResult(songDTO, OBJECT_NAME);
        newSongValidator.validate(songDTO, errors);
        assertNull(errors.getFieldError(FIELD_CATEGORY));
    }

    @Test
    void testNewSongValidatorInvalidCategory() {
        final SongDTO songDTO = new SongDTO.SongDTOBuilder()
                .title("title")
                .category(new CategoryDTO())
                .lyrics("lyrics")
                .duration(60)
                .build();
        final Errors errors = new BeanPropertyBindingResult(songDTO, OBJECT_NAME);
        newSongValidator.validate(songDTO, errors);
        final String errorField = getErrorField(errors);
        assertEquals(FIELD_CATEGORY, errorField);
    }

    @Test
    void testNewSongValidatorEmptyTitle() {
        final SongDTO songDTO = new SongDTO.SongDTOBuilder()
                .title("")
                .category(categoryFacade.getCategory(11))
                .lyrics("lyrics")
                .duration(60)
                .build();
        final Errors errors = new BeanPropertyBindingResult(songDTO, OBJECT_NAME);
        newSongValidator.validate(songDTO, errors);
        final String errorField = getErrorField(errors);
        assertEquals(FIELD_TITLE, errorField);
    }

    @Test
    void testNewSongValidatorNullTitle() {
        final SongDTO songDTO = new SongDTO.SongDTOBuilder()
                .title(null)
                .category(categoryFacade.getCategory(11))
                .lyrics("lyrics")
                .duration(60)
                .build();
        final Errors errors = new BeanPropertyBindingResult(songDTO, OBJECT_NAME);
        newSongValidator.validate(songDTO, errors);
        final String errorField = getErrorField(errors);
        assertEquals(FIELD_TITLE, errorField);
    }
    @Test
    void testNewSongValidatorNegativeDuration() {
        final SongDTO songDTO = new SongDTO.SongDTOBuilder()
                .title("title")
                .category(categoryFacade.getCategory(11))
                .lyrics("lyrics")
                .duration(-1)
                .build();
        final Errors errors = new BeanPropertyBindingResult(songDTO, OBJECT_NAME);
        newSongValidator.validate(songDTO, errors);
        final String errorField = getErrorField(errors);
        assertEquals(FIELD_DURATION, errorField);
    }

    private String getErrorField(final Errors errors) {
        final FieldError fieldError = errors.getFieldError();
        String errorField = null;
        if (fieldError != null) {
            errorField = fieldError.getField();
        }
        return errorField;
    }

}