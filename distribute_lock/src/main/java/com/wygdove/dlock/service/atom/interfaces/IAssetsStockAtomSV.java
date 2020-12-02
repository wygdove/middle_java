package com.wygdove.dlock.service.atom.interfaces;

import com.wygdove.dlock.dao.bo.AssetsStock;
import java.util.List;
import java.util.Map;

/**
 * @Title: IAssetsStockAtomSV
 * @Description:
 */
public interface IAssetsStockAtomSV {
    int add(AssetsStock request);
    int update(AssetsStock request);
    AssetsStock queryById(AssetsStock request);
    List<AssetsStock> queryList(AssetsStock request);
    List<AssetsStock> queryList(AssetsStock request,Map<String,Object> reqmap);
    int count(AssetsStock request);
    int count(AssetsStock request,Map<String,Object> reqmap);
}
