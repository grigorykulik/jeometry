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
package com.aljebra.field.impl.doubles;

import com.aljebra.scalar.Scalar;
import java.util.Arrays;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link DblMatrix}.
 * @since 0.1
 */
public final class DblMatrixTest {

    /**
     * DblMatrix returns right coordinates.
     */
    @Test
    public void returnsCoordinates() {
        final double coora = Math.random();
        final double coorb = Math.random();
        final double coorc = Math.random();
        final double coord = Math.random();
        final DblMatrix mat = new DblMatrix(2, 2, coora, coorb, coorc, coord);
        MatcherAssert.assertThat(
            Arrays.asList(mat.coords()),
            Matchers.equalTo(
                Arrays.asList(
                    new Scalar.Default<>(coora),
                    new Scalar.Default<>(coorb),
                    new Scalar.Default<>(coorc),
                    new Scalar.Default<>(coord)
                )
            )
        );
    }

    /**
     * {@link DblMatrix} can return lines and columns elements.
     */
    @Test
    public void returnsLinesAndColumns() {
        final double coora = Math.random();
        final double coorb = Math.random();
        final double coorc = Math.random();
        final double coord = Math.random();
        final DblMatrix mat = new DblMatrix(2, 2, coora, coorb, coorc, coord);
        MatcherAssert.assertThat(
            mat.line(1),
            Matchers.equalTo(
                new Scalar[] {new Scalar.Default<>(coora), new Scalar.Default<>(coorc)}
            )
        );
        MatcherAssert.assertThat(
            mat.line(2),
            Matchers.equalTo(
                new Scalar[] {new Scalar.Default<>(coorb), new Scalar.Default<>(coord)}
            )
        );
        MatcherAssert.assertThat(
            mat.column(1),
            Matchers.equalTo(
                new Scalar[] {new Scalar.Default<>(coora), new Scalar.Default<>(coorb)}
            )
        );
        MatcherAssert.assertThat(
            mat.column(2),
            Matchers.equalTo(
                new Scalar[] {new Scalar.Default<>(coorc), new Scalar.Default<>(coord)}
            )
        );
        MatcherAssert.assertThat(
            mat.lines(), Matchers.equalTo(2)
        );
        MatcherAssert.assertThat(
            mat.columns(), Matchers.equalTo(2)
        );
    }
}
