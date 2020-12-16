package com.wygdove.multiprovince.service.atom.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wygdove.multiprovince.dao.bo.GsopGridSysParam;
import com.wygdove.multiprovince.dao.mapper.GsopGridSysParamMapper;
import com.wygdove.multiprovince.service.atom.interfaces.IGsopSysParamAtomSV;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * @Title: GsopSysParamAtomSVImpl
 * @Description:
 */
@Repository
@ConditionalOnMissingBean(value=IGsopSysParamAtomSV.class,ignored=GsopSysParamAtomSVImpl.class)
public class GsopSysParamAtomSVImpl implements IGsopSysParamAtomSV {
    private static Logger log=LoggerFactory.getLogger(GsopSysParamAtomSVImpl.class);
    
    @Resource
    private GsopGridSysParamMapper gsopGridSysParamMapper;

    @Override
    public int add(GsopGridSysParam request) {
        log.debug("GsopSysParamAtomSVImpl.add");
        return gsopGridSysParamMapper.insert(request);
    }

    @Override
    public int update(GsopGridSysParam request) {
        log.debug("GsopSysParamAtomSVImpl.update");
        QueryWrapper<GsopGridSysParam> updateWrapper=new QueryWrapper<>();
        updateWrapper.lambda().eq(GsopGridSysParam::getGuidkey,request.getGuidkey());
        return gsopGridSysParamMapper.update(request,updateWrapper);
    }

    @Override
    public GsopGridSysParam queryById(GsopGridSysParam request) {
        log.debug("GsopSysParamAtomSVImpl.queryById");
        return gsopGridSysParamMapper.selectById(request.getGuidkey());
    }

    @Override
    public List<GsopGridSysParam> queryList(GsopGridSysParam request) {
        log.debug("GsopSysParamAtomSVImpl.queryList");
        return this.queryList(request,null);
    }

    @Override
    public List<GsopGridSysParam> queryList(GsopGridSysParam request,Map<String,Object> reqmap) {
        log.debug("GsopSysParamAtomSVImpl.queryList");
        QueryWrapper<GsopGridSysParam> queryWrapper=this.getQueryWrapper(request,reqmap);
        return gsopGridSysParamMapper.selectList(queryWrapper);
    }

    @Override
    public int count(GsopGridSysParam request) {
        log.debug("GsopSysParamAtomSVImpl.count");
        return this.count(request,null);
    }

    @Override
    public int count(GsopGridSysParam request,Map<String,Object> reqmap) {
        log.debug("GsopSysParamAtomSVImpl.count");
        QueryWrapper<GsopGridSysParam> queryWrapper=this.getQueryWrapper(request,reqmap);
        return gsopGridSysParamMapper.selectCount(queryWrapper);
    }
    
    
    private QueryWrapper<GsopGridSysParam> getQueryWrapper(GsopGridSysParam request,Map<String,Object> reqmap) {
        QueryWrapper<GsopGridSysParam> queryWrapper=new QueryWrapper<>();
        if(request!=null) {
			if(StringUtils.hasText(request.getGuidkey())){queryWrapper.lambda().eq(GsopGridSysParam::getGuidkey,request.getGuidkey());}
			if(StringUtils.hasText(request.getTypeCode())){queryWrapper.lambda().eq(GsopGridSysParam::getTypeCode,request.getTypeCode());}
			if(StringUtils.hasText(request.getParamCode())){queryWrapper.lambda().eq(GsopGridSysParam::getParamCode,request.getParamCode());}
			if(StringUtils.hasText(request.getSubParamCode())){queryWrapper.lambda().eq(GsopGridSysParam::getSubParamCode,request.getSubParamCode());}
			if(StringUtils.hasText(request.getColumnValue())){queryWrapper.lambda().eq(GsopGridSysParam::getColumnValue,request.getColumnValue());}
			if(StringUtils.hasText(request.getColumnDesc())){queryWrapper.lambda().eq(GsopGridSysParam::getColumnDesc,request.getColumnDesc());}
			if(request.getDispord()!=null&&request.getDispord()>0){queryWrapper.lambda().eq(GsopGridSysParam::getDispord,request.getDispord());}
			if(StringUtils.hasText(request.getDescb())){queryWrapper.lambda().eq(GsopGridSysParam::getDescb,request.getDescb());}
			if(StringUtils.hasText(request.getState())){queryWrapper.lambda().eq(GsopGridSysParam::getState,request.getState());}

        }
        if(reqmap!=null) {
//            if(reqmap.containsKey("fieldLike")) {
//                String value=(String)reqmap.get("fieldLike");
//                queryWrapper.lambda().like(GsopGridSysParam::getField,value);
//            }
//            if(reqmap.containsKey("fieldIn")) {
//                @SuppressWarnings("unchecked")
//                List<String> values=(List<String>)reqmap.get("fieldIn");
//                queryWrapper.lambda().in(GsopGridSysParam::getField,values);
//            }
        }
        return queryWrapper;
    }
    
}
