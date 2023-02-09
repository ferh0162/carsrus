package dat3.cars.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.cars.entity.Car;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse {
  private int id;
  private String brand;
  private String model1;
  private double pricePrDay;
  private int bestDiscount;
  private LocalDateTime creationTime;
  private  LocalDateTime updatedTime;

  public CarResponse(Car c, boolean includeAll) {
    this.id = id;
    this.brand = brand;
    this.model1 = model1;
    this.pricePrDay = pricePrDay;
    if (includeAll) {
      this.bestDiscount = bestDiscount;
      this.creationTime = creationTime;
      this.updatedTime = updatedTime;
    }
  }
}
