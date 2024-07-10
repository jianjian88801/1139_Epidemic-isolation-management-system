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
 * 隔离结束申请
 *
 * @author 
 * @email
 */
@TableName("gelishenqing")
public class GelishenqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GelishenqingEntity() {

	}

	public GelishenqingEntity(T t) {
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
     * 隔离结束申请内容
     */
    @TableField(value = "gelishenqing_content")

    private String gelishenqingContent;


    /**
     * 申请状态
     */
    @TableField(value = "gelishenqing_yesno_types")

    private Integer gelishenqingYesnoTypes;


    /**
     * 审核意见
     */
    @TableField(value = "gelishenqing_yesno_text")

    private String gelishenqingYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：隔离结束申请内容
	 */
    public String getGelishenqingContent() {
        return gelishenqingContent;
    }


    /**
	 * 获取：隔离结束申请内容
	 */

    public void setGelishenqingContent(String gelishenqingContent) {
        this.gelishenqingContent = gelishenqingContent;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getGelishenqingYesnoTypes() {
        return gelishenqingYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setGelishenqingYesnoTypes(Integer gelishenqingYesnoTypes) {
        this.gelishenqingYesnoTypes = gelishenqingYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getGelishenqingYesnoText() {
        return gelishenqingYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setGelishenqingYesnoText(String gelishenqingYesnoText) {
        this.gelishenqingYesnoText = gelishenqingYesnoText;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Gelishenqing{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", gelishenqingContent=" + gelishenqingContent +
            ", gelishenqingYesnoTypes=" + gelishenqingYesnoTypes +
            ", gelishenqingYesnoText=" + gelishenqingYesnoText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
