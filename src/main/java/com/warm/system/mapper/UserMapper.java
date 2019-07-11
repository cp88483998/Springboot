package com.warm.system.mapper;

import com.warm.common.base.entity.LoginInfo;
import com.warm.system.entity.User;
import com.warm.common.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 陈鹏
 * @since 2019-07-02
 */
public interface UserMapper extends SuperMapper<User> {

    /**
     * 获取用户登录信息
     *
     * @return
     */
    public LoginInfo selectUserLoginInfo(@Param("loginName") String loginName);
}
