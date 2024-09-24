package com.rtarcisio.todo_back.enums;

public enum TodoStateEnum {

    OnDoing("OnDoing"),
    Done("Done"),
    Closed("Closed"),
    ReOpen("ReOpen");

    private String state;

    TodoStateEnum(String string) {
        this.state = string;
    }
    
}
