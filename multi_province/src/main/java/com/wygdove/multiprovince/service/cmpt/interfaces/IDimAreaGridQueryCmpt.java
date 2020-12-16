package com.wygdove.multiprovince.service.cmpt.interfaces;

import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridQueryRequest;

/**
 * @Title: IDimAreaGridQueryCmpt
 * @Description:
 */
public interface IDimAreaGridQueryCmpt {

    DimAreaGridQueryRequest getRequestByType(DimAreaGridQueryRequest request);

}
