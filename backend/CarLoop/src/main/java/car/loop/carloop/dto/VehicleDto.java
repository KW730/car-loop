package car.loop.carloop.dto;

import lombok.Data;

@Data
public class VehicleDto {

    private Long id;
    private String manufacturer;
    private String type;
    private String model;
    private int engineCapacity;
    private int enginePower;
    private int productionYear;
    private String mileage;
    private int price;
}
