package com.example.goodscatalog.domain.models;

import com.example.sharedkernel.domain.base.DomainObjectID;
import org.springframework.lang.NonNull;
public class GoodsId extends DomainObjectID {
    private GoodsId() {
        super(GoodsId.randomId(GoodsId.class).getId());
    }

    public GoodsId(@NonNull String uuid) {
        super(uuid);
    }

    public static GoodsId of(String uuid) {
        GoodsId p = new GoodsId(uuid);
        return p;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
