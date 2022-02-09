package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.ParkingSpotModel;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class ParkingSpotSpecs {

    public static Specification<ParkingSpotModel> between(LocalDateTime initialDate, LocalDateTime finalDate) {
        return (root, query, builder) -> builder.between(root.get("registrationDate"), initialDate, finalDate);
    }

    public static Specification<ParkingSpotModel> after(LocalDateTime initialDate) {
        return (root, query, builder) -> builder.greaterThan(root.get("registrationDate"), initialDate);
    }

    public static Specification<ParkingSpotModel> before(LocalDateTime finalDate) {
        return (root, query, builder) -> builder.lessThan(root.get("registrationDate"), finalDate);
    }
}
