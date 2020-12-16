package com.wygdove.multiprovince.service.cmpt.impl;

import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridQueryRequest;
import com.wygdove.multiprovince.service.cmpt.interfaces.IDimAreaGridQueryCmpt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;


/**
 * @Title: DimAreaGridQueryCmptImpl
 * @Description:
 */
@Component
@ConditionalOnMissingBean(value=IDimAreaGridQueryCmpt.class,ignored=DimAreaGridQueryCmptImpl.class)
public class DimAreaGridQueryCmptImpl implements IDimAreaGridQueryCmpt {
    private static Logger log=LoggerFactory.getLogger(DimAreaGridQueryCmptImpl.class);

    @Override
    public DimAreaGridQueryRequest getRequestByType(DimAreaGridQueryRequest request) {
        log.debug("DimAreaGridQueryCmptImpl.getRequestByType");

        return request;
    }
}
