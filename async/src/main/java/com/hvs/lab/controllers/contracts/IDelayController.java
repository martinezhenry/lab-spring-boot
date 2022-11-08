package com.hvs.lab.controllers.contracts;

public interface IDelayController {
    void processDelayTime(long delayTime) throws InterruptedException;
}
