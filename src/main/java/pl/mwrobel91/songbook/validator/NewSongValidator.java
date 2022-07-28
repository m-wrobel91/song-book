package pl.mwrobel91.songbook.validator;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.mwrobel91.songbook.dto.SongDTO;
import pl.mwrobel91.songbook.enums.Category;

import java.text.MessageFormat;

@Component
public class NewSongValidator implements Validator {

    public static final String DURATION = "duration";
    public static final String TITLE = "title";
    public static final String LYRICS = "lyrics";
    public static final String CATEGORY = "category";

    @Override
    public boolean supports(Class<?> clazz) {
        return SongDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDTO songDTO = (SongDTO) target;
        checkIfCategoryIsProper(songDTO.getCategory(), errors);
        checkIfTitleEmptyOrNull(songDTO.getTitle(), errors);
        checkIfLyricsEmptyOrNull(songDTO.getLyrics(), errors);
        checkIfDurationIsNegative(songDTO.getDuration(), errors);
    }

    private void checkIfCategoryIsProper(final String category, Errors errors) {
        if (!EnumUtils.isValidEnum(Category.class, category)) {
            final String errorCode = MessageFormat.format(
                    "Given category: <{0}> is not within enum values of: <{1}>", category, Category.class);
            errors.rejectValue(CATEGORY, errorCode);
        }
    }

    private void checkIfTitleEmptyOrNull(final String title, Errors errors) {
        if (StringUtils.isBlank(title)) {
            final String errorCode = "Title must not be empty nor null";
            errors.rejectValue(TITLE, errorCode);
        }
    }

    private void checkIfLyricsEmptyOrNull(final String title, Errors errors) {
        if (StringUtils.isBlank(title)) {
            final String errorCode = "Lyrics must not be empty nor null";
            errors.rejectValue(LYRICS, errorCode);
        }
    }

    private void checkIfDurationIsNegative(final Integer duration, Errors errors) {
        if (duration < 0) {
            final String errorCode = "Duration must be positive or zero";
            errors.rejectValue(DURATION, errorCode);
        }
    }
}
