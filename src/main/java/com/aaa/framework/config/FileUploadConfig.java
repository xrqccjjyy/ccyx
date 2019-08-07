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
    //新增门店图标上传路径
    private String uploadStoreIcon;
    //store图标请求路径
    private String storeIconImageDir;
    //用户驾驶证照片上传路径
    private String drivingLicenceImg;
    //用户驾驶证照片请求路径
    private String drivingLicenceImgDir;

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

    public String getUploadStoreIcon() {
        return uploadStoreIcon;
    }

    public void setUploadStoreIcon(String uploadStoreIcon) {
        this.uploadStoreIcon = uploadStoreIcon;
    }

    public String getStoreIconImageDir() {
        return storeIconImageDir;
    }

    public void setStoreIconImageDir(String storeIconImageDir) {
        this.storeIconImageDir = storeIconImageDir;
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
