package com.project.servlets;

import com.project.domain.CarDaoJDBC;
import com.project.entities.Car;
import com.project.services.CarServices;
import com.project.servlets.services.JAXBUtil;
import com.project.servlets.services.ListCars;
import com.project.servlets.services.ServletUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/cars/*")
public class CarsServlet extends HttpServlet {
    private static Long SerialVersionUNID = 1L;
    private CarServices services = new CarServices();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Car> cars = services.getCarros();
        ListCars  listCars= new ListCars();
        listCars.SetCars(cars);
        String json = JAXBUtil.toJson(listCars);

        ServletUtil.writeJson(response, json);

    }

}
