package com.dao;

import com.entity.DiquEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DiquView;

/**
 * 地区 Dao 接口
 *
 * @author 
 */
public interface DiquDao extends BaseMapper<DiquEntity> {

   List<DiquView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
