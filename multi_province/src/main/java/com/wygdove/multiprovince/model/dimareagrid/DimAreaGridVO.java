package com.wygdove.multiprovince.model.dimareagrid;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Title: DimAreaGridVO
 * @Description:
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class DimAreaGridVO implements Serializable {

	private String areaId;
	private String areaName;
	private String areaLevel;
	private String areaType;
	private String areaPid;


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


}