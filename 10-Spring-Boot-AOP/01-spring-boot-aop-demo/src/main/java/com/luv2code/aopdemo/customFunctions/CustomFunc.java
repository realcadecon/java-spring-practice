package com.luv2code.aopdemo.customFunctions;

import org.springframework.stereotype.Component;

@Component
public class CustomFunc {

    public void doCustomFunction(boolean arg1) {
        System.out.println("Doing custom function with " + arg1);
    }
}
