package com.liang.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 测试sentinel限流控制，降级策略，热点key限流
 *      流控效果：
 *          1.直接->快速失败(默认流控处理)；直接失败抛出异常，DefaultController来处理
 *          2.预热->即请求QPS从设置的阈值/冷加载因子(默认3)开始，经过设置的预热时长逐渐升至设置的QPS
 *          3.排队等待->不拒绝请求，匀速处理
 *
 *      降级策略：
 *          1.RT，平均响应时间 (DEGRADEGRADERT)：当 1s 内持续进入 N 个请求，对应时刻的平均响应时间（秒级）均超过阈值（count，以 ms 为单位），
 *          那么在接下的时间窗口（DegradeRule 中的 timeWindow，以 s 为单位）之内，对这个方法的调用都会自动地熔断（抛出 DegradeException）。
 *          注意 Sentinel 默认统计的 RT 上限是 4900 ms，超出此阈值的都会算作 4900 ms，若需要变更此上限可以通过启动配置项 -Dcsp.sentinel.statistic.max.rt=xxx 来配置。
 *              配置：RT=300(单位是毫秒)，时间窗口=10(单位是秒)
 *              解释：当1s内持续进入5个请求，平均响应时间如果超过300毫秒，则在接下来的10秒内资源进入降级状态
 *          2.异常比例(DEGRADE_GRADE_EXCEPTION_RATIO)：当资源的每秒请求量 >= N（可配置），并且每秒异常总数占通过量的比值超过阈值（DegradeRule 中的 count）之后，
 *          资源进入降级状态，即在接下的时间窗口（DegradeRule 中的 timeWindow，以 s 为单位）之内，对这个方法的调用都会自动地返回。异常比率的阈值范围是 [0.0, 1.0]，代表 0% - 100%。
 *              配置：异常比例0.2，时间窗口=10(单位是秒)
 *              解释：当资源的每秒请求量 >= 5，并且每秒异常总数占通过量的比值20%，资源进入降级状态
 *          3.异常数(DEGRADE_GRADE_EXCEPTION_COUNT):当资源近 1 分钟的异常数目超过阈值之后会进行熔断。注意由于统计时间窗口是分钟级别的，若 timeWindow 小于 60s，则结束熔断状态后仍可能再进入熔断状态。
 *
 *      热点key限流： 热点参数限流会统计传入参数中的热点参数，并根据配置的限流阈值与模式，对包含热点参数的资源调用进行限流。
 *                  热点参数限流可以看做是一种特殊的流量控制，仅对包含热点参数的资源调用生效。
 *
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

    /**
     * 降级策略测试， 测试异常数
     */
    @GetMapping("/testD")
    public String testD() {
        log.info("testD 测试异常数");
        int age = 10 / 0;
        return "------testD";
    }

    /**
     * 测试参数限流
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "detailTestHotKey")
    public String testHotKey(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "gender", required = false) String gender) {
        log.info("热点限流……testHotKey参数：name: {}====gender:{}", name, gender);
        return "------testHotKey";
    }
    public String detailTestHotKey(String name, String gender, BlockException exception){
        log.info("detailTestHotKey|name:{}，gender:{}", name, gender);
        return "detail hotkey o(╥﹏╥)o";
    }

}
