package com.pl.pik.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="cars")
public class Car {

    @Id
    @Column(name="registration_number")
    String registrationNumber;

    String mark;

    String model;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="production_date")
    Date productionDate;

    protected Car() {}

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String Date) {
        this.productionDate = productionDate;
    }

    @Override
    public String toString() {
        return
                "{\"registrationNumber\":\"" + registrationNumber + "\"" +
                ", \"mark\":\"" + mark + "\"" +
                ", \"model\":\"" + model + "\"" +
                ", \"productionDate\":\"" + productionDate + "\"" +
                "}";
    }
}