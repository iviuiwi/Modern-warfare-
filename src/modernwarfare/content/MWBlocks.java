package modernwarfare.content;

import arc.graphics.Blending;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Mathf;
import arc.struct.Seq;
import arc.util.Time;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.UnitTypes;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BombBulletType;
import mindustry.entities.bullet.SapBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Building;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.blocks.defense.OverdriveProjector;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.Turret;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.SolidPump;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.consumers.ConsumeLiquid;
import mindustry.world.draw.*;
import mindustry.world.meta.BuildVisibility;

import static arc.graphics.g2d.Draw.color;
import static mindustry.content.Fx.*;
import static mindustry.content.Liquids.slag;
import static mindustry.content.Liquids.water;
import static mindustry.content.StatusEffects.burning;
import static mindustry.gen.Sounds.missile;
import static mindustry.gen.Sounds.smelter;
import static mindustry.type.Category.*;
import static mindustry.type.ItemStack.with;
import static mindustry.world.meta.Attribute.heat;

public class MWBlocks {
    public static Wall gangbanqiang;
    public static Wall shiyingqiang;
    private static Wall juxingshiyingqiang;
    private static Wall daxingganbanqiang;
    private static Wall daxingshiyingqiang;

    private static SolidPump tanshenkuangzhachouquji, tianranqichouquji;

    private static Turret dangtiao, liudanpao, xingshuang, shengguang,shengmie,shipo,suishan;

    protected static GenericCrafter jiexi, tfzzc, lghcc, jingTchanShengy,chaonengyuanji, meitanzhuan,anqiyang,yangqishouji,gangbanlianzhi
            ,danqiyindaoji,danyaorongzhichang,anqihechengchang,kuangzhaningjuji,shiyingfensuichang,shuitiefanyingji,huahewulianzhilu;

    private static UnitFactory chuji;

    private static PowerNode gaoya;

    private static ConsumeGenerator bailinranshaochang;

    protected static OverdriveProjector cchangcshengy;
    ;
    private static CoreBlock spaceStationCore;

