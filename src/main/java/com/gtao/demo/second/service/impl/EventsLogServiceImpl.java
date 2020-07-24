package com.gtao.demo.second.service.impl;

import com.gtao.demo.second.entity.EventsLog;
import com.gtao.demo.second.mapper.EventsLogMapper;
import com.gtao.demo.second.service.EventsLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志表 服务实现类
 * </p>
 *
 * @author gtao
 * @since 2020-07-24
 */
@Service
public class EventsLogServiceImpl extends ServiceImpl<EventsLogMapper, EventsLog> implements EventsLogService {

}
