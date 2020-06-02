package com.softwareconstruction.math.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.softwareconstruction.math.entity.Calculation;

/**
 * @author NGX
 * @Date 2020/5/21 17:50
 */
@Component
public class Generator {

    private Calculation[] calculations;

    /**
     * 生成随机数，范围min - max
     *
     * @param min
     * @param max
     * @return
     */
    public int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * 判断结果是否在范围内
     *
     * @param result
     * @param min
     * @param max
     * @return
     */
    public boolean isBetween(int result, int min, int max) {
        return result >= min && result <= max;
    }

    /**
     * 判断两个算式是否相同
     *
     * @param c1
     * @param c2
     * @return
     */
    public boolean isEquals(Calculation c1, Calculation c2) {
        boolean f = false;
        if (c1.getOper() != c2.getOper()) {
            f = false;
        } else {
            f = c1.getFirst() == c2.getFirst() && c1.getSecond() == c2.getSecond();
        }
        return f;
    }

    /**
     * 计算加法
     *
     * @param first
     * @param second
     * @return
     */
    public int calAdd(int first, int second) {
        return first + second;
    }

    /**
     * 计算减法
     *
     * @param first
     * @param second
     * @return
     */
    public int calSub(int first, int second) {
        return first - second;
    }

    /**
     * 判断生成的算式是否重复
     *
     * @param c
     * @param cs
     * @param n
     * @return
     */
    public boolean isRepeat(Calculation c, Calculation[] cs, int n) {
        boolean f = false;
        for (int i = 0; i < n; i++) {
            if (isEquals(c, cs[i])) {
                f = true;
                break;
            }
        }
        return f;
    }

    /**
     * 生成加法运算式
     *
     * @return
     */
    public Calculation createAdd() {
        Calculation calculation = new Calculation();
        int left = 0;
        int right = 0;
        int res = 0;
        while (true) {
            left = getRandom(1, 100);
            right = getRandom(1, 100);
            res = calAdd(left, right);
            if (isBetween(res, 0, 100)) {
                calculation.setFirst(left);
                calculation.setSecond(right);
                calculation.setResult(res);
                calculation.setOper('+');
                break;
            }
        }
        return calculation;
    }

    /**
     * 生成减法运算式
     *
     * @return
     */
    public Calculation createSub() {
        Calculation calculation = new Calculation();
        int left = 0;
        int right = 0;
        int res = 0;
        while (true) {
            left = getRandom(1, 100);
            right = getRandom(1, 100);
            res = calSub(left, right);
            if (isBetween(res, 0, 100) && left != right) {
                calculation.setFirst(left);
                calculation.setSecond(right);
                calculation.setResult(res);
                calculation.setOper('-');
                break;
            }
        }
        return calculation;
    }

    /**
     * 生成随机的加法或者减法运算式
     *
     * @return
     */
    public Calculation createRandomCal() {
        Calculation calculation = new Calculation();
        Random random = new Random();
        if (random.nextInt(2) == 1) {
            return createAdd();
        } else {
            return createSub();
        }
    }

    /**
     * 创建混合算数
     *
     * @return
     */
    public List<Calculation> createRandomCals() {
        List<Calculation> list = new ArrayList<>();
        calculations = new Calculation[50];
        for (int i = 0; i < 50; ) {
            Calculation cal = createRandomCal();
            if (isRepeat(cal, calculations, i)) {
                continue;
            } else {
                calculations[i] = cal;
                list.add(calculations[i]);
                i++;
            }
        }
        return list;
    }

    /**
     * 创建加法算数
     *
     * @return
     */
    public List<Calculation> createAddCals() {
        List<Calculation> list = new ArrayList<>();
        calculations = new Calculation[50];
        for (int i = 0; i < 50; ) {
            Calculation cal = createAdd();
            if (isRepeat(cal, calculations, i)) {
                continue;
            }
            calculations[i] = cal;
            list.add(cal);
            i++;
        }
        System.out.println(list.size());
        return list;
    }

    /**
     * 创建减法算数
     *
     * @return
     */
    public List<Calculation> createSubCals() {
        List<Calculation> list = new ArrayList<>();
        for (int i = 0; i < 50; ) {
            Calculation cal = createSub();
            if (isRepeat(cal, calculations, i)) {
                continue;
            } else {
                calculations[i] = cal;
                list.add(calculations[i]);
                i++;
            }
        }
        return list;
    }
}