    public static void load() {


        gangbanqiang = new Wall("gang-ban-qiang") {{

            health = 3500;
            size = 1;
            requirements(power, with(MWItems.gangban, 6));
            category = defense;
            absorbLasers = true;
            chanceDeflect = 60;
        }};

        shiyingqiang = new Wall("shi-ying-qiang") {{

            health = 4500;
            size = 1;
            requirements(power, with(MWItems.shiying, 6));
            category = defense;
            absorbLasers = true;
        }};

        Wall bailingqiang = new Wall("bai-ling-qiang") {{

            health = 500;
            size = 1;
            requirements(power, with(MWItems.bailin, 12));
            category = defense;
        }};

        Wall juxingganbanqiqang = new Wall("ju-xing-gang-ban-qiang") {{

            health = 13000;
            size = 3;
            requirements(power, with(MWItems.gangban, 48));
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
            requirements(power, with(MWItems.shiying, 72));
            category = defense;
            absorbLasers = true;
            chanceDeflect = 40;
        }};

        daxingganbanqiang = new Wall("da-xing-gang-ban-qiang") {{

            health = 5000;
            size = 2;
            requirements(power, with(MWItems.gangban, 36));
            category = defense;
            absorbLasers = true;
            chanceDeflect = 90;
        }};

        daxingshiyingqiang = new Wall("da-xing-shi-ying-qiang") {
            {

                health = 8000;
                size = 2;
                requirements(power, with(MWItems.shiying, 24));
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
            reload = 5f;
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
                        damage = 120;
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
                                reload = 30f;
                                splashDamage = 20;
                                splashDamageRadius = 84;
                                damage = 50;
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
                maxAmmo = 20;
                targetAir = true;
                targetGround = true;
                coolantMultiplier = 2;
                heatColor = Color.red;
                drawer = new DrawTurret("reinforced-") {{
                    new RegionPart("-mid") {{
                        progress = PartProgress.recoil;
                        mirror = false;
                        under = true;
                        moveY = -0.8f;
                    }};
                }};
                ammo(
                        MWItems.bailin, new SapBulletType() {
                            {
                                status = burning;
                                width = 0.9f;
                                pierceCap = 1;
                                recoil = 9;
                                splashDamage = 20;
                                splashDamageRadius = 84;
                                damage = 16;
                                shootEffect = shootBig;
                                ammoMultiplier = 10;
                                knockback = 0.3f;
                                speed = 9;
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

        shengmie = new ItemTurret("sheng-mie") {{
                size=2;
                health=2600;
                ammoPerShot=10;
                range=260;
                reload=60;
                liquidCapacity=60;
                coolant = consume(new ConsumeLiquid(Liquids.cryofluid, 0.05f));
                recoil=10;
                recoilTime=20;
                inaccuracy=1;
                ammoUseEffect=casing2;
                rotateSpeed=2.3f;
                maxAmmo=50;
                targetAir=true;
                targetGround=true;
                coolantMultiplier=2.9f;
                ammo(
                MWItems.bailin, new BombBulletType() {{
                            status=burning;
                            splashDamageRadius=25;
                            splashDamage=30;
                            pierceCap=1;
                            reloadMultiplier=1.6f;
                            speed=18;
                            damage=50;
                            knockback=2.3f;
                            lifetime=36;
                            width=10;
                            height=20;
                            ammoMultiplier=1;
                            shootEffect=shootBig;
                    }});
                requirements(Category.crafting, new ItemStack[]{
                        new ItemStack(MWItems.tie, 230),
                        new ItemStack(MWItems.gangban, 140),
                        });
                category=turret;
                //荡涤
            }};

        shipo = new ItemTurret("shipo") {{
                size=2;
                health=1000;
                ammoPerShot=1;
                range=520;
                reload=60;
                consumePower(2);
                inaccuracy=0;
                ammoPerShot=1;
                ammoUseEffect=casing2;
                shootSound=missile;
                maxAmmo=120;
                targetAir=true;
                targetGround=true;
                coolantMultiplier=5;
                ammo(
                    MWItems.chaonengti1xing, new BombBulletType() {{
                        pierceCap=1;
                        reloadMultiplier=1;
                        speed=20;
                        damage=1;
                        knockback=1.1f;
                        lifetime=60;
                        width=3;
                        height=45;
                        ammoMultiplier=10;
                        status=MWStatusEffects.cuowei1;
                        splashDamageRadius=1;
                        splashDamage=60;
                        shootEffect=shootBig;
                    }},
                        MWItems.chaonengti2xing, new BombBulletType() {{
                        pierceCap=1;
                        reloadMultiplier=1.2f;
                        speed=26;
                        damage=1;
                        knockback=1;
                        lifetime=60;
                        width=2;
                        height=60;
                        ammoMultiplier=11;
                        status=MWStatusEffects.cuowei2;
                        splashDamageRadius=1;
                        splashDamage=60;
                        shootEffect=shootBig;
                    }},
                        MWItems.chaonengti3xing, new BombBulletType() {{
                        pierceCap = 1;
                        reloadMultiplier = 1.4f;
                        speed = 30;
                        damage = 1;
                        knockback = 1;
                        lifetime = 80;
                        width = 1;
                        height = 75;
                        ammoMultiplier = 12;
                        status = MWStatusEffects.cuowei3;
                        splashDamageRadius = 1;
                        splashDamage = 60;
                        shootEffect = shootBig;
                        requirements(Category.crafting, new ItemStack[]{
                                new ItemStack(MWItems.tie, 300),
                                new ItemStack(MWItems.guitie, 150),
                                new ItemStack(MWItems.shiying, 200)
                                });
                category = turret;
                                //现代战争-锋芒
                            }});
        }};


        suishan = new ItemTurret("suishan") {{
                size=3;
                health=4000;
                range=240;
                reload=50;
                inaccuracy=3;
                ammoPerShot=1;
                ammoUseEffect=casing2;
                maxAmmo=20;
                targetAir=false;
                coolantMultiplier=2;
            ammo(
                MWItems.paodannengyuan, new BombBulletType() {{
                    pierceCap=1;
                    reloadMultiplier=0.8f;
                    speed=5;
                    fragBullets=20;
                    fragBullet = new ArtilleryBulletType(){
                        {
                            damage = 400;
                            fragBullets = 10;
                            fragBullet = new ArtilleryBulletType() {{
                                fragBullets = 5;
                                status = burning;
                                splashDamageRadius = 35;
                                splashDamage = 30;
                                damage = 200;
                            }};
                        }};
                    damage=350;
                    knockback=15.5f;
                    lifetime=80;
                    width=35;
                    height=35;
                    ammoMultiplier=1;
                    shootEffect=shootBig;
                }});
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(MWItems.tie, 140),
                    new ItemStack(MWItems.gangban, 70),
            });
                category=turret;
                //duo
        }};

        //————————————————————————————————————————————————————————————————————————————————
        //以下工厂：

        jiexi = new GenericCrafter("jie-xi") {{
            itemCapacity = 30;
            health = 1000;
            size = 3;
            hasPower = hasLiquids = false;
            hasItems = true;
            craftTime = 65;
            consumeItem(MWItems.tie, 2);
            outputItem = new ItemStack(MWItems.gangban, 1);
            updateEffect = smeltsmoke;
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(MWItems.tie, 25),
            });
        }};

        chuji = new UnitFactory("chuji"){{
            requirements(Category.units, with(Items.copper, 50, Items.lead, 120, Items.silicon, 80));
            plans = Seq.with(
                    new UnitPlan(MWUnitTypes.caikuangji, 60f * 15, with(Items.graphite, 20, MWItems.tie, 30)),
                    new UnitPlan(MWUnitTypes.jichu, 60f * 15, with(Items.graphite, 120, Items.silicon, 80))
            );
            size = 3;
            consumePower(1.2f);
        }};

        gaoya = new PowerNode("gaoji"){{
            size=1;
            health=120;
            laserRange=20;
            maxNodes=30;
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(MWItems.tie, 10),
            });
            category=power;
           //现代战争-铁
        }};

