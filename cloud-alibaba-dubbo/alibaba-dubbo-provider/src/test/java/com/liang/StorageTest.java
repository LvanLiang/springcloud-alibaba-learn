package com.liang;

import com.liang.api.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Liangxp
 * @date 2020/4/30 9:14
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class StorageTest {
    @Reference
    private StorageService storageService;


    @Test
    public void testStorage() {
        storageService.decrease(1L, 10);
    }
}
