package com.wygdove.multiprovince.service.atom.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wygdove.multiprovince.dao.bo.GsopWoOrdInfo;
import com.wygdove.multiprovince.dao.mapper.GsopWoOrdInfoMapper;
import com.wygdove.multiprovince.service.atom.interfaces.IGsopWoordInfoAtomSV;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * @Title: GsopWoordInfoAtomSVImpl
 * @Description:
 */
@Repository
public class GsopWoordInfoAtomSVImpl implements IGsopWoordInfoAtomSV {
    
    @Resource
    private GsopWoOrdInfoMapper gsopWoOrdInfoMapper;

    @Override
    public int add(GsopWoOrdInfo request) {
        return gsopWoOrdInfoMapper.insert(request);
    }

    @Override
    public int update(GsopWoOrdInfo request) {
        QueryWrapper<GsopWoOrdInfo> updateWrapper=new QueryWrapper<>();
        updateWrapper.lambda().eq(GsopWoOrdInfo::getWoId,request.getWoId());
        return gsopWoOrdInfoMapper.update(request,updateWrapper);
    }

    @Override
    public GsopWoOrdInfo queryById(GsopWoOrdInfo request) {
        return gsopWoOrdInfoMapper.selectById(request.getWoId());
    }

    @Override
    public List<GsopWoOrdInfo> queryList(GsopWoOrdInfo request) {
        return this.queryList(request,null);
    }

    @Override
    public List<GsopWoOrdInfo> queryList(GsopWoOrdInfo request,Map<String,Object> reqmap) {
        QueryWrapper<GsopWoOrdInfo> queryWrapper=this.getQueryWrapper(request,reqmap);
        return gsopWoOrdInfoMapper.selectList(queryWrapper);
    }

    @Override
    public int count(GsopWoOrdInfo request) {
        return this.count(request,null);
    }

    @Override
    public int count(GsopWoOrdInfo request,Map<String,Object> reqmap) {
        QueryWrapper<GsopWoOrdInfo> queryWrapper=this.getQueryWrapper(request,reqmap);
        return gsopWoOrdInfoMapper.selectCount(queryWrapper);
    }
    
    
    private QueryWrapper<GsopWoOrdInfo> getQueryWrapper(GsopWoOrdInfo request,Map<String,Object> reqmap) {
        QueryWrapper<GsopWoOrdInfo> queryWrapper=new QueryWrapper<>();
        if(request!=null) {
			if(request.getWoId()!=null&&request.getWoId()>0){queryWrapper.lambda().eq(GsopWoOrdInfo::getWoId,request.getWoId());}
			if(StringUtils.hasText(request.getProcInstId())){queryWrapper.lambda().eq(GsopWoOrdInfo::getProcInstId,request.getProcInstId());}
			if(request.getAssociationId()!=null&&request.getAssociationId()>0){queryWrapper.lambda().eq(GsopWoOrdInfo::getAssociationId,request.getAssociationId());}
			if(StringUtils.hasText(request.getWoCode())){queryWrapper.lambda().eq(GsopWoOrdInfo::getWoCode,request.getWoCode());}
			if(StringUtils.hasText(request.getWoTitle())){queryWrapper.lambda().eq(GsopWoOrdInfo::getWoTitle,request.getWoTitle());}
			if(StringUtils.hasText(request.getWoBigType())){queryWrapper.lambda().eq(GsopWoOrdInfo::getWoBigType,request.getWoBigType());}
			if(StringUtils.hasText(request.getWoType())){queryWrapper.lambda().eq(GsopWoOrdInfo::getWoType,request.getWoType());}
			if(StringUtils.hasText(request.getWoFirstType())){queryWrapper.lambda().eq(GsopWoOrdInfo::getWoFirstType,request.getWoFirstType());}
			if(StringUtils.hasText(request.getWoSecondType())){queryWrapper.lambda().eq(GsopWoOrdInfo::getWoSecondType,request.getWoSecondType());}

        }
        if(reqmap!=null) {
//            if(reqmap.containsKey("fieldLike")) {
//                String value=(String)reqmap.get("fieldLike");
//                queryWrapper.lambda().like(GsopWoOrdInfo::getField,value);
//            }
//            if(reqmap.containsKey("fieldIn")) {
//                @SuppressWarnings("unchecked")
//                List<String> values=(List<String>)reqmap.get("fieldIn");
//                queryWrapper.lambda().in(GsopWoOrdInfo::getField,values);
//            }
        }
        return queryWrapper;
    }
    
}
