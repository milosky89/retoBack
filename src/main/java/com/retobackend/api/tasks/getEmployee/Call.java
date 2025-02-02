package com.retobackend.api.tasks.getEmployee;

public class Call {

    private Call(){}

    public static ConsumeServiceGet service(){
        return new ConsumeServiceGet();
    }
}
