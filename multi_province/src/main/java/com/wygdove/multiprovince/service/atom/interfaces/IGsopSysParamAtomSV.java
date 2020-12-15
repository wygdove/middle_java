package com.wygdove.multiprovince.service.atom.interfaces;

import com.wygdove.multiprovince.dao.bo.GsopGridSysParam;
import java.util.List;
import java.util.Map;

/**
 * @Title: IGsopSysParamAtomSV
 * @Description:
 */
public interface IGsopSysParamAtomSV {
    int add(GsopGridSysParam request);
    int update(GsopGridSysParam request);
    GsopGridSysParam queryById(GsopGridSysParam request);
    List<GsopGridSysParam> queryList(GsopGridSysParam request);
    List<GsopGridSysParam> queryList(GsopGridSysParam request,Map<String,Object> reqmap);
    int count(GsopGridSysParam request);
    int count(GsopGridSysParam request,Map<String,Object> reqmap);
}
