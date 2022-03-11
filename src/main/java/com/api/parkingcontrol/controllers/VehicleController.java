package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dto.VehicleDto;
import com.api.parkingcontrol.exceptions.AlreadyExistsException;
import com.api.parkingcontrol.exceptions.vehicles.VehicleNotFoundException;
import com.api.parkingcontrol.models.VehicleModel;
import com.api.parkingcontrol.payloads.ApiResponse;
import com.api.parkingcontrol.services.VehicleService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vehicle")
public class VehicleController {
    final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<Object> saveVehicle(@RequestBody @Valid VehicleDto vehicleDto) {
        try {
            var vehicleModel = new VehicleModel();
            BeanUtils.copyProperties(vehicleDto, vehicleModel);
            vehicleService.save(vehicleModel);
        } catch (AlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false, e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "Vehicle created"));
    }

    @GetMapping
    public ResponseEntity<Page<VehicleModel>> getAllVehicles(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneVehicle(@PathVariable(value = "id") UUID id) {
        try {
            Optional<VehicleModel> vehicleModelOptional = vehicleService.findById(id);
            var vehicleModel = vehicleModelOptional.get();
            return ResponseEntity.status(HttpStatus.OK).body(vehicleModel);

        } catch (VehicleNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, e.getMessage()));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVehicle(@PathVariable(value = "id") UUID id) {

        try {
            Optional<VehicleModel> vehicleModelOptional = vehicleService.findById(id);
            var vehicleModel = vehicleModelOptional.get();
            vehicleService.delete(vehicleModel);

        } catch (VehicleNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true, "Vehicle deleted successfully"));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVehicle(@PathVariable(value = "id") UUID id,
            @RequestBody @Valid VehicleDto vehicleDto) {
        try {
            Optional<VehicleModel> vehicleModelOptional = vehicleService.findById(id);
            var vehicleModel = vehicleModelOptional.get();
            vehicleModel.setLicensePlateVehicle(vehicleDto.getLicensePlateVehicle());
            vehicleModel.setModelVehicle(vehicleDto.getModelVehicle());
            vehicleModel.setBrandVehicle(vehicleDto.getBrandVehicle());
            vehicleModel.setColorVehicle(vehicleDto.getColorVehicle());
            vehicleModel.setTypeVehicle(vehicleDto.getTypeVehicle());
            vehicleService.update(vehicleModel);
        } catch (VehicleNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, e.getMessage()));
        }

        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true, "Vehicle updated successfully"));
    }
}
