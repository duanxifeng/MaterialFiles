/*
 * Copyright (c) 2018 Hai Zhang <dreaming.in.code.zh@gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.android.files.functional;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

import me.zhanghai.android.files.functional.compat.Predicate;

public class MoreComparator {

    private MoreComparator() {}

    public static <T> Comparator<T> comparingBoolean(Predicate<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable) (object1, object2) -> Boolean.compare(
                keyExtractor.test(object1), keyExtractor.test(object2));
    }
}
