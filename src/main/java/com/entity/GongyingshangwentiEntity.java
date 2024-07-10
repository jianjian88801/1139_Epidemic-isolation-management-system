package com.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * 供应商问题
 *
 * @author 
 * @email
 */
@TableName("gongyingshangwenti")
public class GongyingshangwentiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongyingshangwentiEntity() {

	}

	public GongyingshangwentiEntity(T t) {
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
     * 供应商
     */
    @TableField(value = "gongyingshang_id")

    private Integer gongyingshangId;


    /**
     * 问题名称
     */
    @TableField(value = "gongyingshangwenti_name")

    private String gongyingshangwentiName;


    /**
     * 供应商问题类型
     */
    @TableField(value = "gongyingshangwenti_types")

    private Integer gongyingshangwentiTypes;


    /**
     * 供应商问题详情
     */
    @TableField(value = "gongyingshangwenti_content")

    private String gongyingshangwentiContent;


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
	 * 设置：供应商
	 */
    public Integer getGongyingshangId() {
        return gongyingshangId;
    }


    /**
	 * 获取：供应商
	 */

    public void setGongyingshangId(Integer gongyingshangId) {
        this.gongyingshangId = gongyingshangId;
    }
    /**
	 * 设置：问题名称
	 */
    public String getGongyingshangwentiName() {
        return gongyingshangwentiName;
    }


    /**
	 * 获取：问题名称
	 */

    public void setGongyingshangwentiName(String gongyingshangwentiName) {
        this.gongyingshangwentiName = gongyingshangwentiName;
    }
    /**
	 * 设置：供应商问题类型
	 */
    public Integer getGongyingshangwentiTypes() {
        return gongyingshangwentiTypes;
    }


    /**
	 * 获取：供应商问题类型
	 */

    public void setGongyingshangwentiTypes(Integer gongyingshangwentiTypes) {
        this.gongyingshangwentiTypes = gongyingshangwentiTypes;
    }
    /**
	 * 设置：供应商问题详情
	 */
    public String getGongyingshangwentiContent() {
        return gongyingshangwentiContent;
    }


    /**
	 * 获取：供应商问题详情
	 */

    public void setGongyingshangwentiContent(String gongyingshangwentiContent) {
        this.gongyingshangwentiContent = gongyingshangwentiContent;
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
        return "Gongyingshangwenti{" +
            "id=" + id +
            ", gongyingshangId=" + gongyingshangId +
            ", gongyingshangwentiName=" + gongyingshangwentiName +
            ", gongyingshangwentiTypes=" + gongyingshangwentiTypes +
            ", gongyingshangwentiContent=" + gongyingshangwentiContent +
            ", insertTime=" + insertTime +
            ", huifuContent=" + huifuContent +
            ", createTime=" + createTime +
        "}";
    }
}
