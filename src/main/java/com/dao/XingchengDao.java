package com.dao;

import com.entity.XingchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XingchengView;

/**
 * 行程 Dao 接口
 *
 * @author 
 */
public interface XingchengDao extends BaseMapper<XingchengEntity> {

   List<XingchengView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
