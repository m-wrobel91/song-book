package pl.mwrobel91.songbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.mwrobel91.songbook.model.MainCategory;

import java.util.List;

public interface MainCategoryRepository extends JpaRepository<MainCategory, Long> {

    @Query(value = "SELECT * FROM main_categories", nativeQuery = true)
    List<MainCategory> getMainCategoriesCategories();
}
