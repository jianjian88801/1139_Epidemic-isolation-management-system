package com.entity.model;

import com.entity.GongyingshangwentiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 供应商问题
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GongyingshangwentiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 问题名称
     */
    private String gongyingshangwentiName;


    /**
     * 供应商问题类型
     */
    private Integer gongyingshangwentiTypes;


    /**
     * 供应商问题详情
     */
    private String gongyingshangwentiContent;


    /**
     * 增加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 回复内容
     */
    private String huifuContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：问题名称
	 */
    public String getGongyingshangwentiName() {
        return gongyingshangwentiName;
    }


    /**
	 * 设置：问题名称
	 */
    public void setGongyingshangwentiName(String gongyingshangwentiName) {
        this.gongyingshangwentiName = gongyingshangwentiName;
    }
    /**
	 * 获取：供应商问题类型
	 */
    public Integer getGongyingshangwentiTypes() {
        return gongyingshangwentiTypes;
    }


    /**
	 * 设置：供应商问题类型
	 */
    public void setGongyingshangwentiTypes(Integer gongyingshangwentiTypes) {
        this.gongyingshangwentiTypes = gongyingshangwentiTypes;
    }
    /**
	 * 获取：供应商问题详情
	 */
    public String getGongyingshangwentiContent() {
        return gongyingshangwentiContent;
    }


    /**
	 * 设置：供应商问题详情
	 */
    public void setGongyingshangwentiContent(String gongyingshangwentiContent) {
        this.gongyingshangwentiContent = gongyingshangwentiContent;
    }
    /**
	 * 获取：增加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：增加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：回复内容
	 */
    public String getHuifuContent() {
        return huifuContent;
    }


    /**
	 * 设置：回复内容
	 */
    public void setHuifuContent(String huifuContent) {
        this.huifuContent = huifuContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
