package com.example.workflow.mvc.delegates;


import com.example.workflow.mvc.service.ClientService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MockCheckLoansDelegate implements JavaDelegate {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    ClientService clientService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        // System.out.println(delegateExecution.getVariable("pizza"));
        // delegateExecution.getSuperExecution().getVariable("pizza");
        // delegateExecution.getVariableLocal("pizza");

        Object termType = delegateExecution.getVariable("termType");
        delegateExecution.setVariable("dataValid","FALSE");
        if (Arrays.asList("SHORT","LONG","HOUSE").contains(termType)){
            delegateExecution.setVariable("dataValid","TRUE");
        }

        //System.out.println(runtimeService.getVariable(delegateExecution.getProcessInstanceId(), "pizza"));


    }
}