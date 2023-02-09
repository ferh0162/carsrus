package dat3.cars.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.cars.entity.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarRequest {
  private int id;
  private String brand;
  private String model1;
  private double pricePrDay;
  private int bestDiscount;
  private LocalDateTime creationTime;
  private  LocalDateTime updatedTime;

  public Car getCarEntity(CarRequest c){
    return new Car(c.id, c.brand, c.model1, c.pricePrDay, c.bestDiscount, c.creationTime, c.updatedTime);
  }

  public CarRequest(Car c) {
    this.id = id;
    this.brand = brand;
    this.model1 = model1;
    this.pricePrDay = pricePrDay;

  }
}

