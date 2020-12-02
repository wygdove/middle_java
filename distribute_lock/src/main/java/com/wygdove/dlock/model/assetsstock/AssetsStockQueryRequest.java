package com.wygdove.dlock.model.assetsstock;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Title: AssetsStockQueryRequest
 * @Description:
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class AssetsStockQueryRequest implements Serializable {
    private static final long serialVersionUID=2846120907146095569L;

    private Long stockId;
    private String categoryCode;
    private String assetsCode;
    private Long num;
    private Timestamp stockinDate;
    private Timestamp useDate;

    private String assetsCodeLike;
    private List<String> assetsCodeIn;

    private Integer pageNo;
    private Integer pageSize;


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

    public String getAssetsCodeLike() {
        return assetsCodeLike;
    }

    public void setAssetsCodeLike(String assetsCodeLike) {
        this.assetsCodeLike=assetsCodeLike;
    }

    public List<String> getAssetsCodeIn() {
        return assetsCodeIn;
    }

    public void setAssetsCodeIn(List<String> assetsCodeIn) {
        this.assetsCodeIn=assetsCodeIn;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo=pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
    }
}
