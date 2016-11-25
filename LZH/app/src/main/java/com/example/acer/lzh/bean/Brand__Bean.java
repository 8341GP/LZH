package com.example.acer.lzh.bean;

import java.util.List;

/**
 * Created by acer on 2016-11-23.
 */
public class Brand__Bean {

    /**
     * brandId : 1376
     * since : 0
     * enable : 2
     * brandTitle : 佬泰丰斋
     * cityId : 10101
     * brandLogoImg : /app/20160602/bd/4939e5a7-199e-48d2-a0b3-30baf41d7342.png?1464853554651
     * bigLogoImg : /app/20160602/bd/e8f252f8-d839-4bc4-ac9d-498ce5a11359.png?1464853563931
     * provinceId : 101
     * brandName : 佬泰丰斋
     * operationType : 3
     * brandDesc : 佬泰丰斋
     * updateTime : 1464853594
     * isUnion : 2
     */

    private List<BrandsBean> brands;

    public List<BrandsBean> getBrands() {
        return brands;
    }

    public void setBrands(List<BrandsBean> brands) {
        this.brands = brands;
    }

    public static class BrandsBean {
        private int brandId;
        private int since;
        private int enable;
        private String brandTitle;
        private int cityId;
        private String brandLogoImg;
        private String bigLogoImg;
        private int provinceId;
        private String brandName;
        private int operationType;
        private String brandDesc;
        private int updateTime;
        private int isUnion;

        public int getBrandId() {
            return brandId;
        }

        public void setBrandId(int brandId) {
            this.brandId = brandId;
        }

        public int getSince() {
            return since;
        }

        public void setSince(int since) {
            this.since = since;
        }

        public int getEnable() {
            return enable;
        }

        public void setEnable(int enable) {
            this.enable = enable;
        }

        public String getBrandTitle() {
            return brandTitle;
        }

        public void setBrandTitle(String brandTitle) {
            this.brandTitle = brandTitle;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public String getBrandLogoImg() {
            return brandLogoImg;
        }

        public void setBrandLogoImg(String brandLogoImg) {
            this.brandLogoImg = brandLogoImg;
        }

        public String getBigLogoImg() {
            return bigLogoImg;
        }

        public void setBigLogoImg(String bigLogoImg) {
            this.bigLogoImg = bigLogoImg;
        }

        public int getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(int provinceId) {
            this.provinceId = provinceId;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public int getOperationType() {
            return operationType;
        }

        public void setOperationType(int operationType) {
            this.operationType = operationType;
        }

        public String getBrandDesc() {
            return brandDesc;
        }

        public void setBrandDesc(String brandDesc) {
            this.brandDesc = brandDesc;
        }

        public int getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(int updateTime) {
            this.updateTime = updateTime;
        }

        public int getIsUnion() {
            return isUnion;
        }

        public void setIsUnion(int isUnion) {
            this.isUnion = isUnion;
        }
    }
}
