package com.wygdove.multiprovince.dao.mapper.beijing;

import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamQueryRequest;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamVO;
import java.util.List;

/**
 * @Title: GsopSysParamSMapper
 * @Description:
 */
public interface GsopSysParamSMapper {

    List<GsopSysParamVO> getSysParamList(GsopSysParamQueryRequest request);
}
