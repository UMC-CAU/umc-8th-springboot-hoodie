package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStoreLocation is a Querydsl query type for StoreLocation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreLocation extends EntityPathBase<StoreLocation> {

    private static final long serialVersionUID = -484031862L;

    public static final QStoreLocation storeLocation = new QStoreLocation("storeLocation");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QStoreLocation(String variable) {
        super(StoreLocation.class, forVariable(variable));
    }

    public QStoreLocation(Path<? extends StoreLocation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStoreLocation(PathMetadata metadata) {
        super(StoreLocation.class, metadata);
    }

}

