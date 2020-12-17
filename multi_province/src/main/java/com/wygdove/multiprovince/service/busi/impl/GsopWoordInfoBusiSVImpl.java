package com.wygdove.multiprovince.service.busi.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoQueryRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoSaveRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoVO;
import com.wygdove.multiprovince.service.atom.interfaces.IGsopWoordInfoAtomSV;
import com.wygdove.multiprovince.service.busi.interfaces.IGsopWoordInfoBusiSV;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * @Title: GsopWoordInfoBusiSVImpl
 * @Description:
 */
@Service
@ConditionalOnMissingBean(value=IGsopWoordInfoBusiSV.class,ignored=GsopWoordInfoBusiSVImpl.class)
public class GsopWoordInfoBusiSVImpl implements IGsopWoordInfoBusiSV {
    private static Logger log=LoggerFactory.getLogger(GsopWoordInfoBusiSVImpl.class);

    @Resource
    private IGsopWoordInfoAtomSV gsopWoordInfoAtomSV;


    @Transactional
    @Override
    public String addGsopWoordInfo(GsopWoordInfoSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.addGsopWoordInfo request: {}",JSON.toJSONString(request));
//        Long itemId=SeqUtil.getNextLongValue(SequencesConstant.ID);
//        request.setId(itemId);
        int res=gsopWoordInfoAtomSV.add(request);
        String result=Integer.toString(res);
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.addGsopWoordInfo result: {}",JSON.toJSONString(result));
        return result;
    }

    @Transactional
    @Override
    public String updateGsopWoordInfo(GsopWoordInfoSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.updateGsopWoordInfo request: {}",JSON.toJSONString(request));
//        if(Objects.isNull(request)||Objects.isNull(request.getId())||request.getId()<=0) {
//            return CommonConstants.STR_0;
//        }
        int res=gsopWoordInfoAtomSV.update(request);
        String result=Integer.toString(res);
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.updateGsopWoordInfo response: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public String deleteGsopWoordInfo(GsopWoordInfoSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.deleteGsopWoordInfo request: {}",JSON.toJSONString(request));
//        if(Objects.isNull(request)||Objects.isNull(request.getId())||request.getId()<=0) {
//            return CommonConstants.STR_0;
//        }
        int res=gsopWoordInfoAtomSV.update(request);
        String result=Integer.toString(res);
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.deleteGsopWoordInfo result: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public GsopWoordInfoVO queryDetailGsopWoordInfo(GsopWoordInfoQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.queryDetailGsopWoordInfo request: {}",JSON.toJSONString(request));
        GsopWoordInfoVO result=null;
//        if(!Objects.isNull(request.getId())&&request.getId()>0) {
//            result=gsopWoordInfoAtomSV.queryById(request);
//        }else {
            List<GsopWoordInfoVO> gsopWoordInfoVOList=gsopWoordInfoAtomSV.queryList(request);
            if(!CollectionUtils.isEmpty(gsopWoordInfoVOList)) {
                result=gsopWoordInfoVOList.get(0);
            }
//        }
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.queryDetailGsopWoordInfo result: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public List<GsopWoordInfoVO> queryListGsopWoordInfo(GsopWoordInfoQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.queryListGsopWoordInfo request: {}",JSON.toJSONString(request));
        List<GsopWoordInfoVO> result=gsopWoordInfoAtomSV.queryList(request);
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.queryListGsopWoordInfo result: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public PageInfo<GsopWoordInfoVO> queryPageGsopWoordInfo(GsopWoordInfoQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.queryPageGsopWoordInfo request: {}",JSON.toJSONString(request));
        if(request.getPageNo()==null||request.getPageSize()==null||request.getPageNo()<=0||request.getPageSize()<=0) {
            return new PageInfo<>();
        }
        PageInfo<GsopWoordInfoVO> pageResult=gsopWoordInfoAtomSV.queryPage(request);
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.queryPageGsopWoordInfo result: {}",JSON.toJSONString(pageResult));
        return pageResult;
    }

    @Override
    public Integer countGsopWoordInfo(GsopWoordInfoQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.countGsopWoordInfo request: {}",JSON.toJSONString(request));
        int result=gsopWoordInfoAtomSV.count(request);
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.countGsopWoordInfo result: {}",JSON.toJSONString(result));
        return result;
    }


}
