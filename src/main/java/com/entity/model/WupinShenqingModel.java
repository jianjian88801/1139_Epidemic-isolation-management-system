package com.entity.model;

import com.entity.WupinShenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物品申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WupinShenqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 申请流水号
     */
    private String wupinShenqingUuidNumber;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 物品
     */
    private Integer wupinId;


    /**
     * 申请数量
     */
    private Integer wupinShenqingNumber;


    /**
     * 申请详情
     */
    private String wupinContent;


    /**
     * 申请状态
     */
    private Integer wupinShenqingYesnoTypes;


    /**
     * 审核意见
     */
    private String wupinShenqingYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：申请流水号
	 */
    public String getWupinShenqingUuidNumber() {
        return wupinShenqingUuidNumber;
    }


    /**
	 * 设置：申请流水号
	 */
    public void setWupinShenqingUuidNumber(String wupinShenqingUuidNumber) {
        this.wupinShenqingUuidNumber = wupinShenqingUuidNumber;
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
	 * 获取：物品
	 */
    public Integer getWupinId() {
        return wupinId;
    }


    /**
	 * 设置：物品
	 */
    public void setWupinId(Integer wupinId) {
        this.wupinId = wupinId;
    }
    /**
	 * 获取：申请数量
	 */
    public Integer getWupinShenqingNumber() {
        return wupinShenqingNumber;
    }


    /**
	 * 设置：申请数量
	 */
    public void setWupinShenqingNumber(Integer wupinShenqingNumber) {
        this.wupinShenqingNumber = wupinShenqingNumber;
    }
    /**
	 * 获取：申请详情
	 */
    public String getWupinContent() {
        return wupinContent;
    }


    /**
	 * 设置：申请详情
	 */
    public void setWupinContent(String wupinContent) {
        this.wupinContent = wupinContent;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getWupinShenqingYesnoTypes() {
        return wupinShenqingYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setWupinShenqingYesnoTypes(Integer wupinShenqingYesnoTypes) {
        this.wupinShenqingYesnoTypes = wupinShenqingYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getWupinShenqingYesnoText() {
        return wupinShenqingYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setWupinShenqingYesnoText(String wupinShenqingYesnoText) {
        this.wupinShenqingYesnoText = wupinShenqingYesnoText;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
