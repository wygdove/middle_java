package com.wygdove.multiprovince.service.atom.interfaces;

import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridQueryRequest;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridSaveRequest;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridVO;
import java.util.List;

/**
 * @Title: IDimAreaGridAtomSV
 * @Description:
 */
public interface IDimAreaGridAtomSV {
    int add(DimAreaGridSaveRequest request);
    int update(DimAreaGridSaveRequest request);
    DimAreaGridVO queryById(DimAreaGridQueryRequest request);
    List<DimAreaGridVO> queryList(DimAreaGridQueryRequest request);
    PageInfo<DimAreaGridVO> queryPage(DimAreaGridQueryRequest request);
    int count(DimAreaGridQueryRequest request);
}
