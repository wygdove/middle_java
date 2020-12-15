package com.wygdove.multiprovince.service.busi.interfaces;

import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamQueryRequest;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamSaveRequest;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamVO;
import java.util.List;

/**
 * @Title: IGsopSysParamBusiSV
 * @Description:
 */
public interface IGsopSysParamBusiSV {

    public String addGsopSysParam(GsopSysParamSaveRequest request);

    public String updateGsopSysParam(GsopSysParamSaveRequest request);

    public String deleteGsopSysParam(GsopSysParamSaveRequest request);

    public GsopSysParamVO queryDetailGsopSysParam(GsopSysParamQueryRequest request);

    public List<GsopSysParamVO> queryListGsopSysParam(GsopSysParamQueryRequest request);

    public PageInfo<GsopSysParamVO> queryPageGsopSysParam(GsopSysParamQueryRequest request);

    public Integer countGsopSysParam(GsopSysParamQueryRequest request);

}
