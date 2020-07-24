package com.gtao.demo.first.service.impl;

import com.gtao.demo.first.entity.User;
import com.gtao.demo.first.mapper.UserMapper;
import com.gtao.demo.first.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gtao
 * @since 2020-07-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
