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
import com.aljebra.metric.MkProduct;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link Supplementary}.
 * @since 0.1
 */
public final class SupplementaryTest {

    /**
     * {@link Supplementary} resolves to a supplementary angle.
     */
    @Test
    public void resolvesSupplementaryAngle() {
        final Degrees<Object> first = new Degrees.Default<>(Math.random());
        final Degrees<Object> second = new Degrees.Default<>(Math.random());
        final Degrees<Object> third = new Degrees.Default<>(Math.random());
        final InnerProduct<Object> pdt = new MkProduct<>();
        final double error = 1.e-6;
        MatcherAssert.assertThat(
            new Supplementary<>(first).resolve(pdt).doubleValue()
                + first.resolve(pdt).doubleValue(),
            Matchers.closeTo(Math.PI, error)
        );
        MatcherAssert.assertThat(
            new Supplementary<>(second).resolve(pdt).doubleValue()
                + second.resolve(pdt).doubleValue(),
            Matchers.closeTo(Math.PI, error)
        );
        MatcherAssert.assertThat(
            new Supplementary<>(third).resolve(pdt).doubleValue()
                + third.resolve(pdt).doubleValue(),
            Matchers.closeTo(Math.PI, error)
        );
    }

    /**
     * {@link Supplementary} toString prints underlying degrees.
     */
    @Test
    public void toStringPrintsDegrees() {
        final Degrees<Object> deg = new Degrees.Default<>(Math.random());
        MatcherAssert.assertThat(
            new Supplementary<>(deg).toString(),
            Matchers.containsString(deg.toString())
        );
    }

    /**
     * {@link Supplementary} respects equality with the same underlying degrees.
     */
    @Test
    public void equalsRespectsDegrees() {
        final Degrees<Object> deg = new Degrees.Default<>(Math.random());
        MatcherAssert.assertThat(
            new Supplementary<>(deg),
            Matchers.equalTo(new Supplementary<>(deg))
        );
    }

    /**
     * {@link Supplementary} respects hashcode with the same underlying degrees.
     */
    @Test
    public void hashCodeRespectsDegrees() {
        final Degrees<Object> deg = new Degrees.Default<>(Math.random());
        MatcherAssert.assertThat(
            new Supplementary<>(deg).hashCode(),
            Matchers.equalTo(new Supplementary<>(deg).hashCode())
        );
    }
}
