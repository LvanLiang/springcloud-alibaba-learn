package com.liang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 测试sentinel限流控制
 * @author Liangxp
 * @date 2020/04/23 20:43
 */
@Slf4j
@RestController
public class FlowLimitController {

    /**
     * QPS(每秒钟的请求数量)： 当调用该 api 的QPS 达到阈值的时候进行限流
     */
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    /**
     * 线程数：当调用该api的线程数达到阈值的时候，进行限流。
     */
    @GetMapping("/testB")
    public String testB() {
        try {
            TimeUnit.MILLISECONDS.sleep(800);
            log.info(Thread.currentThread().getName() + "\t" + "...testB");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "------testB";
    }

    /**
     * 流控模式-关联，当A关联的C达到阈值时，A就挂了
     */
    @GetMapping("/testC")
    public String testC() {
        return "------testC";
    }

}
