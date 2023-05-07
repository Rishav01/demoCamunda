package com.rishav.demoCamunda.servicetask;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class RetryMechanismDemo1ServiceTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        if((Boolean) execution.getVariable("retryNeeded")) {
            throw new RuntimeException("random exception occurred");
        }
    }

}
