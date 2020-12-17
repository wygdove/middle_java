package com.wygdove.multiprovince.service.atom.impl.beijing;

import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.constants.ProvinceConstants;
import com.wygdove.multiprovince.dao.mapper.beijing.GsopSysParamSMapper;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamQueryRequest;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamSaveRequest;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamVO;
import com.wygdove.multiprovince.service.atom.interfaces.IGsopSysParamAtomSV;
import java.util.List;
import javax.annotation.Resource;
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

    @Resource
    private GsopSysParamSMapper sysParamSMapper;

    @Override
    public int add(GsopSysParamSaveRequest request) {
        log.debug("GsopSysParamAtomSVBeijingImpl.add");
        return 0;
    }

    @Override
    public int update(GsopSysParamSaveRequest request) {
        log.debug("GsopSysParamAtomSVBeijingImpl.update");
        return 0;
    }

    @Override
    public GsopSysParamVO queryById(GsopSysParamQueryRequest request) {
        log.debug("GsopSysParamAtomSVBeijingImpl.queryById");
        return null;
    }

    @Override
    public List<GsopSysParamVO> queryList(GsopSysParamQueryRequest request) {
        log.debug("GsopSysParamAtomSVBeijingImpl.queryList");
        return sysParamSMapper.getSysParamList(request);
    }

    @Override
    public PageInfo<GsopSysParamVO> queryPage(GsopSysParamQueryRequest request) {
        log.debug("GsopSysParamAtomSVBeijingImpl.queryPage");
        return null;
    }

    @Override
    public int count(GsopSysParamQueryRequest request) {
        log.debug("GsopSysParamAtomSVBeijingImpl.count");
        return 0;
    }
}
