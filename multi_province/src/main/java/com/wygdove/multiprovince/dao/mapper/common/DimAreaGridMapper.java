package com.wygdove.multiprovince.dao.mapper.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wygdove.multiprovince.dao.bo.common.DimAreaGrid;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

/**
 * @Title: DimAreaGridMapper
 * @Description:
 */
@ConditionalOnMissingBean(value=BaseMapper.class,ignored=DimAreaGridMapper.class)
public interface DimAreaGridMapper extends BaseMapper<DimAreaGrid> {
}
