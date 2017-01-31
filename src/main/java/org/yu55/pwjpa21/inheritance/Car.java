package org.yu55.pwjpa21.inheritance;

import javax.persistence.Entity;

@Entity
class Car extends MotorVehicle {

    private int numberOfWheels;

    int getNumberOfWheels() {
        return numberOfWheels;
    }

    void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfWheels=" + numberOfWheels +
                "} " + super.toString();
    }
}
