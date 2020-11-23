package com.wygdove.dlock.service.atom.interfaces;

import com.wygdove.dlock.dao.bo.MethodLockRecord;
import java.util.List;

/**
 * @Title: IMethodLockRecordAtomSV
 * @Description:
 */
public interface IMethodLockRecordAtomSV {
    public int add(MethodLockRecord request);
    public int update(MethodLockRecord request);
    public int updateByMethod(MethodLockRecord request);
    public List<MethodLockRecord> query(MethodLockRecord request);
}
