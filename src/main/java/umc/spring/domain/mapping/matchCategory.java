package umc.spring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.BaseEntity;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.User;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class matchCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FoodCategory_id")
    private FoodCategory foodCategory;

    public void setUser (User user){
        if(this.user != null)
            user.getMatchCategoryList().remove(this);
        this.user = user;
        user.getMatchCategoryList().add(this);
    }

}
