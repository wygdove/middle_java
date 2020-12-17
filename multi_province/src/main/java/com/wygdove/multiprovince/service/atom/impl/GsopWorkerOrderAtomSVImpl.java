package com.wygdove.multiprovince.service.atom.impl;

import com.wygdove.multiprovince.dao.mapper.common.GsopWorkerOrderSMapper;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoQueryRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoVO;
import com.wygdove.multiprovince.service.atom.interfaces.IGsopWorkerOrderAtomSV;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Repository;

/**
 * @Title: GsopWorkerOrderAtomSVImpl
 * @Description:
 */
@Repository
@ConditionalOnMissingBean(value=IGsopWorkerOrderAtomSV.class,ignored=GsopWorkerOrderAtomSVImpl.class)
public class GsopWorkerOrderAtomSVImpl implements IGsopWorkerOrderAtomSV {

    @Resource
    private GsopWorkerOrderSMapper gsopWorkerOrderSMapper;

    @Override
    public List<GsopWoordInfoVO> getWoordListByType(GsopWoordInfoQueryRequest request) {
        return gsopWorkerOrderSMapper.getWoordListByType(request);
    }
}
