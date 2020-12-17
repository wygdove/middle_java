package com.wygdove.multiprovince.service.atom.interfaces;

import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoQueryRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoSaveRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoVO;
import java.util.List;

/**
 * @Title: IGsopWoordInfoAtomSV
 * @Description:
 */
public interface IGsopWoordInfoAtomSV {
    int add(GsopWoordInfoSaveRequest request);
    int update(GsopWoordInfoSaveRequest request);
    GsopWoordInfoVO queryById(GsopWoordInfoQueryRequest request);
    List<GsopWoordInfoVO> queryList(GsopWoordInfoQueryRequest request);
    PageInfo<GsopWoordInfoVO> queryPage(GsopWoordInfoQueryRequest request);
    int count(GsopWoordInfoQueryRequest request);
}

