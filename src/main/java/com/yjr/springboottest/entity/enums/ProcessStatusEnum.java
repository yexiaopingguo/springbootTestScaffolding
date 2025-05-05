package com.yjr.springboottest.entity.enums;


public enum ProcessStatusEnum {

    PENDING("待处理", 1),
    PAID("已支付", 2),
    SHIPPED("已发货", 3);

    private final String desc;
    private final int code;

    ProcessStatusEnum(String desc, int code) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() { return desc; }
    public int getCode() { return code; }


}
