package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewPost is a Querydsl query type for ReviewPost
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewPost extends EntityPathBase<ReviewPost> {

    private static final long serialVersionUID = 1439265220L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewPost reviewPost = new QReviewPost("reviewPost");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> score = createNumber("score", Integer.class);

    public final QStore store;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public QReviewPost(String variable) {
        this(ReviewPost.class, forVariable(variable), INITS);
    }

    public QReviewPost(Path<? extends ReviewPost> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewPost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewPost(PathMetadata metadata, PathInits inits) {
        this(ReviewPost.class, metadata, inits);
    }

    public QReviewPost(Class<? extends ReviewPost> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

