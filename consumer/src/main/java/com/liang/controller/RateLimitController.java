package com.liang.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.liang.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * nacos持久化sentinel限流规则
 *      resource： 资源名称
 *      limitApp： 来源应用
 *      grade： 阈值类型，0表示线程数，1表示QPS
 *      count: 单机阈值
 *      strategy: 流控模式， 0 - 表示直接，1表示关联，2表示链路
 *      controlBehavior： 流控效果，0表示快速失败，1表示Warm up , 2表示排队
 *      clusterMode： 是否集群。
 * @author Liangxp
 * @date 2020/4/27 11:07
 */
@Slf4j
@RestController
public class RateLimitController {
    /**
     * 测试参数限流 [按照资源名称来限流]，限流异常由自定义的detailTestHotKey方法来处理
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "detailTestHotKey")
    public Result byResource() {
        return Result.builder().code(200).message("按资源名称限流测试OK").data("a").build();
    }
    public Result detailTestHotKey(BlockException exception){
        return Result.builder().code(200).message(exception.getClass().getCanonicalName() +"\t 服务不可用").data("a").build();
    }


    /**
     * 测试参数限流 [按照URL地址来限流], 限流返回的是默认的异常 Blocked by Sentinel (flow limiting)
     */
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public Result rateLimit() {
        return Result.builder().code(200).message("按url限流测试OK").data("a").build();
    }
}
