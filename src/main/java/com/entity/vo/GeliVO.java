package com.entity.vo;

import com.entity.GeliEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 隔离
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("geli")
public class GeliVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
