package com.sai.productservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Getter
@Setter
@Entity     // By default create a table woth same name.If you want different name (name = "catagories")
// @Builder
@NoArgsConstructor // Doesnot take any arguments
@AllArgsConstructor // Take the all arguments
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    //P:C = 1:1
    // C:P = M:1
    // ==>> M:1
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "category")
    private  Category category;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)  //
    // @Fetch(FetchMode.JOIN)
    private  Price price;  // Used double because the fakestore api uses double, can use any data type you want

    private int inventoryCount;

}
