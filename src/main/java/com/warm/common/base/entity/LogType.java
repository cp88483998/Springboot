package com.warm.common.base.entity;

public enum LogType {
	
	LOGOUT("登出", 1),
	LOGIN("登录", 2),
	OPERTION("操作日志", 3);
    
    private String name;  
    
    private int index;  
    
    private LogType(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }  
    
    public static String getName(int index) {  
        for (LogType c : LogType.values()) {  
            if (c.getIndex() == index) {  
                return c.name;  
            }  
        }  
        return null;  
    }  
    
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public int getIndex() {  
        return index;  
    }  
    public void setIndex(int index) {  
        this.index = index;  
    }  
}
