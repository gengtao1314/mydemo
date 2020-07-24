package com.gtao.demo.second.controller;


import com.gtao.demo.second.entity.EventsLog;
import com.gtao.demo.second.service.EventsLogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 操作日志表 前端控制器
 * </p>
 *
 * @author gtao
 * @since 2020-07-24
 */
@RestController
@RequestMapping("/eventsLog")
public class EventsLogController {
    @Resource
    private EventsLogService eventsLogService;

    @PostMapping("list")
    public List<EventsLog>list(){
        return eventsLogService.list();
    }

}
