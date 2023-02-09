package dat3.cars.services;

import dat3.cars.dto.CarResponse;
import dat3.cars.dto.MemberResponse;
import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.repositories.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CarService {

  CarRepository carRepository;

  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public List<CarResponse> getCars(boolean includeAll){
    List<Car> cars = carRepository.findAll();

    List<CarResponse> carResponses = cars.stream().map(c->new CarResponse(c,includeAll)).toList();
    return carResponses;
  }

  public CarResponse findCarById(String id){
    Car car = carRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Member with this username does not exist"));
    CarResponse carResponse = new CarResponse(car, true);
    return carResponse;
  }
}
