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
package com.jeometry.twod.circle;

import com.aljebra.scalar.AddIdentity;
import com.aljebra.vector.Vect;
import com.jeometry.twod.point.PtReflectionPoint;
import com.jeometry.twod.point.XyPoint;
import lombok.ToString;

/**
 * A circle defined as the reflection of a circle, across a given point.
 * @param <T> scalar types
 * @since 0.1
 */
@ToString
public final class PtReflectionCircle<T> extends PtRadCircle<T> {

    /**
     * Constructor.
     * @param center Reflection center
     * @param circle The circle to reflect
     */
    public PtReflectionCircle(final Vect<T> center, final Circle<T> circle) {
        super(new PtReflectionPoint<T>(center, circle.center()), circle.radius());
    }

    /**
     * Constructor. Builds the reflection circle across the origin.
     * @param input The circle to reflect
     */
    public PtReflectionCircle(final Circle<T> input) {
        this(new XyPoint<T>(new AddIdentity<>(), new AddIdentity<>()), input);
    }

}
