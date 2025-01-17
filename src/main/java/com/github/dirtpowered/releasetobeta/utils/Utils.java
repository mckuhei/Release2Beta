/*
 * Copyright (c) 2020 Dirt Powered
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

package com.github.dirtpowered.releasetobeta.utils;

import com.github.dirtpowered.betaprotocollib.data.version.MinecraftVersion;
import com.github.dirtpowered.betaprotocollib.utils.Location;
import com.github.dirtpowered.releasetobeta.configuration.R2BConfiguration;
import com.github.dirtpowered.releasetobeta.data.entity.DummyEntity;
import com.github.dirtpowered.releasetobeta.data.entity.EntityCache;
import com.github.dirtpowered.releasetobeta.data.entity.model.Entity;
import com.github.dirtpowered.releasetobeta.logger.AbstractLogger;

import lombok.Getter;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.UUID;

public class Utils {

    @Getter
    final static byte[] filledBiomeData;

    static {
        filledBiomeData = new byte[256];
        Arrays.fill(filledBiomeData, (byte) 129);
    }


    public static double toModernPos(int pos) {
        return pos / 32.0D;
    }

    public static float toModernPitch(int pitch) {
        /* -90 is looking straight up, and 90 is looking straight down. */
        return ((pitch % 360) * 360) / 256F;
    }

    public static float toModernYaw(int yaw) {
        return ((yaw % 360) * 360) / 256F;
    }

    public static Float toFloat(double doubleValue) {
        return (float) doubleValue;
    }

    public static UUID getOfflineUUID(String username) {
        return UUID.nameUUIDFromBytes(("OfflinePlayer:" + username).getBytes());
    }

    public static Entity getNearestEntity(EntityCache entityCache, Location location) {
        Entity nearbyEntity = new DummyEntity(-1);

        for (Entity entity : entityCache.getEntities().values()) {
            if (entity.getLocation().distanceTo(location) < 2.5D && entity.getLocation().distanceTo(location) != 0.0D /* exclude self */) {
                nearbyEntity = entity;
            }
        }

        return nearbyEntity;
    }

    public static int fixDimension(int dimension) {
        if (MinecraftVersion.B_1_9.isNewerOrEqual(R2BConfiguration.version)) {
            return dimension;
        }

        return (dimension == -1 ? -1 : 0);
    }

    public static int toChunkPos(int posArg) {
        return (int) Math.floor(posArg) >> 4;
    }

    public static String safeSubstring(String str, int start, int end) {
        if (end < 0) {
            end += str.length();
        }

        if (start < 0) {
            start += str.length();
        }

        if (end > str.length()) {
            end = str.length();
        }

        if (start > end) {
            return "";
        } else {
            if (start < 0) {
                start = 0;
            }

            if (end < 0) {
                end = 0;
            }

            return str.substring(start, end);
        }
    }
    
    public static void printException(AbstractLogger logger, Throwable exc, String msg) {
    	StringWriter sw = new StringWriter().append(msg == null ? "" : msg + "\n");
    	exc.printStackTrace(new PrintWriter(sw));
    	logger.error(msg);
    }
}
