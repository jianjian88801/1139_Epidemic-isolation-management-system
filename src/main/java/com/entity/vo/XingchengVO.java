package com.entity.vo;

import com.entity.XingchengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 行程
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xingcheng")
public class XingchengVO implements Serializable {
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

}
