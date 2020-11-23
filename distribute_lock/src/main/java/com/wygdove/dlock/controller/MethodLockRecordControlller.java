package com.wygdove.dlock.controller;

import com.alibaba.fastjson.JSON;
import com.wygdove.dlock.dao.bo.MethodLockRecord;
import com.wygdove.dlock.service.atom.interfaces.IMethodLockRecordAtomSV;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: MethodLockRecordControlller
 * @Description:
 */
@RestController
@RequestMapping("methodlockrecord")
public class MethodLockRecordControlller {
    private static final Logger log=LoggerFactory.getLogger(MethodLockRecordControlller.class);

    @Resource
    private IMethodLockRecordAtomSV methodLockRecordAtomSV;


    @RequestMapping("query")
    public List<MethodLockRecord> query(HttpServletRequest request,MethodLockRecord queryRequest) {
        log.info("controller:/methodlockrecord/query");
        List<MethodLockRecord> result=methodLockRecordAtomSV.query(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("/methodlockrecord/query result: {}",JSON.toJSONString(result));
        }
        return result;
    }


}
