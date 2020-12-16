package com.wygdove.multiprovince.service.busi.impl.xinjiang;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.constants.ProvinceConstants;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoQueryRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoSaveRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoVO;
import com.wygdove.multiprovince.service.atom.interfaces.IGsopWoordInfoAtomSV;
import com.wygdove.multiprovince.service.busi.interfaces.IGsopWoordInfoBusiSV;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Title: GsopWoordInfoBusiSVXinjiangImpl
 * @Description:
 */
@Service
@ConditionalOnProperty(name=ProvinceConstants.PROVINCE,havingValue=ProvinceConstants.XINJIANG)
public class GsopWoordInfoBusiSVXinjiangImpl implements IGsopWoordInfoBusiSV {
    private static Logger log=LoggerFactory.getLogger(GsopWoordInfoBusiSVXinjiangImpl.class);

    @Resource
    private IGsopWoordInfoAtomSV gsopWoordInfoAtomSV;


    @Transactional
    @Override
    public String addGsopWoordInfo(GsopWoordInfoSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVXinjiangImpl.addGsopWoordInfo request: {}",JSON.toJSONString(request));
        return null;
    }

    @Transactional
    @Override
    public String updateGsopWoordInfo(GsopWoordInfoSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVXinjiangImpl.updateGsopWoordInfo request: {}",JSON.toJSONString(request));
        return null;
    }

    @Override
    public String deleteGsopWoordInfo(GsopWoordInfoSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVXinjiangImpl.deleteGsopWoordInfo request: {}",JSON.toJSONString(request));
        return null;
    }

    @Override
    public GsopWoordInfoVO queryDetailGsopWoordInfo(GsopWoordInfoQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVXinjiangImpl.queryDetailGsopWoordInfo request: {}",JSON.toJSONString(request));
        return null;
    }

    @Override
    public List<GsopWoordInfoVO> queryListGsopWoordInfo(GsopWoordInfoQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVXinjiangImpl.queryListGsopWoordInfo request: {}",JSON.toJSONString(request));
        return null;
    }

    @Override
    public PageInfo<GsopWoordInfoVO> queryPageGsopWoordInfo(GsopWoordInfoQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVXinjiangImpl.queryPageGsopWoordInfo request: {}",JSON.toJSONString(request));
        return null;
    }

    @Override
    public Integer countGsopWoordInfo(GsopWoordInfoQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVXinjiangImpl.countGsopWoordInfo request: {}",JSON.toJSONString(request));
        return null;
    }


}
