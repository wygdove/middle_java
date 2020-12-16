package com.wygdove.multiprovince.service.atom.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wygdove.multiprovince.dao.bo.DimAreaGrid;
import com.wygdove.multiprovince.dao.mapper.DimAreaGridMapper;
import com.wygdove.multiprovince.service.atom.interfaces.IDimAreaGridAtomSV;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * @Title: DimAreaGridAtomSVImpl
 * @Description:
 */
@Repository
@ConditionalOnMissingBean(value=IDimAreaGridAtomSV.class,ignored=DimAreaGridAtomSVImpl.class)
public class DimAreaGridAtomSVImpl implements IDimAreaGridAtomSV {
    
    @Resource
    private DimAreaGridMapper dimAreaGridMapper;

    @Override
    public int add(DimAreaGrid request) {
        return dimAreaGridMapper.insert(request);
    }

    @Override
    public int update(DimAreaGrid request) {
        QueryWrapper<DimAreaGrid> updateWrapper=new QueryWrapper<>();
        updateWrapper.lambda().eq(DimAreaGrid::getAreaId,request.getAreaId());
        return dimAreaGridMapper.update(request,updateWrapper);
    }

    @Override
    public DimAreaGrid queryById(DimAreaGrid request) {
        return dimAreaGridMapper.selectById(request.getAreaId());
    }

    @Override
    public List<DimAreaGrid> queryList(DimAreaGrid request) {
        return this.queryList(request,null);
    }

    @Override
    public List<DimAreaGrid> queryList(DimAreaGrid request,Map<String,Object> reqmap) {
        QueryWrapper<DimAreaGrid> queryWrapper=this.getQueryWrapper(request,reqmap);
        return dimAreaGridMapper.selectList(queryWrapper);
    }

    @Override
    public int count(DimAreaGrid request) {
        return this.count(request,null);
    }

    @Override
    public int count(DimAreaGrid request,Map<String,Object> reqmap) {
        QueryWrapper<DimAreaGrid> queryWrapper=this.getQueryWrapper(request,reqmap);
        return dimAreaGridMapper.selectCount(queryWrapper);
    }
    
    
    private QueryWrapper<DimAreaGrid> getQueryWrapper(DimAreaGrid request,Map<String,Object> reqmap) {
        QueryWrapper<DimAreaGrid> queryWrapper=new QueryWrapper<>();
        if(request!=null) {
			if(StringUtils.hasText(request.getAreaId())){queryWrapper.lambda().eq(DimAreaGrid::getAreaId,request.getAreaId());}
			if(StringUtils.hasText(request.getAreaName())){queryWrapper.lambda().eq(DimAreaGrid::getAreaName,request.getAreaName());}
			if(StringUtils.hasText(request.getAreaLevel())){queryWrapper.lambda().eq(DimAreaGrid::getAreaLevel,request.getAreaLevel());}
			if(StringUtils.hasText(request.getAreaType())){queryWrapper.lambda().eq(DimAreaGrid::getAreaType,request.getAreaType());}
			if(StringUtils.hasText(request.getAreaPid())){queryWrapper.lambda().eq(DimAreaGrid::getAreaPid,request.getAreaPid());}

        }
        if(reqmap!=null) {
//            if(reqmap.containsKey("fieldLike")) {
//                String value=(String)reqmap.get("fieldLike");
//                queryWrapper.lambda().like(DimAreaGrid::getField,value);
//            }
//            if(reqmap.containsKey("fieldIn")) {
//                @SuppressWarnings("unchecked")
//                List<String> values=(List<String>)reqmap.get("fieldIn");
//                queryWrapper.lambda().in(DimAreaGrid::getField,values);
//            }
        }
        return queryWrapper;
    }
    
}
