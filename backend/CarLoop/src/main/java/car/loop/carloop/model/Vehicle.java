package car.loop.carloop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String manufacturer;
    private String model;
    private int engineCapacity;
    private int enginePower;
    private int productionYear;
    private String mileage;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User user;

    @OneToMany(mappedBy = "vehicle")
    private List<Reservation> reservations;

    @ManyToMany
    @JoinTable(
            name = "vehicle_features",
            joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id"))
    private List<Feature> features = new ArrayList<>();
}
