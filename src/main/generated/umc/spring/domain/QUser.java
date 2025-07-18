package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1348045193L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final DatePath<java.time.LocalDate> birthday = createDate("birthday", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.spring.domain.enums.Gender> gender = createEnum("gender", umc.spring.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.spring.domain.mapping.matchCategory, umc.spring.domain.mapping.QmatchCategory> matchCategoryList = this.<umc.spring.domain.mapping.matchCategory, umc.spring.domain.mapping.QmatchCategory>createList("matchCategoryList", umc.spring.domain.mapping.matchCategory.class, umc.spring.domain.mapping.QmatchCategory.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.matchMissions, umc.spring.domain.mapping.QmatchMissions> matchMissions = this.<umc.spring.domain.mapping.matchMissions, umc.spring.domain.mapping.QmatchMissions>createList("matchMissions", umc.spring.domain.mapping.matchMissions.class, umc.spring.domain.mapping.QmatchMissions.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.enums.MemberStatus> memberStatus = createEnum("memberStatus", umc.spring.domain.enums.MemberStatus.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<ReviewPost, QReviewPost> reviewPosts = this.<ReviewPost, QReviewPost>createList("reviewPosts", ReviewPost.class, QReviewPost.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.enums.Role> role = createEnum("role", umc.spring.domain.enums.Role.class);

    public final EnumPath<umc.spring.domain.enums.SocialType> socialType = createEnum("socialType", umc.spring.domain.enums.SocialType.class);

    public final StringPath specAddress = createString("specAddress");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUserAddress userAddress;

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userAddress = inits.isInitialized("userAddress") ? new QUserAddress(forProperty("userAddress")) : null;
    }

}

