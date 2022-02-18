package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.VehicleModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleModel, UUID> {
    VehicleModel save(VehicleModel vehicleModel);
    Page<VehicleModel> findAll(Pageable pageable);
    Optional<VehicleModel> findById(UUID id);
    void delete(VehicleModel vehicleModel);
    boolean existsByLicensePlateVehicle(String licensePlateVehicle);
}
