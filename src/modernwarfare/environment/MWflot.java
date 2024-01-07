package modernwarfare.environment;

import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.environment.ShallowLiquid;
import mindustry.world.meta.Attribute;
import modernwarfare.content.MWItems;
import modernwarfare.content.MWLiquids;
import modernwarfare.content.MWStatusEffects;

import static mindustry.graphics.CacheLayer.water;

public class MWflot {
    public static OreBlock tiekuang,shiyingkuang,leikuang,lingsuangaikuang;

    public static ShallowLiquid fusheyedi;

    public static void load() {

        tiekuang = new OreBlock("tie-kuang") {
            {
                playerUnmineable = true;
                itemDrop = MWItems.tie;
                variants = 3;
                mapColor.set(itemDrop.color);
                useColor = true;
                oreDefault = true;
                oreThreshold = 0.9f;
                oreScale = 35;
            }
        };

        shiyingkuang = new OreBlock("shiying-kuang") {
            {
                playerUnmineable=true;
                itemDrop=MWItems.shiying;
                variants=2;
                mapColor.set(itemDrop.color);
                useColor=true;
                oreDefault=true;
                oreThreshold=0.9f;
                oreScale=35;
                }
            };

        leikuang = new OreBlock("lei-kuang") {
            {
                playerUnmineable=false;
                itemDrop=MWItems.lei;
                variants=2;
                mapColor.set(itemDrop.color);
                useColor=true;
                oreDefault=true;
                oreThreshold=0.9f;
                oreScale=35;
            }};

        lingsuangaikuang = new OreBlock("lingsuangai-kuang") {
            {
                itemDrop=MWItems.lingsuangai;
                speedMultiplier=0.95f;
                attributes.set(Attribute.oil, 0.5f);
                attributes.set(Attribute.water, 0.2f);
                variants=3;
                playerUnmineable=true;
            }};

        fusheyedi = new ShallowLiquid("fusheye-dig") {
            {
                speedMultiplier=0.1f;
                variants=0;
                status= MWStatusEffects.cuowei1;
                statusDuration=300;
                albedo=0.9f;
                shallow=false;
                cacheLayer=water;
                isLiquid=true;
                liquidDrop= MWLiquids.fusheye;
                liquidMultiplier=5;
                placeableOn=false;
                supportsOverlay=true;
            }};
    }
}