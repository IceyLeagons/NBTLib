/*
 * MIT License
 *
 * Copyright (c) 2022 IceyLeagons and Contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.iceyleagons.nbtlib.tags.impl.arrays;

import lombok.EqualsAndHashCode;
import net.iceyleagons.nbtlib.tags.Tag;
import net.iceyleagons.nbtlib.tags.TagTypes;

import java.util.Arrays;

/**
 * @author TOTHTOMI
 * @version 1.0.0
 * @since Mar. 15, 2022
 */
@EqualsAndHashCode(callSuper = true)
public class ByteArrayTag extends Tag {

    private final byte[] value;

    public ByteArrayTag(final String name, final byte[] value) {
        super(name, TagTypes.BYTE_ARRAY);
        this.value = value;
    }

    @Override
    public byte[] getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return super.getToString(Arrays.toString(this.value));
    }
}
