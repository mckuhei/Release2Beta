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

package com.github.dirtpowered.releasetobeta.configuration;

import com.github.dirtpowered.betaprotocollib.data.version.MinecraftVersion;
import com.github.dirtpowered.releasetobeta.ReleaseToBeta;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class R2BConfiguration {
    public static MinecraftVersion version;
    public static String motd;
    public static int maxPlayers;
    public static boolean skinFix;
    public static String remoteAddress;
    public static int remotePort;
    public static String bindAddress;
    public static int bindPort;
    public static boolean disableSprinting;
    public static String resourcePack;
    public static String resourcePackHash;
    public static boolean tabComplete;
    public static boolean ver1_8PingPassthrough;
    public static String serverFullMessage;
    public static String connectionThrottleKickMessage;
    public static int globalConnectionThrottle;
    public static boolean onlineMode;
    public static int compressionThreshold;
    public static boolean ipForwarding;
    public static boolean metricsEnabled;
    public static String metricsUniqueId;
    public static boolean logPings;
    public static boolean spamProtection;
    public static String noSpamMessage;

    private ReleaseToBeta main;

    public R2BConfiguration(ReleaseToBeta main) {
        this.main = main;
    }

    private String fixPath(String path) {
        return path.isEmpty() ? "" : path + "/";
    }

    public void loadConfiguration(String path) {
        YamlFile config = new YamlFile(fixPath(path) + "config.yml");
        try {
            if (config.exists()) {
                main.getLogger().info("Loading configuration file");
                config.loadWithComments();
            } else {
                //not compiled
                Path p = Paths.get("src/main/resources/config.yml");
                if (Files.exists(p)) {
                    Files.copy(p, Paths.get(fixPath(path) + "config.yml"));
                } else {
                    //compiled
                    InputStream inputStream = getClass().getResourceAsStream("/config.yml");
                    Files.copy(inputStream, Paths.get(fixPath(path) + "config.yml"));
                }

                config.load();

                //unique id for metrics
                config.set("metrics.unique_id", UUID.randomUUID().toString());
                config.save();
            }

            try {
                version = MinecraftVersion.valueOf(config.getString("general.beta_version"));
            } catch (Exception e) {
                main.getLogger().warning("'beta_version' is wrong, defaulting to B_1_7_3");
                version = MinecraftVersion.B_1_7_3;
            }

            motd = config.getString("general.motd");
            maxPlayers = config.getInt("general.max_players");

            remoteAddress = config.getString("connection.remote_address");
            remotePort = config.getInt("connection.remote_port");
            bindAddress = config.getString("connection.bind_address");
            bindPort = config.getInt("connection.bind_port");
            globalConnectionThrottle = config.getInt("connection.global_connection_throttle");
            onlineMode = config.getBoolean("connection.online_mode");
            compressionThreshold = config.getInt("connection.compression_threshold");
            ipForwarding = config.getBoolean("connection.ip_forwarding");

            resourcePack = config.getString("misc.resource_pack_url");
            resourcePackHash = config.getString("misc.resource_pack_hash");
            tabComplete = config.getBoolean("misc.tab_complete");
            skinFix = config.getBoolean("misc.skin_fix");
            disableSprinting = config.getBoolean("misc.disable_sprinting");
            ver1_8PingPassthrough = config.getBoolean("misc.beta_1_8_ping_passthrough");

            serverFullMessage = config.getString("messages.server_full_message");
            connectionThrottleKickMessage = config.getString("messages.connection_throttle_kick_message");
            noSpamMessage = config.getString("messages.no_spam_message");
            logPings = config.getBoolean("messages.log_pings");
            spamProtection = config.getBoolean("messages.spam_protection");

            //metrics
            metricsEnabled = config.getBoolean("metrics.enable_metrics");
            metricsUniqueId = config.getString("metrics.unique_id");
        } catch (Exception e) {
            main.getLogger().error("Error: " + e.getMessage());
        }
    }
}
