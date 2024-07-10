package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 供应商
 *
 * @author 
 * @email
 */
@TableName("gongyingshang")
public class GongyingshangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongyingshangEntity() {

	}

	public GongyingshangEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 供应商名称
     */
    @TableField(value = "gongyingshang_name")

    private String gongyingshangName;


    /**
     * 供应商地址
     */
    @TableField(value = "gongyingshang_address")

    private String gongyingshangAddress;


    /**
     * 供应商介绍
     */
    @TableField(value = "diqu_content")

    private String diquContent;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：供应商名称
	 */
    public String getGongyingshangName() {
        return gongyingshangName;
    }


    /**
	 * 获取：供应商名称
	 */

    public void setGongyingshangName(String gongyingshangName) {
        this.gongyingshangName = gongyingshangName;
    }
    /**
	 * 设置：供应商地址
	 */
    public String getGongyingshangAddress() {
        return gongyingshangAddress;
    }


    /**
	 * 获取：供应商地址
	 */

    public void setGongyingshangAddress(String gongyingshangAddress) {
        this.gongyingshangAddress = gongyingshangAddress;
    }
    /**
	 * 设置：供应商介绍
	 */
    public String getDiquContent() {
        return diquContent;
    }


    /**
	 * 获取：供应商介绍
	 */

    public void setDiquContent(String diquContent) {
        this.diquContent = diquContent;
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
        return "Gongyingshang{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", gongyingshangName=" + gongyingshangName +
            ", gongyingshangAddress=" + gongyingshangAddress +
            ", diquContent=" + diquContent +
            ", createTime=" + createTime +
        "}";
    }
}
