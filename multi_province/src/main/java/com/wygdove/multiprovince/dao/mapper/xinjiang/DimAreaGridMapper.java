package com.wygdove.multiprovince.dao.mapper.xinjiang;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wygdove.multiprovince.constants.ProvinceConstants;
import com.wygdove.multiprovince.dao.bo.xinjiang.DimAreaGrid;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * @Title: DimAreaGridMapper
 * @Description:
 */
@ConditionalOnProperty(name=ProvinceConstants.PROVINCE,havingValue=ProvinceConstants.XINJIANG)
public interface DimAreaGridMapper extends BaseMapper<DimAreaGrid> {
}
