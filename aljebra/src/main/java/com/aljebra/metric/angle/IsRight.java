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
package com.aljebra.metric.angle;

import com.aljebra.field.MetricSpaceField;
import com.aljebra.scalar.condition.Predicate;

/**
 * A predicate to determine if an angle is right.
 * @param <T> scalar types
 * @since 0.4
 */
public final class IsRight<T> implements Predicate<MetricSpaceField<T>> {

    /**
     * Angle.
     */
    private final Degrees<T> angle;

    /**
     * Constructor.
     * @param angle Angle to check
     */
    public IsRight(final Degrees<T> angle) {
        this.angle = angle;
    }

    @Override
    public boolean resolve(final MetricSpaceField<T> field) {
        return Double.valueOf(
            this.angle.resolve(field.product()).doubleValue() % Math.PI
        ).equals(Math.PI / 2);
    }

}
