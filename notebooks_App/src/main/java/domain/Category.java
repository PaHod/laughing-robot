package domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by PaHod on 24.01.2015.
 */
@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

//    @Column(name = "PARENT_CATEGORY")
    @ManyToOne
    private Category parentCategory;

//    @Column(name = "SUB_CATEGORY")
    @OneToMany(mappedBy = "parentCategory")
    private Set<Category> subCategory;

    @Column(name = "CATEGORY_DESCRIPTION")
    private String description;


}
