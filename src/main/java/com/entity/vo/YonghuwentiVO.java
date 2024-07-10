package com.entity.vo;

import com.entity.YonghuwentiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 用户问题
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yonghuwenti")
public class YonghuwentiVO implements Serializable {
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

    @TableField(value = "insert_time")
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

}
