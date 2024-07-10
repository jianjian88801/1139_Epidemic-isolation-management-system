package com.entity.vo;

import com.entity.DiquEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 地区
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("diqu")
public class DiquVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 地区名称
     */

    @TableField(value = "diqu_name")
    private String diquName;


    /**
     * 风险等级
     */

    @TableField(value = "diqu_types")
    private Integer diquTypes;


    /**
     * 地区详情
     */

    @TableField(value = "diqu_content")
    private String diquContent;


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
	 * 设置：地区名称
	 */
    public String getDiquName() {
        return diquName;
    }


    /**
	 * 获取：地区名称
	 */

    public void setDiquName(String diquName) {
        this.diquName = diquName;
    }
    /**
	 * 设置：风险等级
	 */
    public Integer getDiquTypes() {
        return diquTypes;
    }


    /**
	 * 获取：风险等级
	 */

    public void setDiquTypes(Integer diquTypes) {
        this.diquTypes = diquTypes;
    }
    /**
	 * 设置：地区详情
	 */
    public String getDiquContent() {
        return diquContent;
    }


    /**
	 * 获取：地区详情
	 */

    public void setDiquContent(String diquContent) {
        this.diquContent = diquContent;
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
