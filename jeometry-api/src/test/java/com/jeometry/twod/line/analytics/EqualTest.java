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
package com.jeometry.twod.line.analytics;

import com.aljebra.field.impl.doubles.Decimal;
import com.aljebra.scalar.Different;
import com.jeometry.twod.line.Line;
import com.jeometry.twod.line.PtsLine;
import com.jeometry.twod.line.RandomLine;
import com.jeometry.twod.point.InLinePoint;
import com.jeometry.twod.point.OutsideLinePoint;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link Equal}.
 * @since 0.1
 */
public final class EqualTest {

    /**
     * {@link Equal} resolves to true if the two lines are the same.
     */
    @Test
    public void resolvesTrueIfSameLine() {
        final Line<Double> line = new RandomLine<>();
        MatcherAssert.assertThat(
            new Equal<>(line, line).resolve(new Decimal()),
            Matchers.is(true)
        );
    }

    /**
     * {@link Equal} resolves to true if the two lines are equal.
     */
    @Test
    public void resolvesTrueIfEqualLines() {
        final Line<Double> line = new RandomLine<>();
        final InLinePoint<Double> first = new InLinePoint<>(line);
        MatcherAssert.assertThat(
            new Equal<>(
                line, new PtsLine<>(first, new InLinePoint<>(line, new Different<>(first.xcoor())))
            ).resolve(new Decimal()),
            Matchers.is(true)
        );
    }

    /**
     * {@link Parallel} resolves to false if the lines are only parallel.
     */
    @Test
    public void resolvesFalseIfOnlyParallel() {
        final Line<Double> line = new RandomLine<>();
        MatcherAssert.assertThat(
            new Equal<>(
                line,
                new PtsLine<>(new OutsideLinePoint<>(line), line.point())
            ).resolve(new Decimal()),
            Matchers.is(false)
        );
    }
}
