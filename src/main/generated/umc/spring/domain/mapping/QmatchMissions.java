package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QmatchMissions is a Querydsl query type for matchMissions
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QmatchMissions extends EntityPathBase<matchMissions> {

    private static final long serialVersionUID = -1063354592L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QmatchMissions matchMissions = new QmatchMissions("matchMissions");

    public final umc.spring.domain.QBaseEntity _super = new umc.spring.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DatePath<java.time.LocalDate> deadline = createDate("deadline", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QMissions missions;

    public final EnumPath<umc.spring.domain.enums.MissionStatus> missionStatus = createEnum("missionStatus", umc.spring.domain.enums.MissionStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.spring.domain.QUser user;

    public QmatchMissions(String variable) {
        this(matchMissions.class, forVariable(variable), INITS);
    }

    public QmatchMissions(Path<? extends matchMissions> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QmatchMissions(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QmatchMissions(PathMetadata metadata, PathInits inits) {
        this(matchMissions.class, metadata, inits);
    }

    public QmatchMissions(Class<? extends matchMissions> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.missions = inits.isInitialized("missions") ? new umc.spring.domain.QMissions(forProperty("missions"), inits.get("missions")) : null;
        this.user = inits.isInitialized("user") ? new umc.spring.domain.QUser(forProperty("user")) : null;
    }

}

