package com.wygdove.multiprovince.service.atom.impl.beijing;

import com.wygdove.multiprovince.constants.ProvinceConstants;
import com.wygdove.multiprovince.dao.bo.GsopGridSysParam;
import com.wygdove.multiprovince.service.atom.interfaces.IGsopSysParamAtomSV;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

/**
 * @Title: GsopSysParamAtomSVBeijingImpl
 * @Description:
 */
@Repository
@ConditionalOnProperty(name=ProvinceConstants.PROVINCE,havingValue=ProvinceConstants.BEIJING)
public class GsopSysParamAtomSVBeijingImpl implements IGsopSysParamAtomSV {
    private static Logger log=LoggerFactory.getLogger(GsopSysParamAtomSVBeijingImpl.class);

    @Override
    public int add(GsopGridSysParam request) {
        log.debug("GsopSysParamAtomSVBeijingImpl.add");
        return 0;
    }

    @Override
    public int update(GsopGridSysParam request) {
        log.debug("GsopSysParamAtomSVBeijingImpl.update");
        return 0;
    }

    @Override
    public GsopGridSysParam queryById(GsopGridSysParam request) {
        log.debug("GsopSysParamAtomSVBeijingImpl.queryById");
        return null;
    }

    @Override
    public List<GsopGridSysParam> queryList(GsopGridSysParam request) {
        log.debug("GsopSysParamAtomSVBeijingImpl.queryList");
        return null;
    }

    @Override
    public List<GsopGridSysParam> queryList(GsopGridSysParam request,Map<String,Object> reqmap) {
        log.debug("GsopSysParamAtomSVBeijingImpl.queryList");
        return null;
    }

    @Override
    public int count(GsopGridSysParam request) {
        log.debug("GsopSysParamAtomSVBeijingImpl.count");
        return 0;
    }

    @Override
    public int count(GsopGridSysParam request,Map<String,Object> reqmap) {
        log.debug("GsopSysParamAtomSVBeijingImpl.count");
        return 0;
    }
    
}
