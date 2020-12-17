package com.wygdove.multiprovince.service.atom.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridQueryRequest;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridSaveRequest;
import com.wygdove.multiprovince.model.dimareagrid.DimAreaGridVO;
import com.wygdove.multiprovince.service.atom.interfaces.IDimAreaGridAtomSV;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.wygdove.multiprovince.dao.bo.common.DimAreaGrid;
import com.wygdove.multiprovince.dao.mapper.common.DimAreaGridMapper;

/**
 * @Title: DimAreaGridAtomSVImpl
 * @Description:
 */
@Repository
@ConditionalOnMissingBean(value=IDimAreaGridAtomSV.class,ignored=DimAreaGridAtomSVImpl.class)
public class DimAreaGridAtomSVImpl implements IDimAreaGridAtomSV {
    private static Logger log=LoggerFactory.getLogger(DimAreaGridAtomSVImpl.class);
    
    @Resource
    private DimAreaGridMapper dimAreaGridMapper;


    @Override
    public int add(DimAreaGridSaveRequest request) {
        log.debug("DimAreaGridAtomSVImpl.add");
        DimAreaGrid dimAreaGridRequest=new DimAreaGrid();
        BeanUtils.copyProperties(request,dimAreaGridRequest);
        return dimAreaGridMapper.insert(dimAreaGridRequest);
    }

    @Override
    public int update(DimAreaGridSaveRequest request) {
        log.debug("DimAreaGridAtomSVImpl.update");
        DimAreaGrid dimAreaGridRequest=new DimAreaGrid();
        BeanUtils.copyProperties(request,dimAreaGridRequest);
        QueryWrapper<DimAreaGrid> updateWrapper=new QueryWrapper<>();
        updateWrapper.lambda().eq(DimAreaGrid::getAreaId,request.getAreaId());
        return dimAreaGridMapper.update(dimAreaGridRequest,updateWrapper);
    }

    @Override
    public DimAreaGridVO queryById(DimAreaGridQueryRequest request) {
        log.debug("DimAreaGridAtomSVImpl.queryById");
        DimAreaGrid dimAreaGrid=dimAreaGridMapper.selectById(request.getAreaId());
        DimAreaGridVO result=new DimAreaGridVO();
        BeanUtils.copyProperties(dimAreaGrid,result);
        return result;
    }

    @Override
    public List<DimAreaGridVO> queryList(DimAreaGridQueryRequest request) {
        log.debug("DimAreaGridAtomSVImpl.queryList");
        List<DimAreaGridVO> result=new ArrayList<>();
        QueryWrapper<DimAreaGrid> queryWrapper=this.getQueryWrapper(request);
        List<DimAreaGrid> resList=dimAreaGridMapper.selectList(queryWrapper);
        if(!CollectionUtils.isEmpty(resList)) {
            DimAreaGridVO itemVo=null;
            for(DimAreaGrid item:resList) {
                itemVo=new DimAreaGridVO();
                BeanUtils.copyProperties(item,itemVo);
                result.add(itemVo);
            }
        }
        return result;
    }

    @Override
    public PageInfo<DimAreaGridVO> queryPage(DimAreaGridQueryRequest request) {
        log.debug("DimAreaGridAtomSVImpl.queryPage");
        PageInfo<DimAreaGridVO> pageResult=new PageInfo<>();
        List<DimAreaGridVO> result=new ArrayList<>();

        QueryWrapper<DimAreaGrid> queryWrapper=this.getQueryWrapper(request);
        List<DimAreaGrid> resList;
        Page<DimAreaGrid> pageData;
        PageHelper.startPage(request.getPageNo(),request.getPageSize());
        try {
            resList=dimAreaGridMapper.selectList(queryWrapper);
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
        return pageResult;
    }

    @Override
    public int count(DimAreaGridQueryRequest request) {
        log.debug("DimAreaGridAtomSVImpl.count");
        QueryWrapper<DimAreaGrid> queryWrapper=this.getQueryWrapper(request);
        return dimAreaGridMapper.selectCount(queryWrapper);
    }


    private QueryWrapper<DimAreaGrid> getQueryWrapper(DimAreaGridQueryRequest request) {
        QueryWrapper<DimAreaGrid> queryWrapper=new QueryWrapper<>();
        if(request!=null) {
            if(StringUtils.hasText(request.getAreaId())){queryWrapper.lambda().eq(DimAreaGrid::getAreaId,request.getAreaId());}
            if(StringUtils.hasText(request.getAreaName())){queryWrapper.lambda().eq(DimAreaGrid::getAreaName,request.getAreaName());}
            if(StringUtils.hasText(request.getAreaLevel())){queryWrapper.lambda().eq(DimAreaGrid::getAreaLevel,request.getAreaLevel());}
            if(StringUtils.hasText(request.getAreaType())){queryWrapper.lambda().eq(DimAreaGrid::getAreaType,request.getAreaType());}
            if(StringUtils.hasText(request.getAreaPid())){queryWrapper.lambda().eq(DimAreaGrid::getAreaPid,request.getAreaPid());}

//            if(StringUtils.hasText(request.getFieldLike())) {
//                String value="%"+request.getFieldLike()+"%";
//                queryWrapper.lambda().like(DimAreaGrid::getField,value);
//            }
//            if(!CollectionUtils.isEmpty(request.getFieldIn())) {
//                queryWrapper.lambda().in(DimAreaGrid::getField,request.getFieldIn());
//            }
        }
        return queryWrapper;
    }
}
