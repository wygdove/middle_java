package com.wygdove.multiprovince.service.busi.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.dao.bo.DimAreaGrid;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridQueryRequest;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridSaveRequest;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridVO;
import com.wygdove.multiprovince.service.atom.interfaces.IDimAreaGridAtomSV;
import com.wygdove.multiprovince.service.busi.interfaces.IDimAreaGridBusiSV;
import com.wygdove.multiprovince.service.cmpt.interfaces.IDimAreaGridQueryCmpt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * @Title: DimAreaGridBusiSVImpl
 * @Description:
 */
@Service
@ConditionalOnMissingBean(value=IDimAreaGridBusiSV.class,ignored=DimAreaGridBusiSVImpl.class)
public class DimAreaGridBusiSVImpl implements IDimAreaGridBusiSV {
    private static Logger log=LoggerFactory.getLogger(DimAreaGridBusiSVImpl.class);

    @Resource
    private IDimAreaGridAtomSV dimAreaGridAtomSV;
    @Resource
    private IDimAreaGridQueryCmpt dimAreaGridQueryCmpt;


    @Transactional
    @Override
    public String addDimAreaGrid(DimAreaGridSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.addDimAreaGrid request: {}",JSON.toJSONString(request));
//        Long itemId=seqUtil.getNextLongValue(SequencesConstant.ASSETS_STOCK_SEQ_ID);
//        request.setId(itemId);
        DimAreaGrid dimAreaGridRequest=new DimAreaGrid();
        BeanUtils.copyProperties(request,dimAreaGridRequest);
        int res=dimAreaGridAtomSV.add(dimAreaGridRequest);
        String result=Integer.toString(res);
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.addDimAreaGrid result: {}",JSON.toJSONString(result));
        return result;
    }

    @Transactional
    @Override
    public String updateDimAreaGrid(DimAreaGridSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.updateDimAreaGrid request: {}",JSON.toJSONString(request));
//        if(Objects.isNull(request)||Objects.isNull(request.getId())||request.getId()<=0) {
//            return CommonConstants.STR_0;
//        }
        DimAreaGrid dimAreaGridRequest=new DimAreaGrid();
        BeanUtils.copyProperties(request,dimAreaGridRequest);
        int res=dimAreaGridAtomSV.update(dimAreaGridRequest);
        String result=Integer.toString(res);
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.updateDimAreaGrid response: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public String deleteDimAreaGrid(DimAreaGridSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.deleteDimAreaGrid request: {}",JSON.toJSONString(request));
//        if(Objects.isNull(request)||Objects.isNull(request.getId())||request.getId()<=0) {
//            return CommonConstants.STR_0;
//        }
        DimAreaGrid dimAreaGridRequest=new DimAreaGrid();
        BeanUtils.copyProperties(request,dimAreaGridRequest);
        int res=dimAreaGridAtomSV.update(dimAreaGridRequest);
        String result=Integer.toString(res);
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.deleteDimAreaGrid result: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public DimAreaGridVO queryDetailDimAreaGrid(DimAreaGridQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.queryDetailDimAreaGrid request: {}",JSON.toJSONString(request));
        DimAreaGridVO result=null;
        DimAreaGrid dimAreaGridRequest=new DimAreaGrid();
        BeanUtils.copyProperties(request,dimAreaGridRequest);
        DimAreaGrid dimAreaGrid=null;
//        if(!Objects.isNull(request.getId())&&request.getId()>0) {
//            dimAreaGrid=dimAreaGridAtomSV.queryById(dimAreaGridRequest);
//        }else {
            List<DimAreaGrid> dimAreaGridList=dimAreaGridAtomSV.queryList(dimAreaGridRequest);
            if(!CollectionUtils.isEmpty(dimAreaGridList)) {
                dimAreaGrid=dimAreaGridList.get(0);
            }
//        }
        if(!Objects.isNull(dimAreaGrid)) {
            result=new DimAreaGridVO();
            BeanUtils.copyProperties(dimAreaGrid,result);
        }
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.queryDetailDimAreaGrid result: {}",JSON.toJSONString(result));
        return result;
    }



    @Override
    public List<DimAreaGridVO> queryListDimAreaGrid(DimAreaGridQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.queryListDimAreaGrid request: {}",JSON.toJSONString(request));
        List<DimAreaGridVO> result=new ArrayList<>();

        request=dimAreaGridQueryCmpt.getRequestByType(request);

        DimAreaGrid queryRequest=new DimAreaGrid();
        BeanUtils.copyProperties(request,queryRequest);
        Map<String,Object> reqmap=this.setAtomQueryMap(request);
        List<DimAreaGrid> resList=dimAreaGridAtomSV.queryList(queryRequest,reqmap);
        if(!CollectionUtils.isEmpty(resList)) {
            DimAreaGridVO itemVo=null;
            for(DimAreaGrid item:resList) {
                itemVo=new DimAreaGridVO();
                BeanUtils.copyProperties(item,itemVo);
                result.add(itemVo);
            }
        }
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.queryListDimAreaGrid result: {}",JSON.toJSONString(result));
        return result;
    }



    @Override
    public PageInfo<DimAreaGridVO> queryPageDimAreaGrid(DimAreaGridQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.queryPageDimAreaGrid request: {}",JSON.toJSONString(request));
        PageInfo<DimAreaGridVO> pageResult=new PageInfo<>();
        List<DimAreaGridVO> result=new ArrayList<>();

        DimAreaGrid queryRequest=new DimAreaGrid();
        BeanUtils.copyProperties(request,queryRequest);
        Map<String,Object> reqmap=this.setAtomQueryMap(request);

        List<DimAreaGrid> resList;
        Page<DimAreaGrid> pageData;
        PageHelper.startPage(request.getPageNo(),request.getPageSize());
        try {
            resList=dimAreaGridAtomSV.queryList(queryRequest,reqmap);
            pageData=(Page<DimAreaGrid>)resList;
        }finally {
            PageHelper.clearPage();
        }
        if(!CollectionUtils.isEmpty(resList)) {
            DimAreaGridVO itemVo=null;
            for(DimAreaGrid item:resList) {
                itemVo=new DimAreaGridVO();
                BeanUtils.copyProperties(item,itemVo);
                result.add(itemVo);
            }
            BeanUtils.copyProperties(pageData,pageResult);
        }
        pageResult.setList(result);

        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.queryPageDimAreaGrid result: {}",JSON.toJSONString(result));
        return pageResult;
    }

    @Override
    public Integer countDimAreaGrid(DimAreaGridQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.countDimAreaGrid request: {}",JSON.toJSONString(request));
        DimAreaGrid queryRequest=new DimAreaGrid();
        BeanUtils.copyProperties(request,queryRequest);
        Map<String,Object> reqmap=this.setAtomQueryMap(request);
        int result=dimAreaGridAtomSV.count(queryRequest,reqmap);
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.countDimAreaGrid result: {}",JSON.toJSONString(result));
        return result;
    }


    private Map<String,Object> setAtomQueryMap(DimAreaGridQueryRequest src) {
        Map<String,Object> res=new HashMap<>();
        if(src==null) return res;
//        if(StringUtils.hasText(src.getFieldLike())) {
//            res.put("fieldLike",src.getFieldLike());
//        }
//        if(!CollectionUtils.isEmpty(src.getFieldIn())) {
//            res.put("fieldIn",src.getFieldIn());
//        }
        return res;
    }
    
    
}
