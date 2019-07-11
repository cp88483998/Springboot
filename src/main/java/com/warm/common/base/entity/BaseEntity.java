package com.warm.common.base.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;

/**
 * Created by zhangbin on 2019/5/20.
 *
 * @author zhangbin
 * @date 2019-05-20 17:11:07
 */
@SuppressWarnings("all")
@Data
public class BaseEntity<T extends Model<?>> extends Model<T> {

    @TableId(type =IdType.UUID)
    protected Integer id;
    protected String createdBy;    // 创建者
    @TableField(fill = FieldFill.INSERT)
    protected Date createdTime;    // 创建日期
    protected String updatedBy;    // 更新者
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected Date updatedTime;    // 更新日期
//    protected String deleted = DEL_FLAG_NORMAL;
    /**
     * 删除标记（0：正常；1：删除）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
