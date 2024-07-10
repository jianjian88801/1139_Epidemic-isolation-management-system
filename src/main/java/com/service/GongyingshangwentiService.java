package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.GongyingshangwentiEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 供应商问题 服务类
 */
public interface GongyingshangwentiService extends IService<GongyingshangwentiEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}