package com.hvs.lab.controllers.contracts;

public interface IDelayController {
    void processDelayTime(int executions) throws InterruptedException;
}
