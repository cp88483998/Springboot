package com.warm.system.mapper;

import java.util.List;

import com.warm.common.base.mapper.SuperMapper;
import com.warm.system.entity.UserInfo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
public interface UserInfoMapper extends SuperMapper<UserInfo> {

    List<UserInfo> selectAllUserInfo();
}
