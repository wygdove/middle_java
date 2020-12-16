package com.wygdove.multiprovince.service.atom.interfaces;

import com.wygdove.multiprovince.dao.bo.DimAreaGrid;
import java.util.List;
import java.util.Map;

/**
 * @Title: IDimAreaGridAtomSV
 * @Description:
 */
public interface IDimAreaGridAtomSV {
    int add(DimAreaGrid request);
    int update(DimAreaGrid request);
    DimAreaGrid queryById(DimAreaGrid request);
    List<DimAreaGrid> queryList(DimAreaGrid request);
    List<DimAreaGrid> queryList(DimAreaGrid request,Map<String,Object> reqmap);
    int count(DimAreaGrid request);
    int count(DimAreaGrid request,Map<String,Object> reqmap);
}
