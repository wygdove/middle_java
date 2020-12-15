package com.wygdove.multiprovince.controller.gsopwoordinfo;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoQueryRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoSaveRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoVO;
import com.wygdove.multiprovince.model.common.AjaxResult;
import com.wygdove.multiprovince.service.busi.interfaces.IGsopWoordInfoBusiSV;
import com.wygdove.multiprovince.utils.AjaxUtil;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: GsopWoordInfoController
 * @Description:
 */
@RestController
@RequestMapping("gsopwoordinfo")
public class GsopWoordInfoController {
    private static final Logger log=LoggerFactory.getLogger(GsopWoordInfoController.class);

    @Resource
    private IGsopWoordInfoBusiSV gsopWoordInfoBusiSV;


    @RequestMapping("saveGsopWoordInfo")
    public AjaxResult saveGsopWoordInfo(HttpServletRequest request,@RequestBody GsopWoordInfoSaveRequest saveRequest) {
        log.info("controller:/gsopwoordinfo/saveGsopWoordInfo");
        if(log.isInfoEnabled()) {
            log.info("/gsopwoordinfo/saveGsopWoordInfo saveRequest: {}",JSON.toJSONString(saveRequest));
        }
        String response=null;
        if(!Objects.isNull(saveRequest.getWoId())&&saveRequest.getWoId()>0) {
            response=gsopWoordInfoBusiSV.updateGsopWoordInfo(saveRequest);
        }else {
            response=gsopWoordInfoBusiSV.addGsopWoordInfo(saveRequest);
        }
        if(log.isInfoEnabled()) {
            log.info("/gsopwoordinfo/saveGsopWoordInfo response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }


    @RequestMapping("deleteGsopWoordInfo")
    public AjaxResult deleteGsopWoordInfo(HttpServletRequest request,@RequestBody GsopWoordInfoSaveRequest saveRequest) {
        log.info("controller:/gsopwoordinfo/deleteGsopWoordInfo");
        if(log.isInfoEnabled()) {
            log.info("/gsopwoordinfo/deleteGsopWoordInfo saveRequest: {}",JSON.toJSONString(saveRequest));
        }
        String response=gsopWoordInfoBusiSV.deleteGsopWoordInfo(saveRequest);
        if(log.isInfoEnabled()) {
            log.info("/gsopwoordinfo/deleteGsopWoordInfo response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }


    @RequestMapping("queryDetailGsopWoordInfo")
    public AjaxResult queryDetailGsopWoordInfo(HttpServletRequest request,GsopWoordInfoQueryRequest queryRequest) {
        log.info("controller:/gsopwoordinfo/queryDetailGsopWoordInfo");
        if(log.isInfoEnabled()) {
            log.info("/gsopwoordinfo/queryDetailGsopWoordInfo queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        GsopWoordInfoVO response=gsopWoordInfoBusiSV.queryDetailGsopWoordInfo(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("/gsopwoordinfo/queryDetailGsopWoordInfo response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }

    @RequestMapping("queryListGsopWoordInfo")
    public AjaxResult queryListGsopWoordInfo(HttpServletRequest request,GsopWoordInfoQueryRequest queryRequest) {
        log.info("controller:/gsopwoordinfo/queryListGsopWoordInfo");
        if(log.isInfoEnabled()) {
            log.info("/gsopwoordinfo/queryListGsopWoordInfo queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        List<GsopWoordInfoVO> response=gsopWoordInfoBusiSV.queryListGsopWoordInfo(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("/gsopwoordinfo/queryListGsopWoordInfo response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }

    @RequestMapping("queryPageGsopWoordInfo")
    public AjaxResult queryPageGsopWoordInfo(HttpServletRequest request,GsopWoordInfoQueryRequest queryRequest) {
        log.info("controller:/gsopwoordinfo/queryPageGsopWoordInfo");
        if(log.isInfoEnabled()) {
            log.info("/gsopwoordinfo/queryPageGsopWoordInfo queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        PageInfo<GsopWoordInfoVO> response=gsopWoordInfoBusiSV.queryPageGsopWoordInfo(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("/gsopwoordinfo/queryPageGsopWoordInfo response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }

    @RequestMapping("countGsopWoordInfo")
    public AjaxResult countGsopWoordInfo(HttpServletRequest request,GsopWoordInfoQueryRequest queryRequest) {
        log.info("controller:/gsopwoordinfo/countGsopWoordInfo");
        if(log.isInfoEnabled()) {
            log.info("/gsopwoordinfo/countGsopWoordInfo queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        Integer response=gsopWoordInfoBusiSV.countGsopWoordInfo(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("/gsopwoordinfo/countGsopWoordInfo response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }


}
