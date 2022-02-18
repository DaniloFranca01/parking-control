package com.api.parkingcontrol.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_VEHICLE")
public class VehicleModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;
    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateVehicle;
    @Column(nullable = false, length = 70)
    private String typeVehicle;
    @Column(nullable = false, length = 70)
    private String brandVehicle;
    @Column(nullable = false, length = 70)
    private String modelVehicle;
    @Column(nullable = false, length = 70)
    private String colorVehicle;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLicensePlateVehicle() {
        return licensePlateVehicle;
    }

    public void setLicensePlateVehicle(String licensePlateVehicle) {
        this.licensePlateVehicle = licensePlateVehicle;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
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
