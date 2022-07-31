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

package net.iceyleagons.nbtlib.tags.impl;

import lombok.EqualsAndHashCode;
import net.iceyleagons.nbtlib.NBT;
import net.iceyleagons.nbtlib.tags.Tag;
import net.iceyleagons.nbtlib.tags.TagTypes;
import net.iceyleagons.nbtlib.tags.impl.arrays.ByteArrayTag;
import net.iceyleagons.nbtlib.tags.impl.arrays.IntArrayTag;
import net.iceyleagons.nbtlib.tags.impl.arrays.LongArrayTag;
import net.iceyleagons.nbtlib.tags.impl.numbers.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TOTHTOMI
 * @version 1.0.0
 * @since Mar. 15, 2022
 */
@EqualsAndHashCode(callSuper = true)
public class CompoundTag extends Tag {

    private final Map<String, Tag> value;

    public CompoundTag(final String name) {
        this(name, new HashMap<>());
    }

    public CompoundTag(final String name, final Map<String, Tag> value) {
        super(name, TagTypes.COMPOUND);
        this.value = value;
    }

    public void putTag(Tag tag) {
        putTag(tag.getName(), tag);
    }

    private void putTag(String name, Tag value) {
        this.value.put(name, value);
    }

    public <T> T getTag(String name, Class<T> type) {
        if (!this.value.containsKey(name)) return null;

        Tag tag = this.value.get(name);
        if (!type.isInstance(tag)) {
            throw new IllegalStateException(name + " tag is not of tag type " + type.getName());
        }

        return type.cast(tag);
    }

    public boolean has(String name) {
        return this.value.containsKey(name);
    }

    public void put(String name, byte[] value) {
        putTag(NBT.of(name, value));
    }

    public void put(String name, byte value) {
        putTag(NBT.of(name, value));
    }

    public void put(String name, double value) {
        putTag(NBT.of(name, value));
    }

    public void put(String name, float value) {
        putTag(NBT.of(name, value));
    }

    public void put(String name, int[] value) {
        putTag(NBT.of(name, value));
    }

    public void put(String name, int value) {
        putTag(NBT.of(name, value));
    }

    public void put(String name, long[] value) {
        putTag(NBT.of(name, value));
    }

    public void put(String name, long value) {
        putTag(NBT.of(name, value));
    }

    public void put(String name, short value) {
        putTag(NBT.of(name, value));
    }

    public void put(String name, String value) {
        putTag(NBT.of(name, value));
    }

    public byte[] getByteArray(String name) {
        ByteArrayTag tag = getTag(name, ByteArrayTag.class);
        return tag == null ? null : tag.getValue();
    }

    public Byte getByte(String name) {
        ByteTag tag = getTag(name, ByteTag.class);
        return tag == null ? null : tag.getValue();
    }

    public CompoundTag getCompound(String name) {
        return getTag(name, CompoundTag.class);
    }

    public Double getDouble(String name) {
        DoubleTag tag = getTag(name, DoubleTag.class);
        return tag == null ? null : tag.getValue();
    }

    public Float getFloat(String name) {
        FloatTag tag = getTag(name, FloatTag.class);
        return tag == null ? null : tag.getValue();
    }

    public int[] getIntArray(String name) {
        IntArrayTag tag = getTag(name, IntArrayTag.class);
        return tag == null ? null : tag.getValue();
    }

    public Integer getInt(String name) {
        IntTag tag = getTag(name, IntTag.class);
        return tag == null ? null : tag.getValue();
    }

    public ListTag getList(String name) {
        return getTag(name, ListTag.class);
    }

    public long[] getLongArray(String name) {
        LongArrayTag tag = getTag(name, LongArrayTag.class);
        return tag == null ? null : tag.getValue();
    }

    public Long getLong(String name) {
        LongTag tag = getTag(name, LongTag.class);
        return tag == null ? null : tag.getValue();
    }

    public Short getShort(String name) {
        ShortTag tag = getTag(name, ShortTag.class);
        return tag == null ? null : tag.getValue();
    }

    public String getString(String name) {
        StringTag tag = getTag(name, StringTag.class);
        return tag == null ? null : tag.getValue();
    }

    @Override
    public Map<String, Tag> getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(value.size()).append(" entries\r\n{\r\n");
        for (final Map.Entry<String, Tag> entry : value.entrySet()) {
            sb.append("   ").append(entry.getValue().toString().replaceAll("\r\n", "\r\n   ")).append("\r\n");
        }
        sb.append("}");

        return super.getToString(sb.toString());
    }
}
