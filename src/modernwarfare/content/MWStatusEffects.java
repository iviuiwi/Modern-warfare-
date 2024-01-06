package modernwarfare.content;

import mindustry.type.StatusEffect;

public class MWStatusEffects {
    public static StatusEffect
            ruofushe,cuowei1,cuowei2,cuowei3;

    public static void load() {
        ruofushe = new StatusEffect("ruo-fu-she") {{
            damage=0.3F;
        }};

        cuowei1 = new StatusEffect("cuowei-1") {
            {
                damage = 5F;
                effectChance=1;
                damageMultiplier=1;
                healthMultiplier=0.8f;
                speedMultiplier=0.7f;
                reloadMultiplier=0.65f;
                permanent=false;
            }};

        cuowei2 = new StatusEffect("cuowei-2") {
            {
                damage = 6;
                effectChance=1;
                damageMultiplier=1;
                healthMultiplier=0.7f;
                speedMultiplier=0.6f;
                reloadMultiplier=0.55f;
                permanent=false;
            }};

        cuowei3 = new StatusEffect("cuowei-3") {
            {
                damage = 15;
                effectChance=1;
                damageMultiplier=1;
                healthMultiplier=0.6f;
                speedMultiplier=0.5f;
                reloadMultiplier=0.45f;
                permanent=false;
            }};
    }
    }