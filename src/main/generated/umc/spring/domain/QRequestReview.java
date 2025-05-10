package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRequestReview is a Querydsl query type for RequestReview
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRequestReview extends EntityPathBase<RequestReview> {

    private static final long serialVersionUID = 1189356955L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRequestReview requestReview = new QRequestReview("requestReview");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath body = createString("body");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final QNotification notification;

    public final NumberPath<Long> requestId = createNumber("requestId", Long.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QRequestReview(String variable) {
        this(RequestReview.class, forVariable(variable), INITS);
    }

    public QRequestReview(Path<? extends RequestReview> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRequestReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRequestReview(PathMetadata metadata, PathInits inits) {
        this(RequestReview.class, metadata, inits);
    }

    public QRequestReview(Class<? extends RequestReview> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.notification = inits.isInitialized("notification") ? new QNotification(forProperty("notification"), inits.get("notification")) : null;
    }

}

