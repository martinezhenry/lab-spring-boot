package com.hvs.lab.service.implementations;

import com.hvs.lab.service.contracts.IAsyncProcessorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
public class AsyncProcessorService implements IAsyncProcessorService {
    @Override
    @Async
    public void processDelay() throws InterruptedException {
        long delay = ThreadLocalRandom.current().nextLong(0, 1500 + 1);
        log.info("processing delay: {}", delay);
        Thread.sleep(delay);
        log.info("delay time processed");

    }
}