        tfzzc = new GenericCrafter("tf-zz-c") {{
            itemCapacity = 30;
            health = 600;
            size = 2;
            hasPower = hasItems = hasLiquids = true;
            craftTime = 65;
            drawer = new DrawMulti(new DrawDefault());
            outputItem = new ItemStack(MWItems.tanfen, 2);
            craftEffect = MWFx.lle(Color.white, 1.1f);
            consumePower(2);
            consumeItem(Items.scrap, 3);
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(MWItems.tie, 130),
                    new ItemStack(MWItems.shiying, 120)
                });
                new DrawCrucibleFlame() {
                    {
                        midColor = Color.valueOf("2e2f34");
                        circleStroke = 1.05f;
                        circleSpace = 2.65f;
                    }
                };

            }
        };
        lghcc = new GenericCrafter("lg-hc-c") {{
            liquidCapacity = 900;
            itemCapacity = 30;
            health = 4000;
            size = 2;
            hasPower = hasItems = hasLiquids = true;
            craftTime = 65;

            consumePower(5);
            consumeLiquid(MWLiquids.gong, 100 / 60f);
            consumeLiquid(MWLiquids.xiaosuan, 100 / 130f);

            drawer = new DrawMulti(new DrawDefault());
            outputItem = new ItemStack(MWItems.leigong, 1);

            craftEffect = MWFx.maoyan;
            craftEffect = MWFx.xuan(4f, 360);

            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(MWItems.tie, 260),
                    new ItemStack(MWItems.gangban, 420)
                });
            }
        };

        meitanzhuan = new GenericCrafter("mt-zhuan") {{
            itemCapacity = 60;
            health = 4000;
            size = 2;
            hasPower = hasItems = true;
            hasLiquids = false;
            craftTime = 65;
            consumePower(3);
            consumeItem(Items.coal, 1);
            consumeLiquid(MWLiquids.jiujing, 120 / 60f);
            drawer = new DrawMulti(new DrawDefault());
            outputLiquids = LiquidStack.with(MWLiquids.jiujing, 120 / 60);
            updateEffect=hitEmpSpark;
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(MWItems.tie, 50),
                    new ItemStack(MWItems.gangban, 30),
                    new ItemStack(MWItems.shiying, 60)
                });
    }
        };
        anqiyang = new GenericCrafter("anqi-yanghua") {{
            liquidCapacity = 900;
            health=3000;
            size=3;
            hasPower=hasLiquids=true;
            hasItems=false;
            craftTime=65;
            consumePower(3);
            consumeLiquid(MWLiquids.yangqi, 600 / 60f);
            consumeLiquid(Liquids.water, 100 / 60f);
            consumeLiquid(MWLiquids.anqi, 600 / 60f);
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.water, 2f),
                    new DrawBubbles(Color.valueOf("7693e3")){{
                            sides = 10;
                            recurrence = 3f;
                            spread = 6;
                            radius = 1.5f;
                            amount = 20;
                        }},
                    new DrawRegion(),
                    new DrawLiquidOutputs(),
                    new DrawGlowRegion(){{
                            alpha = 0.7f;
                            color = Color.valueOf("c4bdf3");
                            glowIntensity = 0.3f;
                            glowScale = 6f;
                        }}
                );
            outputLiquids = LiquidStack.with(MWLiquids.xiaosuan, 120 / 60);
            updateEffect=smeltsmoke;
            requirements(Category.crafting, new ItemStack[]{
                        new ItemStack(MWItems.gangban, 320),
                        new ItemStack(MWItems.shiying, 240)
                });
            }
        };

        yangqishouji = new GenericCrafter("yangqi-shouji") {{
            liquidCapacity=900;
            health=4000;
            size=2;
            hasPower=true;
            hasLiquids=hasItems=false;
            craftTime=45;
            consumePower(3*2);
            drawer = new DrawMulti(new DrawDefault());
            outputLiquids = LiquidStack.with(MWLiquids.yangqi, 120 / 60);
            updateEffect=smeltsmoke;
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(MWItems.gangban, 120),
                    new ItemStack(MWItems.tie, 340)
                });
            }
            };

        gangbanlianzhi = new GenericCrafter("gangban-lianzhi") {{
            itemCapacity = 30;
            health = 1000;
            size = 3;
            hasPower = hasLiquids = false;
            hasItems = true;
            craftTime = 65;
            consumeItem(MWItems.tie, 1);
            outputItem = new ItemStack(MWItems.gangban, 1);
            updateEffect = smeltsmoke;
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(MWItems.tie, 25)
                });
            }
        };

        chaonengyuanji = new GenericCrafter("chaonengyuanji"){{
            liquidCapacity=1800;
            health=8000;
            size=5;
            hasPower=hasLiquids=true;
            hasItems=false;
            craftTime=125;
            consumePower(3*10);
            consumeLiquid(MWLiquids.anqi, 0.2f);
            consumeLiquid(MWLiquids.yangqi, 0.3f);
            consumeLiquid(MWLiquids.tianranqi, 0.5f);
            consumeLiquid(MWLiquids.danqi, 0.45f);
            consumeLiquid(MWLiquids.xiaosuan, 600 / 60f);
            consumeLiquid(Liquids.water, 0.9f);
            drawer = new DrawMulti(new DrawDefault());
            drawer = new DrawLiquidTile();
            drawer = new DrawRegion(new DrawDefault().toString());
            outputItem = new ItemStack(MWItems.chaonengti1xing, 2);
            updateEffect=smeltsmoke;
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(MWItems.tie, 820),
                    new ItemStack(MWItems.guitie, 1220),
                    new ItemStack(MWItems.gangban, 520),
                    new ItemStack(MWItems.shiying, 340)

            });
               //现代战争-氨气氧化厂
            }
        };

        danqiyindaoji = new GenericCrafter("danqi-yindaoji"){{
            liquidCapacity = 900;
            health = 4000;
            size = 2;
            hasPower = true;
            hasLiquids = hasItems = false;
            craftTime = 45;
            consumePower(3 * 2);
            drawer = new DrawMulti(new DrawDefault());
            outputLiquids = LiquidStack.with(MWLiquids.danqi, 0.5f);
            updateEffect = smeltsmoke;
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(MWItems.tie, 140),
                    new ItemStack(MWItems.gangban, 120)
                });
            }};

        danyaorongzhichang = new GenericCrafter("danyao-rongzhichang"){{
            itemCapacity=120;
            health=2000;
            size=2;
            hasPower=hasLiquids=false;
            hasItems=true;
            drawer = new DrawMulti(new DrawDefault());
            drawer = new DrawMulti(new DrawRegion("-top"));
            drawer = new DrawMulti(new DrawFlame(Color.valueOf("ffef99")));
            craftTime=65;
            consumePower(2);
            consumeItem(MWItems.tie, 3);
            updateEffect=hitEmpSpark;
            outputItem = new ItemStack(MWItems.paodannengyuan, 1);
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(MWItems.tie, 25)
                    });
                       //现代战争-铁
        }};

        anqihechengchang = new GenericCrafter("anqi-hechengchang"){{
            liquidCapacity=900;
            health=6000;
            size=3;
            hasPower=hasLiquids=true;
            hasItems=false;
            craftTime=65;
            consumePower(2*5);
            consumeLiquid(MWLiquids.qingqi, 0.1f);
            consumeLiquid(MWLiquids.danqi, 0.1f);
            drawer = new DrawMulti(new DrawDefault());
            outputLiquids = LiquidStack.with(MWLiquids.anqi, 0.1f);
            updateEffect=smeltsmoke;
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(MWItems.tie, 120),
                    new ItemStack(MWItems.gangban, 320),
                    new ItemStack(MWItems.shiying, 240),
            });
            //现代战争-氮气引导机
            }};

        kuangzhaningjuji = new GenericCrafter("kuangzha-ningjuji"){{
            liquidCapacity=900;
            itemCapacity=100;
            health=3000;
            size=3;
            hasPower=hasItems=hasLiquids=true;
            craftTime=30;
            consumeItem(Items.copper, 1);
            consumeItem(Items.lead, 1);
            consumeLiquid(slag, 0.1f);
            drawer = new DrawMulti(new DrawDefault());
            outputItem = new ItemStack(Items.scrap, 2);
            updateEffect=smeltsmoke;
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(MWItems.gangban, 320),
                    new ItemStack(MWItems.shiying, 240),
            });
            //现代战争-氧气收集器
        }};

        shiyingfensuichang = new GenericCrafter("shiying-fensuichang"){{
            itemCapacity=30;
            health=1000;
            size=2;
            hasPower=hasItems=true;
            hasLiquids=false;
            craftTime=65;
            consumePower(3);
            consumeItem(MWItems.shiying, 1);
            drawer = new DrawMulti(new DrawDefault());
            outputItem = new ItemStack(MWItems.shiyingsha, 3);
            updateEffect=smeltsmoke;
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(MWItems.tie, 80),
                    new ItemStack(MWItems.shiying, 120),
            });
            //copper
        }};

        shuitiefanyingji = new GenericCrafter("shuitie-fanyingji"){{
            liquidCapacity=900;
            itemCapacity=400;
            health=5000;
            size=2;
            hasPower=hasLiquids=hasItems=true;
            craftTime=45;
            consumePower(3*2);
            consumeLiquid(water, 0.3f);
            consumeItem(MWItems.tie, 1);
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawRegion("-bottom"),
                new DrawLiquidTile()
            );
            outputLiquids = LiquidStack.with(MWLiquids.qingqi, 0.5f);
            updateEffect=smeltsmoke;
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(MWItems.shiying, 240),
                    new ItemStack(MWItems.gangban, 160),
            });
           //现代战争-氧气收集器
        }};

        huahewulianzhilu = new GenericCrafter("huahewu-lianzhilu"){{
            itemCapacity=90;
            health=500;
            size=2;
            hasPower=hasItems=true;
            hasLiquids=false;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawFlame(Color.valueOf("FFD700")
                    ));
            craftTime=65;
            consumePower(5);
            consumeItems(with(MWItems.tanfen, 2, MWItems.shiyingsha, 1, MWItems.lingsuangai, 3));
            drawer = new DrawMulti(new DrawDefault());
            outputItem = new ItemStack(MWItems.bailin, 1);
            updateEffect=freezing;
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(MWItems.tie, 80),
                    new ItemStack(MWItems.shiying, 30),
            });
            //现代战争-石英
        }};

        bailinranshaochang = new ConsumeGenerator("bailin-ranshaochang"){{
            size=2;
            health=1600 ;
            hasLiquids=false;
            hasItems=true;
            itemDuration=30;
            powerProduction=15;
            itemCapacity=2;
            generateEffect=generatespark;
            consumeItem(MWItems.bailin, 1);
            requirements(Category.crafting, new ItemStack[]{
                    new ItemStack(MWItems.tie, 80),
                    new ItemStack(MWItems.shiying, 50),
                    new ItemStack(MWItems.gangban, 90),
            });
            ambientSound=smelter;
            ambientSoundVolume=0.01f;
            category=power;
            //现代战争-高压能量节点
        }};


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
                craftEffect = MWFx.maoyan;
            drawer = new DrawMulti(new DrawDefault(),new DrawLiquidTile(MWLiquids.yedan),new DrawRegion("-1-2"));

            new DrawCrucibleFlame(){
                {
                    midColor = Color.valueOf("2e2f34");
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
                        color(flameColor, a);

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

                        color(midColor, build.warmup());
                        Lines.square(build.x, build.y, (flameRad + circleSpace + si) * build.warmup(), 45);

                        Draw.reset();
                    }
                }
            };
                    new DrawGlowRegion(){{
                        layer = -1;
                        glowIntensity = 1.1f;
                        alpha = 1.1f;
                    }};
            }
        };
        cchangcshengy = new OverdriveProjector("cchang-csheng-y"){{
            requirements(Category.effect, with(Items.lead, 200, Items.titanium, 130, Items.silicon, 130, Items.plastanium, 80, Items.surgeAlloy, 120));
            consumePower(15f);
            size = 3;
            range = 200f;
            speedBoost = 4f;
            useTime = 9000;
            hasBoost = false;
            consumeItems(with(MWItems.shingyinghej, 1));

        }};
        spaceStationCore = new CoreBlock("space-station-core"){{
            requirements(Category.effect, BuildVisibility.editorOnly, with(MWItems.tie, 1300));
            alwaysUnlocked = true;

            isFirstTier = true;
            unitType = MWUnitTypes.xns;
            health = 1300;
            itemCapacity = 4000;
            size = 3;

            unitCapModifier = 16;
        }};
    }
}