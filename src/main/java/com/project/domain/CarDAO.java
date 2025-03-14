package com.project.domain;

import com.project.entities.Car;

import java.util.List;

public interface CarDAO {
    public List<Car> getCarros();
    public Car getid(Integer id);
    public void deleteid(Integer id);
    public void update(Integer idEntity, Car newCarro);
    public void created(Car newCarro);



}
