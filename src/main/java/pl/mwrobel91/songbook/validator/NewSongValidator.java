package pl.mwrobel91.songbook.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.mwrobel91.songbook.dto.CategoryDTO;
import pl.mwrobel91.songbook.dto.SongDTO;
import pl.mwrobel91.songbook.facade.CategoryFacade;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NewSongValidator implements Validator {
    @Autowired
    private final CategoryFacade categoryFacade;
    public static final String DURATION = "duration";
    public static final String TITLE = "title";
    public static final String LYRICS = "lyrics";
    public static final String CATEGORY = "category";

    public NewSongValidator(CategoryFacade categoryFacade) {
        this.categoryFacade = categoryFacade;
    }

    @Override
    public boolean supports(final Class<?> clazz) {
        return SongDTO.class.equals(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        final SongDTO songDTO = (SongDTO) target;
        checkIfCategoryIsProper(songDTO.getCategory(), errors); //to add mocking
        checkIfTitleEmptyOrNull(songDTO.getTitle(), errors);
        checkIfLyricsEmptyOrNull(songDTO.getLyrics(), errors);
        checkIfDurationIsNegative(songDTO.getDuration(), errors);
    }

    private void checkIfCategoryIsProper(final String category, final Errors errors) {
        List<String> categories = categoryFacade.getCategories()
                .stream()
                .map(CategoryDTO::getName)
                .collect(Collectors.toList());
        if (!categories.contains(category)) {
            final String errorCode = MessageFormat.format(
                    "Given category: <{0}> is not within possible values of categories", category);
            errors.rejectValue(CATEGORY, errorCode);
       }
    }

    private void checkIfTitleEmptyOrNull(final String title, final Errors errors) {
        if (StringUtils.isBlank(title)) {
            final String errorCode = "Title must not be empty nor null";
            errors.rejectValue(TITLE, errorCode);
        }
    }

    private void checkIfLyricsEmptyOrNull(final String title, final Errors errors) {
        if (StringUtils.isBlank(title)) {
            final String errorCode = "Lyrics must not be empty nor null";
            errors.rejectValue(LYRICS, errorCode);
        }
    }

    private void checkIfDurationIsNegative(final Integer duration, final Errors errors) {
        if (duration < 0) {
            final String errorCode = "Duration must be positive or zero";
            errors.rejectValue(DURATION, errorCode);
        }
    }
}
