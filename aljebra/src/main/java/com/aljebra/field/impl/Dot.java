/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2016, Hamdi Douss
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
package com.aljebra.field.impl;

import com.aljebra.aspects.DimensionsEqual;
import com.aljebra.scalar.Add;
import com.aljebra.scalar.Diff;
import com.aljebra.scalar.Division;
import com.aljebra.scalar.Multiplication;
import com.aljebra.scalar.Scalar;
import com.aljebra.vector.Vect;
import com.aljebra.vector.metric.InnerProduct;
import java.util.stream.IntStream;

/**
 * Class implementing dot operation (scalar product) or inner product
 * of 2 vectors in Real numbers field.
 * @author Hamdi Douss (douss.hamdi@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class Dot implements InnerProduct {

    @Override
    @DimensionsEqual
    public Scalar product(final Vect foperand, final Vect soperand) {
        final Scalar[] first = foperand.coords();
        final Scalar[] second = soperand.coords();
        return new Add(
            IntStream.range(0, first.length)
            .mapToObj(i -> new Multiplication(first[i], second[i]))
            .toArray(Multiplication[]::new)
        );
    }

    @Override
    public Scalar norm(final Vect vect) {
        return Dot.wrap(Math.sqrt(Dot.val(this.product(vect, vect))));
    }

    @Override
    public Number angle(final Vect first, final Vect second) {
        final Scalar cross = new Diff(
            new Multiplication(first.coords()[0], second.coords()[1]),
            new Multiplication(second.coords()[0], first.coords()[1])
        );
        final Scalar norms = new Multiplication(
            this.norm(first), this.norm(second)
        );
        final Double result;
        if (Dot.val(norms) == 0) {
            result = 0.;
        } else {
            final Double arcsin = Math.asin(
                Math.abs(Dot.val(cross)) / Dot.val(norms)
            );
            final Double arcos = Math.acos(
                Dot.val(new Division(this.product(first, second), norms))
            );
            if (arcsin > 0) {
                result = arcos;
            } else {
                result = -arcos;
            }
        }
        return result;
    }

    /**
     * Gives the actual value of the scalar.
     * @param input Scalar
     * @return A double
     */
    private static Double val(final Scalar input) {
        return new Decimal().actual(input);
    }

    /**
     * Gives a scalar wrapping a double.
     * @param input A double
     * @return A scalar
     */
    private static Scalar wrap(final double input) {
        return new Scalar.Default<Double>(input);
    }
}