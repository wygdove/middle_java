package com.wygdove.multiprovince.dao.bo.xinjiang;


import java.math.BigDecimal;

/**
 * @Title: DimAreaGrid
 * @Description:
 */
public class DimAreaGrid {

	private String areaId;
	private String areaName;
	private String areaLevel;
	private String areaType;
	private String areaPid;

	private BigDecimal acreage;


	public String getAreaId(){return areaId;}
	public void setAreaId(String areaId) {this.areaId=areaId;}
	public String getAreaName(){return areaName;}
	public void setAreaName(String areaName) {this.areaName=areaName;}
	public String getAreaLevel(){return areaLevel;}
	public void setAreaLevel(String areaLevel) {this.areaLevel=areaLevel;}
	public String getAreaType(){return areaType;}
	public void setAreaType(String areaType) {this.areaType=areaType;}
	public String getAreaPid(){return areaPid;}
	public void setAreaPid(String areaPid) {this.areaPid=areaPid;}


    public BigDecimal getAcreage() {
        return acreage;
    }

    public void setAcreage(BigDecimal acreage) {
        this.acreage=acreage;
    }
}
