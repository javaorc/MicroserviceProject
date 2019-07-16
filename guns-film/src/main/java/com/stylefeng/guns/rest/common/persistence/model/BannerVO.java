package com.stylefeng.guns.rest.common.persistence.model;

import java.io.Serializable;


public class BannerVO implements Serializable {
        private  String bannerId;
        private  String bannerAddress;
        private  String bannerUrl;

    @Override
    public String toString() {
        return "BannerVO{" +
                "bannerId='" + bannerId + '\'' +
                ", bannerAddress='" + bannerAddress + '\'' +
                ", bannerUrl='" + bannerUrl + '\'' +
                '}';
    }

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerAddress() {
        return bannerAddress;
    }

    public void setBannerAddress(String bannerAddress) {
        this.bannerAddress = bannerAddress;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }
}
