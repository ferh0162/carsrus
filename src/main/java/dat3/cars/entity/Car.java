package dat3.cars.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder

@Entity
public class Car {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int id;

  @Column (name = "car_brand")
  private String brand;

  @Column (name = "car_model")
  private String model1;

  @Column (name = "rental_price_day")
  private double pricePrDay;

  @Column (name = "max_discount")
  private int bestDiscount;

  @CreationTimestamp
  private LocalDateTime creationTime;

  @UpdateTimestamp
  private  LocalDateTime updatedTime;

  public Car() {

  }

}
