package com.wygdove.dlock.service.busi.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wygdove.dlock.constants.CommonConstants;
import com.wygdove.dlock.constants.SequencesConstant;
import com.wygdove.dlock.dao.bo.AssetsStock;
import com.wygdove.dlock.model.assetsstock.AssetsStockQueryRequest;
import com.wygdove.dlock.model.assetsstock.AssetsStockSaveRequest;
import com.wygdove.dlock.model.assetsstock.AssetsStockVO;
import com.wygdove.dlock.service.atom.interfaces.IAssetsStockAtomSV;
import com.wygdove.dlock.service.busi.interfaces.IAssetsStockBusiSV;
import com.wygdove.dlock.utils.SeqUtil;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * @Title: AssetsStockBusiSVImpl
 * @Description:
 */
@Service
public class AssetsStockBusiSVImpl implements IAssetsStockBusiSV {
    private static Logger log=LoggerFactory.getLogger(AssetsStockBusiSVImpl.class);

    @Resource
    private SeqUtil seqUtil;
    @Resource
    private IAssetsStockAtomSV assetsStockAtomSV;


    @Transactional
    @Override
    public String addAssetsStock(AssetsStockSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("AssetsStockBusiSVImpl.addAssetsStock request: {}",JSON.toJSONString(request));
        Long itemId=seqUtil.getNextLongValue(SequencesConstant.ASSETS_STOCK_SEQ_ID);
        request.setStockId(itemId);
        AssetsStock assetsStockRequest=new AssetsStock();
        BeanUtils.copyProperties(request,assetsStockRequest);
        int res=assetsStockAtomSV.add(assetsStockRequest);
        String result=Integer.toString(res);
        if(log.isDebugEnabled()) log.debug("AssetsStockBusiSVImpl.addAssetsStock result: {}",JSON.toJSONString(result));
        return result;
    }

