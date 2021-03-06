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
package com.aljebra.vector;

import com.aljebra.scalar.AddInverse;
import com.aljebra.scalar.MultIdentity;
import com.aljebra.scalar.Scalar;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * A vector represented as the opposite of a vector.
 * @param <T> scalar types
 * @since 0.1
 */
@ToString(includeFieldNames = false)
@EqualsAndHashCode
public final class Opposite<T> implements Vect<T> {

    /**
     * The vector to oppose.
     */
    private final transient Vect<T> vector;

    /**
     * Constructor.
     * @param vector Vector to oppose
     */
    public Opposite(final Vect<T> vector) {
        this.vector = vector;
    }

    @Override
    public Scalar<T>[] coords() {
        return new Times<T>(
            this.vector, new AddInverse<T>(new MultIdentity<T>())
        ).coords();
    }

}
