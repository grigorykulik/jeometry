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
package com.aljebra.matrix;

import com.aljebra.scalar.Multiplication;
import com.aljebra.scalar.Scalar;
import com.aljebra.vector.FixedVector;
import com.aljebra.vector.Vect;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Tests for {@link Times}.
 * @since 0.1
 */
public final class TimesTest {

    /**
     * {@link Times} calculates coordinates as the multiplication of scalars.
     */
    @Test
    public void calculatesTimesCoordinates() {
        final int lines = 3;
        final int cols = 4;
        final List<Scalar<Object>> coorsa = TimesTest.scalars(lines * cols);
        final Scalar<Object> factor = new Scalar.Default<>(new Object());
        final Matrix<Object> times = new Times<>(
            new FixedMatrix<Object>(lines, cols, coorsa), factor
        );
        final Scalar<Object>[] expected = new com.aljebra.vector.Times<Object>(
            new FixedVector<Object>(coorsa), factor
        ).coords();
        MatcherAssert.assertThat(times.lines(), Matchers.equalTo(lines));
        MatcherAssert.assertThat(times.columns(), Matchers.equalTo(cols));
        MatcherAssert.assertThat(times.coords(), Matchers.equalTo(expected));
    }

    /**
     * {@link Times} can return lines and columns.
     */
    @Test
    public void returnsLinesAndColumns() {
        final Scalar<Object> scalara = new Scalar.Default<>(new Object());
        final Scalar<Object> scalarb = new Scalar.Default<>(new Object());
        final Scalar<Object> scalarc = new Scalar.Default<>(new Object());
        final Scalar<Object> scalard = new Scalar.Default<>(new Object());
        final Scalar<Object> scalare = new Scalar.Default<>(new Object());
        final Matrix<Object> matrix = new Times<>(
            new FixedMatrix<Object>(
                2, 2, Arrays.asList(scalara, scalarb, scalarc, scalard)
            ),
            scalare
        );
        MatcherAssert.assertThat(
            matrix.line(1),
            Matchers.equalTo(
                new Scalar[] {
                    new Multiplication<Object>(Arrays.asList(scalara, scalare)),
                    new Multiplication<Object>(Arrays.asList(scalarc, scalare)),
                }
            )
        );
        MatcherAssert.assertThat(
            matrix.line(2),
            Matchers.equalTo(
                new Scalar[] {
                    new Multiplication<Object>(Arrays.asList(scalarb, scalare)),
                    new Multiplication<Object>(Arrays.asList(scalard, scalare)),
                }
            )
        );
        MatcherAssert.assertThat(
            matrix.column(1),
            Matchers.equalTo(
                new Scalar[] {
                    new Multiplication<Object>(Arrays.asList(scalara, scalare)),
                    new Multiplication<Object>(Arrays.asList(scalarb, scalare)),
                }
            )
        );
        MatcherAssert.assertThat(
            matrix.column(2),
            Matchers.equalTo(
                new Scalar[] {
                    new Multiplication<Object>(Arrays.asList(scalarc, scalare)),
                    new Multiplication<Object>(Arrays.asList(scalard, scalare)),
                }
            )
        );
    }

    /**
     * {@link Times} transforms a vector as the multiplication
     * of the transformations by the scalar (linear).
     */
    @SuppressWarnings("unchecked")
    @Test
    public void appliesTimesTransformation() {
        final int lines = 3;
        final int cols = 4;
        final FixedMatrix<Object> first = new FixedMatrix<>(
            lines, cols, TimesTest.scalars(lines * cols)
        );
        final Vect<Object> input = Mockito.mock(Vect.class);
        Mockito.when(input.coords()).thenReturn(TimesTest.scalars(cols).toArray(new Scalar[1]));
        final Scalar<Object> factor = new Scalar.Default<>(new Object());
        MatcherAssert.assertThat(
            new Times<Object>(first, factor).apply(input),
            Matchers.equalTo(
                new com.aljebra.vector.Times<Object>(first.apply(input), factor)
            )
        );
    }

    /**
     * Mocks a list of {@link Scalar} with a given size.
     * @param length List size
     * @return A list of scalars
     */
    private static List<Scalar<Object>> scalars(final int length) {
        final List<Scalar<Object>> result = new ArrayList<>(length);
        for (int idx = 0; idx < length; ++idx) {
            result.add(new Scalar.Default<>(new Object()));
        }
        return result;
    }

}
