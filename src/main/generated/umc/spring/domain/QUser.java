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

    public static final QUser user = new QUser("user");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath birthday = createString("birthday");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<umc.spring.domain.enums.Gender> gender = createEnum("gender", umc.spring.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.spring.domain.mapping.matchMissions, umc.spring.domain.mapping.QmatchMissions> matchMissions = this.<umc.spring.domain.mapping.matchMissions, umc.spring.domain.mapping.QmatchMissions>createList("matchMissions", umc.spring.domain.mapping.matchMissions.class, umc.spring.domain.mapping.QmatchMissions.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.enums.MemberStatus> memberStatus = createEnum("memberStatus", umc.spring.domain.enums.MemberStatus.class);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final NumberPath<Integer> points = createNumber("points", Integer.class);

    public final ListPath<ReviewPost, QReviewPost> reviewPosts = this.<ReviewPost, QReviewPost>createList("reviewPosts", ReviewPost.class, QReviewPost.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.enums.SocialType> socialType = createEnum("socialType", umc.spring.domain.enums.SocialType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

