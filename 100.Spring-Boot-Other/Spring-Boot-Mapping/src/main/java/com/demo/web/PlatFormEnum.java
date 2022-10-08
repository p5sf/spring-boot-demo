package com.demo.web;

import lombok.Getter;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月16日 14:57
 */

public enum PlatFormEnum {
    PC("PC", 1),APP("APP",1),WAP("WAP",1), ALL("ALL", 0);

   @Getter
    private final String name;

   @Getter
    private final int order;

    PlatFormEnum(String name, int order) {
        this.name = name;
        this.order = order;
    }

    public static PlatFormEnum nameOf(String name) {
        if (name == null) {
            return ALL;
        }
        name = name.toLowerCase().trim();
        for (PlatFormEnum sub : PlatFormEnum.values()) {
            if (sub.name.equals(name)) {
                return sub;
            }
        }

        return ALL;
    }

}
