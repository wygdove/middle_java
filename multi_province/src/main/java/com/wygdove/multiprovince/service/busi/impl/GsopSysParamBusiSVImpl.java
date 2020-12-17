package com.wygdove.multiprovince.service.busi.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamQueryRequest;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamSaveRequest;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamVO;
import com.wygdove.multiprovince.service.atom.interfaces.IGsopSysParamAtomSV;
import com.wygdove.multiprovince.service.busi.interfaces.IGsopSysParamBusiSV;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * @Title: GsopSysParamBusiSVImpl
 * @Description:
 */
@Service
@ConditionalOnMissingBean(value=IGsopSysParamBusiSV.class,ignored=GsopSysParamBusiSVImpl.class)
public class GsopSysParamBusiSVImpl implements IGsopSysParamBusiSV {
    private static Logger log=LoggerFactory.getLogger(GsopSysParamBusiSVImpl.class);

    @Resource
    private IGsopSysParamAtomSV gsopSysParamAtomSV;


    @Transactional
    @Override
    public String addGsopSysParam(GsopSysParamSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.addGsopSysParam request: {}",JSON.toJSONString(request));
//        Long itemId=SeqUtil.getNextLongValue(SequencesConstant.ID);
//        request.setId(itemId);
        int res=gsopSysParamAtomSV.add(request);
        String result=Integer.toString(res);
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.addGsopSysParam result: {}",JSON.toJSONString(result));
        return result;
    }

    @Transactional
    @Override
    public String updateGsopSysParam(GsopSysParamSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.updateGsopSysParam request: {}",JSON.toJSONString(request));
//        if(Objects.isNull(request)||Objects.isNull(request.getId())||request.getId()<=0) {
//            return CommonConstants.STR_0;
//        }
        int res=gsopSysParamAtomSV.update(request);
        String result=Integer.toString(res);
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.updateGsopSysParam response: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public String deleteGsopSysParam(GsopSysParamSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.deleteGsopSysParam request: {}",JSON.toJSONString(request));
//        if(Objects.isNull(request)||Objects.isNull(request.getId())||request.getId()<=0) {
//            return CommonConstants.STR_0;
//        }
        int res=gsopSysParamAtomSV.update(request);
        String result=Integer.toString(res);
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.deleteGsopSysParam result: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public GsopSysParamVO queryDetailGsopSysParam(GsopSysParamQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.queryDetailGsopSysParam request: {}",JSON.toJSONString(request));
        GsopSysParamVO result=null;
//        if(!Objects.isNull(request.getId())&&request.getId()>0) {
//            result=gsopSysParamAtomSV.queryById(request);
//        }else {
            List<GsopSysParamVO> gsopSysParamVOList=gsopSysParamAtomSV.queryList(request);
            if(!CollectionUtils.isEmpty(gsopSysParamVOList)) {
                result=gsopSysParamVOList.get(0);
            }
//        }
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.queryDetailGsopSysParam result: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public List<GsopSysParamVO> queryListGsopSysParam(GsopSysParamQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.queryListGsopSysParam request: {}",JSON.toJSONString(request));
        List<GsopSysParamVO> result=gsopSysParamAtomSV.queryList(request);
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.queryListGsopSysParam result: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public PageInfo<GsopSysParamVO> queryPageGsopSysParam(GsopSysParamQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.queryPageGsopSysParam request: {}",JSON.toJSONString(request));
        if(request.getPageNo()==null||request.getPageSize()==null||request.getPageNo()<=0||request.getPageSize()<=0) {
            return new PageInfo<>();
        }
        PageInfo<GsopSysParamVO> pageResult=gsopSysParamAtomSV.queryPage(request);
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.queryPageGsopSysParam result: {}",JSON.toJSONString(pageResult));
        return pageResult;
    }

    @Override
    public Integer countGsopSysParam(GsopSysParamQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.countGsopSysParam request: {}",JSON.toJSONString(request));
        int result=gsopSysParamAtomSV.count(request);
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.countGsopSysParam result: {}",JSON.toJSONString(result));
        return result;
    }


}
