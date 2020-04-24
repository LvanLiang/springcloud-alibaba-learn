package com.liang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 测试sentinel限流控制
 *      流控效果：
 *          1.直接->快速失败(默认流控处理)；直接失败抛出异常，DefaultController来处理
 *          2.预热->即请求QPS从设置的阈值/冷加载因子(默认3)开始，经过设置的预热时长逐渐升至设置的QPS
 *          3.排队等待->不拒绝请求，匀速处理
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
        log.info(Thread.currentThread().getName() + "\t" + "...testC");
        return "------testC";
    }

}