    @Transactional
    @Override
    public String updateAssetsStock(AssetsStockSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("AssetsStockBusiSVImpl.updateAssetsStock request: {}",JSON.toJSONString(request));
        if(Objects.isNull(request)||Objects.isNull(request.getStockId())||request.getStockId()<=0) {
            return CommonConstants.STR_0;
        }
        AssetsStock assetsStockRequest=new AssetsStock();
        BeanUtils.copyProperties(request,assetsStockRequest);
        int res=assetsStockAtomSV.update(assetsStockRequest);
        String result=Integer.toString(res);
        if(log.isDebugEnabled()) log.debug("AssetsStockBusiSVImpl.updateAssetsStock response: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public String deleteAssetsStock(AssetsStockSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("AssetsStockBusiSVImpl.deleteAssetsStock request: {}",JSON.toJSONString(request));
        if(Objects.isNull(request)||Objects.isNull(request.getStockId())||request.getStockId()<=0) {
            return CommonConstants.STR_0;
        }
        AssetsStock assetsStockRequest=new AssetsStock();
        BeanUtils.copyProperties(request,assetsStockRequest);
        assetsStockRequest.setUseDate(new Timestamp(System.currentTimeMillis()));
        int res=assetsStockAtomSV.update(assetsStockRequest);
        String result=Integer.toString(res);
        if(log.isDebugEnabled()) log.debug("AssetsStockBusiSVImpl.deleteAssetsStock result: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public AssetsStockVO queryDetailAssetsStock(AssetsStockQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("AssetsStockBusiSVImpl.queryDetailAssetsStock request: {}",JSON.toJSONString(request));
        AssetsStockVO result=null;
        AssetsStock assetsStockRequest=new AssetsStock();
        BeanUtils.copyProperties(request,assetsStockRequest);
        AssetsStock assetsStock=null;
        if(!Objects.isNull(request.getStockId())&&request.getStockId()>0) {
            assetsStock=assetsStockAtomSV.queryById(assetsStockRequest);
        }else {
            List<AssetsStock> assetsStockList=assetsStockAtomSV.queryList(assetsStockRequest);
            if(!CollectionUtils.isEmpty(assetsStockList)) {
                assetsStock=assetsStockList.get(0);
            }
        }
        if(!Objects.isNull(assetsStock)) {
            result=new AssetsStockVO();
            BeanUtils.copyProperties(assetsStock,result);
        }
        if(log.isDebugEnabled()) log.debug("AssetsStockBusiSVImpl.queryDetailAssetsStock result: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public List<AssetsStockVO> queryListAssetsStock(AssetsStockQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("AssetsStockBusiSVImpl.queryListAssetsStock request: {}",JSON.toJSONString(request));
        List<AssetsStockVO> result=new ArrayList<>();
        AssetsStock queryRequest=new AssetsStock();
        BeanUtils.copyProperties(request,queryRequest);
        Map<String,Object> reqmap=this.setAtomQueryMap(request);
        List<AssetsStock> resList=assetsStockAtomSV.queryList(queryRequest,reqmap);
        if(!CollectionUtils.isEmpty(resList)) {
            AssetsStockVO itemVo=null;
            for(AssetsStock item:resList) {
                itemVo=new AssetsStockVO();
                BeanUtils.copyProperties(item,itemVo);
                result.add(itemVo);
            }
        }
        if(log.isDebugEnabled()) log.debug("AssetsStockBusiSVImpl.queryListAssetsStock result: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public PageInfo<AssetsStockVO> queryPageAssetsStock(AssetsStockQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("AssetsStockBusiSVImpl.queryPageAssetsStock request: {}",JSON.toJSONString(request));
        PageInfo<AssetsStockVO> pageResult=new PageInfo<>();
        List<AssetsStockVO> result=new ArrayList<>();

        AssetsStock queryRequest=new AssetsStock();
        BeanUtils.copyProperties(request,queryRequest);
        Map<String,Object> reqmap=this.setAtomQueryMap(request);

        List<AssetsStock> resList;
        Page<AssetsStock> pageData;
        PageHelper.startPage(request.getPageNo(),request.getPageSize());
        try {
            resList=assetsStockAtomSV.queryList(queryRequest,reqmap);
            pageData=(Page<AssetsStock>)resList;
        }finally {
            PageHelper.clearPage();
        }
        if(!CollectionUtils.isEmpty(resList)) {
            AssetsStockVO itemVo=null;
            for(AssetsStock item:resList) {
                itemVo=new AssetsStockVO();
                BeanUtils.copyProperties(item,itemVo);
                result.add(itemVo);
            }
            BeanUtils.copyProperties(pageData,pageResult);
        }
        pageResult.setList(result);

        if(log.isDebugEnabled()) log.debug("AssetsStockBusiSVImpl.queryPageAssetsStock result: {}",JSON.toJSONString(result));
        return pageResult;
    }

    @Override
    public Integer countAssetsStock(AssetsStockQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("AssetsStockBusiSVImpl.countAssetsStock request: {}",JSON.toJSONString(request));
        AssetsStock queryRequest=new AssetsStock();
        BeanUtils.copyProperties(request,queryRequest);
        Map<String,Object> reqmap=this.setAtomQueryMap(request);
        int result=assetsStockAtomSV.count(queryRequest,reqmap);
        if(log.isDebugEnabled()) log.debug("AssetsStockBusiSVImpl.countAssetsStock result: {}",JSON.toJSONString(result));
        return result;
    }


    private Map<String,Object> setAtomQueryMap(AssetsStockQueryRequest src) {
        Map<String,Object> res=new HashMap<>();
        if(src==null) return res;
        if(StringUtils.hasText(src.getAssetsCodeLike())) {
            res.put("assetsCodeLike",src.getAssetsCodeLike());
        }
        if(!CollectionUtils.isEmpty(src.getAssetsCodeIn())) {
            res.put("assetsCodeIn",src.getAssetsCodeIn());
        }
        return res;
    }
    
    
}
