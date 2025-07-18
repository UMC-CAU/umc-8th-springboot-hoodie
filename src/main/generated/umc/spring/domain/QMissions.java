package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMissions is a Querydsl query type for Missions
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMissions extends EntityPathBase<Missions> {

    private static final long serialVersionUID = -1172044525L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMissions missions = new QMissions("missions");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath mission_spec = createString("mission_spec");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final QStore store;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMissions(String variable) {
        this(Missions.class, forVariable(variable), INITS);
    }

    public QMissions(Path<? extends Missions> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMissions(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMissions(PathMetadata metadata, PathInits inits) {
        this(Missions.class, metadata, inits);
    }

    public QMissions(Class<? extends Missions> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

