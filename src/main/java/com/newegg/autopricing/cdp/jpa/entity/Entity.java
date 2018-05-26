package com.newegg.autopricing.cdp.jpa.entity;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

class Entity {

    protected final static String[] EMPTY_STRING_ARRAY = {};

    @PrePersist
    protected void prePersist() {
    }

    @PreUpdate
    protected void preUpdate() {
    }

    @PreRemove
    protected void preRemove() {
    }

    static final String trim(String str) {
        if (str == null)
            return null;
        return str.trim();
    }

    static final boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
