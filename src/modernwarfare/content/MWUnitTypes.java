package modernwarfare.content;

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

import static mindustry.content.Fx.none;
import static mindustry.content.Fx.*;
import static mindustry.content.StatusEffects.electrified;
import static mindustry.gen.Sounds.*;
import static modernwarfare.content.MWStatusEffects.cuowei1;
import static modernwarfare.content.MWStatusEffects.cuowei2;


public class MWUnitTypes {
    public static UnitType nsxpp, xns, feiji1, caikuangji,zhongzixing,jichu;


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

                BulletType s = new SapBulletType() {{
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

            BulletType b = new SapBulletType() {{
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
                        status = cuowei2;
                        statusDuration = 60;
                        maxTargets = 60;
                        effectRadius = 0;
                        sectors = 0;
                        rotateSpeed = 0;
                        sectorRad = 0;
                        healPercent = 10;
                        damageEffect = none;
                        hitEffect = none;
                        healEffect = none;
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
                            BulletType b = new LaserBulletType() {{
                                damage = 1124;
                                width = 10;
                                length = 100;
                                statusDuration = 240;
                                status = electrified;
                                hitShake = 3;  // 命中震动程度为2
                                despawnEffect = smokeCloud;
                                smokeEffect = none;
                            }};
                            bullet = b;
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
                                BulletType c = new LaserBulletType() {{
                                    damage = 624;
                                    width = 10;
                                    length = 50;
                                    statusDuration = 120;
                                    status = electrified;
                                    lifetime = 160;
                                    hitShake = 1;
                                    despawnEffect = smokeCloud;
                                    smokeEffect = none;
                                    abilities.add(new ForceFieldAbility(60f, 0.3f, 400f, 60f * 6));
                                }};
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
                            BulletType d = new LaserBulletType() {{
                                damage = 624;
                                width = 10;
                                length = 50;
                                statusDuration = 120;
                                status = electrified;
                                lifetime = 160;
                                hitShake = 1;
                                despawnEffect = smokeCloud;
                                smokeEffect = none;
                                abilities.add(new ForceFieldAbility(60f, 0.3f, 400f, 60f * 6));
                            }};
                            bullet = d;
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
                            BulletType e = new ContinuousLaserBulletType() {{
                                smokeEffect = none;
                                status = cuowei1;
                                statusDuration = 300;
                                collidesTeam = true;
                                healPercent = 1.3f;
                                ammoMultiplier = 1;
                                damage = 265;
                                abilities.add(new ForceFieldAbility(60f, 0.3f, 400f, 60f * 6));
                            }};
                            bullet = e;
                        }},
                        new Weapon("zaixing-2") {
                            {
                                x = 0;
                                y = 0;
                                shootY = 0;
                                mirror = false;
                                BulletType f = new ContinuousLaserBulletType() {
                                    {
                                        maxRange = 260;
                                    }
                                };
                                bullet = f;
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
    }
}

