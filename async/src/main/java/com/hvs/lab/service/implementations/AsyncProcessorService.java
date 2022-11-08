package com.hvs.lab.service.implementations;

import com.hvs.lab.service.contracts.IAsyncProcessorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncProcessorService implements IAsyncProcessorService {
    @Override
    @Async
    public void processDelayRequest(long delayTime) throws InterruptedException {
        log.info("processing delay: {}", delayTime);
        Thread.sleep(delayTime);
        log.info("delay time processed");

    }
}
