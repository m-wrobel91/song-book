package pl.mwrobel91.songbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mwrobel91.songbook.dto.MainCategoryDTO;
import pl.mwrobel91.songbook.facade.MainCategoryFacade;

import java.util.List;

import static pl.mwrobel91.songbook.constant.CrossOriginConstants.ALLOWED_ORIGIN;

@RestController
@CrossOrigin(origins = ALLOWED_ORIGIN)
@RequestMapping("/maincategory")
public class MainCategoryController {

    @Autowired
    private final MainCategoryFacade mainCategoryFacade;

    public MainCategoryController(final MainCategoryFacade mainCategoryFacade) {
        this.mainCategoryFacade = mainCategoryFacade;
    }

    @GetMapping(value = "/all")
    public List<MainCategoryDTO> getCategories() {
        return mainCategoryFacade.getMainCategories();
    }
}
