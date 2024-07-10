package com.entity.vo;

import com.entity.WupinShenqingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物品申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wupin_shenqing")
public class WupinShenqingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 申请流水号
     */

    @TableField(value = "wupin_shenqing_uuid_number")
    private String wupinShenqingUuidNumber;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 物品
     */

    @TableField(value = "wupin_id")
    private Integer wupinId;


    /**
     * 申请数量
     */

    @TableField(value = "wupin_shenqing_number")
    private Integer wupinShenqingNumber;


    /**
     * 申请详情
     */

    @TableField(value = "wupin_content")
    private String wupinContent;


    /**
     * 申请状态
     */

    @TableField(value = "wupin_shenqing_yesno_types")
    private Integer wupinShenqingYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "wupin_shenqing_yesno_text")
    private String wupinShenqingYesnoText;


    /**
     * 申请时间
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
	 * 设置：申请流水号
	 */
    public String getWupinShenqingUuidNumber() {
        return wupinShenqingUuidNumber;
    }


    /**
	 * 获取：申请流水号
	 */

    public void setWupinShenqingUuidNumber(String wupinShenqingUuidNumber) {
        this.wupinShenqingUuidNumber = wupinShenqingUuidNumber;
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
	 * 设置：物品
	 */
    public Integer getWupinId() {
        return wupinId;
    }


    /**
	 * 获取：物品
	 */

    public void setWupinId(Integer wupinId) {
        this.wupinId = wupinId;
    }
    /**
	 * 设置：申请数量
	 */
    public Integer getWupinShenqingNumber() {
        return wupinShenqingNumber;
    }


    /**
	 * 获取：申请数量
	 */

    public void setWupinShenqingNumber(Integer wupinShenqingNumber) {
        this.wupinShenqingNumber = wupinShenqingNumber;
    }
    /**
	 * 设置：申请详情
	 */
    public String getWupinContent() {
        return wupinContent;
    }


    /**
	 * 获取：申请详情
	 */

    public void setWupinContent(String wupinContent) {
        this.wupinContent = wupinContent;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getWupinShenqingYesnoTypes() {
        return wupinShenqingYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setWupinShenqingYesnoTypes(Integer wupinShenqingYesnoTypes) {
        this.wupinShenqingYesnoTypes = wupinShenqingYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getWupinShenqingYesnoText() {
        return wupinShenqingYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setWupinShenqingYesnoText(String wupinShenqingYesnoText) {
        this.wupinShenqingYesnoText = wupinShenqingYesnoText;
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

}
