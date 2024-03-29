package modernwarfare.content;

import arc.graphics.Color;
import arc.graphics.g2d.Lines;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.abilities.EnergyFieldAbility;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.entities.abilities.SuppressionFieldAbility;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.HaloPart;
import mindustry.entities.part.ShapePart;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.LegsUnit;
import mindustry.gen.MechUnit;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import modernwarfare.world.MWPal;

import static mindustry.content.Fx.none;
import static mindustry.content.Fx.*;
import static mindustry.gen.Sounds.*;


public class MWUnitTypes {
    public static UnitType nsxpp, xns, feiji1, caikuangji,zhongzixing,jichu,cuowu,
    //双子
    genkui,muyue;


    public static void load() {
        feiji1 = new UnitType("fei-ji-1") {
            {
                constructor = MechUnit::create;
                BulletType h = new MissileBulletType() {{
                    lifetime = 90f;
                    damage = 2024f;
                    speed = 12f;
                }};
                weapons.add(
                        new Weapon("2") {
                            {
                                mirror = true;
                                this.top = false;

                                rotate = true;
                                rotationLimit = 15f;

                                x = 5f;
                                y = -1f;
                                shootY = 6f;
                                reload = 15f;
                                shoot = new ShootSpread() {{
                                    shots = 3;
                                    spread = 3;
                                }};
                                inaccuracy = 4f;
                                velocityRnd = 0.15f;
                                shootSound = Sounds.artillery;
                                shake = 0.75f;
                                bullet = h;
                            }
                        }
                );
                speed = 0.6F;
                hitSize = 8.0F;
                health = 160.0F;
            }

        };

        nsxpp = new UnitType("ns-x-pp") {
            {
                constructor = LegsUnit::create;
                speed = 3.2F;
                drag = 0.1F;
                hitSize = 21.0F;
                rotateSpeed = 3.0F;
                health = 2024520;
                armor = 10.0F;
                legCount = 4;
                legLength = 60.0F;
                legGroupSize = 1;
                legExtension = -4.5F;
                legBaseOffset = 7.0F;
                legLengthScl = 0.925F;
                legMoveSpace = 3.047F;
                hovering = true;
                groundLayer = 74.0F;
                faceTarget = false;

                BulletType s = new ContinuousLaserBulletType() {{
                    width = 1.5f;
                    damage = 2024f;
                    length = 70f;
                }};
                weapons.addAll(
                        new Weapon("1") {{
                            y = -7f;
                            x = 9f;
                            shootY = 7f;
                            reload = 45;
                            shake = 3f;
                            rotateSpeed = 1.5f;
                            ejectEffect = Fx.casing1;
                            shootSound = Sounds.artillery;
                            rotate = true;
                            shadow = 8f;
                            recoil = 3f;
                            bullet = s;
                        }},
                        new Weapon("2") {{
                            y = -7f;
                            x = 9f;
                            shootY = 7f;
                            reload = 45;
                            shake = 3f;
                            rotateSpeed = 1.5f;
                            ejectEffect = Fx.casing1;
                            shootSound = Sounds.artillery;
                            rotate = true;
                            shadow = 8f;
                            recoil = 3f;
                            bullet = s;
                        }},
                        new Weapon("3") {{
                            y = -12f;
                            x = -13f;
                            shootY = 7f;
                            reload = 35;
                            shake = 6f;
                            rotateSpeed = 1.5f;
                            ejectEffect = Fx.casing1;
                            shootSound = Sounds.artillery;
                            rotate = true;
                            shadow = 8f;
                            recoil = 5f;
                            bullet = s;
                        }},
                        new Weapon("3") {{
                            y = -12f;
                            x = 13f;
                            shootY = 7f;
                            reload = 35;
                            shake = 6f;
                            rotateSpeed = 1.5f;
                            ejectEffect = Fx.casing1;
                            shootSound = Sounds.artillery;
                            rotate = true;
                            shadow = 8f;
                            recoil = 5f;
                            bullet = s;
                        }}
                );
            }
        };

        xns = new UnitType("x-ns") {{
            constructor = LegsUnit::create;
            speed = 3.3F;
            drag = 0.1F;
            hitSize = 21.0F;
            rotateSpeed = 3.0F;
            health = 2024520;
            armor = 20.0F;
            legCount = 4;
            legLength = 15.0F;
            legGroupSize = 2;
            legExtension = 4.5F;
            legBaseOffset = 7.0F;
            legLengthScl = 0.925F;
            legMoveSpace = 4F;
            hovering = true;
            groundLayer = 74.0F;
            faceTarget = false;

            BulletType b = new ContinuousLaserBulletType() {{
                damage = 2024F;
            }};
            weapons.addAll(
                    new Weapon("2") {{
                        y = -7f;
                        x = -9f;
                        shootY = 7f;
                        reload = 45;
                        shake = 3f;
                        rotateSpeed = 2.5f;
                        ejectEffect = Fx.casing1;
                        shootSound = Sounds.artillery;
                        rotate = true;
                        shadow = 8f;
                        recoil = 3f;
                        bullet = b;
                    }},
                    new Weapon("1") {{
                        y = -7f;
                        x = 9f;
                        shootY = 7f;
                        reload = 45;
                        shake = 3f;
                        rotateSpeed = 2.5f;
                        ejectEffect = Fx.casing1;
                        shootSound = Sounds.artillery;
                        rotate = true;
                        shadow = 8f;
                        recoil = 3f;
                        bullet = b;
                    }}
            );
        }};
        caikuangji = new UnitType("caikuang-ji") {
            {
                constructor = UnitEntity::create;
                health = 100;
                speed = 2;
                range = 20;
                itemCapacity = 150;
                mineSpeed = 20;
                mineTier = 1;
                flying = true;
                targetAir = false;
                drag = 0.2f;
            }
        };


        zhongzixing = new UnitType("zhongzixing") {
            {
                constructor = UnitEntity::create;
                speed = 4f;
                drag = 0.6f;
                accel = 0.1f;
                rotateSpeed = 14;
                ammoCapacity = 0;
                hitSize = 10;
                flying = true;
                faceTarget = true;
                range = 40;
                health = 81000;
                armor = 62000;
                engineOffset = 2;
                engineSize = 0.1f;
                mineSpeed = 10;
                mineTier = 6;
                buildSpeed = 2;
                abilities.add(new EnergyFieldAbility(20 * 8, 90, 2100) {
                    {

                        hitBuildings = true;
                        damage = 500;
                        reload = 15;
                        range = 20;
                        maxTargets = 60;
                        effectRadius = 0;
                        sectors = 0;
                        rotateSpeed = 0;
                        sectorRad = 0;
                        healPercent = 10;
                    }
                });
                itemCapacity = 1000000;
                parts.add(
                        new ShapePart() {{
                            layer = 110;//所在图层高度
                            stroke = 10;//开始时的粗细
                            strokeTo = 10;//结束时的粗细
                            circle = true;//是否圆圈？
                            hollow = false;//是否空心
                            radius = 10;//开始时的大小
                            radiusTo = 10;//结束时的大小
                            x = 0;
                            y = 0;
                        }},
                        new HaloPart() {{
                            rotateSpeed = 0;
                            sides = 3;
                            shapes = 2;
                            layer = 110;
                            tri = true;
                            radius = 8;
                            radiusTo = 8;
                            triLength = 180;
                            triLengthTo = 180;
                            haloRadius = 10;
                            haloRadiusTo = 10;
                            haloRotation = 0;
                            haloRotateSpeed = -0.9f;
                        }},
                        new HaloPart() {
                            {
                                rotateSpeed = 0;
                                sides = 2;
                                shapes = 6;//围绕旋转的图形数量
                                layer = 110;//所在图层高度
                                tri = false;//是否三角形
                                radius = 8;//开始时的大小
                                radiusTo = 8;//结束时的大小
                                triLength = 180;//三角形开始时的尖锐程度
                                triLengthTo = 180;//三角形结束时的尖锐程度
                                haloRadius = 50;//开始时的围绕半径
                                haloRadiusTo = 50;//结束时的围绕半径
                                haloRotation = 0;//开始时的角度
                                haloRotateSpeed = 0.9f;//旋转速度
                            }
                        });
                BulletType c = new LaserBulletType() {{
                    damage = 624;
                    width = 10;
                    length = 50;
                    lifetime = 160;
                    hitShake = 1;
                    despawnEffect = smokeCloud;
                    smokeEffect = none;
                    abilities.add(new ForceFieldAbility(60f, 0.3f, 400f, 60f * 6));
                }};
                weapons.addAll(
                        new Weapon("qiangpenfa") {{
                            x = 0;
                            y = 0;
                            mirror = false;
                            reload = 60;/*重新装弹速度 */
                            rotate = true;/*是否旋转 */
                            rotateSpeed = 1;/*旋转速度 */
                            inaccuracy = 360;//误差角度
                            shootSound = laserblast;
                            chargeSound = lasercharge;
                            bullet = c;
                            abilities.add(
                                    new SuppressionFieldAbility() {{
                                        particles = 20;  // 粒子数量为6
                                        lifetime = 30;  // 生命周期为5
                                    }}
                            );
                        }},
                        new Weapon("ruopenfa") {
                            {
                                x = 0;
                                y = 0;
                                mirror = false;
                                reload = 120;
                                rotate = true;
                                rotateSpeed = 1;
                                inaccuracy = 360;
                                shootSound = laserblast;
                                chargeSound = lasercharge;
                                bullet = c;
                            }
                        },
                        new Weapon("kaiyuan") {{
                            x = 0;
                            y = 0;
                            mirror = false;
                            reload = 360;
                            rotate = true;
                            rotateSpeed = 1;
                            inaccuracy = 0;
                            continuous = true;
                            shootSound = laserblast;
                            chargeSound = lasercharge;
                            bullet = c;
                        }},
                        new Weapon("changshi-penfa") {{
                            mirror = false;
                            top = false;
                            shake = 1;
                            shootY = 0;
                            x = 0;
                            y = 0;
                            reload = 170;
                            recoil = 0;
                            parentizeEffects = true;
                            chargeSound = lasercharge2;
                            shootSound = beam;
                            continuous = true;
                            cooldownTime = 300;
                            bullet = c;
                        }},
                        new Weapon("zaixing-2") {
                            {
                                x = 0;
                                y = 0;
                                shootY = 0;
                                mirror = false;
                                bullet = new ContinuousLaserBulletType() {
                                    {
                                        maxRange = 260;
                                        lifetime = 390;
                                        damage = 624;
                                        length = 50;
                                    }
                                };
                            }
                        });
            }
        };

        jichu = new UnitType("jichu") {{
            constructor = UnitEntity::create;
            speed=15.4f;
            drag=0.6f;
            accel=0.1f;
            rotateSpeed=20;
            ammoCapacity=0;
            hitSize=18;
            flying=true;
            faceTarget=true;
            range=40;
            health=290;
            armor=2;
            engineSize=1.2f;
            engineOffset=8;
            trailLength=4;
            abilities.add(new ForceFieldAbility(32, 0.04f, 30f, 12));
            weapons.addAll(
                    new Weapon("Bom") {{
                        reload=30;
                        x=0;
                        y=0;
                        rotate=false;
                        shootCone=170;
                        ejectEffect=none;
                        shootSound=explosionbig;
                        mirror=false;
                        inaccuracy=0;
                        alternate=true;
                        top=false;
                        shootOnDeath=true;
                        BulletType g = new ContinuousLaserBulletType() {
                            {
                                maxRange = 260;
                                killShooter=true;
                                splashDamageRadius=78;
                                instantDisappear=true;
                                collides=false;
                                splashDamage=90;
                                speed=1;
                                lifetime=10;
                                hitEffect=massiveExplosion;
                                hitEffect = despawnEffect = new MultiEffect(
                                        new Effect(200, e -> {
                                            rand.setSeed(e.id);
                                            float r = 45 * 8;
                                            float pin = (1 - e.foutpow());
                                            Lines.circle(e.x, e.y, r * pin);

                                            if(!Vars.state.isPaused()) Effect.shake(5, 5, e.x, e.y);
                                        }),
                                        new ExplosionEffect(){{
                                            lifetime = 180f;
                                            waveStroke = 0f;
                                            waveLife = 0f;
                                            smokeColor = Pal.gray;
                                            smokes = 10;
                                            smokeSize = 56;
                                            sparks = 16;
                                            smokeRad = sparkRad = 45 * 8;
                                            sparkLen = 21f;
                                            sparkStroke = 9f;
                                        }}
                                );
                                abilities.add(
                                        new SuppressionFieldAbility() {
                                            {
                                                orbRadius = 5;
                                                particleSize = 9;
                                                y = -12.4f;
                                                x = 2;
                                                particles = 18;
                                                length = 65;
                                                lifetime = 35;
                                            }},
                                new SuppressionFieldAbility() {
                                    {
                                        particles = 12;
                                        length = 23;
                                        lifetime = 22;
                                    }});
                            }
                        };
                        abilities.add(new ForceFieldAbility(60f, 0.3f, 400f, 60f * 6));
                        bullet = g;
                    }
                    }
                );
            }
        };

        cuowu = new UnitType("cuowu") {{
            constructor = UnitEntity::create;//类别是飞机
            speed=5.4f;//速度
            drag=0.6f;//拉
            accel=0.1f;//加速
            ammoCapacity=0;//弹药容量
            hitSize=18;//命中尺寸
            flying=true;//是否飞行
            faceTarget=true;//面部目标
            range=90;//范围
            health=2048;//生命
            armor=2;//装甲
            engineSize=1.2f;//发动机大小
            engineOffset=8;//发动机偏移
            trailLength=4;//步道长度
            abilities.add(new EnergyFieldAbility(20 * 8, 90, 2100) {//立场墙特效
                {
                    hitBuildings = true;//是否命中建筑物
                    damage = 5000;//伤害
                    reload = 15;//重新加载时间
                    range = 20;//范围
                    maxTargets = 60;//最大目标
                    effectRadius = 0;//效果半径
                    rotateSpeed = 0;//旋转速度
                }
            });
            BulletType h = new ContinuousLaserBulletType() {
                {
                    width = 5f;
                    length = 600;
                    damage = 500;
                    shake = 1f;
                    largeHit = true;
                    drawSize =420f;
                    incendAmount = 1;
                    incendSpread =5;
                    incendChance = 0.4f;
                    lightColor = Color.blue;
                    hitColor = colors[2];
                }};
            parts.add(
                    new HaloPart() {
                        {
                            rotateSpeed = 3;
                            sides = 3;
                            shapes = 6;//围绕旋转的图形数量
                            layer = 110;//所在图层高度
                            tri = false;//是否三角形
                            radius = 8;//开始时的大小
                            radiusTo = 15;//结束时的大小
                            triLength = 180;//三角形开始时的尖锐程度
                            triLengthTo = 180;//三角形结束时的尖锐程度
                            haloRadius = 30;//开始时的围绕半径
                            haloRadiusTo = 50;//结束时的围绕半径
                            haloRotation = 0;//开始时的角度
                            haloRotateSpeed = 0.9f;//旋转速度
                        }
                    });

            weapons.addAll(
                    new Weapon("sishe") {{
                        reload=30;
                        x=10;
                        y=0;
                        rotate=false;
                        shootCone=170;
                        ejectEffect=none;
                        shootSound=explosionbig;
                        mirror=false;
                        inaccuracy=0;
                        alternate=true;
                        top=false;
                        shootOnDeath=true;
                        bullet = h;
                    }},
                    new Weapon("sishe2") {{
                        reload=30;
                        x=-10;
                        y=0;
                        rotate=false;
                        shootCone=170;
                        ejectEffect=none;
                        shootSound=explosionbig;
                        mirror=false;
                        inaccuracy=0;
                        alternate=true;
                        top=false;
                        shootOnDeath=true;
                        bullet = h;
                    }}
            );
        }};

        genkui = new UnitType("genkui") {
            {
                constructor = LegsUnit::create;
                speed=2.1f;//速度
                drag=0.6f;//拉
                accel=0.1f;//加速
                hitSize=18;//命中尺寸
                faceTarget=true;//面部目标
                range=90;//范围
                health=3000;//生命
                armor=2;//装甲
                abilities.add(new ForceFieldAbility(200f, 0.3f, 4000f, 60f * 6));

                parts.add(
                        new HaloPart() {
                            {
                                color = Color.red;
                                rotateSpeed = 3;
                                sides = 3;
                                shapes = 6;//围绕旋转的图形数量
                                layer = 110;//所在图层高度
                                tri = false;//是否三角形
                                radius = 8;//开始时的大小
                                radiusTo = 15;//结束时的大小
                                triLength = 180;//三角形开始时的尖锐程度
                                triLengthTo = 180;//三角形结束时的尖锐程度
                                haloRadius = 30;//开始时的围绕半径
                                haloRadiusTo = 50;//结束时的围绕半径
                                haloRotation = 0;//开始时的角度
                                haloRotateSpeed = 0.9f;//旋转速度
                            }
                        });

                BulletType i = new LaserBoltBulletType() {
                    {
                        lightColor = MWPal.sky11;
                        range=900;
                        speed=5f;
                        width = 5f;
                        damage = 500;
                        drawSize =420f;
                        incendAmount = 1;
                        incendSpread =5;
                        incendChance = 0.4f;
                    }};
                weapons.addAll(
                        new Weapon("sishe") {{
                            reload=5;
                            x=10;
                            y=0;
                            rotate=false;
                            shootCone=170;
                            ejectEffect=none;
                            shootSound=explosionbig;
                            mirror=false;
                            inaccuracy=0;
                            alternate=true;
                            top=false;
                            shootOnDeath=true;
                            bullet = i;
                        }},
                        new Weapon("sishe1") {{
                            reload=5;
                            x=-10;
                            y=0;
                            rotate=false;
                            shootCone=170;
                            ejectEffect=none;
                            shootSound=explosionbig;
                            mirror=false;
                            inaccuracy=0;
                            alternate=true;
                            top=false;
                            shootOnDeath=true;
                            bullet = i;
                        }}
                );
            }
        };

        muyue = new UnitType("muyue") {
            {
                constructor = LegsUnit::create;
                speed=2.1f;//速度
                drag=0.6f;//拉
                accel=0.1f;//加速
                hitSize=18;//命中尺寸
                faceTarget=true;//面部目标
                range=90;//范围
                health=3000;//生命
                armor=2;//装甲
                abilities.add(new ForceFieldAbility(200f, 0.3f, 4000f, 60f * 6));

                parts.add(
                        new HaloPart() {
                            {
                                color = Color.blue;
                                rotateSpeed = 3;
                                sides = 3;
                                shapes = 6;//围绕旋转的图形数量
                                layer = 110;//所在图层高度
                                tri = false;//是否三角形
                                radius = 8;//开始时的大小
                                radiusTo = 15;//结束时的大小
                                triLength = 180;//三角形开始时的尖锐程度
                                triLengthTo = 180;//三角形结束时的尖锐程度
                                haloRadius = 30;//开始时的围绕半径
                                haloRadiusTo = 50;//结束时的围绕半径
                                haloRotation = 0;//开始时的角度
                                haloRotateSpeed = 0.9f;//旋转速度
                            }
                        });

                BulletType i = new LaserBoltBulletType() {
                    {
                        lightColor = MWPal.red22;
                        range=900;
                        speed=5f;
                        width = 5f;
                        damage = 500;
                        drawSize =420f;
                        incendAmount = 1;
                        incendSpread =5;
                        incendChance = 0.4f;
                    }};
                weapons.addAll(
                        new Weapon("mingsi") {{
                            reload=5;
                            x=10;
                            y=0;
                            rotate=false;
                            shootCone=170;
                            ejectEffect=none;
                            shootSound=explosionbig;
                            mirror=false;
                            inaccuracy=0;
                            alternate=true;
                            top=false;
                            shootOnDeath=true;
                            bullet = i;
                        }},
                        new Weapon("mingsi1") {{
                            reload=5;
                            x=-10;
                            y=0;
                            rotate=false;
                            shootCone=170;
                            ejectEffect=none;
                            shootSound=explosionbig;
                            mirror=false;
                            inaccuracy=0;
                            alternate=true;
                            top=false;
                            shootOnDeath=true;
                            bullet = i;
                        }}
                );
            }};
    }
}

