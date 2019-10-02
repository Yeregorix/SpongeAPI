/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.entity.living.monster.raider.illager.spellcaster;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.type.SpellType;
import org.spongepowered.api.data.value.OptionalValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.living.monster.raider.illager.Illager;

public interface Spellcaster extends Illager {

    /**
     * {@link Keys#CURRENT_SPELL}.
     */
    default OptionalValue.Mutable<SpellType> currentSpell() {
        return this.getValue(Keys.CURRENT_SPELL).get().asMutable();
    }

    /**
     * Instructs this caster to cast it's current {@link SpellType}.
     */
    void castSpell();

    /**
     * {@link Keys#CASTING_TIME}
     */
    default Value.Mutable<Integer> castingTime() {
        return this.getValue(Keys.CASTING_TIME).get().asMutable();
    }

    /**
     * Gets if the caster is currently casting a spell.
     *
     * @return True if casting a spell, false if not
     */
    default boolean isCastingSpell() {
        return this.castingTime().get() <= 0;
    }
}