package com.winter24.enums;

import lombok.Getter;

public enum SideBarMenuEnums {

    ADMIN("Admin"),
    PIM("Pim");
    @Getter

    String menu;

    SideBarMenuEnums(String menu){
        this.menu= menu;
    }

}
