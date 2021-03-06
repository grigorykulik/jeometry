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
package com.jeometry.render.awt;

import com.aljebra.field.impl.doubles.Decimal;
import com.jeometry.twod.Shape;
import com.jeometry.twod.mock.SpyCircle;
import com.jeometry.twod.mock.SpyLine;
import com.jeometry.twod.style.Fill;
import com.jeometry.twod.style.Stroke;
import com.jeometry.twod.style.Style;
import java.awt.Graphics2D;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Tests for {@link AwtCircle}.
 * @since 0.1
 */
public final class AwtCircleTest {

    /**
     * {@link AwtCircle} renders circle.
     */
    @Test
    public void rendersCircles() {
        final SpyCircle<Double> circle = new SpyCircle<>();
        final AwtCircle painter = new AwtCircle(new Decimal());
        final Style style = Mockito.mock(Style.class);
        Mockito.when(style.stroke()).thenReturn(
            Mockito.mock(Stroke.class)
        );
        Mockito.when(style.fill()).thenReturn(Mockito.mock(Fill.class));
        painter.render(
            new Shape<>(circle, style),
            new AwtDrawableSurface().context(),
            Mockito.mock(Graphics2D.class)
        );
        Mockito.verify(style).fill();
        Mockito.verify(style).stroke();
        MatcherAssert.assertThat(circle.centered(), Matchers.equalTo(true));
    }

    /**
     * {@link AwtCircle} does not render other renderables.
     */
    @Test
    public void doesNotRenderOthers() {
        final SpyLine<Double> render = new SpyLine<>();
        final AwtCircle painter = new AwtCircle(new Decimal());
        painter.render(
            new Shape<>(render),
            new AwtDrawableSurface().context(),
            Mockito.mock(Graphics2D.class)
        );
        MatcherAssert.assertThat(render.pointed(), Matchers.equalTo(false));
        MatcherAssert.assertThat(render.directioned(), Matchers.equalTo(false));
    }

}
