package pl.mwrobel91.songbook.validator;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.mwrobel91.songbook.dto.SongDTO;
import pl.mwrobel91.songbook.enums.Category;

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
        if(!EnumUtils.isValidEnum(Category.class, category)) {
            errors.rejectValue("category", "Given category string is not within enum values");
        }
    }
}
