package com.wygdove.multiprovince.service.atom.interfaces;

import com.wygdove.multiprovince.dao.bo.GsopWoOrdInfo;
import java.util.List;
import java.util.Map;

/**
 * @Title: IGsopWoordInfoAtomSV
 * @Description:
 */
public interface IGsopWoordInfoAtomSV {
    int add(GsopWoOrdInfo request);
    int update(GsopWoOrdInfo request);
    GsopWoOrdInfo queryById(GsopWoOrdInfo request);
    List<GsopWoOrdInfo> queryList(GsopWoOrdInfo request);
    List<GsopWoOrdInfo> queryList(GsopWoOrdInfo request,Map<String,Object> reqmap);
    int count(GsopWoOrdInfo request);
    int count(GsopWoOrdInfo request,Map<String,Object> reqmap);
}
