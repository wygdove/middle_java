package com.wygdove.multiprovince.service.cmpt.impl.beijing;

import com.wygdove.multiprovince.constants.ProvinceConstants;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridQueryRequest;
import com.wygdove.multiprovince.service.cmpt.interfaces.IDimAreaGridQueryCmpt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


/**
 * @Title: DimAreaGridQueryCmptBeijingImpl
 * @Description:
 */
@Component
@ConditionalOnProperty(name=ProvinceConstants.PROVINCE,havingValue=ProvinceConstants.BEIJING)
public class DimAreaGridQueryCmptBeijingImpl implements IDimAreaGridQueryCmpt {
    private static Logger log=LoggerFactory.getLogger(DimAreaGridQueryCmptBeijingImpl.class);

    @Override
    public DimAreaGridQueryRequest getRequestByType(DimAreaGridQueryRequest request) {
        log.debug("DimAreaGridQueryCmptBeijingImpl.getRequestByType");

        request.setAreaType("beijing");

        return request;
    }
}
