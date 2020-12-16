package com.wygdove.multiprovince.service.busi.impl.beijing;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.constants.ProvinceConstants;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoQueryRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoSaveRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoVO;
import com.wygdove.multiprovince.service.busi.interfaces.IGsopWoordInfoBusiSV;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Title: GsopWoordInfoBusiSVBeijingImpl
 * @Description:
 */
@Service
@ConditionalOnProperty(name=ProvinceConstants.PROVINCE,havingValue=ProvinceConstants.BEIJING)
public class GsopWoordInfoBusiSVBeijingImpl implements IGsopWoordInfoBusiSV {
    private static Logger log=LoggerFactory.getLogger(GsopWoordInfoBusiSVBeijingImpl.class);

    @Transactional
    @Override
    public String addGsopWoordInfo(GsopWoordInfoSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVBeijingImpl.addGsopWoordInfo request: {}",JSON.toJSONString(request));
        return null;
    }

    @Transactional
    @Override
    public String updateGsopWoordInfo(GsopWoordInfoSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVBeijingImpl.updateGsopWoordInfo request: {}",JSON.toJSONString(request));
        return null;
    }

    @Override
    public String deleteGsopWoordInfo(GsopWoordInfoSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVBeijingImpl.deleteGsopWoordInfo request: {}",JSON.toJSONString(request));
        return null;
    }

    @Override
    public GsopWoordInfoVO queryDetailGsopWoordInfo(GsopWoordInfoQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVBeijingImpl.queryDetailGsopWoordInfo request: {}",JSON.toJSONString(request));
        return null;
    }

    @Override
    public List<GsopWoordInfoVO> queryListGsopWoordInfo(GsopWoordInfoQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVBeijingImpl.queryListGsopWoordInfo request: {}",JSON.toJSONString(request));
        return null;
    }

    @Override
    public PageInfo<GsopWoordInfoVO> queryPageGsopWoordInfo(GsopWoordInfoQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVBeijingImpl.queryPageGsopWoordInfo request: {}",JSON.toJSONString(request));
        return null;
    }

    @Override
    public Integer countGsopWoordInfo(GsopWoordInfoQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVBeijingImpl.countGsopWoordInfo request: {}",JSON.toJSONString(request));
        return null;
    }


}
