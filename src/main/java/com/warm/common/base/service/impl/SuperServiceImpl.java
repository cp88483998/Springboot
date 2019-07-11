package com.warm.common.base.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.warm.common.base.service.ISuperService;

/**
 * service实现父类
 *
 * @author zhangbin
 * @date 2019/05/20
 */
public class SuperServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements ISuperService<T> {
}
