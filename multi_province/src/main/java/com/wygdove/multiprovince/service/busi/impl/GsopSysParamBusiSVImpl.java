package com.wygdove.multiprovince.service.busi.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.constants.CommonConstants;
import com.wygdove.multiprovince.dao.bo.GsopGridSysParam;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamQueryRequest;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamSaveRequest;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamVO;
import com.wygdove.multiprovince.service.atom.interfaces.IGsopSysParamAtomSV;
import com.wygdove.multiprovince.service.busi.interfaces.IGsopSysParamBusiSV;
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
 * @Title: GsopSysParamBusiSVImpl
 * @Description:
 */
@Service
public class GsopSysParamBusiSVImpl implements IGsopSysParamBusiSV {
    private static Logger log=LoggerFactory.getLogger(GsopSysParamBusiSVImpl.class);

    @Resource
    private IGsopSysParamAtomSV gsopSysParamAtomSV;


    @Transactional
    @Override
    public String addGsopSysParam(GsopSysParamSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.addGsopSysParam request: {}",JSON.toJSONString(request));
//        Long itemId=seqUtil.getNextLongValue(SequencesConstant.ASSETS_STOCK_SEQ_ID);
//        request.setId(itemId);
        GsopGridSysParam gsopSysParamRequest=new GsopGridSysParam();
        BeanUtils.copyProperties(request,gsopSysParamRequest);
        int res=gsopSysParamAtomSV.add(gsopSysParamRequest);
        String result=Integer.toString(res);
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.addGsopSysParam result: {}",JSON.toJSONString(result));
        return result;
    }

    @Transactional
    @Override
    public String updateGsopSysParam(GsopSysParamSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.updateGsopSysParam request: {}",JSON.toJSONString(request));
//        if(Objects.isNull(request)||Objects.isNull(request.getGuidkey())||request.getGuidkey()<=0) {
//            return CommonConstants.STR_0;
//        }
        GsopGridSysParam gsopSysParamRequest=new GsopGridSysParam();
        BeanUtils.copyProperties(request,gsopSysParamRequest);
        int res=gsopSysParamAtomSV.update(gsopSysParamRequest);
        String result=Integer.toString(res);
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.updateGsopSysParam response: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public String deleteGsopSysParam(GsopSysParamSaveRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.deleteGsopSysParam request: {}",JSON.toJSONString(request));
//        if(Objects.isNull(request)||Objects.isNull(request.getGuidkey())||request.getGuidkey()<=0) {
//            return CommonConstants.STR_0;
//        }
        GsopGridSysParam gsopSysParamRequest=new GsopGridSysParam();
        BeanUtils.copyProperties(request,gsopSysParamRequest);
        int res=gsopSysParamAtomSV.update(gsopSysParamRequest);
        String result=Integer.toString(res);
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.deleteGsopSysParam result: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public GsopSysParamVO queryDetailGsopSysParam(GsopSysParamQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.queryDetailGsopSysParam request: {}",JSON.toJSONString(request));
        GsopSysParamVO result=null;
        GsopGridSysParam gsopSysParamRequest=new GsopGridSysParam();
        BeanUtils.copyProperties(request,gsopSysParamRequest);
        GsopGridSysParam gsopSysParam=null;
        if(StringUtils.hasText(request.getGuidkey())) {
            gsopSysParam=gsopSysParamAtomSV.queryById(gsopSysParamRequest);
        }else {
            List<GsopGridSysParam> gsopSysParamList=gsopSysParamAtomSV.queryList(gsopSysParamRequest);
            if(!CollectionUtils.isEmpty(gsopSysParamList)) {
                gsopSysParam=gsopSysParamList.get(0);
            }
        }
        if(!Objects.isNull(gsopSysParam)) {
            result=new GsopSysParamVO();
            BeanUtils.copyProperties(gsopSysParam,result);
        }
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.queryDetailGsopSysParam result: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public List<GsopSysParamVO> queryListGsopSysParam(GsopSysParamQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.queryListGsopSysParam request: {}",JSON.toJSONString(request));
        List<GsopSysParamVO> result=new ArrayList<>();
        GsopGridSysParam queryRequest=new GsopGridSysParam();
        BeanUtils.copyProperties(request,queryRequest);
        Map<String,Object> reqmap=this.setAtomQueryMap(request);
        List<GsopGridSysParam> resList=gsopSysParamAtomSV.queryList(queryRequest,reqmap);
        if(!CollectionUtils.isEmpty(resList)) {
            GsopSysParamVO itemVo=null;
            for(GsopGridSysParam item:resList) {
                itemVo=new GsopSysParamVO();
                BeanUtils.copyProperties(item,itemVo);
                result.add(itemVo);
            }
        }
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.queryListGsopSysParam result: {}",JSON.toJSONString(result));
        return result;
    }

    @Override
    public PageInfo<GsopSysParamVO> queryPageGsopSysParam(GsopSysParamQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.queryPageGsopSysParam request: {}",JSON.toJSONString(request));
        PageInfo<GsopSysParamVO> pageResult=new PageInfo<>();
        List<GsopSysParamVO> result=new ArrayList<>();

        GsopGridSysParam queryRequest=new GsopGridSysParam();
        BeanUtils.copyProperties(request,queryRequest);
        Map<String,Object> reqmap=this.setAtomQueryMap(request);

        List<GsopGridSysParam> resList;
        Page<GsopGridSysParam> pageData;
        PageHelper.startPage(request.getPageNo(),request.getPageSize());
        try {
            resList=gsopSysParamAtomSV.queryList(queryRequest,reqmap);
            pageData=(Page<GsopGridSysParam>)resList;
        }finally {
            PageHelper.clearPage();
        }
        if(!CollectionUtils.isEmpty(resList)) {
            GsopSysParamVO itemVo=null;
            for(GsopGridSysParam item:resList) {
                itemVo=new GsopSysParamVO();
                BeanUtils.copyProperties(item,itemVo);
                result.add(itemVo);
            }
            BeanUtils.copyProperties(pageData,pageResult);
        }
        pageResult.setList(result);

        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.queryPageGsopSysParam result: {}",JSON.toJSONString(result));
        return pageResult;
    }

    @Override
    public Integer countGsopSysParam(GsopSysParamQueryRequest request) {
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.countGsopSysParam request: {}",JSON.toJSONString(request));
        GsopGridSysParam queryRequest=new GsopGridSysParam();
        BeanUtils.copyProperties(request,queryRequest);
        Map<String,Object> reqmap=this.setAtomQueryMap(request);
        int result=gsopSysParamAtomSV.count(queryRequest,reqmap);
        if(log.isDebugEnabled()) log.debug("GsopSysParamBusiSVImpl.countGsopSysParam result: {}",JSON.toJSONString(result));
        return result;
    }


    private Map<String,Object> setAtomQueryMap(GsopSysParamQueryRequest src) {
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
