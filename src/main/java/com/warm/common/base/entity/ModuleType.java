package com.warm.common.base.entity;

public enum ModuleType {
    
	EMPTY("", 0),
	ORG("部门管理", 1),
	GROUP("用户组管理", 2),
	USER("用户管理", 3),
	ROLE("角色管理", 4),
	PERM("权限管理", 5),
	DATA_DIC("数据字典管理", 6),
	SESSION("在线用户管理", 7),
	LOG("日志管理", 8);

    private String name;  
    
    private int index;  
    
    private ModuleType(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }  
    
    public static String getName(int index) {  
        for (ModuleType c : ModuleType.values()) {  
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
    
    public static void main(String[] args) {
		System.out.println(ModuleType.PERM.getName());
	}
}
