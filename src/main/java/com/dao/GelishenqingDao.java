package com.dao;

import com.entity.GelishenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GelishenqingView;

/**
 * 隔离结束申请 Dao 接口
 *
 * @author 
 */
public interface GelishenqingDao extends BaseMapper<GelishenqingEntity> {

   List<GelishenqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
