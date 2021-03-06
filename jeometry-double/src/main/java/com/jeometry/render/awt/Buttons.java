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

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Control buttons panel.
 * @since 0.1
 */
public final class Buttons extends JPanel {

    /**
     * Serial version ID.
     */
    private static final long serialVersionUID = -7413652639513091330L;

    /**
     * Translate increment/decrement amount.
     */
    private static final int TRANSLATE_AMOUNT = 2;

    /**
     * Drawable Panel.
     */
    private final AwtDrawableSurface drawable;

    /**
     * Ctor.
     * @param drawable The drawable surface
     */
    public Buttons(final AwtDrawableSurface drawable) {
        super();
        this.drawable = drawable;
    }

    /**
     * Builds the component.
     * @return This buttons JPanel
     */
    public JPanel init() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new TranslationButton("up", 0, Buttons.TRANSLATE_AMOUNT).react(this.drawable));
        this.add(new TranslationButton("down", 0, -Buttons.TRANSLATE_AMOUNT).react(this.drawable));
        this.add(new TranslationButton("right", Buttons.TRANSLATE_AMOUNT, 0).react(this.drawable));
        this.add(new TranslationButton("left", -Buttons.TRANSLATE_AMOUNT, 0).react(this.drawable));
        this.add(new ZoomInButton("zoomin").react(this.drawable));
        this.add(new ZoomOutButton("zoomout").react(this.drawable));
        return this;
    }

}
