package pl.mwrobel91.songbook.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "main_categories")
public class MainCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mainCategory", cascade = CascadeType.ALL)
    private Set<Category> subCategories = new HashSet<Category>();

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(final Set<Category> subCategories) {
        this.subCategories = subCategories;
    }
}
