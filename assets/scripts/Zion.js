const SFlib = require("base/SFlib");
const Zion = new Planet("Zion", Planets.sun, 1, 3.3);
Zion.meshLoader = prov(() => new MultiMesh(
	new HexMesh(Zion, 8)
));
Zion.generator = extend(SerpuloPlanetGenerator, {
	getDefaultLoadout() {
		return Schematics.readBase64("bXNjaAF4nA3JMQ6AIBAAwQXFRr9i4XuMBR5XkCAYkP9LphwcbmLO/lHMwRq0SY3vF0sGluRvTQ17XoZNStU9d0na20gDduAHAc0Org==")
	}
});
Zion.cloudMeshLoader = prov(() => new MultiMesh(
	new HexSkyMesh(Zion, 2, 0.15, 0.14, 5, Color.valueOf("25C9AB80"), 2, 0.42, 1, 0.43),
	new HexSkyMesh(Zion, 3, 0.6, 0.15, 5, Color.valueOf("25C9ABFF"), 2, 0.42, 1.2, 0.45)
));
Zion.generator = new SerpuloPlanetGenerator();
Zion.visible = Zion.accessible = Zion.alwaysUnlocked = true;
Zion.clearSectorOnLose = false;
Zion.tidalLock = false;
Zion.localizedName = "Zion";
Zion.prebuildBase = false;
Zion.bloom = false;
Zion.startSector = 1;
Zion.orbitRadius = 85;
Zion.orbitTime = 180 * 60;
Zion.rotateTime = 90 * 60;
Zion.atmosphereRadIn = 0.02;
Zion.atmosphereRadOut = 0.3;
Zion.atmosphereColor = Zion.lightColor = Color.valueOf("25C9AB90");
Zion.iconColor = Color.valueOf("25C9AB"),
Zion.hiddenItems.addAll(Items.erekirItems).removeAll(Items.serpuloItems);

const p = new SectorPreset("p", Zion, 1);
p.description = "women";
p.difficulty = 2;
p.alwaysUnlocked = false;
p.addStartingItems = true;
p.captureWave = 0;
p.localizedName = "p";
exports.p = p;
SFlib.addToResearch(p, {
	parent: "planetaryTerminal",
	objectives: Seq.with(
	new Objectives.SectorComplete(SectorPresets.planetaryTerminal))
});

const h = new SectorPreset("h", Zion, 2);
h.description = "kakan";
h.difficulty = 2;
h.alwaysUnlocked = false;
h.addStartingItems = true;
h.captureWave = 120;
h.localizedName = "h";
exports.h = h;
SFlib.addToResearch(h, {
	parent: "p",
	objectives: Seq.with(
	new Objectives.SectorComplete(p))
})

const l = new SectorPreset("l", Zion, 62);
l.description = "zheli";
l.difficulty = 8;
l.alwaysUnlocked = false;
l.addStartingItems = true;
l.captureWave = 0;
l.localizedName = "l";
exports.l = l;
SFlib.addToResearch(l, {
	parent: "h",
	objectives: Seq.with(
	new Objectives.SectorComplete(h))
})

const s = new SectorPreset("s", Zion, 4);
s.description = "diwu";
s.difficulty = 8;
s.alwaysUnlocked = false;
s.addStartingItems = true;
s.captureWave = 160;
s.localizedName = "s";
exports.s = s;
SFlib.addToResearch(s, {
	parent: "l",
	objectives: Seq.with(
	new Objectives.Research(l))
});

const d = new SectorPreset("d", Zion, 5);
d.description = "diw";
d.difficulty = 10;
d.alwaysUnlocked = false;
d.addStartingItems = true;
d.captureWave = 200;
d.localizedName = "d";
exports.d = d;
SFlib.addToResearch(d, {
	parent: "s",
	objectives: Seq.with(
	new Objectives.SectorComplete(SectorPresets.planetaryTerminal))
});

