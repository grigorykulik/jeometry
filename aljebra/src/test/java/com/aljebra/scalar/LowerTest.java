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
package com.aljebra.scalar;

import com.aljebra.field.mock.SpyField;
import com.aljebra.field.mock.SpyMetricSpace;
import java.util.Optional;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for {@link Lower}.
 * @since 0.1
 */
public final class LowerTest {

    /**
     * Junit rule for expected exceptions.
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * {@link Lower} relies on ordered field to calculate actual value.
     */
    @Test
    public void delegatesToOrderedField() {
        final Scalar<Object> first = new Scalar.Default<>(new Object());
        final SpyMetricSpace<Object> field = new SpyMetricSpace<>(new Object(), new Object());
        new Lower<>(first).value(field);
        final Optional<Scalar<Object>> params = field.lower();
        MatcherAssert.assertThat(params.isPresent(), Matchers.is(true));
        MatcherAssert.assertThat(params.get(), Matchers.is(first));
    }

    /**
     * {@link Lower} throws exception if the field is not ordered.
     */
    @Test
    public void throwsExceptionWhenUnorderedField() {
        this.thrown.expect(UnsupportedOperationException.class);
        new Lower<>(
            new Scalar.Default<>(new Object())
        ).value(new SpyField<>(new Object(), new Object()));
    }

    /**
     * {@link Lower} toString prints scalar bound.
     */
    @Test
    public void printsAttributes() {
        final Scalar<Object> first = new Scalar.Default<>(new Object());
        MatcherAssert.assertThat(
            new Lower<>(first).toString(),
            Matchers.containsString(first.toString())
        );
    }
}
