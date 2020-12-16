package com.wygdove.multiprovince.controller.dimareagrid;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridQueryRequest;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridSaveRequest;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridVO;
import com.wygdove.multiprovince.model.common.AjaxResult;
import com.wygdove.multiprovince.service.busi.interfaces.IDimAreaGridBusiSV;
import com.wygdove.multiprovince.utils.AjaxUtil;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: DimAreaGridController
 * @Description:
 */
@RestController
@RequestMapping("dimareagrid")
public class DimAreaGridController {
    private static final Logger log=LoggerFactory.getLogger(DimAreaGridController.class);

    @Resource
    private IDimAreaGridBusiSV dimAreaGridBusiSV;


    @RequestMapping("saveDimAreaGrid")
    public AjaxResult saveDimAreaGrid(HttpServletRequest request,@RequestBody DimAreaGridSaveRequest saveRequest) {
        log.info("controller:/dimareagrid/saveDimAreaGrid");
        if(log.isInfoEnabled()) {
            log.info("/dimareagrid/saveDimAreaGrid saveRequest: {}",JSON.toJSONString(saveRequest));
        }
        String response=null;
        if(StringUtils.hasText(saveRequest.getAreaId())) {
            response=dimAreaGridBusiSV.updateDimAreaGrid(saveRequest);
        }else {
            response=dimAreaGridBusiSV.addDimAreaGrid(saveRequest);
        }
        if(log.isInfoEnabled()) {
            log.info("/dimareagrid/saveDimAreaGrid response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }


    @RequestMapping("deleteDimAreaGrid")
    public AjaxResult deleteDimAreaGrid(HttpServletRequest request,@RequestBody DimAreaGridSaveRequest saveRequest) {
        log.info("controller:/dimareagrid/deleteDimAreaGrid");
        if(log.isInfoEnabled()) {
            log.info("/dimareagrid/deleteDimAreaGrid saveRequest: {}",JSON.toJSONString(saveRequest));
        }
        String response=dimAreaGridBusiSV.deleteDimAreaGrid(saveRequest);
        if(log.isInfoEnabled()) {
            log.info("/dimareagrid/deleteDimAreaGrid response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }


    @RequestMapping("queryDetailDimAreaGrid")
    public AjaxResult queryDetailDimAreaGrid(HttpServletRequest request,DimAreaGridQueryRequest queryRequest) {
        log.info("controller:/dimareagrid/queryDetailDimAreaGrid");
        if(log.isInfoEnabled()) {
            log.info("/dimareagrid/queryDetailDimAreaGrid queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        DimAreaGridVO response=dimAreaGridBusiSV.queryDetailDimAreaGrid(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("/dimareagrid/queryDetailDimAreaGrid response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }

    @RequestMapping("queryListDimAreaGrid")
    public AjaxResult queryListDimAreaGrid(HttpServletRequest request,DimAreaGridQueryRequest queryRequest) {
        log.info("controller:/dimareagrid/queryListDimAreaGrid");
        if(log.isInfoEnabled()) {
            log.info("/dimareagrid/queryListDimAreaGrid queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        List<DimAreaGridVO> response=dimAreaGridBusiSV.queryListDimAreaGrid(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("/dimareagrid/queryListDimAreaGrid response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }

    @RequestMapping("queryPageDimAreaGrid")
    public AjaxResult queryPageDimAreaGrid(HttpServletRequest request,DimAreaGridQueryRequest queryRequest) {
        log.info("controller:/dimareagrid/queryPageDimAreaGrid");
        if(log.isInfoEnabled()) {
            log.info("/dimareagrid/queryPageDimAreaGrid queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        PageInfo<DimAreaGridVO> response=dimAreaGridBusiSV.queryPageDimAreaGrid(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("/dimareagrid/queryPageDimAreaGrid response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }

    @RequestMapping("countDimAreaGrid")
    public AjaxResult countDimAreaGrid(HttpServletRequest request,DimAreaGridQueryRequest queryRequest) {
        log.info("controller:/dimareagrid/countDimAreaGrid");
        if(log.isInfoEnabled()) {
            log.info("/dimareagrid/countDimAreaGrid queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        Integer response=dimAreaGridBusiSV.countDimAreaGrid(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("/dimareagrid/countDimAreaGrid response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }


}
