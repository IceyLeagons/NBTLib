package net.iceyleagons.nbtlib;

import net.iceyleagons.nbtlib.tags.impl.CompoundTag;
import net.iceyleagons.nbtlib.tags.impl.StringTag;
import net.iceyleagons.nbtlib.tags.impl.arrays.ByteArrayTag;
import net.iceyleagons.nbtlib.tags.impl.ByteTag;
import net.iceyleagons.nbtlib.tags.impl.arrays.IntArrayTag;
import net.iceyleagons.nbtlib.tags.impl.arrays.LongArrayTag;
import net.iceyleagons.nbtlib.tags.impl.numbers.*;

/**
 * @author TOTHTOMI
 * @version 1.0.0
 * @since Jul. 31, 2022
 */
public final class NBT {

    public static CompoundTag ofCompound(String name, CompoundInitializer compoundInitializer) {
        CompoundTag compoundTag = new CompoundTag(name);
        compoundInitializer.init(compoundTag);

        return compoundTag;
    }

    public static ByteArrayTag of(String name, byte[] value) {
        return new ByteArrayTag(name, value);
    }

    public static ByteTag of(String name, byte value) {
        return new ByteTag(name, value);
    }

    public static DoubleTag of(String name, double value) {
        return new DoubleTag(name, value);
    }

    public static FloatTag of(String name, float value) {
        return new FloatTag(name, value);
    }

    public static IntArrayTag of(String name, int[] value) {
        return new IntArrayTag(name, value);
    }

    public static IntTag of(String name, int value) {
        return new IntTag(name, value);
    }

    public static LongArrayTag of(String name, long[] value) {
        return new LongArrayTag(name, value);
    }

    public static LongTag of(String name, long value) {
        return new LongTag(name, value);
    }

    public static ShortTag of(String name, short value) {
        return new ShortTag(name, value);
    }

    public static StringTag of(String name, String value) {
        return new StringTag(name, value);
    }

    public interface CompoundInitializer {
        void init(final CompoundTag tag);
    }
}
