package com.wygdove.dlock.dao.bo;

import java.sql.Timestamp;

/**
 * @Title: AssetsStock
 * @Description:
 */
public class AssetsStock {
    private Long stockId;
    private String categoryCode;
    private String assetsCode;
    private Long num;
    private Timestamp stockinDate;
    private Timestamp useDate;


    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId=stockId;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode=categoryCode;
    }

    public String getAssetsCode() {
        return assetsCode;
    }

    public void setAssetsCode(String assetsCode) {
        this.assetsCode=assetsCode;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num=num;
    }

    public Timestamp getStockinDate() {
        return stockinDate;
    }

    public void setStockinDate(Timestamp stockinDate) {
        this.stockinDate=stockinDate;
    }

    public Timestamp getUseDate() {
        return useDate;
    }

    public void setUseDate(Timestamp useDate) {
        this.useDate=useDate;
    }
}
