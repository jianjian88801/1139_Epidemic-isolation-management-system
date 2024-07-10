package com.dao;

import com.entity.WupinShenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WupinShenqingView;

/**
 * 物品申请 Dao 接口
 *
 * @author 
 */
public interface WupinShenqingDao extends BaseMapper<WupinShenqingEntity> {

   List<WupinShenqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
