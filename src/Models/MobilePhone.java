package Models;

import javafx.scene.image.Image;

import java.sql.SQLException;
import java.util.ArrayList;

public class MobilePhone {
    private String make, model, os;
    private double screenSize, memory, frontCameraRes, rearCameraRes, price;
    private Image phoneImage;

    public MobilePhone(String make, String model, String os) {
        try {
            setMake(make);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setModel(model);
        setOs(os);
    }

    public MobilePhone(String make, String model, String os, double screenSize, double memory, double frontCameraRes, double rearCameraRes, double price) {
        this(make, model, os);
        setScreenSize(screenSize);
        setMemory(memory);
        setFrontCameraRes(frontCameraRes);
        setRearCameraRes(rearCameraRes);
        setPrice(price);
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) throws SQLException {
        ArrayList<String> validMakes = DBConnect.getPhoneManufacturers();

        if (validMakes.contains(make))
            this.make = make;
        else
            throw new IllegalArgumentException("Valid makes are: "+validMakes);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (!model.isEmpty())
            this.model = model;
        else
            throw new IllegalArgumentException("Model cannot be empty");
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        if (os.equals("iOS") || os.equals("android") || os.equals("Blackberry"))
            this.os = os;
        else
            throw new IllegalArgumentException("OS must be iOS, android or Blackberry");
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        if (screenSize>0)
            this.screenSize = screenSize;
        else
            throw new IllegalArgumentException("screen size cannot be negative");
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        if (memory > 0 && memory <=512)
            this.memory = memory;
        else
            throw new IllegalArgumentException("memory must be 0-512");
    }

    public double getFrontCameraRes() {
        return frontCameraRes;
    }

    public void setFrontCameraRes(double frontCameraRes) {
        if (frontCameraRes>=0 && frontCameraRes<=100)
            this.frontCameraRes = frontCameraRes;
        else
            throw new IllegalArgumentException("front camera res must be 0-100");
    }

    public double getRearCameraRes() {
        return rearCameraRes;
    }

    public void setRearCameraRes(double rearCameraRes) {
        if (rearCameraRes>=0 && rearCameraRes<=100)
            this.rearCameraRes = rearCameraRes;
        else
            throw new IllegalArgumentException("rear camera res must be 0-100");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {

        if (price >0 && price <= 5000)
            this.price = price;
        else
            throw new IllegalArgumentException("Price must be 0-5000");
    }

    public Image getPhoneImage() {
        return phoneImage;
    }

    public void setPhoneImage(Image phoneImage) {
        this.phoneImage = phoneImage;
    }
}
