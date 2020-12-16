package com.wygdove.multiprovince.service.busi.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.dao.bo.GsopWoOrdInfo;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoQueryRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoSaveRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoVO;
import com.wygdove.multiprovince.service.atom.interfaces.IGsopWoordInfoAtomSV;
import com.wygdove.multiprovince.service.busi.interfaces.IGsopWoordInfoBusiSV;
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
//        Long itemId=seqUtil.getNextLongValue(SequencesConstant.ASSETS_STOCK_SEQ_ID);
//        request.setId(itemId);
        GsopWoOrdInfo gsopWoOrdInfoRequest=new GsopWoOrdInfo();
        BeanUtils.copyProperties(request,gsopWoOrdInfoRequest);
        int res=gsopWoordInfoAtomSV.add(gsopWoOrdInfoRequest);
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
        GsopWoOrdInfo gsopWoOrdInfoRequest=new GsopWoOrdInfo();
        BeanUtils.copyProperties(request,gsopWoOrdInfoRequest);
        int res=gsopWoordInfoAtomSV.update(gsopWoOrdInfoRequest);
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
        GsopWoOrdInfo gsopWoOrdInfoRequest=new GsopWoOrdInfo();
        BeanUtils.copyProperties(request,gsopWoOrdInfoRequest);
        int res=gsopWoordInfoAtomSV.update(gsopWoOrdInfoRequest);
        String result=Integer.toString(res);
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.deleteGsopWoordInfo result: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public GsopWoordInfoVO queryDetailGsopWoordInfo(GsopWoordInfoQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.queryDetailGsopWoordInfo request: {}",JSON.toJSONString(request));
        GsopWoordInfoVO result=null;
        GsopWoOrdInfo gsopWoOrdInfoRequest=new GsopWoOrdInfo();
        BeanUtils.copyProperties(request,gsopWoOrdInfoRequest);
        GsopWoOrdInfo gsopWoOrdInfo=null;
//        if(!Objects.isNull(request.getId())&&request.getId()>0) {
//            gsopWoOrdInfo=gsopWoordInfoAtomSV.queryById(gsopWoOrdInfoRequest);
//        }else {
            List<GsopWoOrdInfo> gsopWoOrdInfoList=gsopWoordInfoAtomSV.queryList(gsopWoOrdInfoRequest);
            if(!CollectionUtils.isEmpty(gsopWoOrdInfoList)) {
                gsopWoOrdInfo=gsopWoOrdInfoList.get(0);
            }
//        }
        if(!Objects.isNull(gsopWoOrdInfo)) {
            result=new GsopWoordInfoVO();
            BeanUtils.copyProperties(gsopWoOrdInfo,result);
        }
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.queryDetailGsopWoordInfo result: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public List<GsopWoordInfoVO> queryListGsopWoordInfo(GsopWoordInfoQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.queryListGsopWoordInfo request: {}",JSON.toJSONString(request));
        List<GsopWoordInfoVO> result=new ArrayList<>();
        GsopWoOrdInfo queryRequest=new GsopWoOrdInfo();
        BeanUtils.copyProperties(request,queryRequest);
        Map<String,Object> reqmap=this.setAtomQueryMap(request);
        List<GsopWoOrdInfo> resList=gsopWoordInfoAtomSV.queryList(queryRequest,reqmap);
        if(!CollectionUtils.isEmpty(resList)) {
            GsopWoordInfoVO itemVo=null;
            for(GsopWoOrdInfo item:resList) {
                itemVo=new GsopWoordInfoVO();
                BeanUtils.copyProperties(item,itemVo);
                result.add(itemVo);
            }
        }
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.queryListGsopWoordInfo result: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public PageInfo<GsopWoordInfoVO> queryPageGsopWoordInfo(GsopWoordInfoQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.queryPageGsopWoordInfo request: {}",JSON.toJSONString(request));
        PageInfo<GsopWoordInfoVO> pageResult=new PageInfo<>();
        List<GsopWoordInfoVO> result=new ArrayList<>();

        GsopWoOrdInfo queryRequest=new GsopWoOrdInfo();
        BeanUtils.copyProperties(request,queryRequest);
        Map<String,Object> reqmap=this.setAtomQueryMap(request);

        List<GsopWoOrdInfo> resList;
        Page<GsopWoOrdInfo> pageData;
        PageHelper.startPage(request.getPageNo(),request.getPageSize());
        try {
            resList=gsopWoordInfoAtomSV.queryList(queryRequest,reqmap);
            pageData=(Page<GsopWoOrdInfo>)resList;
        }finally {
            PageHelper.clearPage();
        }
        if(!CollectionUtils.isEmpty(resList)) {
            GsopWoordInfoVO itemVo=null;
            for(GsopWoOrdInfo item:resList) {
                itemVo=new GsopWoordInfoVO();
                BeanUtils.copyProperties(item,itemVo);
                result.add(itemVo);
            }
            BeanUtils.copyProperties(pageData,pageResult);
        }
        pageResult.setList(result);

        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.queryPageGsopWoordInfo result: {}",JSON.toJSONString(result));
        return pageResult;
    }

    @Override
    public Integer countGsopWoordInfo(GsopWoordInfoQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.countGsopWoordInfo request: {}",JSON.toJSONString(request));
        GsopWoOrdInfo queryRequest=new GsopWoOrdInfo();
        BeanUtils.copyProperties(request,queryRequest);
        Map<String,Object> reqmap=this.setAtomQueryMap(request);
        int result=gsopWoordInfoAtomSV.count(queryRequest,reqmap);
        if(log.isDebugEnabled()) log.debug("GsopWoordInfoBusiSVImpl.countGsopWoordInfo result: {}",JSON.toJSONString(result));
        return result;
    }


    private Map<String,Object> setAtomQueryMap(GsopWoordInfoQueryRequest src) {
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
