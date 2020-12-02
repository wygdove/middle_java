package com.wygdove.dlock.controller;

import com.alibaba.fastjson.JSON;
import com.wygdove.dlock.model.assetsstock.AssetsStockQueryRequest;
import com.wygdove.dlock.model.assetsstock.AssetsStockSaveRequest;
import com.wygdove.dlock.model.assetsstock.AssetsStockVO;
import com.wygdove.dlock.model.common.AjaxResult;
import com.wygdove.dlock.service.busi.interfaces.IAssetsStockBusiSV;
import com.wygdove.dlock.utils.AjaxUtil;
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
 * @Title: AssetsStockController
 * @Description:
 */
@RestController
@RequestMapping("assetsstock")
public class AssetsStockController {
    private static final Logger log=LoggerFactory.getLogger(AssetsStockController.class);

    @Resource
    private IAssetsStockBusiSV assetsStockBusiSV;


    @RequestMapping("saveAssetsStock")
    public AjaxResult saveAssetsStock(HttpServletRequest request,@RequestBody AssetsStockSaveRequest saveRequest) {
        log.info("controller:/assetsstock/saveAssetsStock");
        if(log.isInfoEnabled()) {
            log.info("/assetsstock/saveAssetsStock saveRequest: {}",JSON.toJSONString(saveRequest));
        }
        String response=null;
        if(!Objects.isNull(saveRequest.getStockId())&&saveRequest.getStockId()>0) {
            saveRequest.setUseDate(new Timestamp(System.currentTimeMillis()));
            response=assetsStockBusiSV.updateAssetsStock(saveRequest);
        }else {
            saveRequest.setStockinDate(new Timestamp(System.currentTimeMillis()));
            response=assetsStockBusiSV.addAssetsStock(saveRequest);
        }
        if(log.isInfoEnabled()) {
            log.info("/assetsstock/saveAssetsStock response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }


    @RequestMapping("deleteAssetsStock")
    public AjaxResult deleteAssetsStock(HttpServletRequest request,@RequestBody AssetsStockSaveRequest saveRequest) {
        log.info("controller:/assetsstock/deleteAssetsStock");
        if(log.isInfoEnabled()) {
            log.info("/assetsstock/deleteAssetsStock saveRequest: {}",JSON.toJSONString(saveRequest));
        }
        String response=assetsStockBusiSV.deleteAssetsStock(saveRequest);
        if(log.isInfoEnabled()) {
            log.info("/assetsstock/deleteAssetsStock response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }


    @RequestMapping("queryAssetsStockDetail")
    public AjaxResult queryAssetsStockDetail(HttpServletRequest request,AssetsStockQueryRequest queryRequest) {
        log.info("controller:/assetsstock/queryAssetsStockDetail");
        if(log.isInfoEnabled()) {
            log.info("/assetsstock/queryAssetsStockDetail queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        AssetsStockVO response=assetsStockBusiSV.queryDetailAssetsStock(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("/assetsstock/queryAssetsStockDetail response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }

    @RequestMapping("queryAssetsStockList")
    public AjaxResult queryAssetsStockList(HttpServletRequest request,AssetsStockQueryRequest queryRequest) {
        log.info("controller:/assetsstock/queryAssetsStockList");
        if(log.isInfoEnabled()) {
            log.info("/assetsstock/queryAssetsStockList queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        List<AssetsStockVO> response=assetsStockBusiSV.queryListAssetsStock(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("/assetsstock/queryAssetsStockList response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }

    @RequestMapping("countAssetsStock")
    public AjaxResult countAssetsStock(HttpServletRequest request,AssetsStockQueryRequest queryRequest) {
        log.info("controller:/assetsstock/countAssetsStock");
        if(log.isInfoEnabled()) {
            log.info("/assetsstock/countAssetsStock queryRequest: {}",JSON.toJSONString(queryRequest));
        }
        Integer response=assetsStockBusiSV.countAssetsStock(queryRequest);
        if(log.isInfoEnabled()) {
            log.info("/assetsstock/countAssetsStock response: {}",JSON.toJSONString(response));
        }
        if(response!=null) {
            return AjaxUtil.markSuccess(response);
        }
        return AjaxUtil.markError();
    }


}
