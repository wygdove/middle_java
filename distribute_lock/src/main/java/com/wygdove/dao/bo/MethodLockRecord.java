package com.wygdove.dao.bo;

import java.sql.Timestamp;

/**
 * @Title: MethodLockRecord
 * @Description:
 */
public class MethodLockRecord {
    private String lockId;
    private String methodClass;
    private String methodName;
    private String lockState;
    private Timestamp lockTime;
    private Timestamp unlockTime;
    private String lockThread;
    private String remark;


    public String getLockId() {
        return lockId;
    }

    public void setLockId(String lockId) {
        this.lockId=lockId;
    }

    public String getMethodClass() {
        return methodClass;
    }

    public void setMethodClass(String methodClass) {
        this.methodClass=methodClass;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName=methodName;
    }

    public String getLockState() {
        return lockState;
    }

    public void setLockState(String lockState) {
        this.lockState=lockState;
    }

    public Timestamp getLockTime() {
        return lockTime;
    }

    public void setLockTime(Timestamp lockTime) {
        this.lockTime=lockTime;
    }

    public Timestamp getUnlockTime() {
        return unlockTime;
    }

    public void setUnlockTime(Timestamp unlockTime) {
        this.unlockTime=unlockTime;
    }

    public String getLockThread() {
        return lockThread;
    }

    public void setLockThread(String lockThread) {
        this.lockThread=lockThread;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark=remark;
    }
}
