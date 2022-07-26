package pl.mwrobel91.songbook.validator;

import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import pl.mwrobel91.songbook.dto.SongDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class NewSongValidatorTest {

    private static final String OBJECT_NAME = "songDTO";
    private static final String FIELD_CATEGORY = "category";
    private static final String FIELD_TITLE = "title";
    private final NewSongValidator newSongValidator = new NewSongValidator();

    @Test
    void testNewSongValidatorValidCategory() {
        final SongDTO songDTO = new SongDTO("title", "SUITA_KRAKOWIAK", "lyrics", 60);
        final Errors errors = new BeanPropertyBindingResult(songDTO, OBJECT_NAME);
        newSongValidator.validate(songDTO, errors);
        assertNull(errors.getFieldError(FIELD_CATEGORY));
    }

    @Test
    void testNewSongValidatorInvalidCategory() {
        final SongDTO songDTO = new SongDTO("title", "category_X", "lyrics", 60);
        final Errors errors = new BeanPropertyBindingResult(songDTO, OBJECT_NAME);
        newSongValidator.validate(songDTO, errors);
        final String errorField = getErrorField(errors);
        assertEquals(FIELD_CATEGORY, errorField);
    }

    @Test
    void testNewSongValidatorEmptyTitle() {
        final SongDTO songDTO = new SongDTO("", "SUITA_KRAKOWIAK", "lyrics", 60);
        final Errors errors = new BeanPropertyBindingResult(songDTO, OBJECT_NAME);
        newSongValidator.validate(songDTO, errors);
        final String errorField = getErrorField(errors);
        assertEquals(FIELD_TITLE, errorField);
    }

    @Test
    void testNewSongValidatorNullTitle() {
        final SongDTO songDTO = new SongDTO(null, "SUITA_KRAKOWIAK", "lyrics", 60);
        final Errors errors = new BeanPropertyBindingResult(songDTO, OBJECT_NAME);
        newSongValidator.validate(songDTO, errors);
        final String errorField = getErrorField(errors);
        assertEquals(FIELD_TITLE, errorField);
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