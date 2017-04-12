package com.smart.test.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.smart.test.wechat.AccessTokenUtil;

/**
 * SchedulingConfig
 *
 * @author hzzjb
 * @date 2017/4/7
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {

    @Scheduled(cron = "0 1/30 * * * ?") // 每5分钟执行一次
    public void refreshAccessToken() {
        System.out.println(">>>>>>>>>>>>> scheduled ... ");
        Thread t = new Thread() {
            public void run() {
                AccessTokenUtil.refreshToken();
            }
        };
        try {
            t.start();
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
