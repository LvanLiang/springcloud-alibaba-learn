package com.liang.service;

import com.liang.api.StorageService;
import com.liang.mapper.StorageMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author Liangxp
 * @date 2020/4/29 17:06
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");
    }
}
