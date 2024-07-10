package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.GongyingshangwentiEntity;
import com.entity.view.GongyingshangwentiView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 供应商问题 Dao 接口
 *
 * @author 
 */
public interface GongyingshangwentiDao extends BaseMapper<GongyingshangwentiEntity> {

   List<GongyingshangwentiView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
