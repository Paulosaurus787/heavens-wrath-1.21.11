package de.heavenswrath;

import com.mojang.blaze3d.platform.InputConstants;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;

/** Hotkey (Standard: K) öffnet das Heaven's Wrath Menü. In den Tasteneinstellungen änderbar. */
public final class HeavensWrathTaste {

	private static KeyMapping taste;

	private HeavensWrathTaste() {
	}

	public static void registrieren() {
		KeyMapping.Category kategorie = KeyMapping.Category
				.register(Identifier.fromNamespaceAndPath("heavens_wrath", "heavens_wrath"));
		taste = KeyBindingHelper.registerKeyBinding(
				new KeyMapping("key.heavens_wrath.menu", InputConstants.Type.KEYSYM, InputConstants.KEY_K, kategorie));
	}

	public static void tick(Minecraft mc) {
		if (taste == null) {
			return;
		}
		while (taste.consumeClick()) {
			if (mc.screen == null && mc.player != null) {
				mc.setScreen(new HeavensWrathScreen(0));
			}
		}
	}
}
