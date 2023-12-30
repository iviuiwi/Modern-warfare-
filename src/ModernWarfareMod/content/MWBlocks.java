package ModernWarfareMod.content;

import arc.graphics.Blending;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.SapBulletType;
import mindustry.gen.Building;
import mindustry.graphics.Drawf;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.Turret;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.SolidPump;
import mindustry.world.draw.*;

import static arc.graphics.Color.white;
import static arc.graphics.Color.yellow;
import static mindustry.content.Fx.casing2;
import static mindustry.content.Fx.shootBig;
import static mindustry.content.Liquids.slag;
import static mindustry.content.StatusEffects.burning;
import static mindustry.gen.Sounds.build;
import static mindustry.type.Category.defense;
import static mindustry.type.Category.turret;
import static mindustry.type.ItemStack.with;
import static mindustry.world.meta.Attribute.heat;

public class MWBlocks {
    public static Wall gangbanqiang;
    public static Wall shiyingqiang;
    private static Wall juxingshiyingqiang;
    private static Wall daxingganbanqiang;
    private static Wall daxingshiyingqiang;

    private static SolidPump tanshenkuangzhachouquji, tianranqichouquji;

    private static Turret dangtiao, liudanpao, xingshuang,shengguang;

    protected static GenericCrafter jiexi, tfzzc,lghcc,jingTchanShengy;

