package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GelishenqingEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 隔离结束申请 服务类
 */
public interface GelishenqingService extends IService<GelishenqingEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}