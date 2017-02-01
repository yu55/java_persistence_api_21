package org.yu55.pwjpa21.inheritance2;

import javax.persistence.Entity;

@Entity
class Reptile extends Animal {

    private int numberOfEggs;

    public int getNumberOfEggs() {
        return numberOfEggs;
    }

    public void setNumberOfEggs(int numberOfEggs) {
        this.numberOfEggs = numberOfEggs;
    }

    @Override
    public String toString() {
        return "Reptile{" +
                "numberOfEggs=" + numberOfEggs +
                "} " + super.toString();
    }
}
