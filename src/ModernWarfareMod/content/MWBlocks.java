package ModernWarfareMod.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.SapBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.SolidPump;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawFlame;
import mindustry.world.draw.DrawMulti;

import static mindustry.content.Fx.casing2;
import static mindustry.content.Fx.shootBig;
import static mindustry.content.Liquids.slag;
import static mindustry.content.StatusEffects.burning;
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

    private static ItemTurret dangtiao, liudanpao, xingshuang;

    protected static GenericCrafter jiexi, tfzzc,lghcc;

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
            heatColor = Color.valueOf("#FF0000");
            ammo(
                    MWItems.zidanjuhenengyuan, new BasicBulletType() {{
                        width = 14f;
                        height = 19f;
                        pierceCap = 1;
                        reloadMultiplier = 3.3F;
                        speed = 2;
                        damage = 50;
                        knockback = 1.1F;
                        lifetime = 90;
                        ammoMultiplier = 2;

                    }});
            requirements(Category.turret, with(MWItems.tie, 40, MWItems.shiying, 80));
            category = Category.valueOf("turret");
        }};


        liudanpao = new ItemTurret("liu-dan-pao") {{
            size = 3;
            health = 3500;
            range = 480;
            inaccuracy = 3;
            ammoPerShot = 1;
            ammo(
                    MWItems.paodannengyuan, new BasicBulletType() {
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
                    }
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
                maxAmmo = 120;
                targetAir = true;
                targetGround = true;
                coolantMultiplier = 2;
                heatColor = Color.red;
                ammo(
                        MWItems.paodannengyuan, new BasicBulletType() {
                            {
                                status = burning;
                                pierceCap = 1;
                                recoil = 5;
                                splashDamage = 20;
                                splashDamageRadius = 84;
                                damage = 16;
                                shootEffect = shootBig;
                                ammoMultiplier = 10;
                                knockback = 0.3f;
                                speed = 3;
                                reloadMultiplier = 1;
                                lifetime = 90;
                                range = 400;
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
        }};

        tfzzc = new GenericCrafter("tf-zz-c") {{
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
    }
}