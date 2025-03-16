package com.project.services;

import com.project.domain.CarDaoJDBC;
import com.project.entities.Car;

import java.util.List;

public class CarServices {
    private CarDaoJDBC  repository = new CarDaoJDBC();
    public List<Car> getCarros(){
        return  repository.getCarros();

    }
    public Car getId(Integer id){
        return repository.getid(id);

    }
    public void created(Car newCarro){
        repository.created(newCarro);

    }
    public void update(Integer id, Car newCar){
        repository.update(id, newCar);

    }
    public void  delete(Integer id){
        repository.deleteid(id);

    }


}

