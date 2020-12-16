package com.wygdove.multiprovince.service.cmpt.impl.xinjiang;

import com.wygdove.multiprovince.constants.ProvinceConstants;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridQueryRequest;
import com.wygdove.multiprovince.service.cmpt.interfaces.IDimAreaGridQueryCmpt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


/**
 * @Title: DimAreaGridQueryCmptXinjiangImpl
 * @Description:
 */
@Component
@ConditionalOnProperty(name=ProvinceConstants.PROVINCE,havingValue=ProvinceConstants.XINJIANG)
public class DimAreaGridQueryCmptXinjiangImpl implements IDimAreaGridQueryCmpt {
    private static Logger log=LoggerFactory.getLogger(DimAreaGridQueryCmptXinjiangImpl.class);

    @Override
    public DimAreaGridQueryRequest getRequestByType(DimAreaGridQueryRequest request) {
        log.debug("DimAreaGridQueryCmptXinjiangImpl.getRequestByType");

        request.setAreaType("xinjiang");

        return request;
    }
}