    public static void load() {


                gangbanqiang = new Wall("gang-ban-qiang") {{

            health = 3500;
            size = 1;
            requirements(Category.power, with(MWItems.gangban, 6));
            category = defense;
            absorbLasers = true;
            chanceDeflect = 60;
        }};

        shiyingqiang = new Wall("shi-ying-qiang") {{

            health = 4500;
            size = 1;
            requirements(Category.power, with(MWItems.shiying, 6));
            category = defense;
            absorbLasers = true;
        }};

        Wall bailingqiang = new Wall("bai-ling-qiang") {{

            health = 500;
            size = 1;
            requirements(Category.power, with(MWItems.bailing, 12));
            category = defense;
        }};

        Wall juxingganbanqiqang = new Wall("ju-xing-gang-ban-qiang") {{

            health = 13000;
            size = 3;
            requirements(Category.power, with(MWItems.gangban, 48));
            category = defense;
            absorbLasers = true;
            chanceDeflect = 95;
            lightningChance = 1;
            lightningDamage = 1;
            lightningLength = 3;
        }};

        juxingshiyingqiang = new Wall("ju-xing-shi-ying-qiang") {{

            health = 19000;
            size = 3;
            requirements(Category.power, with(MWItems.shiying, 72));
            category = defense;
            absorbLasers = true;
            chanceDeflect = 40;
        }};

        daxingganbanqiang = new Wall("da-xing-gang-ban-qiang") {{

            health = 5000;
            size = 2;
            requirements(Category.power, with(MWItems.gangban, 36));
            category = defense;
            absorbLasers = true;
            chanceDeflect = 90;
        }};

        daxingshiyingqiang = new Wall("da-xing-shi-ying-qiang") {
            {

                health = 8000;
                size = 2;
                requirements(Category.power, with(MWItems.shiying, 24));
                category = defense;
                absorbLasers = true;
                chanceDeflect = 20;
            }
        };

        tanshenkuangzhachouquji = new SolidPump("tan-shen-kuang-zha-chou-qu-ji") {{
            requirements(Category.production, with(MWItems.tie, 80, MWItems.shiying, 80, MWItems.gangban, 70, MWItems.guitie, 60));
            result = slag;
            pumpAmount = 1.1f;
            size = 3;
            health = 1060;
            rotateSpeed = 2.6f;
            outputsLiquid = true;
            liquidCapacity = 580;
            attribute = heat;
        }};

        tianranqichouquji = new SolidPump("tian-ran-qi-chou-qu-ji") {{
            requirements(Category.production, with(MWItems.tie, 30, MWItems.shiying, 60, MWItems.gangban, 20));
            result = MWLiquids.tianranqi;
            pumpAmount = 0.25f;
            size = 2;
            health = 760;
            rotateSpeed = 1.5f;
            outputsLiquid = true;
            liquidCapacity = 90;
            attribute = heat;
            consumesPower = true;
            hasPower = true;
        }};


        dangtiao = new ItemTurret("dang-tiao") {{
            size = 2;
            health = 2000;
            ammoPerShot = 1;
            range = 360;
            inaccuracy = 6;
            maxAmmo = 60;
            targetAir = true;
            targetGround = true;
            coolantMultiplier = 2;
            reload = 60f;
            heatColor = Color.valueOf("#FF0000");
            ammo(
                    MWItems.zidanjuhenengyuan, new BasicBulletType() {
                        {
                            pierceCap = 1;
                            reloadMultiplier = 3.3F;
                            speed = 8f;
                            damage = 350;
                            knockback = 9.3F;
                            lifetime = 90;
                            ammoMultiplier = 1;
                            recoil = 5;
                        }
                    });
            requirements(Category.turret, with(MWItems.tie, 40, MWItems.shiying, 80));
            category = Category.valueOf("turret");
        }};


        liudanpao = new ItemTurret("liu-dan-pao") {{
            size = 3;
            health = 3500;
            range = 480;
            inaccuracy = 3;
            ammoPerShot = 1;
            reload = 65f;
            ammo(
                    MWItems.paodannengyuan, new BasicBulletType() {{
                        width = 14f;
                        height = 19f;
                        pierceCap = 1;
                        reloadMultiplier = 3.3F;
                        speed = 1.9f;
                        damage = 50;
                        knockback = 1.1F;
                        lifetime = 110;
                        ammoMultiplier = 2;
                        range = 480;
                    }}
            );
            maxAmmo = 20;
            targetAir = false;
            targetGround = true;
            coolantMultiplier = 2;
            requirements(Category.turret, with(MWItems.tie, 300, MWItems.gangban, 70));
            category = turret;
        }};

        xingshuang = new ItemTurret("xing-shuang") {
            {
                size = 2;
                health = 3500;
                range = 3200;
                inaccuracy = 8;
                ammoPerShot = 1;
                ammoUseEffect = casing2;
                maxAmmo = 50;
                targetAir = true;
                targetGround = true;
                coolantMultiplier = 2;
                heatColor = Color.red;
                ammo(
                        MWItems.zidanjuhenengyuan, new BasicBulletType() {
                            {
                                status = burning;
                                height = 30f;
                                pierceCap = 1;
                                recoil = 5;
                                splashDamage = 20;
                                splashDamageRadius = 84;
                                damage = 39;
                                shootEffect = shootBig;
                                ammoMultiplier = 10;
                                knockback = 0.3f;
                                speed = 3;
                                reloadMultiplier = 1;
                                lifetime = 90;
                                range = 55;
                            }
                        }
                );
                requirements(Category.turret, with(MWItems.gangban, 80, Items.graphite, 50, Items.titanium, 60));
                category = turret;
            }
        };

        shengguang = new ItemTurret("sheng-guang") {
            {
                size = 3;
                health = 3500;
                range = 3200;
                inaccuracy = 8;
                ammoPerShot = 1;
                ammoUseEffect = casing2;
                maxAmmo = 120;
                targetAir = true;
                targetGround = true;
                coolantMultiplier = 2;
                heatColor = Color.red;
                ammo(
                        MWItems.bailing, new SapBulletType() {
                            {
                                status = burning;
                                size = 6;
                                width = 0.9f;
                                pierceCap = 1;
                                recoil = 9;
                                splashDamage = 20;
                                splashDamageRadius = 84;
                                damage = 16;
                                shootEffect = shootBig;
                                ammoMultiplier = 10;
                                knockback = 0.3f;
                                speed = 6;
                                reloadMultiplier = 1;
                                lifetime = 900;
                                range = 120;
                            }
                        }
                );
                requirements(Category.turret, with(MWItems.gangban, 80, Items.graphite, 50, Items.titanium, 60));
                category = turret;
            }
        };

        jiexi = new GenericCrafter("jie-xi") {{
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(MWItems.tie, 30),
                    new ItemStack(MWItems.gangban, 70),
                    new ItemStack(MWItems.shiying, 20),
                    new ItemStack(MWItems.chaonengti3xing, 50)
            });
            outputItem = new ItemStack(MWItems.wuliuxiansuo, 1);
            craftTime = 3780f;
            size = 3;
            consumesPower = true;
            hasItems = hasPower = hasLiquids = true;
            consumePower(290);
            consumeLiquid(MWLiquids.fusheye, 15 / 60f);
            consumeItem(MWItems.canHai, 1);

            drawer = new DrawMulti(new DrawRegion("-ming"), new DrawLiquidTile(), new DrawRegion("-ming"),
                    new DrawCrucibleFlame(){
                        {
                            midColor = Color.valueOf("2e2f34");
                            circleStroke = 1.05f;
                            circleSpace = 2.65f;
                        }
        });
        }};

        tfzzc = new GenericCrafter("tf-zz-c") {
            {
                itemCapacity = 30;
                health = 600;
                size = 2;
                hasPower = hasItems = hasLiquids = true;
                craftTime = 65;
                drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
                outputItem = new ItemStack(MWItems.tanfen, 2);
                craftEffect = Fx.smeltsmoke;
                consumePower(2);
                consumeItem(Items.scrap, 3);
                requirements(Category.crafting, new ItemStack[]{
                        new ItemStack(MWItems.tie, 130),
                        new ItemStack(MWItems.shiying, 120)
                });
                        new DrawCrucibleFlame(){
                            {
                                midColor = Color.valueOf("2e2f34");
                                circleStroke = 1.05f;
                                circleSpace = 2.65f;
                            }
                        };

                        }};
                lghcc = new GenericCrafter("lg-hc-c") {
                    {
                        liquidCapacity = 900;
                        itemCapacity = 30;
                        health = 4000;
                        size = 2;
                        hasPower = hasItems = hasLiquids = true;
                        craftTime = 65;
                        consumePower(5);
                        consumeLiquid(MWLiquids.gong, 100 / 60f);
                        consumeLiquid(MWLiquids.xiaosuan, 100 / 130f);
                        drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
                        outputItem = new ItemStack(MWItems.leigong, 1);
                        craftEffect = Fx.smeltsmoke;
                        requirements(Category.crafting, new ItemStack[]{
                                new ItemStack(MWItems.tie, 260),
                                new ItemStack(MWItems.gangban, 420)
                        });
                    }
                };

        jingTchanShengy = new GenericCrafter("jingtichansheng-yi"){{
                requirements(Category.crafting, new ItemStack[]{
                        new ItemStack(MWItems.gangban, 30),
                        new ItemStack(Items.lead, 25),
                        new ItemStack(MWItems.tie, 25)
                });
                outputItem = new ItemStack(MWItems.shingyinghej, 2);
                craftTime = 80f;
                size = 3;
                hasItems = true;
                hasLiquids = true;
                consumePower(15);
                consumeItem(MWItems.shiyingsha, 3);
                consumeItem(MWItems.shiying, 1);
                consumeLiquid(MWLiquids.yedan, 300 / 60f);
                hasPower = true;
            drawer = new DrawMulti(new DrawRegion("-1"), new DrawLiquidTile(MWLiquids.yedan),new DrawRegion("-1-2"));
                    new DrawCrucibleFlame(){
                        {
                            midColor = Color.valueOf("F5F5F5");
                            circleStroke = 1.05f;
                            circleSpace = 2.65f;
                        }

                        @Override
                        public void draw(Building build){
                            if(build.warmup() > 0f && flameColor.a > 0.001f){
                                Lines.stroke(circleStroke * build.warmup());

                                float si = Mathf.absin(flameRadiusScl, flameRadiusMag);
                                float a = alpha * build.warmup();

                                Draw.blend(Blending.additive);
                                Draw.color(flameColor, a);

                                float base = (Time.time / particleLife);
                                rand.setSeed(build.id);
                                for(int i = 0; i < particles; i++){
                                    float fin = (rand.random(1f) + base) % 1f, fout = 1f - fin;
                                    float angle = rand.random(360f) + (Time.time / rotateScl) % 360f;
                                    float len = particleRad * particleInterp.apply(fout);
                                    Draw.alpha(a * (1f - Mathf.curve(fin, 1f - fadeMargin)));
                                    Fill.square(
                                            build.x + Angles.trnsx(angle, len),
                                            build.y + Angles.trnsy(angle, len),
                                            particleSize * fin * build.warmup(), 45
                                    );
                                }

                                Draw.blend();

                                Draw.color(midColor, build.warmup());
                                Lines.square(build.x, build.y, (flameRad + circleSpace + si) * build.warmup(), 45);

                                Draw.reset();
                            }
                        }
                    };
                    }};
        }}