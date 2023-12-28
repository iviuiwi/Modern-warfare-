package ModernWarfareMod.content;

import mindustry.type.StatusEffect;

public class MWStatusEffects {
    public static StatusEffect
            ruofushe;

    public static void load() {
        ruofushe = new StatusEffect("ruo-fu-she") {{
            damage=0.3F;
        }};
    }
}