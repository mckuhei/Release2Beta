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

package com.github.dirtpowered.releasetobeta.data;

import java.util.HashMap;

public class Block {
    public final static int AIR = 0;
    public final static int STICKY_PISTON = 29;
    public final static int PISTON = 33;
    public final static int OBSIDIAN = 49;
    public final static int CHEST = 54;
    public final static int PORTAL = 90;
    
    private static final HashMap<Integer, String> id2nameMapping = new HashMap<>();
    private static final HashMap<String, Integer> name2idMapping = new HashMap<>();
    
    public static int name2id(String name) {
    	return name2idMapping.containsKey(name) ? name2idMapping.get(name) : 0;
    }
    
    public static String id2name(int id) {
    	return id2nameMapping.containsKey(id) ? id2nameMapping.get(id) : "air";
    }
    
    private static void addMapping(String name, int id) {
    	id2nameMapping.put(id, name);
    	name2idMapping.put(name, id);
	}
    
    static {
    	addMapping("acacia_door", 196);
    	addMapping("acacia_fence", 192);
    	addMapping("acacia_fence_gate", 187);
    	addMapping("acacia_stairs", 163);
    	addMapping("activator_rail", 157);
    	addMapping("air", 0);
    	addMapping("anvil", 145);
    	addMapping("barrier", 166);
    	addMapping("beacon", 138);
    	addMapping("bed", 26);
    	addMapping("bedrock", 7);
    	addMapping("beetroots", 207);
    	addMapping("birch_door", 194);
    	addMapping("birch_fence", 189);
    	addMapping("birch_fence_gate", 184);
    	addMapping("birch_stairs", 135);
    	addMapping("black_glazed_terracotta", 250);
    	addMapping("black_shulker_box", 234);
    	addMapping("blue_glazed_terracotta", 246);
    	addMapping("blue_shulker_box", 230);
    	addMapping("bone_block", 216);
    	addMapping("bookshelf", 47);
    	addMapping("brewing_stand", 117);
    	addMapping("brick_block", 45);
    	addMapping("brick_stairs", 108);
    	addMapping("brown_glazed_terracotta", 247);
    	addMapping("brown_mushroom", 39);
    	addMapping("brown_mushroom_block", 99);
    	addMapping("brown_shulker_box", 231);
    	addMapping("cactus", 81);
    	addMapping("cake", 92);
    	addMapping("carpet", 171);
    	addMapping("carrots", 141);
    	addMapping("cauldron", 118);
    	addMapping("chain_command_block", 211);
    	addMapping("chest", 54);
    	addMapping("chorus_flower", 200);
    	addMapping("chorus_plant", 199);
    	addMapping("clay", 82);
    	addMapping("coal_block", 173);
    	addMapping("coal_ore", 16);
    	addMapping("cobblestone", 4);
    	addMapping("cobblestone_wall", 139);
    	addMapping("cocoa", 127);
    	addMapping("command_block", 137);
    	addMapping("concrete", 251);
    	addMapping("concrete_powder", 252);
    	addMapping("crafting_table", 58);
    	addMapping("cyan_glazed_terracotta", 244);
    	addMapping("cyan_shulker_box", 228);
    	addMapping("dark_oak_door", 197);
    	addMapping("dark_oak_fence", 191);
    	addMapping("dark_oak_fence_gate", 186);
    	addMapping("dark_oak_stairs", 164);
    	addMapping("daylight_detector", 151);
    	addMapping("daylight_detector_inverted", 178);
    	addMapping("deadbush", 32);
    	addMapping("detector_rail", 28);
    	addMapping("diamond_block", 57);
    	addMapping("diamond_ore", 56);
    	addMapping("dirt", 3);
    	addMapping("dispenser", 23);
    	addMapping("double_plant", 175);
    	addMapping("double_stone_slab", 43);
    	addMapping("double_stone_slab2", 181);
    	addMapping("double_wooden_slab", 125);
    	addMapping("dragon_egg", 122);
    	addMapping("dropper", 158);
    	addMapping("emerald_block", 133);
    	addMapping("emerald_ore", 129);
    	addMapping("enchanting_table", 116);
    	addMapping("end_bricks", 206);
    	addMapping("end_gateway", 209);
    	addMapping("end_portal", 119);
    	addMapping("end_portal_frame", 120);
    	addMapping("end_rod", 198);
    	addMapping("end_stone", 121);
    	addMapping("ender_chest", 130);
    	addMapping("farmland", 60);
    	addMapping("fence", 85);
    	addMapping("fence_gate", 107);
    	addMapping("fire", 51);
    	addMapping("flower_pot", 140);
    	addMapping("flowing_lava", 10);
    	addMapping("flowing_water", 8);
    	addMapping("frosted_ice", 212);
    	addMapping("furnace", 61);
    	addMapping("glass", 20);
    	addMapping("glass_pane", 102);
    	addMapping("glowstone", 89);
    	addMapping("gold_block", 41);
    	addMapping("gold_ore", 14);
    	addMapping("golden_rail", 27);
    	addMapping("grass", 2);
    	addMapping("grass_path", 208);
    	addMapping("gravel", 13);
    	addMapping("gray_glazed_terracotta", 242);
    	addMapping("gray_shulker_box", 226);
    	addMapping("green_glazed_terracotta", 248);
    	addMapping("green_shulker_box", 232);
    	addMapping("hardened_clay", 172);
    	addMapping("hay_block", 170);
    	addMapping("heavy_weighted_pressure_plate", 148);
    	addMapping("hopper", 154);
    	addMapping("ice", 79);
    	addMapping("iron_bars", 101);
    	addMapping("iron_block", 42);
    	addMapping("iron_door", 71);
    	addMapping("iron_ore", 15);
    	addMapping("iron_trapdoor", 167);
    	addMapping("jukebox", 84);
    	addMapping("jungle_door", 195);
    	addMapping("jungle_fence", 190);
    	addMapping("jungle_fence_gate", 185);
    	addMapping("jungle_stairs", 136);
    	addMapping("ladder", 65);
    	addMapping("lapis_block", 22);
    	addMapping("lapis_ore", 21);
    	addMapping("lava", 11);
    	addMapping("leaves", 18);
    	addMapping("leaves2", 161);
    	addMapping("lever", 69);
    	addMapping("light_blue_glazed_terracotta", 238);
    	addMapping("light_blue_shulker_box", 222);
    	addMapping("light_weighted_pressure_plate", 147);
    	addMapping("lime_glazed_terracotta", 240);
    	addMapping("lime_shulker_box", 224);
    	addMapping("lit_furnace", 62);
    	addMapping("lit_pumpkin", 91);
    	addMapping("lit_redstone_lamp", 124);
    	addMapping("lit_redstone_ore", 74);
    	addMapping("log", 17);
    	addMapping("log2", 162);
    	addMapping("magenta_glazed_terracotta", 237);
    	addMapping("magenta_shulker_box", 221);
    	addMapping("magma", 213);
    	addMapping("melon_block", 103);
    	addMapping("melon_stem", 105);
    	addMapping("mob_spawner", 52);
    	addMapping("monster_egg", 97);
    	addMapping("mossy_cobblestone", 48);
    	addMapping("mycelium", 110);
    	addMapping("nether_brick", 112);
    	addMapping("nether_brick_fence", 113);
    	addMapping("nether_brick_stairs", 114);
    	addMapping("nether_wart", 115);
    	addMapping("nether_wart_block", 214);
    	addMapping("netherrack", 87);
    	addMapping("noteblock", 25);
    	addMapping("oak_stairs", 53);
    	addMapping("observer", 218);
    	addMapping("obsidian", 49);
    	addMapping("orange_glazed_terracotta", 236);
    	addMapping("orange_shulker_box", 220);
    	addMapping("packed_ice", 174);
    	addMapping("pink_glazed_terracotta", 241);
    	addMapping("pink_shulker_box", 225);
    	addMapping("piston", 33);
    	addMapping("piston_extension", 36);
    	addMapping("piston_head", 34);
    	addMapping("planks", 5);
    	addMapping("portal", 90);
    	addMapping("potatoes", 142);
    	addMapping("powered_comparator", 150);
    	addMapping("powered_repeater", 94);
    	addMapping("prismarine", 168);
    	addMapping("pumpkin", 86);
    	addMapping("pumpkin_stem", 104);
    	addMapping("purple_glazed_terracotta", 245);
    	addMapping("purple_shulker_box", 229);
    	addMapping("purpur_block", 201);
    	addMapping("purpur_double_slab", 204);
    	addMapping("purpur_pillar", 202);
    	addMapping("purpur_slab", 205);
    	addMapping("purpur_stairs", 203);
    	addMapping("quartz_block", 155);
    	addMapping("quartz_ore", 153);
    	addMapping("quartz_stairs", 156);
    	addMapping("rail", 66);
    	addMapping("red_flower", 38);
    	addMapping("red_glazed_terracotta", 249);
    	addMapping("red_mushroom", 40);
    	addMapping("red_mushroom_block", 100);
    	addMapping("red_nether_brick", 215);
    	addMapping("red_sandstone", 179);
    	addMapping("red_sandstone_stairs", 180);
    	addMapping("red_shulker_box", 233);
    	addMapping("redstone_block", 152);
    	addMapping("redstone_lamp", 123);
    	addMapping("redstone_ore", 73);
    	addMapping("redstone_torch", 76);
    	addMapping("redstone_wire", 55);
    	addMapping("reeds", 83);
    	addMapping("repeating_command_block", 210);
    	addMapping("sand", 12);
    	addMapping("sandstone", 24);
    	addMapping("sandstone_stairs", 128);
    	addMapping("sapling", 6);
    	addMapping("sea_lantern", 169);
    	addMapping("silver_glazed_terracotta", 243);
    	addMapping("silver_shulker_box", 227);
    	addMapping("skull", 144);
    	addMapping("slime", 165);
    	addMapping("snow", 80);
    	addMapping("snow_layer", 78);
    	addMapping("soul_sand", 88);
    	addMapping("sponge", 19);
    	addMapping("spruce_door", 193);
    	addMapping("spruce_fence", 188);
    	addMapping("spruce_fence_gate", 183);
    	addMapping("spruce_stairs", 134);
    	addMapping("stained_glass", 95);
    	addMapping("stained_glass_pane", 160);
    	addMapping("stained_hardened_clay", 159);
    	addMapping("standing_banner", 176);
    	addMapping("standing_sign", 63);
    	addMapping("sticky_piston", 29);
    	addMapping("stone", 1);
    	addMapping("stone_brick_stairs", 109);
    	addMapping("stone_button", 77);
    	addMapping("stone_pressure_plate", 70);
    	addMapping("stone_slab", 44);
    	addMapping("stone_slab2", 182);
    	addMapping("stone_stairs", 67);
    	addMapping("stonebrick", 98);
    	addMapping("structure_block", 255);
    	addMapping("structure_void", 217);
    	addMapping("tallgrass", 31);
    	addMapping("tnt", 46);
    	addMapping("torch", 50);
    	addMapping("trapdoor", 96);
    	addMapping("trapped_chest", 146);
    	addMapping("tripwire", 132);
    	addMapping("tripwire_hook", 131);
    	addMapping("unlit_redstone_torch", 75);
    	addMapping("unpowered_comparator", 149);
    	addMapping("unpowered_repeater", 93);
    	addMapping("vine", 106);
    	addMapping("wall_banner", 177);
    	addMapping("wall_sign", 68);
    	addMapping("water", 9);
    	addMapping("waterlily", 111);
    	addMapping("web", 30);
    	addMapping("wheat", 59);
    	addMapping("white_glazed_terracotta", 235);
    	addMapping("white_shulker_box", 219);
    	addMapping("wooden_button", 143);
    	addMapping("wooden_door", 64);
    	addMapping("wooden_pressure_plate", 72);
    	addMapping("wooden_slab", 126);
    	addMapping("wool", 35);
    	addMapping("yellow_flower", 37);
    	addMapping("yellow_glazed_terracotta", 239);
    	addMapping("yellow_shulker_box", 223);
    }
}
