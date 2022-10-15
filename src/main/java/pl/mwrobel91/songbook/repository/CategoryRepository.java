package pl.mwrobel91.songbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.mwrobel91.songbook.model.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM categories", nativeQuery = true)
    List<Category> getCategories();

    @Query(value = "SELECT * FROM categories c WHERE c.id = :id", nativeQuery = true)
    Category getCategory(@Param("id") int categoryId);
}
