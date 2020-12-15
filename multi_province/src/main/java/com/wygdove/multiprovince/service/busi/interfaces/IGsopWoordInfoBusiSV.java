package com.wygdove.multiprovince.service.busi.interfaces;

import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoQueryRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoSaveRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoVO;
import java.util.List;

/**
 * @Title: IGsopWoordInfoBusiSV
 * @Description:
 */
public interface IGsopWoordInfoBusiSV {

    public String addGsopWoordInfo(GsopWoordInfoSaveRequest request);

    public String updateGsopWoordInfo(GsopWoordInfoSaveRequest request);

    public String deleteGsopWoordInfo(GsopWoordInfoSaveRequest request);

    public GsopWoordInfoVO queryDetailGsopWoordInfo(GsopWoordInfoQueryRequest request);

    public List<GsopWoordInfoVO> queryListGsopWoordInfo(GsopWoordInfoQueryRequest request);

    public PageInfo<GsopWoordInfoVO> queryPageGsopWoordInfo(GsopWoordInfoQueryRequest request);

    public Integer countGsopWoordInfo(GsopWoordInfoQueryRequest request);

}
