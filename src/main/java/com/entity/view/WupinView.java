package com.entity.view;

import com.entity.WupinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 物品
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("wupin")
public class WupinView extends WupinEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 物品类型的值
		*/
		private String wupinValue;



		//级联表 gongyingshang
			/**
			* 供应商名称
			*/
			private String gongyingshangName;
			/**
			* 供应商地址
			*/
			private String gongyingshangAddress;
			/**
			* 供应商介绍
			*/
			private String diquContent;

	public WupinView() {

	}

	public WupinView(WupinEntity wupinEntity) {
		try {
			BeanUtils.copyProperties(this, wupinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 物品类型的值
			*/
			public String getWupinValue() {
				return wupinValue;
			}
			/**
			* 设置： 物品类型的值
			*/
			public void setWupinValue(String wupinValue) {
				this.wupinValue = wupinValue;
			}












				//级联表的get和set gongyingshang
					/**
					* 获取： 供应商名称
					*/
					public String getGongyingshangName() {
						return gongyingshangName;
					}
					/**
					* 设置： 供应商名称
					*/
					public void setGongyingshangName(String gongyingshangName) {
						this.gongyingshangName = gongyingshangName;
					}
					/**
					* 获取： 供应商地址
					*/
					public String getGongyingshangAddress() {
						return gongyingshangAddress;
					}
					/**
					* 设置： 供应商地址
					*/
					public void setGongyingshangAddress(String gongyingshangAddress) {
						this.gongyingshangAddress = gongyingshangAddress;
					}
					/**
					* 获取： 供应商介绍
					*/
					public String getDiquContent() {
						return diquContent;
					}
					/**
					* 设置： 供应商介绍
					*/
					public void setDiquContent(String diquContent) {
						this.diquContent = diquContent;
					}














}
