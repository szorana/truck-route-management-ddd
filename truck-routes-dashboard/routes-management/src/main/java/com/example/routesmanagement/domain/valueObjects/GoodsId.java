package com.example.routesmanagement.domain.valueObjects;

import com.example.sharedkernel.domain.base.DomainObjectID;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;

@Embeddable
public class GoodsId extends DomainObjectID {
    public GoodsId() {
        super(GoodsId.randomId(GoodsId.class).getId());
    }

    public GoodsId(@NonNull String uuid) {
        super(uuid);
    }

    public static GoodsId of(String uuid) {
        GoodsId p = new GoodsId(uuid);
        return p;
    }

}
