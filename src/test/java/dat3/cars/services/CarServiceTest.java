package dat3.cars.services;

import dat3.cars.dto.CarResponse;
import dat3.cars.dto.MemberResponse;
import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.repositories.CarRepository;
import dat3.cars.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarServiceTest {

  @Autowired
  public CarRepository carRepository;

  CarService carService;

  boolean dataIsReady = false;

  @BeforeEach
  void setUp() {
    if(!dataIsReady){  //Explain this
      carRepository.save(new Car(1, "bmw", "x5", 1000, 20, LocalDateTime.now(), LocalDateTime.now()));
      dataIsReady = true;
      carService = new CarService(carRepository); //Real DB is mocked away with H2
    }
  }

  @Test
  void getCars() {
    List<CarResponse> cars = carService.getCars(true);
    assertEquals(1,cars.size());
  }

  @Test
  void findCarById() {
  }
}