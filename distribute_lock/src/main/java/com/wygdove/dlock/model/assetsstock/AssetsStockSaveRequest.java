package com.wygdove.dlock.model.assetsstock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Title: AssetsStockSaveRequest
 * @Description:
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class AssetsStockSaveRequest implements Serializable {
    private static final long serialVersionUID=-1276608896407357827L;

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
