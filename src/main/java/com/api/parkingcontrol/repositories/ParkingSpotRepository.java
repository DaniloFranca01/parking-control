package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.dto.VehicleDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID>, JpaSpecificationExecutor<ParkingSpotModel> {
    ParkingSpotModel save(ParkingSpotModel parkingSpotModel);
    Page<ParkingSpotModel> findAll(Pageable pageable);
    Optional<ParkingSpotModel> findById(UUID id);
    void delete(ParkingSpotModel parkingSpotModel);
    boolean existsByVehicle(UUID vehicle_id);
    boolean existsByParkingSpotNumber(String parkingSpotNumber);
    boolean existsByApartmentAndBlock(String apartment, String block);
}
