package com.project.servlets.services;

import com.project.entities.Car;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;
@XmlRootElement(name="cars")
public class ListCars implements Serializable {
    private static final long  SerialVersionUID = 1L;
    private List<Car> cars;

    @XmlElement(name="car")
    public List<Car> getCar(){
        return cars;
    }

    public void SetCars(List<Car> cars){
        this.cars = cars;
    }
    @Override
    public String toString(){
        return "Carlist [car =" + cars +"]";
    }

}
