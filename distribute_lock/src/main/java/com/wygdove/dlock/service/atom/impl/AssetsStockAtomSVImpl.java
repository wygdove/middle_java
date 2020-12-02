package com.wygdove.dlock.service.atom.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wygdove.dlock.dao.bo.AssetsStock;
import com.wygdove.dlock.dao.mapper.AssetsStockMapper;
import com.wygdove.dlock.service.atom.interfaces.IAssetsStockAtomSV;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * @Title: AssetsStockAtomSVImpl
 * @Description:
 */
@Repository
public class AssetsStockAtomSVImpl implements IAssetsStockAtomSV {
    
    @Resource
    private AssetsStockMapper assetsStockMapper;

    @Override
    public int add(AssetsStock request) {
        return assetsStockMapper.insert(request);
    }

    @Override
    public int update(AssetsStock request) {
        QueryWrapper<AssetsStock> updateWrapper=new QueryWrapper<>();
        updateWrapper.lambda().eq(AssetsStock::getStockId,request.getStockId());
        return assetsStockMapper.update(request,updateWrapper);
    }

    @Override
    public AssetsStock queryById(AssetsStock request) {
        return assetsStockMapper.selectById(request.getStockId());
    }

    @Override
    public List<AssetsStock> queryList(AssetsStock request) {
        return this.queryList(request,null);
    }

    @Override
    public List<AssetsStock> queryList(AssetsStock request,Map<String,Object> reqmap) {
        QueryWrapper<AssetsStock> queryWrapper=this.getQueryWrapper(request,reqmap);
        return assetsStockMapper.selectList(queryWrapper);
    }

    @Override
    public int count(AssetsStock request) {
        return this.count(request,null);
    }

    @Override
    public int count(AssetsStock request,Map<String,Object> reqmap) {
        QueryWrapper<AssetsStock> queryWrapper=this.getQueryWrapper(request,reqmap);
        return assetsStockMapper.selectCount(queryWrapper);
    }
    
    
    private QueryWrapper<AssetsStock> getQueryWrapper(AssetsStock request,Map<String,Object> reqmap) {
        QueryWrapper<AssetsStock> queryWrapper=new QueryWrapper<>();
        if(request!=null) {
            if(!Objects.isNull(request.getStockId())&&request.getStockId()>0) {
                queryWrapper.lambda().eq(AssetsStock::getStockId,request.getStockId());
            }
            if(StringUtils.hasText(request.getCategoryCode())) {
                queryWrapper.lambda().eq(AssetsStock::getCategoryCode,request.getCategoryCode());
            }
            if(StringUtils.hasText(request.getAssetsCode())) {
                queryWrapper.lambda().eq(AssetsStock::getAssetsCode,request.getAssetsCode());
            }
            if(!Objects.isNull(request.getStockinDate())) {
                queryWrapper.lambda().eq(AssetsStock::getStockinDate,request.getStockinDate());
            }
        }
        if(reqmap!=null) {
            if(reqmap.containsKey("assetsCodeLike")) {
                String value=(String)reqmap.get("assetsCodeLike");
                queryWrapper.lambda().like(AssetsStock::getAssetsCode,value);
            }
            if(reqmap.containsKey("assetsCodeIn")) {
                @SuppressWarnings("unchecked")
                List<String> values=(List<String>)reqmap.get("assetsCodeIn");
                queryWrapper.lambda().in(AssetsStock::getAssetsCode,values);
            }
        }
        return queryWrapper;
    }
    
}
