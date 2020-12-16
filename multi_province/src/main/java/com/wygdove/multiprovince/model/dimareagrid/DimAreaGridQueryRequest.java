package com.wygdove.multiprovince.model.dimareagrid;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @Title: DimAreaGridQueryRequest
 * @Description:
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class DimAreaGridQueryRequest implements Serializable {

	private String areaId;
	private String areaName;
	private String areaLevel;
	private String areaType;
	private String areaPid;

    private Integer pageNo;
    private Integer pageSize;


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


    public Integer getPageNo(){return pageNo;}
    public void setPageNo(Integer pageNo){this.pageNo=pageNo;}
    public Integer getPageSize(){return pageSize;}
    public void setPageSize(Integer pageSize){this.pageSize=pageSize;}

}