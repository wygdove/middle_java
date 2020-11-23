package com.wygdove.dlock.lock;

import com.wygdove.dlock.constants.CommonConstants;
import com.wygdove.dlock.dao.bo.MethodLockRecord;
import com.wygdove.dlock.service.atom.interfaces.IMethodLockRecordAtomSV;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.Resource;
import org.springframework.util.StringUtils;

/**
 * @Title: DbLock
 * @Description:
 */
public class DbLock implements Lock {

    @Resource
    private IMethodLockRecordAtomSV methodLockRecordAtomSV;
    
    private MethodLockRecord lockRequest;

    public DbLock(MethodLockRecord lockRequest) {
        this.lockRequest=lockRequest;
    }


    @Override
    public void lock() {
        while(true) {
            boolean canLock=tryLock();
            if(canLock) {
                int addResult=methodLockRecordAtomSV.add(lockRequest);
                if(addResult>0) {
                    return;
                }
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        if(StringUtils.isEmpty(lockRequest)) {
            lockRequest.setLockState(CommonConstants.STR_1);
        }
        lockRequest.setLockTime(new Timestamp(System.currentTimeMillis()));
        List<MethodLockRecord> lockRecords=methodLockRecordAtomSV.query(lockRequest);
        return lockRecords.isEmpty();
    }

    @Override
    public boolean tryLock(long time,TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        lockRequest.setLockState(CommonConstants.STR_0);
        lockRequest.setUnlockTime(new Timestamp(System.currentTimeMillis()));
        methodLockRecordAtomSV.updateByMethod(lockRequest);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    
}
