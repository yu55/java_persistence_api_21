package org.yu55.pwjpa21.inheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InheritanceMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo01-pu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Generic vehicle");
        em.persist(vehicle);

        MotorVehicle motorVehicle = new MotorVehicle();
        motorVehicle.setEngineType("electric");
        em.persist(motorVehicle);

        Car car = new Car();
        car.setNumberOfWheels(4);
        em.persist(car);
        tx.commit();

        System.out.println("vehicle=" + em.find(Vehicle.class, vehicle.getId()));
        System.out.println("motorVehicle=" + em.find(MotorVehicle.class, motorVehicle.getId()));
        System.out.println("car=" + em.find(Car.class, car.getId()));
    }
}
