package com.wygdove.multiprovince.service.busi.interfaces;

import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridQueryRequest;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridSaveRequest;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridVO;
import java.util.List;

/**
 * @Title: IDimAreaGridBusiSV
 * @Description:
 */
public interface IDimAreaGridBusiSV {

    public String addDimAreaGrid(DimAreaGridSaveRequest request);

    public String updateDimAreaGrid(DimAreaGridSaveRequest request);

    public String deleteDimAreaGrid(DimAreaGridSaveRequest request);

    public DimAreaGridVO queryDetailDimAreaGrid(DimAreaGridQueryRequest request);

    public List<DimAreaGridVO> queryListDimAreaGrid(DimAreaGridQueryRequest request);

    public PageInfo<DimAreaGridVO> queryPageDimAreaGrid(DimAreaGridQueryRequest request);

    public Integer countDimAreaGrid(DimAreaGridQueryRequest request);

}
