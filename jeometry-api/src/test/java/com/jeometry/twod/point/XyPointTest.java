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
package com.jeometry.twod.point;

import com.aljebra.scalar.Scalar;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link XyPoint}.
 * @since 0.1
 */
public final class XyPointTest {
    /**
     * {@link XyPoint} returns true coordinates.
     */
    @Test
    public void buildsAVector() {
        final Scalar.Default<Double> xcoor = new Scalar.Default<>(2.);
        final Scalar.Default<Double> ycoor = new Scalar.Default<>(1.);
        final XyPoint<Double> vector = new XyPoint<>(xcoor, ycoor);
        final Scalar<Double>[] coords = vector.coords();
        MatcherAssert.assertThat(coords[0], Matchers.equalTo(xcoor));
        MatcherAssert.assertThat(coords[1], Matchers.equalTo(ycoor));
        MatcherAssert.assertThat(vector.xcoor(), Matchers.equalTo(xcoor));
        MatcherAssert.assertThat(vector.ycoor(), Matchers.equalTo(ycoor));
    }
}
