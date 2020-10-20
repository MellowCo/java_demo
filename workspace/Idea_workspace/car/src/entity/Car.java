package entity;

public class Car {
    private int id; //车辆编号
    private String imgPath; //车辆图片
    private String carInfo; //车辆信息
    private String name; //车辆名称
    private double rent; //车辆租金

    public Car(int id, String imgPath, String carInfo, String name, double rent) {
        this.id = id;
        this.imgPath = imgPath;
        this.carInfo = carInfo;
        this.name = name;
        this.rent = rent;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }
}
