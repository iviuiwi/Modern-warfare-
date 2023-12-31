package modernwarfare.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.bullet.SapBulletType;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.LegsUnit;
import mindustry.gen.MechUnit;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;


public class MWUnitTypes {
    public static UnitType nsxpp,xns,feiji1,zns;



    public static void load() {
        feiji1 = new UnitType("fei-ji-1"){
            {
                constructor = MechUnit::create;
                BulletType h = new MissileBulletType(){{
                    lifetime = 90f;
                    damage = 2024f;
                    speed = 12f;
                }};
                weapons.add(
                        new Weapon("2"){
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
                                }}
                        );
                speed = 0.6F;
                hitSize = 8.0F;
                health = 160.0F;
            }

        };

        nsxpp = new UnitType("ns-x-pp"){{
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

            BulletType s = new SapBulletType(){{
                width = 1.5f;
                damage = 2024f;
                length = 70f;
            }};
            weapons.addAll(
                    new Weapon("1"){{
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
                    new Weapon("2"){{
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
            new Weapon("3"){{
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
            new Weapon("3"){{
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

        xns = new UnitType("x-ns"){{
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

            BulletType b = new SapBulletType(){{
                damage = 2024F;
            }};
            weapons.addAll(
                    new Weapon("2"){{
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
                    new Weapon("1"){{
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

            zns = new UnitType("z-ns"){{
                constructor = MechUnit::create;
                speed = 2.7F;
                drag = 0.1F;
                hitSize = 21.0F;
                rotateSpeed = 3.0F;
                health = 2024520;
                armor = 10.0F;
                hovering = true;//悬浮
                groundLayer = 74.0F;//图层
                faceTarget = false;

                BulletType w = new LaserBulletType(){{
                    length = 460f;
                    damage = 560f;
                    width = 110f;

                    lifetime = 65f;

                    lightningSpacing = 35f;
                    lightningLength = 5;
                    lightningDelay = 1.1f;
                    lightningLengthRand = 15;
                    lightningDamage = 50;
                    lightningAngleRand = 40f;
                    largeHit = true;
                    lightColor = lightningColor = Pal.heal;

                    chargeEffect = Fx.greenLaserCharge;

                    healPercent = 25f;
                    collidesTeam = true;

                    sideAngle = 15f;
                    sideWidth = 0f;
                    sideLength = 0f;
                    colors = new Color[]{Pal.heal.cpy().a(0.4f), Pal.heal, Color.white};
                }};
                weapons.addAll(
                        new Weapon("12"){{
                            bullet = w;
                            shootSound = Sounds.laserblast;
                            chargeSound = Sounds.lasercharge;
                            soundPitchMin = 1f;
                            top = false;
                            mirror = false;
                            shake = 14f;
                            shootY = 5f;
                            x = y = 0;
                            reload = 350f;
                            recoil = 0f;

                            cooldownTime = 350f;

                            shootStatusDuration = 60f * 2f;
                            shootStatus = StatusEffects.unmoving;
                            shoot.firstShotDelay = Fx.greenLaserCharge.lifetime;
                            parentizeEffects = true;
                        }},
                        new Weapon("22"){{
                            bullet = w;
                            shootSound = Sounds.laserblast;
                            chargeSound = Sounds.lasercharge;
                            soundPitchMin = 1f;
                            top = false;
                            mirror = false;
                            shake = 14f;
                            shootY = 5f;
                            x = y = 0;
                            reload = 350f;
                            recoil = 0f;

                            cooldownTime = 350f;

                            shootStatusDuration = 60f * 2f;
                            shootStatus = StatusEffects.unmoving;
                            shoot.firstShotDelay = Fx.greenLaserCharge.lifetime;
                            parentizeEffects = true;
                        }},
                        new Weapon("312"){{
                            bullet = w;
                            shootSound = Sounds.laserblast;
                            chargeSound = Sounds.lasercharge;
                            soundPitchMin = 1f;
                            top = false;
                            mirror = false;
                            shake = 14f;
                            shootY = 5f;
                            x = y = 0;
                            reload = 350f;
                            recoil = 0f;

                            cooldownTime = 350f;

                            shootStatusDuration = 60f * 2f;
                            shootStatus = StatusEffects.unmoving;
                            shoot.firstShotDelay = Fx.greenLaserCharge.lifetime;
                            parentizeEffects = true;
                        }},
                        new Weapon("31"){{
                            bullet = w;
                            shootSound = Sounds.laserblast;
                            chargeSound = Sounds.lasercharge;
                            soundPitchMin = 1f;
                            top = false;
                            mirror = false;
                            shake = 14f;
                            shootY = 5f;
                            x = y = 0;
                            reload = 350f;
                            recoil = 0f;

                            cooldownTime = 350f;

                            shootStatusDuration = 60f * 2f;
                            shootStatus = StatusEffects.unmoving;
                            shoot.firstShotDelay = Fx.greenLaserCharge.lifetime;
                            parentizeEffects = true;
                        }}
                );
            }
            };
    }
}
