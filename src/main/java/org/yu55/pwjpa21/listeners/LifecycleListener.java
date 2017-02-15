package org.yu55.pwjpa21.listeners;

import javax.persistence.*;

public class LifecycleListener {

    @PrePersist
    void prePersist(Object object) {
        System.out.println(object + " prePersist");
    }

    @PostPersist
    void postPersist(Object object) {
        System.out.println(object + " postPersist");
    }

    @PreUpdate
    void preUpdate(Object object) {
        System.out.println(object + " preUpdate");
    }

    @PostUpdate
    void postUpdate(Object object) {
        System.out.println(object + " postUpdate");
    }

    @PreRemove
    void preRemove(Object object) {
        System.out.println(object + " preRemove");
    }

    @PostRemove
    void postRemove(Object object) {
        System.out.println(object + " postRemove");
    }

    @PostLoad
    void postLoad(Object object) {
        System.out.println(object + " postLoad");
    }
}
