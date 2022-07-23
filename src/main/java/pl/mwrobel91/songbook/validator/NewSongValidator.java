package pl.mwrobel91.songbook.validator;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.mwrobel91.songbook.dto.SongDTO;
import pl.mwrobel91.songbook.enums.Category;

import java.text.MessageFormat;

@Component
public class NewSongValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return SongDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDTO songDTO = (SongDTO) target;
        checkIfCategoryIsProper(songDTO.getCategory(), errors);
    }

    private void checkIfCategoryIsProper(String category, Errors errors) {
        if (!EnumUtils.isValidEnum(Category.class, category)) {
            final String errorCode = MessageFormat.format(
                    "Given category: <{0}> is not within enum values of: <{1}>", category, Category.class);
            errors.rejectValue("category", errorCode);
        }
    }
}
