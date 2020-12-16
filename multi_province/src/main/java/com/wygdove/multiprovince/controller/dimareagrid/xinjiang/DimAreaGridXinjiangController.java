package com.wygdove.multiprovince.controller.dimareagrid.xinjiang;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.model.common.AjaxResult;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridQueryRequest;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridSaveRequest;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridVO;
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
@RequestMapping("dimareagrid/xinjiang")
public class DimAreaGridXinjiangController {
    private static final Logger log=LoggerFactory.getLogger(DimAreaGridXinjiangController.class);

    @Resource
    private IDimAreaGridBusiSV dimAreaGridBusiSV;


    @RequestMapping("saveDimAreaGrid")
    public AjaxResult saveDimAreaGrid(HttpServletRequest request,@RequestBody DimAreaGridSaveRequest saveRequest) {
        log.info("controller:dimareagrid/xinjiang/saveDimAreaGrid");
        if(log.isInfoEnabled()) {
            log.info("dimareagrid/xinjiang/saveDimAreaGrid saveRequest: {}",JSON.toJSONString(saveRequest));
        }
        String response=null;
        if(StringUtils.hasText(saveRequest.getAreaId())) {
            response=dimAreaGridBusiSV.updateDimAreaGrid(saveRequest);
        }else {
            response=dimAreaGridBusiSV.addDimAreaGrid(saveRequest);
        }
        if(log.isInfoEnabled()) {
            log.info("dimareagrid/xinjiang/saveDimAreaGrid response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }


    @RequestMapping("deleteDimAreaGrid")
    public AjaxResult deleteDimAreaGrid(HttpServletRequest request,@RequestBody DimAreaGridSaveRequest saveRequest) {
        log.info("controller:dimareagrid/xinjiang/deleteDimAreaGrid");
        if(log.isInfoEnabled()) {
            log.info("dimareagrid/xinjiang/deleteDimAreaGrid saveRequest: {}",JSON.toJSONString(saveRequest));
        }
        String response=dimAreaGridBusiSV.deleteDimAreaGrid(saveRequest);
        if(log.isInfoEnabled()) {
            log.info("dimareagrid/xinjiang/deleteDimAreaGrid response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }


    @RequestMapping("queryDetailDimAreaGrid")
    public AjaxResult queryDetailDimAreaGrid(HttpServletRequest request,DimAreaGridQueryRequest queryRequest) {
        log.info("controller:dimareagrid/xinjiang/queryDetailDimAreaGrid");
        if(log.isInfoEnabled()) {
            log.info("dimareagrid/xinjiang/queryDetailDimAreaGrid queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        DimAreaGridVO response=dimAreaGridBusiSV.queryDetailDimAreaGrid(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("dimareagrid/xinjiang/queryDetailDimAreaGrid response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }

    @RequestMapping("queryListDimAreaGrid")
    public AjaxResult queryListDimAreaGrid(HttpServletRequest request,DimAreaGridQueryRequest queryRequest) {
        log.info("controller:dimareagrid/xinjiang/queryListDimAreaGrid");
        if(log.isInfoEnabled()) {
            log.info("dimareagrid/xinjiang/queryListDimAreaGrid queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        List<DimAreaGridVO> response=dimAreaGridBusiSV.queryListDimAreaGrid(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("dimareagrid/xinjiang/queryListDimAreaGrid response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }

    @RequestMapping("queryPageDimAreaGrid")
    public AjaxResult queryPageDimAreaGrid(HttpServletRequest request,DimAreaGridQueryRequest queryRequest) {
        log.info("controller:dimareagrid/xinjiang/queryPageDimAreaGrid");
        if(log.isInfoEnabled()) {
            log.info("dimareagrid/xinjiang/queryPageDimAreaGrid queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        PageInfo<DimAreaGridVO> response=dimAreaGridBusiSV.queryPageDimAreaGrid(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("dimareagrid/xinjiang/queryPageDimAreaGrid response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }

    @RequestMapping("countDimAreaGrid")
    public AjaxResult countDimAreaGrid(HttpServletRequest request,DimAreaGridQueryRequest queryRequest) {
        log.info("controller:dimareagrid/xinjiang/countDimAreaGrid");
        if(log.isInfoEnabled()) {
            log.info("dimareagrid/xinjiang/countDimAreaGrid queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        Integer response=dimAreaGridBusiSV.countDimAreaGrid(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("dimareagrid/xinjiang/countDimAreaGrid response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }


}
