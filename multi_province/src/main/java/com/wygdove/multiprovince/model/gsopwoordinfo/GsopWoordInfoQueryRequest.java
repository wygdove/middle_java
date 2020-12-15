package com.wygdove.multiprovince.model.gsopwoordinfo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @Title: GsopWoordInfoQueryRequest
 * @Description:
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class GsopWoordInfoQueryRequest implements Serializable {

	private Long woId;
	private String procInstId;
	private Long associationId;
	private String woCode;
	private String woTitle;
	private String woBigType;
	private String woType;
	private String woFirstType;
	private String woSecondType;

    private Integer pageNo;
    private Integer pageSize;


	public Long getWoId(){return woId;}
	public void setWoId(Long woId) {this.woId=woId;}
	public String getProcInstId(){return procInstId;}
	public void setProcInstId(String procInstId) {this.procInstId=procInstId;}
	public Long getAssociationId(){return associationId;}
	public void setAssociationId(Long associationId) {this.associationId=associationId;}
	public String getWoCode(){return woCode;}
	public void setWoCode(String woCode) {this.woCode=woCode;}
	public String getWoTitle(){return woTitle;}
	public void setWoTitle(String woTitle) {this.woTitle=woTitle;}
	public String getWoBigType(){return woBigType;}
	public void setWoBigType(String woBigType) {this.woBigType=woBigType;}
	public String getWoType(){return woType;}
	public void setWoType(String woType) {this.woType=woType;}
	public String getWoFirstType(){return woFirstType;}
	public void setWoFirstType(String woFirstType) {this.woFirstType=woFirstType;}
	public String getWoSecondType(){return woSecondType;}
	public void setWoSecondType(String woSecondType) {this.woSecondType=woSecondType;}


    public Integer getPageNo(){return pageNo;}
    public void setPageNo(Integer pageNo){this.pageNo=pageNo;}
    public Integer getPageSize(){return pageSize;}
    public void setPageSize(Integer pageSize){this.pageSize=pageSize;}

}