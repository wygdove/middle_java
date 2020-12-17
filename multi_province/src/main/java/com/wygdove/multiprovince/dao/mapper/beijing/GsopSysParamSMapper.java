package com.wygdove.multiprovince.dao.mapper.beijing;

import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamQueryRequest;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Title: GsopSysParamSMapper
 * @Description:
 */
public interface GsopSysParamSMapper {

    List<GsopSysParamVO> getSysParamList(GsopSysParamQueryRequest request);
}
