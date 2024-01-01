package modernwarfare.world.blocks.production;

import arc.graphics.Color;
import arc.graphics.g2d.TextureRegion;
import arc.math.Interp;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.effect.MultiEffect;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.world.Block;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.Env;
import modernwarfare.content.MWFx;

import static mindustry.Vars.tilesize;

public class Quarry extends Block {
        public TextureRegion sideRegion1;
        public TextureRegion sideRegion2;
        public TextureRegion locator;
        public TextureRegion armRegion;
        public TextureRegion drill;
        public float mineTime;
        public float liquidBoostIntensity;
        public int areaSize;
        public Color areaColor = Pal.accent;
        public Color boostColor = Color.sky.cpy().mul(0.87f);
        public Effect drillEffect = new MultiEffect(MWFx.quarryDrillEffect, Fx.mine);

        public Interp deployInterp;
        public Interp deployInterpInverse;

        public float drillMoveSpeed;
        public float deploySpeed;
        public float drillMargin = 20f;
        public float elevation = 8f;

        protected float fulls = areaSize * tilesize / 2f;

    public Quarry(String name) {
            super(name);
            update = true;
            solid = true;
            rotate = true;
            group = BlockGroup.drills;
            hasItems = true;
            hasLiquids = true;
            acceptsItems = true;
            liquidCapacity = 5f;
            hasPower = true;
            envEnabled |= Env.space;
            updateInUnits = false;
            quickRotate = false;
            ambientSoundVolume = 0.05f;
            ambientSound = Sounds.minebeam;
        }
}