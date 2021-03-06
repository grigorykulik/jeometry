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

import com.aljebra.metric.InnerProduct;
import com.aljebra.vector.Vect;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Degrees between two vectors.
 * @param <T> scalar types
 * @since 0.1
 */
@ToString(includeFieldNames = false)
@EqualsAndHashCode
public final class VectsDegrees<T> implements Degrees<T> {

    /**
     * First vector.
     */
    private final Vect<T> first;

    /**
     * Second vector.
     */
    private final Vect<T> second;

    /**
     * Constructor.
     * @param first First vector
     * @param second Second vector
     */
    public VectsDegrees(final Vect<T> first, final Vect<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Number resolve(final InnerProduct<T> product) {
        return product.angle(this.first, this.second).resolve(product);
    }

}
