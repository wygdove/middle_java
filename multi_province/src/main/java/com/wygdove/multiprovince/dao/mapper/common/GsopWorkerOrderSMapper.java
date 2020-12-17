package com.wygdove.multiprovince.dao.mapper.common;


import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoQueryRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Title: GsopWorkerOrderSMapper
 * @Description:
 */
public interface GsopWorkerOrderSMapper {

    List<GsopWoordInfoVO> getWoordListByType(GsopWoordInfoQueryRequest request);

}
