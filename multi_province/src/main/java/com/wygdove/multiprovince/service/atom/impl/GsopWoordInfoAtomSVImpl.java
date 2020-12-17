package com.wygdove.multiprovince.service.atom.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.dao.bo.common.GsopWoOrdInfo;
import com.wygdove.multiprovince.dao.mapper.common.GsopWoOrdInfoMapper;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoQueryRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoSaveRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoVO;
import com.wygdove.multiprovince.service.atom.interfaces.IGsopWoordInfoAtomSV;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * @Title: GsopWoordInfoAtomSVImpl
 * @Description:
 */
@Repository
@ConditionalOnMissingBean(value=IGsopWoordInfoAtomSV.class,ignored=GsopWoordInfoAtomSVImpl.class)
public class GsopWoordInfoAtomSVImpl implements IGsopWoordInfoAtomSV {
    
    @Resource
    private GsopWoOrdInfoMapper gsopWoOrdInfoMapper;


    @Override
    public int add(GsopWoordInfoSaveRequest request) {
        GsopWoOrdInfo gsopWoOrdInfoRequest=new GsopWoOrdInfo();
        BeanUtils.copyProperties(request,gsopWoOrdInfoRequest);
        return gsopWoOrdInfoMapper.insert(gsopWoOrdInfoRequest);
    }

    @Override
    public int update(GsopWoordInfoSaveRequest request) {
        GsopWoOrdInfo gsopWoOrdInfoRequest=new GsopWoOrdInfo();
        BeanUtils.copyProperties(request,gsopWoOrdInfoRequest);
        QueryWrapper<GsopWoOrdInfo> updateWrapper=new QueryWrapper<>();
        updateWrapper.lambda().eq(GsopWoOrdInfo::getWoId,request.getWoId());
        return gsopWoOrdInfoMapper.update(gsopWoOrdInfoRequest,updateWrapper);
    }

    @Override
    public GsopWoordInfoVO queryById(GsopWoordInfoQueryRequest request) {
        GsopWoOrdInfo gsopWoOrdInfo=gsopWoOrdInfoMapper.selectById(request.getWoId());
        GsopWoordInfoVO result=new GsopWoordInfoVO();
        BeanUtils.copyProperties(gsopWoOrdInfo,result);
        return result;
    }

    @Override
    public List<GsopWoordInfoVO> queryList(GsopWoordInfoQueryRequest request) {
        List<GsopWoordInfoVO> result=new ArrayList<>();
        QueryWrapper<GsopWoOrdInfo> queryWrapper=this.getQueryWrapper(request);
        List<GsopWoOrdInfo> resList=gsopWoOrdInfoMapper.selectList(queryWrapper);
        if(!CollectionUtils.isEmpty(resList)) {
            GsopWoordInfoVO itemVo=null;
            for(GsopWoOrdInfo item:resList) {
                itemVo=new GsopWoordInfoVO();
                BeanUtils.copyProperties(item,itemVo);
                result.add(itemVo);
            }
        }
        return result;
    }

    @Override
    public PageInfo<GsopWoordInfoVO> queryPage(GsopWoordInfoQueryRequest request) {
        PageInfo<GsopWoordInfoVO> pageResult=new PageInfo<>();
        List<GsopWoordInfoVO> result=new ArrayList<>();

        QueryWrapper<GsopWoOrdInfo> queryWrapper=this.getQueryWrapper(request);
        List<GsopWoOrdInfo> resList;
        Page<GsopWoOrdInfo> pageData;
        PageHelper.startPage(request.getPageNo(),request.getPageSize());
        try {
            resList=gsopWoOrdInfoMapper.selectList(queryWrapper);
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
        return pageResult;
    }

    @Override
    public int count(GsopWoordInfoQueryRequest request) {
        QueryWrapper<GsopWoOrdInfo> queryWrapper=this.getQueryWrapper(request);
        return gsopWoOrdInfoMapper.selectCount(queryWrapper);
    }


    private QueryWrapper<GsopWoOrdInfo> getQueryWrapper(GsopWoordInfoQueryRequest request) {
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


//            if(StringUtils.hasText(request.getFieldLike())) {
//                String value="%"+request.getFieldLike()+"%";
//                queryWrapper.lambda().like(GsopWoOrdInfo::getField,value);
//            }
//            if(!CollectionUtils.isEmpty(request.getFieldIn())) {
//                queryWrapper.lambda().in(GsopWoOrdInfo::getField,request.getFieldIn());
//            }
        }
        return queryWrapper;
    }
}
