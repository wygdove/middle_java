package com.wygdove.dlock.service.busi.interfaces;

import com.github.pagehelper.PageInfo;
import com.wygdove.dlock.model.assetsstock.AssetsStockQueryRequest;
import com.wygdove.dlock.model.assetsstock.AssetsStockSaveRequest;
import com.wygdove.dlock.model.assetsstock.AssetsStockVO;
import java.util.List;

/**
 * @Title: IAssetsStockBusiSV
 * @Description:
 */
public interface IAssetsStockBusiSV {

    public String addAssetsStock(AssetsStockSaveRequest request);

    public String updateAssetsStock(AssetsStockSaveRequest request);

    public String deleteAssetsStock(AssetsStockSaveRequest request);

    public AssetsStockVO queryDetailAssetsStock(AssetsStockQueryRequest request);

    public List<AssetsStockVO> queryListAssetsStock(AssetsStockQueryRequest request);

    public PageInfo<AssetsStockVO> queryPageAssetsStock(AssetsStockQueryRequest request);

    public Integer countAssetsStock(AssetsStockQueryRequest request);
    
}
