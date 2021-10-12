package ua.com.alevel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category_type", nullable = false)
    private boolean category_type;

    @OneToMany(mappedBy = "category")
    private List<Operation> operations;

    public Category() {
        operations = new ArrayList<>();
    }

    public Category(String name, boolean category_type) {
        this.name = name;
        this.category_type = category_type;
        operations = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getCategory_type() {
        return category_type;
    }

    public void setCategory_type(boolean category_type) {
        this.category_type = category_type;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
