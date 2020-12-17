package com.wygdove.multiprovince.service.atom.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wygdove.multiprovince.dao.bo.common.GsopGridSysParam;
import com.wygdove.multiprovince.dao.mapper.common.GsopGridSysParamMapper;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamQueryRequest;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamSaveRequest;
import com.wygdove.multiprovince.model.gsopsysparam.GsopSysParamVO;
import com.wygdove.multiprovince.service.atom.interfaces.IGsopSysParamAtomSV;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * @Title: GsopSysParamAtomSVImpl
 * @Description:
 */
@Repository
@ConditionalOnMissingBean(value=IGsopSysParamAtomSV.class,ignored=GsopSysParamAtomSVImpl.class)
public class GsopSysParamAtomSVImpl implements IGsopSysParamAtomSV {
    
    @Resource
    private GsopGridSysParamMapper gsopGridSysParamMapper;


    @Override
    public int add(GsopSysParamSaveRequest request) {
        GsopGridSysParam gsopGridSysParamRequest=new GsopGridSysParam();
        BeanUtils.copyProperties(request,gsopGridSysParamRequest);
        return gsopGridSysParamMapper.insert(gsopGridSysParamRequest);
    }

    @Override
    public int update(GsopSysParamSaveRequest request) {
        GsopGridSysParam gsopGridSysParamRequest=new GsopGridSysParam();
        BeanUtils.copyProperties(request,gsopGridSysParamRequest);
        QueryWrapper<GsopGridSysParam> updateWrapper=new QueryWrapper<>();
        updateWrapper.lambda().eq(GsopGridSysParam::getGuidkey,request.getGuidkey());
        return gsopGridSysParamMapper.update(gsopGridSysParamRequest,updateWrapper);
    }

    @Override
    public GsopSysParamVO queryById(GsopSysParamQueryRequest request) {
        GsopGridSysParam gsopGridSysParam=gsopGridSysParamMapper.selectById(request.getGuidkey());
        GsopSysParamVO result=new GsopSysParamVO();
        BeanUtils.copyProperties(gsopGridSysParam,result);
        return result;
    }

    @Override
    public List<GsopSysParamVO> queryList(GsopSysParamQueryRequest request) {
        List<GsopSysParamVO> result=new ArrayList<>();
        QueryWrapper<GsopGridSysParam> queryWrapper=this.getQueryWrapper(request);
        List<GsopGridSysParam> resList=gsopGridSysParamMapper.selectList(queryWrapper);
        if(!CollectionUtils.isEmpty(resList)) {
            GsopSysParamVO itemVo=null;
            for(GsopGridSysParam item:resList) {
                itemVo=new GsopSysParamVO();
                BeanUtils.copyProperties(item,itemVo);
                result.add(itemVo);
            }
        }
        return result;
    }

    @Override
    public PageInfo<GsopSysParamVO> queryPage(GsopSysParamQueryRequest request) {
        PageInfo<GsopSysParamVO> pageResult=new PageInfo<>();
        List<GsopSysParamVO> result=new ArrayList<>();

        QueryWrapper<GsopGridSysParam> queryWrapper=this.getQueryWrapper(request);
        List<GsopGridSysParam> resList;
        Page<GsopGridSysParam> pageData;
        PageHelper.startPage(request.getPageNo(),request.getPageSize());
        try {
            resList=gsopGridSysParamMapper.selectList(queryWrapper);
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
        return pageResult;
    }

    @Override
    public int count(GsopSysParamQueryRequest request) {
        QueryWrapper<GsopGridSysParam> queryWrapper=this.getQueryWrapper(request);
        return gsopGridSysParamMapper.selectCount(queryWrapper);
    }


    private QueryWrapper<GsopGridSysParam> getQueryWrapper(GsopSysParamQueryRequest request) {
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


//            if(StringUtils.hasText(request.getFieldLike())) {
//                String value="%"+request.getFieldLike()+"%";
//                queryWrapper.lambda().like(GsopGridSysParam::getField,value);
//            }
//            if(!CollectionUtils.isEmpty(request.getFieldIn())) {
//                queryWrapper.lambda().in(GsopGridSysParam::getField,request.getFieldIn());
//            }
        }
        return queryWrapper;
    }
}
