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
 * 行程
 *
 * @author 
 * @email
 */
@TableName("xingcheng")
public class XingchengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XingchengEntity() {

	}

	public XingchengEntity(T t) {
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
     * 地区
     */
    @TableField(value = "diqu_id")

    private Integer diquId;


    /**
     * 行程备注
     */
    @TableField(value = "xingcheng_content")

    private String xingchengContent;


    /**
     * 经过时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "jingguo_time")

    private Date jingguoTime;


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
	 * 设置：地区
	 */
    public Integer getDiquId() {
        return diquId;
    }


    /**
	 * 获取：地区
	 */

    public void setDiquId(Integer diquId) {
        this.diquId = diquId;
    }
    /**
	 * 设置：行程备注
	 */
    public String getXingchengContent() {
        return xingchengContent;
    }


    /**
	 * 获取：行程备注
	 */

    public void setXingchengContent(String xingchengContent) {
        this.xingchengContent = xingchengContent;
    }
    /**
	 * 设置：经过时间
	 */
    public Date getJingguoTime() {
        return jingguoTime;
    }


    /**
	 * 获取：经过时间
	 */

    public void setJingguoTime(Date jingguoTime) {
        this.jingguoTime = jingguoTime;
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
        return "Xingcheng{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", diquId=" + diquId +
            ", xingchengContent=" + xingchengContent +
            ", jingguoTime=" + jingguoTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
