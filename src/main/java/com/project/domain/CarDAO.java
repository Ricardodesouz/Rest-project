package com.project.domain;

import com.project.entities.car;

import java.util.List;

public interface CarDAO {
    public List<car> getCarros();
    public car getid(Integer id);
    public void deleteid(Integer id);
    public void update(Integer idEntity, car newCarro);
    public void created(car newCarro);



}
