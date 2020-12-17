package com.wygdove.multiprovince.service.atom.interfaces;

import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoQueryRequest;
import com.wygdove.multiprovince.model.gsopwoordinfo.GsopWoordInfoVO;
import java.util.List;

/**
 * @Title: IGsopWorkerOrderAtomSV
 * @Description:
 */
public interface IGsopWorkerOrderAtomSV {
    List<GsopWoordInfoVO> getWoordListByType(GsopWoordInfoQueryRequest request);
}
