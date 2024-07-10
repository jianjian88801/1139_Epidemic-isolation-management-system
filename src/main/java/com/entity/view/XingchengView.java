package com.entity.view;

import com.entity.XingchengEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 行程
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xingcheng")
public class XingchengView extends XingchengEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 diqu
			/**
			* 地区名称
			*/
			private String diquName;
			/**
			* 风险等级
			*/
			private Integer diquTypes;
				/**
				* 风险等级的值
				*/
				private String diquValue;
			/**
			* 地区详情
			*/
			private String diquContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public XingchengView() {

	}

	public XingchengView(XingchengEntity xingchengEntity) {
		try {
			BeanUtils.copyProperties(this, xingchengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}











				//级联表的get和set diqu
					/**
					* 获取： 地区名称
					*/
					public String getDiquName() {
						return diquName;
					}
					/**
					* 设置： 地区名称
					*/
					public void setDiquName(String diquName) {
						this.diquName = diquName;
					}
					/**
					* 获取： 风险等级
					*/
					public Integer getDiquTypes() {
						return diquTypes;
					}
					/**
					* 设置： 风险等级
					*/
					public void setDiquTypes(Integer diquTypes) {
						this.diquTypes = diquTypes;
					}


						/**
						* 获取： 风险等级的值
						*/
						public String getDiquValue() {
							return diquValue;
						}
						/**
						* 设置： 风险等级的值
						*/
						public void setDiquValue(String diquValue) {
							this.diquValue = diquValue;
						}
					/**
					* 获取： 地区详情
					*/
					public String getDiquContent() {
						return diquContent;
					}
					/**
					* 设置： 地区详情
					*/
					public void setDiquContent(String diquContent) {
						this.diquContent = diquContent;
					}























				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}







}
