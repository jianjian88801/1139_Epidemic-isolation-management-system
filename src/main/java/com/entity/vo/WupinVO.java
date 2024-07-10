package com.entity.vo;

import com.entity.WupinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物品
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wupin")
public class WupinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 供应商
     */

    @TableField(value = "gongyingshang_id")
    private Integer gongyingshangId;


    /**
     * 物品名称
     */

    @TableField(value = "wupin_name")
    private String wupinName;


    /**
     * 物品照片
     */

    @TableField(value = "wupin_photo")
    private String wupinPhoto;


    /**
     * 物品类型
     */

    @TableField(value = "wupin_types")
    private Integer wupinTypes;


    /**
     * 物品库存
     */

    @TableField(value = "wupin_kucun_number")
    private Integer wupinKucunNumber;


    /**
     * 逻辑删除
     */

    @TableField(value = "wupin_delete")
    private Integer wupinDelete;


    /**
     * 物品介绍
     */

    @TableField(value = "wupin_content")
    private String wupinContent;


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
	 * 设置：物品名称
	 */
    public String getWupinName() {
        return wupinName;
    }


    /**
	 * 获取：物品名称
	 */

    public void setWupinName(String wupinName) {
        this.wupinName = wupinName;
    }
    /**
	 * 设置：物品照片
	 */
    public String getWupinPhoto() {
        return wupinPhoto;
    }


    /**
	 * 获取：物品照片
	 */

    public void setWupinPhoto(String wupinPhoto) {
        this.wupinPhoto = wupinPhoto;
    }
    /**
	 * 设置：物品类型
	 */
    public Integer getWupinTypes() {
        return wupinTypes;
    }


    /**
	 * 获取：物品类型
	 */

    public void setWupinTypes(Integer wupinTypes) {
        this.wupinTypes = wupinTypes;
    }
    /**
	 * 设置：物品库存
	 */
    public Integer getWupinKucunNumber() {
        return wupinKucunNumber;
    }


    /**
	 * 获取：物品库存
	 */

    public void setWupinKucunNumber(Integer wupinKucunNumber) {
        this.wupinKucunNumber = wupinKucunNumber;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getWupinDelete() {
        return wupinDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setWupinDelete(Integer wupinDelete) {
        this.wupinDelete = wupinDelete;
    }
    /**
	 * 设置：物品介绍
	 */
    public String getWupinContent() {
        return wupinContent;
    }


    /**
	 * 获取：物品介绍
	 */

    public void setWupinContent(String wupinContent) {
        this.wupinContent = wupinContent;
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
