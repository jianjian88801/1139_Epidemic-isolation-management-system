package com.entity.model;

import com.entity.WupinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物品
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WupinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 供应商
     */
    private Integer gongyingshangId;


    /**
     * 物品名称
     */
    private String wupinName;


    /**
     * 物品照片
     */
    private String wupinPhoto;


    /**
     * 物品类型
     */
    private Integer wupinTypes;


    /**
     * 物品库存
     */
    private Integer wupinKucunNumber;


    /**
     * 逻辑删除
     */
    private Integer wupinDelete;


    /**
     * 物品介绍
     */
    private String wupinContent;


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
	 * 获取：供应商
	 */
    public Integer getGongyingshangId() {
        return gongyingshangId;
    }


    /**
	 * 设置：供应商
	 */
    public void setGongyingshangId(Integer gongyingshangId) {
        this.gongyingshangId = gongyingshangId;
    }
    /**
	 * 获取：物品名称
	 */
    public String getWupinName() {
        return wupinName;
    }


    /**
	 * 设置：物品名称
	 */
    public void setWupinName(String wupinName) {
        this.wupinName = wupinName;
    }
    /**
	 * 获取：物品照片
	 */
    public String getWupinPhoto() {
        return wupinPhoto;
    }


    /**
	 * 设置：物品照片
	 */
    public void setWupinPhoto(String wupinPhoto) {
        this.wupinPhoto = wupinPhoto;
    }
    /**
	 * 获取：物品类型
	 */
    public Integer getWupinTypes() {
        return wupinTypes;
    }


    /**
	 * 设置：物品类型
	 */
    public void setWupinTypes(Integer wupinTypes) {
        this.wupinTypes = wupinTypes;
    }
    /**
	 * 获取：物品库存
	 */
    public Integer getWupinKucunNumber() {
        return wupinKucunNumber;
    }


    /**
	 * 设置：物品库存
	 */
    public void setWupinKucunNumber(Integer wupinKucunNumber) {
        this.wupinKucunNumber = wupinKucunNumber;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getWupinDelete() {
        return wupinDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setWupinDelete(Integer wupinDelete) {
        this.wupinDelete = wupinDelete;
    }
    /**
	 * 获取：物品介绍
	 */
    public String getWupinContent() {
        return wupinContent;
    }


    /**
	 * 设置：物品介绍
	 */
    public void setWupinContent(String wupinContent) {
        this.wupinContent = wupinContent;
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
