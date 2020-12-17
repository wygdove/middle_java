package com.wygdove.multiprovince.service.busi.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridQueryRequest;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridSaveRequest;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridVO;
import com.wygdove.multiprovince.service.atom.interfaces.IDimAreaGridAtomSV;
import com.wygdove.multiprovince.service.busi.interfaces.IDimAreaGridBusiSV;
import com.wygdove.multiprovince.service.cmpt.interfaces.IDimAreaGridQueryCmpt;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        int res=dimAreaGridAtomSV.add(request);
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
        int res=dimAreaGridAtomSV.update(request);
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
        int res=dimAreaGridAtomSV.update(request);
        String result=Integer.toString(res);
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.deleteDimAreaGrid result: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public DimAreaGridVO queryDetailDimAreaGrid(DimAreaGridQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.queryDetailDimAreaGrid request: {}",JSON.toJSONString(request));
        DimAreaGridVO result=null;
//        if(!Objects.isNull(request.getId())&&request.getId()>0) {
//            result=dimAreaGridAtomSV.queryById(request);
//        }else {
            List<DimAreaGridVO> dimAreaGridVOList=dimAreaGridAtomSV.queryList(request);
            if(!CollectionUtils.isEmpty(dimAreaGridVOList)) {
                result=dimAreaGridVOList.get(0);
            }
//        }
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.queryDetailDimAreaGrid result: {}",JSON.toJSONString(result));
        return result;
    }



    @Override
    public List<DimAreaGridVO> queryListDimAreaGrid(DimAreaGridQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.queryListDimAreaGrid request: {}",JSON.toJSONString(request));

        request=dimAreaGridQueryCmpt.getRequestByType(request);

        List<DimAreaGridVO> result=dimAreaGridAtomSV.queryList(request);
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.queryListDimAreaGrid result: {}",JSON.toJSONString(result));
        return result;
    }




    @Override
    public PageInfo<DimAreaGridVO> queryPageDimAreaGrid(DimAreaGridQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.queryPageDimAreaGrid request: {}",JSON.toJSONString(request));
        if(request.getPageNo()==null||request.getPageSize()==null||request.getPageNo()<=0||request.getPageSize()<=0) {
            return new PageInfo<>();
        }
        PageInfo<DimAreaGridVO> pageResult=dimAreaGridAtomSV.queryPage(request);
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.queryPageDimAreaGrid result: {}",JSON.toJSONString(pageResult));
        return pageResult;
    }

    @Override
    public Integer countDimAreaGrid(DimAreaGridQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.countDimAreaGrid request: {}",JSON.toJSONString(request));
        int result=dimAreaGridAtomSV.count(request);
        if(log.isDebugEnabled()) log.debug("DimAreaGridBusiSVImpl.countDimAreaGrid result: {}",JSON.toJSONString(result));
        return result;
    }

    
    
}
