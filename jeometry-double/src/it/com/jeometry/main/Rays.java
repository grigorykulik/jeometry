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
package com.jeometry.main;

import com.aljebra.vector.Vect;
import com.jeometry.model.decimal.DblPoint;
import com.jeometry.render.awt.Awt;
import com.jeometry.twod.Figure;
import com.jeometry.twod.ray.PtDirRay;
import com.jeometry.twod.ray.Ray;

/**
 * Main rays testing class using {@link Awt} output.
 * @since 0.1
 */
public final class Rays {

    /**
     * Private constructor.
     */
    private Rays() {
    }

    /**
     * Main start method.
     * @param args Unused args
     */
    public static void main(final String... args) {
        final int count = 12;
        final Figure figure = new Figure();
        for (int idx = 0; idx < count; ++idx) {
            figure.add(Rays.ray(idx * 2 * Math.PI / count));
        }
        final Awt awt = new Awt().withSize(50, 50);
        awt.render(figure);
        awt.setVisible(true);
    }

    /**
     * Generates a ray making the given angle with the x-axis.
     * @param angle Angle to make with the x-axis
     * @return The ray
     */
    private static Ray ray(final double angle) {
        final int rad = 3;
        final Vect vertex = new DblPoint(
            rad * Math.cos(angle), rad * Math.sin(angle)
        );
        return new PtDirRay(vertex, vertex);
    }

}
