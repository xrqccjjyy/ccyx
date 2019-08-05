package com.aaa.framework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "upload")
public class FileUploadConfig {
    //车辆照片上传路径
    private String uploadCarImage;
    //车辆照片请求路径
    private String carImageDir;
    //洗车照片上传路径
    private String uploadWashCarImage;
    //洗车照片请求路径
    private String washCarImageDir;
    //门店营业执照上传路径
    private String uploadShopLicenseImg;
    //门店营业执照请求路径
    private String uploadShopLicenseImgDir;
    //用户驾驶证照片上传路径
    private String drivingLicenceImg;
    //用户驾驶证照片请求路径
    private String drivingLicenceImgDir;

    public String getUploadShopLicenseImg() {
        return uploadShopLicenseImg;
    }

    public void setUploadShopLicenseImg(String uploadShopLicenseImg) {
        this.uploadShopLicenseImg = uploadShopLicenseImg;
    }

    public String getUploadShopLicenseImgDir() {
        return uploadShopLicenseImgDir;
    }

    public void setUploadShopLicenseImgDir(String uploadShopLicenseImgDir) {
        this.uploadShopLicenseImgDir = uploadShopLicenseImgDir;
    }

    public String getUploadCarImage() {
        return uploadCarImage;
    }

    public void setUploadCarImage(String uploadCarImage) {
        this.uploadCarImage = uploadCarImage;
    }

    public String getCarImageDir() {
        return carImageDir;
    }

    public void setCarImageDir(String carImageDir) {
        this.carImageDir = carImageDir;
    }

    public String getUploadWashCarImage() {
        return uploadWashCarImage;
    }

    public void setUploadWashCarImage(String uploadWashCarImage) {
        this.uploadWashCarImage = uploadWashCarImage;
    }

    public String getWashCarImageDir() {
        return washCarImageDir;
    }

    public void setWashCarImageDir(String washCarImageDir) {
        this.washCarImageDir = washCarImageDir;
    }


    public String getDrivingLicenceImg() {
        return drivingLicenceImg;
    }

    public void setDrivingLicenceImg(String drivingLicenceImg) {
        this.drivingLicenceImg = drivingLicenceImg;
    }

    public String getDrivingLicenceImgDir() {
        return drivingLicenceImgDir;
    }

    public void setDrivingLicenceImgDir(String drivingLicenceImgDir) {
        this.drivingLicenceImgDir = drivingLicenceImgDir;
    }
}
