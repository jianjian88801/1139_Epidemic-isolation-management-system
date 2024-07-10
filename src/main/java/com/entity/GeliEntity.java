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
 * 隔离
 *
 * @author 
 * @email
 */
@TableName("geli")
public class GeliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GeliEntity() {

	}

	public GeliEntity(T t) {
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
     * 隔离类型
     */
    @TableField(value = "geli_types")

    private Integer geliTypes;


    /**
     * 隔离备注
     */
    @TableField(value = "geli_content")

    private String geliContent;


    /**
     * 隔离时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "geli_time")

    private Date geliTime;


    /**
     * 添加时间
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
	 * 设置：隔离类型
	 */
    public Integer getGeliTypes() {
        return geliTypes;
    }


    /**
	 * 获取：隔离类型
	 */

    public void setGeliTypes(Integer geliTypes) {
        this.geliTypes = geliTypes;
    }
    /**
	 * 设置：隔离备注
	 */
    public String getGeliContent() {
        return geliContent;
    }


    /**
	 * 获取：隔离备注
	 */

    public void setGeliContent(String geliContent) {
        this.geliContent = geliContent;
    }
    /**
	 * 设置：隔离时间
	 */
    public Date getGeliTime() {
        return geliTime;
    }


    /**
	 * 获取：隔离时间
	 */

    public void setGeliTime(Date geliTime) {
        this.geliTime = geliTime;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
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
        return "Geli{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", geliTypes=" + geliTypes +
            ", geliContent=" + geliContent +
            ", geliTime=" + geliTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