const hs = new SectorPreset("hs", Zion, 13);
hs.description = "haijun";
hs.difficulty = 10;
hs.alwaysUnlocked = false;
hs.addStartingItems = true;
hs.captureWave = 150;
hs.localizedName = "hs";
exports.hs = hs;
SFlib.addToResearch(hs, {
	parent: "s",
	objectives: Seq.with(
	new Objectives.SectorComplete(SectorPresets.planetaryTerminal))
});
/*
const 军工河原 = new SectorPreset("军工河原", Zion, 7);
军工河原.description = "这里仍在运行并持续不断的派遣军队进攻d。先遣部队已经抵达并建立基地，迅速摧毁这个巨大的军工区，不要给他们派出更多援军的机会。";
军工河原.difficulty = 12;
军工河原.alwaysUnlocked = false;
军工河原.addStartingItems = true;
军工河原.captureWave = 160;
军工河原.localizedName = "军工河原";
exports.军工河原 = 军工河原;
SFlib.addToResearch(军工河原, {
	parent: "d",
	objectives: Seq.with(
	new Objectives.SectorComplete(d))
});
*/

const y = new SectorPreset("y", Zion, 24);
y.description = "cichu";
y.difficulty = 26;
y.alwaysUnlocked = false;
y.addStartingItems = true;
y.captureWave = 80;
y.localizedName = "y";
exports.y = y;
SFlib.addToResearch(y, {
	parent: "d",
	objectives: Seq.with(
	new Objectives.SectorComplete(d))
});

const f = new SectorPreset("f", Zion, 8);
f.description = "dichu";
f.difficulty = 12;
f.alwaysUnlocked = false;
f.addStartingItems = true;
f.captureWave = 150;
f.localizedName = "f";
exports.f = f;
SFlib.addToResearch(f, {
	parent: "hs",
	objectives: Seq.with(
	new Objectives.SectorComplete(SectorPresets.planetaryTerminal))
});

const x = new SectorPreset("x", Zion, 124);
x.description = "huanxing";
x.difficulty = 18;
x.alwaysUnlocked = false;
x.addStartingItems = true;
x.captureWave = 45;
x.localizedName = "x";
exports.x = x;
SFlib.addToResearch(x, {
	parent: "f",
	objectives: Seq.with(
	new Objectives.SectorComplete(SectorPresets.planetaryTerminal))
});


const m = new SectorPreset("m", Zion, 78);
m.description = "bieji";
m.difficulty = 20;
m.alwaysUnlocked = false;
m.addStartingItems = true;
m.captureWave = 0;
m.localizedName = "m";
exports.m = m;
SFlib.addToResearch(m, {
	parent: "x",
	objectives: Seq.with(
	new Objectives.SectorComplete(x))
});
/*
const 惶恐滩 = new SectorPreset("惶恐滩", Zion, 224);
惶恐滩.description = "解决北极基地，就是这个环境恶劣的地方。敌人正在垂死挣扎，他们集结大量兵力准备摧毁这里，迅速修复前线。\n小心空降部队，剿灭敌人";
惶恐滩.difficulty = 1;
//难度参考等级：26
惶恐滩.alwaysUnlocked = false;
惶恐滩.addStartingItems = true;
惶恐滩.captureWave = 0;
惶恐滩.localizedName = "惶恐滩";
exports.惶恐滩 = 惶恐滩;
SFlib.addToResearch(惶恐滩, {
	parent: "m",
	objectives: Seq.with(
	new Objectives.SectorComplete(m))
});
*/
const c = new SectorPreset("c", Zion, 9);
c.description = "yelong";
c.difficulty = 12;
c.alwaysUnlocked = false;
c.addStartingItems = true;
c.captureWave = 65;
c.localizedName = "c";
exports.c = c;
SFlib.addToResearch(c, {
	parent: "m",
	objectives: Seq.with(
	new Objectives.SectorComplete(SectorPresets.planetaryTerminal))
});

const xc = new SectorPreset("xc", Zion, 10);
xc.description = "zheli";
xc.difficulty = 18;
xc.alwaysUnlocked = false;
xc.addStartingItems = true;
xc.captureWave = 150;
xc.localizedName = "xc";
exports.xc = xc;
SFlib.addToResearch(xc, {
	parent: "c",
	objectives: Seq.with(
	new Objectives.SectorComplete(SectorPresets.planetaryTerminal))
});