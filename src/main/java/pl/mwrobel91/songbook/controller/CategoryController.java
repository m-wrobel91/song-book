package pl.mwrobel91.songbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mwrobel91.songbook.dto.CategoryDTO;
import pl.mwrobel91.songbook.facade.CategoryFacade;

import java.util.List;

import static pl.mwrobel91.songbook.constant.CrossOriginConstants.ALLOWED_ORIGIN;

@RestController
@CrossOrigin(origins = ALLOWED_ORIGIN)
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private final CategoryFacade categoryFacade;

    public CategoryController(CategoryFacade categoryFacade) {
        this.categoryFacade = categoryFacade;
    }

    @GetMapping(value = "/all")
    public List<CategoryDTO> getCategories() {
        return categoryFacade.getCategories();
    }
}
