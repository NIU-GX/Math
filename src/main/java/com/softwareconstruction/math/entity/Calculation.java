package com.softwareconstruction.math.entity;

import lombok.Data;

/**
 * @author NGX
 * @Date 2020/5/21 15:38
 */
@Data
public class Calculation {
    private int first;
    private int second;
    private int result;
    private char oper;

    @Override
    public String toString() {
        return this.getFirst() + "" + this.getOper() + "" + this.getSecond() + "=";
    }
}
