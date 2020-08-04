package com.kuguo.leetcode.model;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Title:
 * Description:
 * Copyright © 2001-2020 17173. All rights reserved.
 *
 * @author cqt
 * @version 2020/8/4
 */
public class Person<T> {

    public Person() {
        Type type = getClass().getGenericSuperclass();
        Class a = (Class) ((ParameterizedType) ((ParameterizedType) type).getActualTypeArguments()[0]).getActualTypeArguments()[0];
    }
}