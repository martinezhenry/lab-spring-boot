package com.hvs.lab.controllers.implementations;

import com.hvs.lab.controllers.contracts.IDelayController;
import com.hvs.lab.service.contracts.IAsyncProcessorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DelayController implements IDelayController {

    private final IAsyncProcessorService asyncProcessorService;

    public DelayController(IAsyncProcessorService asyncProcessorService){
        this.asyncProcessorService = asyncProcessorService;
    }

    @Override
    @GetMapping(value = "delay/{executions}")
    public void processDelayTime(@PathVariable(value = "executions") int executions) throws InterruptedException {
        log.info("Tries: {}", executions);
        for(int i = 0; i < executions; i++) {
            this.asyncProcessorService.processDelay();
        }
    }
}
