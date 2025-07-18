package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNewMission is a Querydsl query type for NewMission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNewMission extends EntityPathBase<NewMission> {

    private static final long serialVersionUID = 704722296L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNewMission newMission = new QNewMission("newMission");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath body = createString("body");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> missionId = createNumber("missionId", Long.class);

    public final QNotification notification;

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QNewMission(String variable) {
        this(NewMission.class, forVariable(variable), INITS);
    }

    public QNewMission(Path<? extends NewMission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNewMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNewMission(PathMetadata metadata, PathInits inits) {
        this(NewMission.class, metadata, inits);
    }

    public QNewMission(Class<? extends NewMission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.notification = inits.isInitialized("notification") ? new QNotification(forProperty("notification"), inits.get("notification")) : null;
    }

}

