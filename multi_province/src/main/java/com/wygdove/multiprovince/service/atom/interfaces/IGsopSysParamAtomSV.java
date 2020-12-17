package com.wygdove.multiprovince.service.atom.interfaces;

import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamQueryRequest;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamSaveRequest;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamVO;
import java.util.List;

/**
 * @Title: IGsopSysParamAtomSV
 * @Description:
 */
public interface IGsopSysParamAtomSV {
    int add(GsopSysParamSaveRequest request);
    int update(GsopSysParamSaveRequest request);
    GsopSysParamVO queryById(GsopSysParamQueryRequest request);
    List<GsopSysParamVO> queryList(GsopSysParamQueryRequest request);
    PageInfo<GsopSysParamVO> queryPage(GsopSysParamQueryRequest request);
    int count(GsopSysParamQueryRequest request);
}

