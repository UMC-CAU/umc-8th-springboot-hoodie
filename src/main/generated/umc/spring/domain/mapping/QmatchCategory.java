package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QmatchCategory is a Querydsl query type for matchCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QmatchCategory extends EntityPathBase<matchCategory> {

    private static final long serialVersionUID = 193956791L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QmatchCategory matchCategory = new QmatchCategory("matchCategory");

    public final umc.spring.domain.QBaseEntity _super = new umc.spring.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.spring.domain.QFoodCategory foodCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.spring.domain.QUser user;

    public QmatchCategory(String variable) {
        this(matchCategory.class, forVariable(variable), INITS);
    }

    public QmatchCategory(Path<? extends matchCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QmatchCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QmatchCategory(PathMetadata metadata, PathInits inits) {
        this(matchCategory.class, metadata, inits);
    }

    public QmatchCategory(Class<? extends matchCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new umc.spring.domain.QFoodCategory(forProperty("foodCategory")) : null;
        this.user = inits.isInitialized("user") ? new umc.spring.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

