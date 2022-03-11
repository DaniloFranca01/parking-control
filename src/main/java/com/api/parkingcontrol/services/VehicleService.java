package com.api.parkingcontrol.services;

import com.api.parkingcontrol.exceptions.AlreadyExistsException;
import com.api.parkingcontrol.exceptions.vehicles.VehicleNotFoundException;
import com.api.parkingcontrol.models.VehicleModel;
import com.api.parkingcontrol.repositories.VehicleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleService {
    final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public VehicleModel save(VehicleModel vehicleModel) {
        if (vehicleRepository.existsByLicensePlateVehicle(vehicleModel.getLicensePlateVehicle())) {
            throw new AlreadyExistsException(String.format("License Plate %s is already in use!",
                    vehicleModel.getLicensePlateVehicle()));
        }
        return vehicleRepository.save(vehicleModel);
    }

    @Transactional
    public void update(VehicleModel vehicleModel) {
        vehicleRepository.save(vehicleModel);
    }

    public boolean existsByLicensePlateVehicle(String licensePlateVehicle) {
        return vehicleRepository.existsByLicensePlateVehicle(licensePlateVehicle);
    }

    public Page<VehicleModel> findAll(Pageable pageable) {
        return vehicleRepository.findAll(pageable);
    }

    public Optional<VehicleModel> findById(UUID id) {
        Optional<VehicleModel> vehicleModelOptional = vehicleRepository.findById(id);
        if (!vehicleModelOptional.isPresent()) {
            throw new VehicleNotFoundException("Vehicle Not Found.");
        }
        return vehicleModelOptional;
    }

    @Transactional
    public void delete(VehicleModel vehicleModel) {
        vehicleRepository.delete(vehicleModel);
    }

}
