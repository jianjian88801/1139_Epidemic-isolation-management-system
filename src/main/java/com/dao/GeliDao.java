package com.dao;

import com.entity.GeliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GeliView;

/**
 * 隔离 Dao 接口
 *
 * @author 
 */
public interface GeliDao extends BaseMapper<GeliEntity> {

   List<GeliView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
