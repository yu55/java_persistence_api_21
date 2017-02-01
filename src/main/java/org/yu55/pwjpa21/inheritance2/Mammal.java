package org.yu55.pwjpa21.inheritance2;

import javax.persistence.Entity;

@Entity
class Mammal extends Animal {

    private int hairLegth;

    public int getHairLegth() {
        return hairLegth;
    }

    public void setHairLegth(int hairLegth) {
        this.hairLegth = hairLegth;
    }

    @Override
    public String toString() {
        return "Mammal{" +
                "hairLegth=" + hairLegth +
                "} " + super.toString();
    }
}
