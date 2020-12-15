package com.wygdove.multiprovince.controller.gsopsysparam;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamQueryRequest;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamSaveRequest;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamVO;
import com.wygdove.multiprovince.model.common.AjaxResult;
import com.wygdove.multiprovince.service.busi.interfaces.IGsopSysParamBusiSV;
import com.wygdove.multiprovince.utils.AjaxUtil;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: GsopSysParamController
 * @Description:
 */
@RestController
@RequestMapping("gsopsysparam")
public class GsopSysParamController {
    private static final Logger log=LoggerFactory.getLogger(GsopSysParamController.class);

    @Resource
    private IGsopSysParamBusiSV gsopSysParamBusiSV;


    @RequestMapping("saveGsopSysParam")
    public AjaxResult saveGsopSysParam(HttpServletRequest request,@RequestBody GsopSysParamSaveRequest saveRequest) {
        log.info("controller:/gsopsysparam/saveGsopSysParam");
        if(log.isInfoEnabled()) {
            log.info("/gsopsysparam/saveGsopSysParam saveRequest: {}",JSON.toJSONString(saveRequest));
        }
        String response=null;
        if(StringUtils.hasText(saveRequest.getGuidkey())) {
            response=gsopSysParamBusiSV.updateGsopSysParam(saveRequest);
        }else {
            response=gsopSysParamBusiSV.addGsopSysParam(saveRequest);
        }
        if(log.isInfoEnabled()) {
            log.info("/gsopsysparam/saveGsopSysParam response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }


    @RequestMapping("deleteGsopSysParam")
    public AjaxResult deleteGsopSysParam(HttpServletRequest request,@RequestBody GsopSysParamSaveRequest saveRequest) {
        log.info("controller:/gsopsysparam/deleteGsopSysParam");
        if(log.isInfoEnabled()) {
            log.info("/gsopsysparam/deleteGsopSysParam saveRequest: {}",JSON.toJSONString(saveRequest));
        }
        String response=gsopSysParamBusiSV.deleteGsopSysParam(saveRequest);
        if(log.isInfoEnabled()) {
            log.info("/gsopsysparam/deleteGsopSysParam response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }


    @RequestMapping("queryDetailGsopSysParam")
    public AjaxResult queryDetailGsopSysParam(HttpServletRequest request,GsopSysParamQueryRequest queryRequest) {
        log.info("controller:/gsopsysparam/queryDetailGsopSysParam");
        if(log.isInfoEnabled()) {
            log.info("/gsopsysparam/queryDetailGsopSysParam queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        GsopSysParamVO response=gsopSysParamBusiSV.queryDetailGsopSysParam(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("/gsopsysparam/queryDetailGsopSysParam response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }

    @RequestMapping("queryListGsopSysParam")
    public AjaxResult queryListGsopSysParam(HttpServletRequest request,GsopSysParamQueryRequest queryRequest) {
        log.info("controller:/gsopsysparam/queryListGsopSysParam");
        if(log.isInfoEnabled()) {
            log.info("/gsopsysparam/queryListGsopSysParam queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        List<GsopSysParamVO> response=gsopSysParamBusiSV.queryListGsopSysParam(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("/gsopsysparam/queryListGsopSysParam response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }

    @RequestMapping("queryPageGsopSysParam")
    public AjaxResult queryPageGsopSysParam(HttpServletRequest request,GsopSysParamQueryRequest queryRequest) {
        log.info("controller:/gsopsysparam/queryPageGsopSysParam");
        if(log.isInfoEnabled()) {
            log.info("/gsopsysparam/queryPageGsopSysParam queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        PageInfo<GsopSysParamVO> response=gsopSysParamBusiSV.queryPageGsopSysParam(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("/gsopsysparam/queryPageGsopSysParam response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }

    @RequestMapping("countGsopSysParam")
    public AjaxResult countGsopSysParam(HttpServletRequest request,GsopSysParamQueryRequest queryRequest) {
        log.info("controller:/gsopsysparam/countGsopSysParam");
        if(log.isInfoEnabled()) {
            log.info("/gsopsysparam/countGsopSysParam queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        Integer response=gsopSysParamBusiSV.countGsopSysParam(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("/gsopsysparam/countGsopSysParam response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }


}
