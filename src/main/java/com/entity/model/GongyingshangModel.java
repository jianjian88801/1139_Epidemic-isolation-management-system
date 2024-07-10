package com.entity.model;

import com.entity.GongyingshangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 供应商
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GongyingshangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 供应商名称
     */
    private String gongyingshangName;


    /**
     * 供应商地址
     */
    private String gongyingshangAddress;


    /**
     * 供应商介绍
     */
    private String diquContent;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：供应商名称
	 */
    public String getGongyingshangName() {
        return gongyingshangName;
    }


    /**
	 * 设置：供应商名称
	 */
    public void setGongyingshangName(String gongyingshangName) {
        this.gongyingshangName = gongyingshangName;
    }
    /**
	 * 获取：供应商地址
	 */
    public String getGongyingshangAddress() {
        return gongyingshangAddress;
    }


    /**
	 * 设置：供应商地址
	 */
    public void setGongyingshangAddress(String gongyingshangAddress) {
        this.gongyingshangAddress = gongyingshangAddress;
    }
    /**
	 * 获取：供应商介绍
	 */
    public String getDiquContent() {
        return diquContent;
    }


    /**
	 * 设置：供应商介绍
	 */
    public void setDiquContent(String diquContent) {
        this.diquContent = diquContent;
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
