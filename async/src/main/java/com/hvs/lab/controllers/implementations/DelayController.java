package com.hvs.lab.controllers.implementations;

import com.hvs.lab.controllers.contracts.IDelayController;
import com.hvs.lab.service.contracts.IAsyncProcessorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DelayController implements IDelayController {

    private IAsyncProcessorService asyncProcessorService;

    public DelayController(IAsyncProcessorService asyncProcessorService){
        this.asyncProcessorService = asyncProcessorService;
    }

    @Override
    @GetMapping(value = "delay/{}")
    public void processDelayTime(@PathVariable long delayTime) throws InterruptedException {
        this.asyncProcessorService.processDelayRequest(delayTime);
    }
}
