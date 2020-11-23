package com.wygdove.dlock.service.atom.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wygdove.dlock.dao.bo.MethodLockRecord;
import com.wygdove.dlock.dao.mapper.MethodLockRecordMapper;
import com.wygdove.dlock.service.atom.interfaces.IMethodLockRecordAtomSV;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Title: MethodLockRecordAtomSVImpl
 * @Description:
 */
@Component
public class MethodLockRecordAtomSVImpl implements IMethodLockRecordAtomSV {

    @Resource
    private MethodLockRecordMapper methodLockRecordMapper;


    @Override
    public int add(MethodLockRecord request) {
        return methodLockRecordMapper.insert(request);
    }

    @Override
    public int update(MethodLockRecord request) {
        return methodLockRecordMapper.updateById(request);
    }

    @Override
    public int updateByMethod(MethodLockRecord request) {
        QueryWrapper<MethodLockRecord> updateWrapper=new QueryWrapper<>();
        updateWrapper.lambda().eq(MethodLockRecord::getMethodClass,request.getMethodClass());
        updateWrapper.lambda().eq(MethodLockRecord::getMethodName,request.getMethodName());
        return methodLockRecordMapper.update(request,updateWrapper);
    }

    @Override
    public List<MethodLockRecord> query(MethodLockRecord request) {
        if(request==null) {
            request=new MethodLockRecord();
        }
        QueryWrapper<MethodLockRecord> queryWrapper=new QueryWrapper<>();
        if(StringUtils.hasText(request.getLockId())) {
            queryWrapper.lambda().eq(MethodLockRecord::getLockId,request.getLockId());
        }
        if(StringUtils.hasText(request.getMethodClass())) {
            queryWrapper.lambda().eq(MethodLockRecord::getMethodClass,request.getMethodClass());
        }
        if(StringUtils.hasText(request.getMethodName())) {
            queryWrapper.lambda().eq(MethodLockRecord::getMethodName,request.getMethodName());
        }
        if(StringUtils.hasText(request.getLockState())) {
            queryWrapper.lambda().eq(MethodLockRecord::getLockState,request.getLockState());
        }
        return methodLockRecordMapper.selectList(queryWrapper);
    }
}
