package com.wygdove.dlock.utils;

import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
import org.springframework.stereotype.Component;

/**
 * @Title: SeqUtil
 * @Description:
 */
@Component
public class SeqUtil {

    @Resource
    private DataSource dataSource;


    public Integer getNextIntegerValue(String sequenceName) {
        OracleSequenceMaxValueIncrementer sequenceIncrementer=new OracleSequenceMaxValueIncrementer(dataSource,sequenceName);
        return sequenceIncrementer.nextIntValue();
    }

    public Long getNextLongValue(String sequenceName) {
        OracleSequenceMaxValueIncrementer sequenceIncrementer=new OracleSequenceMaxValueIncrementer(dataSource,sequenceName);
        return sequenceIncrementer.nextLongValue();
    }

    public String getNextStringValue(String sequenceName) {
        OracleSequenceMaxValueIncrementer sequenceIncrementer=new OracleSequenceMaxValueIncrementer(dataSource,sequenceName);
        return sequenceIncrementer.nextStringValue();
    }


}
