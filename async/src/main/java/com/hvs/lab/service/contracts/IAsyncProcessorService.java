package com.hvs.lab.service.contracts;

public interface IAsyncProcessorService {

    void processDelayRequest(long delayTime) throws InterruptedException;

}
