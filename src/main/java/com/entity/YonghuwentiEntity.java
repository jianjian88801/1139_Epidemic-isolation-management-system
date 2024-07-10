package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 用户问题
 *
 * @author 
 * @email
 */
@TableName("yonghuwenti")
public class YonghuwentiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YonghuwentiEntity() {

	}

	public YonghuwentiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 问题名称
     */
    @TableField(value = "yonghuwenti_name")

    private String yonghuwentiName;


    /**
     * 用户问题类型
     */
    @TableField(value = "yonghuwenti_types")

    private Integer yonghuwentiTypes;


    /**
     * 用户问题详情
     */
    @TableField(value = "yonghuwenti_content")

    private String yonghuwentiContent;


    /**
     * 增加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 回复内容
     */
    @TableField(value = "huifu_content")

    private String huifuContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：问题名称
	 */
    public String getYonghuwentiName() {
        return yonghuwentiName;
    }


    /**
	 * 获取：问题名称
	 */

    public void setYonghuwentiName(String yonghuwentiName) {
        this.yonghuwentiName = yonghuwentiName;
    }
    /**
	 * 设置：用户问题类型
	 */
    public Integer getYonghuwentiTypes() {
        return yonghuwentiTypes;
    }


    /**
	 * 获取：用户问题类型
	 */

    public void setYonghuwentiTypes(Integer yonghuwentiTypes) {
        this.yonghuwentiTypes = yonghuwentiTypes;
    }
    /**
	 * 设置：用户问题详情
	 */
    public String getYonghuwentiContent() {
        return yonghuwentiContent;
    }


    /**
	 * 获取：用户问题详情
	 */

    public void setYonghuwentiContent(String yonghuwentiContent) {
        this.yonghuwentiContent = yonghuwentiContent;
    }
    /**
	 * 设置：增加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：增加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：回复内容
	 */
    public String getHuifuContent() {
        return huifuContent;
    }


    /**
	 * 获取：回复内容
	 */

    public void setHuifuContent(String huifuContent) {
        this.huifuContent = huifuContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Yonghuwenti{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", yonghuwentiName=" + yonghuwentiName +
            ", yonghuwentiTypes=" + yonghuwentiTypes +
            ", yonghuwentiContent=" + yonghuwentiContent +
            ", insertTime=" + insertTime +
            ", huifuContent=" + huifuContent +
            ", createTime=" + createTime +
        "}";
    }
}
