package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.GongyingshangwentiEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 供应商问题
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("gongyingshangwenti")
public class GongyingshangwentiView extends GongyingshangwentiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 供应商问题类型的值
		*/
		private String gongyingshangwentiValue;



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

	public GongyingshangwentiView() {

	}

	public GongyingshangwentiView(GongyingshangwentiEntity gongyingshangwentiEntity) {
		try {
			BeanUtils.copyProperties(this, gongyingshangwentiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 供应商问题类型的值
			*/
			public String getGongyingshangwentiValue() {
				return gongyingshangwentiValue;
			}
			/**
			* 设置： 供应商问题类型的值
			*/
			public void setGongyingshangwentiValue(String gongyingshangwentiValue) {
				this.gongyingshangwentiValue = gongyingshangwentiValue;
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
