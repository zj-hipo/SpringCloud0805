package com.zj.controller;
import com.zj.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @program: springCloud1
 * @description: 呵呵
 * @author: 张军
 * @create: 2020-07-15 16:09
 **/
@Controller
@RequestMapping("/user-consumer")
public class UserFeignController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @RequestMapping("/{id}")
    @ResponseBody
    public News query(@PathVariable int id){
        //ribbion的用法
        //获取ip和端口信息
        String basUrl="http://user-provider/"+id;
        News news=restTemplate.getForObject(basUrl,News.class);
        return news;
    }
}
