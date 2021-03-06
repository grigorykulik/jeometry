/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2020, Hamdi Douss
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES
 * OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.aljebra.scalar.condition;

import com.aljebra.field.Field;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import java.util.Arrays;

/**
 * A predicate that is true if one of the given predicates is true.
 * @param <T> scalar types
 * @since 0.1
 */
public final class Or<T> implements Predicate<Field<T>> {

    /**
     * Predicates.
     */
    private final Multiset<Predicate<Field<T>>> opers;

    /**
     * Constructor.
     * @param operands Predicates
     */
    public Or(final Iterable<? extends Predicate<Field<T>>> operands) {
        this.opers = HashMultiset.create(operands);
    }

    /**
     * Constructor. Build or with two predicates
     * @param first First operand
     * @param second Second operand
     */
    public Or(final Predicate<Field<T>> first, final Predicate<Field<T>> second) {
        this(Arrays.asList(first, second));
    }

    @Override
    public boolean resolve(final Field<T> field) {
        boolean result = false;
        for (final Predicate<Field<T>> predicate : this.opers) {
            if (predicate.resolve(field)) {
                result = true;
                break;
            }
        }
        return result;
    }

}
