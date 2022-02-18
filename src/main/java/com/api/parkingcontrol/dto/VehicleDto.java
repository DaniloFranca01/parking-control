package com.api.parkingcontrol.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class VehicleDto {
    @NotBlank
    @Size(max = 7)
    private String licensePlateVehicle;
    @NotBlank
    private String brandVehicle;
    @NotBlank
    private String modelVehicle;
    @NotBlank
    private String colorVehicle;

    public String getLicensePlateVehicle() {
        return licensePlateVehicle;
    }

    public void setLicensePlateVehicle(String licensePlateVehicle) {
        this.licensePlateVehicle = licensePlateVehicle;
    }

    public String getBrandVehicle() {
        return brandVehicle;
    }

    public void setBrandVehicle(String brandVehicle) {
        this.brandVehicle = brandVehicle;
    }

    public String getModelVehicle() {
        return modelVehicle;
    }

    public void setModelVehicle(String modelVehicle) {
        this.modelVehicle = modelVehicle;
    }

    public String getColorVehicle() {
        return colorVehicle;
    }

    public void setColorVehicle(String colorVehicle) {
        this.colorVehicle = colorVehicle;
    }
}
