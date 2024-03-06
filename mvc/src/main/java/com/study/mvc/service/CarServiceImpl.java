package com.study.mvc.service;

import com.study.mvc.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService{

    @Value("${component.carRepository.name}")
    private final String componentName = "a";

    @Autowired
    @Qualifier(componentName)
    private CarRepository carRepository;

    @Override
    public String getCarNames() {
        return String.join(", ", carRepository.getCarNames());
        // 문자열: k3, k5
    }

    @Override
    public int addCar(String carName) {
        return 0;
    }
}
