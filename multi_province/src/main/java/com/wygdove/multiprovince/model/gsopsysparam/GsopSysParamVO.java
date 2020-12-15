package com.wygdove.multiprovince.model.gsopsysparam;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Title: GsopSysParamVO
 * @Description:
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class GsopSysParamVO implements Serializable {

	private String guidkey;
	private String typeCode;
	private String paramCode;
	private String subParamCode;
	private String columnValue;
	private String columnDesc;
	private Long dispord;
	private String descb;
	private String state;


	public String getGuidkey(){return guidkey;}
	public void setGuidkey(String guidkey) {this.guidkey=guidkey;}
	public String getTypeCode(){return typeCode;}
	public void setTypeCode(String typeCode) {this.typeCode=typeCode;}
	public String getParamCode(){return paramCode;}
	public void setParamCode(String paramCode) {this.paramCode=paramCode;}
	public String getSubParamCode(){return subParamCode;}
	public void setSubParamCode(String subParamCode) {this.subParamCode=subParamCode;}
	public String getColumnValue(){return columnValue;}
	public void setColumnValue(String columnValue) {this.columnValue=columnValue;}
	public String getColumnDesc(){return columnDesc;}
	public void setColumnDesc(String columnDesc) {this.columnDesc=columnDesc;}
	public Long getDispord(){return dispord;}
	public void setDispord(Long dispord) {this.dispord=dispord;}
	public String getDescb(){return descb;}
	public void setDescb(String descb) {this.descb=descb;}
	public String getState(){return state;}
	public void setState(String state) {this.state=state;}


}