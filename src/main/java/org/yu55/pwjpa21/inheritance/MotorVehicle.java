package org.yu55.pwjpa21.inheritance;

import javax.persistence.Entity;

@Entity
class MotorVehicle extends Vehicle {

    private String engineType;

    String getEngineType() {
        return engineType;
    }

    void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Override
    public String toString() {
        return "MotorVehicle{" +
                "engineType='" + engineType + '\'' +
                "} " + super.toString();
    }
}
