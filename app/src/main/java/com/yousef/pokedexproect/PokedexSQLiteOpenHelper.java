package com.yousef.pokedexproect;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class PokedexSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "POKEDEX";
    private static final int DB_VERSION = 1;

    public PokedexSQLiteOpenHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE POKEDEX(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "IMAGE_RESOURCE_ID INTEGER," +
                "NAME TEXT," +
                "TYPE TEXT," +
                "ABILITIES TEXT," +
                "CLASSIFICATION TEXT," +
                "EVOLUTION_LEVEL TEXT)");

        db.execSQL("CREATE TABLE STATS(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "HP INTEGER," +
                "ATTACK INTEGER," +
                "DEFENSE INTEGER," +
                "SPATTACK INTEGER," +
                "SPDEFENSE INTEGER," +
                "SPEED INTEGER)");

        db.execSQL("CREATE TABLE FAVORITES(" +
                "_id INTEGER PRIMARY KEY," +
                "IMAGE_RESOURCE_ID INTEGER," +
                "NAME TEXT)");

        insertPokemon(db, R.drawable.p001, "Bulbasaur", "Grass  Poison", "Overgrow\nClorophyll", "Seed Pokemon", "Evolves at level 16");
        insertPokemon(db, R.drawable.p002, "Ivysaur", "Grass  Poison", "Overgrow\nClorophyll", "Seed Pokemon", "Evolves at level 32");
        insertPokemon(db, R.drawable.p003, "Venasaur", "Grass  Poison", "Overgrow\nClorophyll", "Seed Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p004, "Charmander", "Fire", "Blaze\nSolar Power", "Lizard Pokemon", "Evolves at level 16");
        insertPokemon(db, R.drawable.p005, "Charmeleon", "Fire", "Blaze\nSolar Power", "Flame Pokemon", "Evolves at level 36");
        insertPokemon(db, R.drawable.p006, "Charizard", "Fire  Flying", "Blaze\nSolar Power", "Flame Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p007, "Squirtle", "Water", "Torrent\nRain Dish", "Tiny Turtle Pokemon", "Evolves at level 16");
        insertPokemon(db, R.drawable.p008, "Wartortle", "Water", "Torrent\nRain Dish", "Turtle Pokemon", "Evolves at level 36");
        insertPokemon(db, R.drawable.p009, "Blastoise", "Water", "Torrent\nRain Dish", "Shellfish Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p010, "Caterpie", "Bug", "Shield Dust\nRun Away", "Worm Pokemon", "Evolves at level 07");
        insertPokemon(db, R.drawable.p011, "Metapod", "Bug", "Shed Skin", "Cocoon Pokemon", "Evolved at level 10");
        insertPokemon(db, R.drawable.p012, "Butterfree", "Bug  Flying", "Compoundeyes\nTinted Lens", "Butterfly Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p013, "Weedle", "Bug  Poison", "Shield Dust\nRun Away", "Hairy Pokemon", "Evolves at level 07");
        insertPokemon(db, R.drawable.p014, "Kakuna", "Bug  Poison", "Shed Skin", "Cocoon Pokemon", "Evolves at level 10");
        insertPokemon(db, R.drawable.p015, "Beedrill", "Bug  Poison", "Swarm\nSniper", "Poison Bee Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p016, "Pidgey", "Normal Flying", "Keen Eye\nTangled Feet\nBig Pecks", "Tiny Bird Pokemon", "Evolves at level 18");
        insertPokemon(db, R.drawable.p017, "Pidgeotto", "Normal Flying", "Keen Eye\nTangled Feet\nBig Pecks", "Bird Pokemon", "Evolves at level 36");
        insertPokemon(db, R.drawable.p018, "Pidgeot", "Normal Flying", "Keen Eye\nTangled Feet\nBig Pecks", "Bird Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p019, "Ratata", "Normal", "Run Away\nGuts\nHustle", "Mouse Pokemon", "Evolves at level 20");
        insertPokemon(db, R.drawable.p020, "Raticate", "Normal", "Run Away\nGuts\nHustle", "Mouse Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p021, "Spearow", "Normal Flying", "Keen Eye\nSniper", "Tiny Bird Pokemon", "Evolves at level 20");
        insertPokemon(db, R.drawable.p022, "Fearow", "Normal Flying", "Keen Eye\nSniper", "Beak Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p023, "Ekans", "Poison", "Intimidate\nShed Skin\nUnnerve", "Snake Pokemon", "Evolves at level 22");
        insertPokemon(db, R.drawable.p024, "Arbok", "Poison", "Intimidate\nShed Skin\nUnnerve", "Cobra Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p025, "Pikachu", "Electric", "Static\nElectric Rod", "Mouse Pokemon", "Evolves using Thunder Stone");
        insertPokemon(db, R.drawable.p026, "Raichu", "Electric", "Static\nElectric Rod", "Mouse Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p027, "Sandshrew", "Ground", "Sand Veil\nSand Rush", "Mouse Pokemon", "Evolves at level 22");
        insertPokemon(db, R.drawable.p028, "Sandslash", "Ground", "Sand Veil\nSand Rush", "Mouse Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p029, "Nidoran(F)", "Poison", "Poison Point\nRivalry\nHustle", "Poison Pin Pokemon", "Evolves at level 16");
        insertPokemon(db, R.drawable.p030, "Nidorina", "Poison", "Poison Point\nRivalry\nHustle", "Poison Pin Pokemon", "Evolves using Moonstone");
        insertPokemon(db, R.drawable.p031, "Nidoqueen", "Poison  Ground", "Poison Point\nRivalry\nSheer Force", "Drill Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p032, "Nidoran(M)", "Poison", "Poison Point\nRivalry\nHustle", "Poison Pin Pokemon", "Evolves at level 16");
        insertPokemon(db, R.drawable.p033, "Nidorino", "Poison", "Poison Point\nRivalry\nHustle", "Poison Pin Pokemon", "Evolves using Moonstone");
        insertPokemon(db, R.drawable.p034, "Nidoking", "Poison  Ground", "Poison Point\nRivalry\nSheer Force", "Drill Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p035, "Clefairy", "Fairy", "Cute Charm\nMagic Guard\nFriend Guard", "Fairy Pokemon", "Evolves at max friendship");
        insertPokemon(db, R.drawable.p036, "Clefable", "Fairy", "Cute Charm\nMagic Guard\nUnaware", "Fairy Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p037, "Vulpix", "Fire", "Flash Fire\nDrought", "Fox Pokemon", "Evolves using fire stone");
        insertPokemon(db, R.drawable.p038, "Ninetales", "Fire", "Flash Fire\nDrought", "Fox Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p039, "Jigglypuff", "Normal  Fairy", "Cute Charm\nCompetitive\nFriend Guard", "Balloon Pokemon", "Evolves using moon stone");
        insertPokemon(db, R.drawable.p040, "Wigglytuff", "Normal  Fairy", "Cute Charm\nCompetitive\nFrisk", "Balloon Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p041, "Zubat", "Poison  Flying", "Inner Focus\nInfiltrator", "Bat Pokemon", "Evolves at level 22");
        insertPokemon(db, R.drawable.p042, "Golbat", "Poison  Flying", "Inner Focus\nInfiltrator", "Bat Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p043, "Oddish", "Grass  Poison", "Clorophyll\nRun Away", "Weed Pokemon", "Evolves at level 21");
        insertPokemon(db, R.drawable.p044, "Gloom", "Grass  Poison", "Clorophyll\nStench", "Weed Pokemon", "Evolves using leaf stone");
        insertPokemon(db, R.drawable.p045, "Vileplume", "Grass  Poison", "Clorophyll\nEffect Spore", "Flower Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p046, "Paras", "Bug  Grass", "Effect Spore\nDry Skin\nDamp", "Mushroom Pokemon", "Evolves at level 24");
        insertPokemon(db, R.drawable.p047, "Parasect", "Bug  Grass", "Effect Spore\nDry Skin\nDamp", "Mushroom Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p048, "Venonat", "Bug  Poison", "Compoundeyes\nTinted Lens\nRun Away", "Insect Pokemon", "Evolves at level 31");
        insertPokemon(db, R.drawable.p049, "Venomoth", "Bug  Poison", "Shield Dust\nTinted Lens\nWonder Skin", "Poison Moth Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p050, "Diglet", "Ground", "Sand Veil\nArena Trap\nSand Force", "Mole Pokemon", "Evolves at level 26");
        insertPokemon(db, R.drawable.p051, "Dugtrio", "Ground", "Sand Veil\nArena Trap\nSand Force", "Mole Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p052, "Meowth", "Normal", "Pickup\nTechnician\nUnnerve", "Scratch Cat Pokemon", "Evolve at level 28");
        insertPokemon(db, R.drawable.p053, "Persian", "Normal", "Limber\nTechnician\nUnnerve", "Classy Cat Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p054, "Psyduck", "Water", "Damp\nCloud Nine\nSwift Swift", "Duck Pokemon", "Evolves at level 33");
        insertPokemon(db, R.drawable.p055, "Golduck", "Water", "Damp\nCloud Nine\nSwift Swift", "Duck Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p056, "Mankey", "Fight", "Vital Spirit\nAnger Point\nDefiant", "Pig Monkey Pokemon", "Evolves at level 28");
        insertPokemon(db, R.drawable.p057, "Primeape", "Fight", "Vital Spirit\nAnger Point\nDefiant", "Pig Monkey Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p058, "Growlithe", "Fire", "Intimidate\nFlash Fire\nJustified", "Puppy Pokemon", "Evolves using fire stone");
        insertPokemon(db, R.drawable.p059, "Arcanine", "Fire", "Intimidate\nFlash Fire\nJustified", "Legendary Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p060, "Poliwag", "Water", "Water Absorb\nDamp\nSwift Swift", "Tadpole Pokemon", "Evolves at 25");
        insertPokemon(db, R.drawable.p061, "Poliwhirl", "Water", "Water Absorb\nDamp\nSwift Swift", "Tadpole Pokemon", "Evolves using water stone");
        insertPokemon(db, R.drawable.p062, "Poliwrath", "Water  Fight", "Water Absorb\nDamp\nSwift Swift", "Tadpole Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p063, "Abra", "Psychic", "Synchronize\nInner Focus\nMagic Guard", "Psi Pokemon", "Evolves at level 16");
        insertPokemon(db, R.drawable.p064, "Kadabra", "Psychic", "Synchronize\nInner Focus\nMagic Guard", "Psi Pokemon", "Evolves using trade");
        insertPokemon(db, R.drawable.p065, "Alakazam", "Psychic", "Synchronize\nInner Focus\nMagic Guard", "Psi Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p066, "Machop", "Fight", "Guts\nNo Guard\nSteadfast", "Superpower Pokemon", "Evolves at level 28");
        insertPokemon(db, R.drawable.p067, "Machoke", "Fight", "Guts\nNo Guard\nSteadfast", "Superpower Pokemon", "Evolves when traded");
        insertPokemon(db, R.drawable.p068, "Machamp", "Fight", "Guts\nNo Guard\nSteadfast", "Superpower Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p069, "Bellsprout", "Grass  Poison", "Chlorophyll\nGluttony", "Flower Pokemon", "Evolves at level 21");
        insertPokemon(db, R.drawable.p070, "Weepinbell", "Grass  Poison", "Chlorophyll\nGluttony", "Flycatcher Pokemon", "Evolves using leaf stone");
        insertPokemon(db, R.drawable.p071, "Victreebel", "Grass  Poison", "Chlorophyll\nGluttony", "Flycatcher Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p072, "Tentacool", "Water  Poison", "Clear Body\nLiquid Ooze\nRain Dish", "Jellyfish Pokemon", "Evolves at level 30");
        insertPokemon(db, R.drawable.p073, "Tentacruel", "Water  Poison", "Clear Body\nLiquid Ooze\nRain Dish", "Jellyfish Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p074, "Geodude", "Rock  Ground", "Rock Head\nSturdy\nSand Veil", "Rock Pokemon", "Evolves at level 25");
        insertPokemon(db, R.drawable.p075, "Graveler", "Rock  Ground", "Rock Head\nSturdy\nSand Veil", "Rock Pokemon", "Evolves when traded");
        insertPokemon(db, R.drawable.p076, "Golem", "Rock  Ground", "Rock Head\nSturdy\nSand Veil", "Megaton Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p077, "Ponyta", "Fire", "Run Away\nFlash Fire\nFlame Body", "Fire Horse Pokemon", "Evolves at level 40");
        insertPokemon(db, R.drawable.p078, "Rapidash", "Fire", "Run Away\nFlash Fire\nFlame Body", "Fire Horse Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p079, "Slowpoke", "Water  Psychic", "Oblivious\nOwn Tempo\nRegenerator", "Dopey Pokemon", "Evolves at level 37");
        insertPokemon(db, R.drawable.p080, "Slowbro", "Water  Psychic", "Oblivious\nOwn Tempo\nRegenerator", "Hermit Crab Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p081, "Magnemite", "Electric  Steel", "Magnet Pull\nSturdy\nAnalytic", "Magnet Pokemon", "Evolves at level 30");
        insertPokemon(db, R.drawable.p082, "Magneton", "Electric  Steel", "Magnet Pull\nSturdy\nAnalytic", "Magnet Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p083, "Farfetch'd", "Normal  Flying", "Keen Eyes\nInner Focus\nDefiant", "Wild Duck Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p084, "Doduo", "Normal  Flying", "Run Away\nEarly Bird\nTangled Feet", "Twin Bird Pokemon", "Evolves at level 31");
        insertPokemon(db, R.drawable.p085, "Dodrio", "Normal  Flying", "Run Away\nEarly Bird\nTangled Feet", "Triple Bird Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p086, "Seel", "Water", "Thick Fat\nHydration\nIce Body", "Sea Lion Pokemon", "Evolves at level 34");
        insertPokemon(db, R.drawable.p087, "Dewgong", "Water  Ice", "Thick Fat\nHydration\nIce Body", "Sea Lion Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p088, "Grimer", "Poison", "Stench\nSticky Hold\nPoison Touch", "Sludge Pokemon", "Evolves at level 38");
        insertPokemon(db, R.drawable.p089, "Muk", "Poison", "Stench\nSticky Hold\nPoison Touch", "Sludge Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p090, "Shellder", "Water", "Shell Armor\nSkill Link\nOvercoat", "Bivalve Pokemon", "Evolves using water stone");
        insertPokemon(db, R.drawable.p091, "Cloyster", "Water  Ice", "Shell Armor\nSkill Link\nOvercoat", "Bivalve Pokemon", "Does noy evolve");
        insertPokemon(db, R.drawable.p092, "Gastly", "Ghost  Poison", "Levitate", "Gas Pokemon", "Evolves at level 25");
        insertPokemon(db, R.drawable.p093, "Hunter", "Ghost  Poison", "Levitate", "Gas Pokemon", "Evolves when traded");
        insertPokemon(db, R.drawable.p094, "Gengar", "Ghost  Poison", "Cursed Body", "Shadow Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p095, "Onix", "Rock  Ground", "Rock head\nSturdy\nweak Armor", "Rock Snake Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p096, "Drowzee", "Psychic", "Insomnia\nForewarn\nInner Focus", "Hypnosis Pokemon", "Evolves at level 26");
        insertPokemon(db, R.drawable.p097, "Hypno", "Psychic", "Insomnia\nForewarn\nInner Focus", "Hypnosis Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p098, "Krabby", "Water", "Hyper Cytter\nShell Armor\nSheer Force", "River Crab Pokemon", "Evolves at level 28");
        insertPokemon(db, R.drawable.p099, "Kingler", "Water", "Hyper Cytter\nShell Armor\nSheer Force", "Pincer Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p100, "Voltorb", "Electric", "Soundproof\nStatic\nAftermath", "Ball Pokemon", "Evolves at level 30");
        insertPokemon(db, R.drawable.p101, "Electrode", "Electric", "Soundproof\nStatic\nAftermath", "Ball Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p102, "Exeggcute", "Grass  Psychic", "Chlorophyll\nHarvest", "Egg Pokemon", "Evovles using a leaf stone");
        insertPokemon(db, R.drawable.p103, "Exeggutor", "Grass  Psychic", "Chlorophyll\nHarvest", "Coconut Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p104, "Cubone", "Ground", "Rock Head\nLightning Rod\nBattle Armor", "Lonely Pokemon", "Evolves at level 28");
        insertPokemon(db, R.drawable.p105, "Marowak", "Ground", "Rock Head\nLightning Rod\nBattle Armor", "Bone Keeper Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p106, "Hitmonlee", "Fight", "Limber\nReckless\nUnburden", "Kicking Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p107, "Hitmonchan", "Fight", "Keen Eye\nIron Fist\nInner Focus", "Punching Pokemon", "Does  not evolve");
        insertPokemon(db, R.drawable.p108, "Lickitung", "Normal", "Own Tempo\nOblivious\nCloud Nine", "Licking Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p109, "Weezing", "Poison", "Levitate\nNeutralizing Gas\nStench", "Poison Gas Pokemon", "Evolves at level 35");
        insertPokemon(db, R.drawable.p110, "Koffing", "Poison", "Levitate\nNeutralizing Gas\nStench", "Poison Gas Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p111, "Rhydon", "Ground  Rock", "Lightning Rod\nRock Head\nReckless", "Spikes Pokemon", "Evolves at level 42");
        insertPokemon(db, R.drawable.p112, "Rhyhorn", "Ground  Rock", "Lightning Rod\nRock Head\nReckless", "Drill Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p113, "Chansey", "Normal", "Natural Cute\nSerene Grace\nHealer", "Egg Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p114, "Tangela", "Grass", "Chlorophyll\nLead Guard\nRegenerator", "Vine Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p115, "Kangaskhan", "Normal", "Early Bird\nScappy\nInner Focus", "Parent Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p116, "Horsea", "Water", "Swift Swim\nSniper\nDamp", "Dragon Pokemon", "Evolves at level 32");
        insertPokemon(db, R.drawable.p117, "Seadra", "Water", "Poison Point\nSniper\nDamp", "Dragon Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p118, "Goldeen", "Water", "Swift Swim\nWater Veil\nLightning Rod", "Goldfish Pokemon", "Evolves at level 33");
        insertPokemon(db, R.drawable.p119, "Seaking", "Water", "Swift Swim\nWater Veil\nLightning Rod", "Goldfish Pokemon", "Does not  evolve");
        insertPokemon(db, R.drawable.p120, "Staryu", "Water", "Illuminate\nNatural Cure\nAnalytic", "Starshape Pokemon", "Evolves using water stone");
        insertPokemon(db, R.drawable.p121, "Starmie", "Water  Psychic", "Illuminate\nNatural Cure\nAnalytic", "Mysterious Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p122, "Mr. Mime", "Psychic  Fairy", "Soundprood\nFiler\nTechnician", "Barrier Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p123, "Scyther", "Bug  Flying", "Swarm\nSteadfast\nTechnician", "Mantis Pokemon", "Does note evolve");
        insertPokemon(db, R.drawable.p124, "Jynx", "Ice  Psychic", "Oblicious\nForeworn\nDry Skin", "Humanshape Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p125, "Electabuzz", "Electric", "Static\n Vital Spirit", "Electric Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p126, "Magmar", "Fire", "Flame Body\nVital Spirit", "Spitfire Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p127, "Pinsir", "Bug  Flying", "Hyper Cutter\nMold Breaker\nMoxie", "Stagbeetle Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p128, "Tauros", "Normal", "Intimidate\nAnger Point\nSheer Force", "Wild Bull Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p129, "Magikarp", "Water", "Swift Swim\nRattled", "Fish Pokemon", "Evolves at level 20");
        insertPokemon(db, R.drawable.p130, "Gyrados", "Water  Flying", "Intimidate\nMoxie", "Atrocious Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p131, "Lapras", "Water  Ice", "Water Absorb\nShell Armor\nHydration", "Transport Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p132, "Ditto", "Normal", "Limber\nImposter", "Transform Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p133, "Eevee", "Normal", "Run Away\nAdaptability\nAnticipation", "Evolution Pokemon", "Evolves using different stones");
        insertPokemon(db, R.drawable.p134, "Vaporeon", "Water", "Water Absorb\nHydration", "Bubble Jet Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p135, "Jolteon", "Electric", "Volt Absorb\nQuick Feet", "Lightning Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p136, "Flareon", "Fire", "Flash Fire\nGuts", "Flame Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p137, "Porygon", "Normal", "Trace\nDownload\nAnalytic", "Virtual Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p138, "Omanyte", "Rock  Water", "Swift Swim\nShell Armor\nWeak Armor", "Spiral Pokemon", "Evolves at level 40");
        insertPokemon(db, R.drawable.p139, "Omastar", "Rock  Water", "Swift Swim\nShell Armor\nWeak Armor", "Spiral Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p140, "Kabuto", "Rock  Water", "Swift Swim\nBattle Armor\nWeak Armor", "Shellfish Pokemon", "Evolves at level 40");
        insertPokemon(db, R.drawable.p141, "Kabutops", "Rock  Water", "Swift Swim\nBattle Armor\nWeak Armor", "Shellfish Pokemon", "Does noy evolve");
        insertPokemon(db, R.drawable.p142, "Aerodactyl", "Rock  Flying", "Rock Head\nPressure\nUnnerve", "Fossil Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p143, "Snorlax", "Normal", "Immunity\nGluttony\nThick Fat", "Sleeping Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p144, "Articuno", "Ice  Flying", "Pressure\nSnow Cloak", "Freeze Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p145, "Zapdos", "Electric  Flying", "Pressure\nStatic", "Electric Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p146, "Moltres", "Fire  FLying", "Pressure\nFlame Body", "Flame Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p147, "Dratini", "Dragon", "Shed Skin\nMarvel Scale", "Dragon Pokemon", "Evolves at level 30");
        insertPokemon(db, R.drawable.p148, "Dragonair", "Dragon", "Shed Skin\nMarvel Scale", "Dragon Pokemon", "Evolves at level 55");
        insertPokemon(db, R.drawable.p149, "Dragonite", "Dragon  Flying", "Inner Focus\nMultiscale", "Dragon Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p150, "Mewtwo", "Psychic", "Pressure\nUnnerve", "Genetic Pokemon", "Does not evolve");
        insertPokemon(db, R.drawable.p151, "Mew", "Psychic", "Synchronize", "New Species Pokemon", "Does not evolve");


        insertStats(db, 45, 49, 49, 65, 65, 45);
        insertStats(db, 60, 62, 63, 80, 80, 60);
        insertStats(db, 80, 82, 83, 100, 100, 80);
        insertStats(db, 39, 52, 43, 60, 50, 65);
        insertStats(db, 58, 64, 58, 80, 65, 80);
        insertStats(db, 78, 84, 78, 109, 85, 100);
        insertStats(db, 44, 48, 65, 50, 64, 43);
        insertStats(db, 59, 63, 80, 65, 80, 58);
        insertStats(db, 79, 83, 100, 85, 105, 78);
        insertStats(db, 45, 30, 35, 20, 20, 45);
        insertStats(db, 50, 20, 55, 25, 25, 30);
        insertStats(db, 60, 45, 50, 90, 80, 70);
        insertStats(db, 40, 35, 30, 20, 20, 50);
        insertStats(db, 45, 25, 50, 25, 25, 35);
        insertStats(db, 65, 150, 40, 15, 80, 145);
        insertStats(db, 40, 45, 40, 35, 35, 56);
        insertStats(db, 63, 60, 55, 50, 50, 71);
        insertStats(db, 83, 80, 75, 70, 70, 101);
        insertStats(db, 30, 56, 35, 25, 35, 72);
        insertStats(db, 55, 81, 60, 50, 70, 97);
        insertStats(db, 40, 60, 30, 31, 31, 70);
        insertStats(db, 65, 90, 65, 61, 61, 100);
        insertStats(db, 35, 60, 44, 40, 54, 55);
        insertStats(db, 60, 95, 69, 65, 79, 80);
        insertStats(db, 35, 55, 40, 50, 50, 90);
        insertStats(db, 60, 90, 55, 90, 80, 110);
        insertStats(db, 50, 75, 85, 20, 30, 40);
        insertStats(db, 75, 100, 110, 45, 55, 65);
        insertStats(db, 55, 47, 52, 40, 40, 41);
        insertStats(db, 70, 62, 67, 55, 55, 56);
        insertStats(db, 90, 92, 87, 75, 85, 76);
        insertStats(db, 46, 57, 40, 40, 40, 50);
        insertStats(db, 61, 72, 57, 55, 55, 65);
        insertStats(db, 81, 102, 77, 85, 75, 85);
        insertStats(db, 70, 45, 48, 60, 65, 35);
        insertStats(db, 95, 70, 73, 95, 90, 60);
        insertStats(db, 38, 41, 40, 50, 65, 65);
        insertStats(db, 73, 76, 75, 81, 100, 100);
        insertStats(db, 115, 45, 20, 45, 25, 20);
        insertStats(db, 140, 70, 45, 85, 50, 45);
        insertStats(db, 40, 45, 35, 30, 40, 55);
        insertStats(db, 75, 80, 70, 65, 75, 90);
        insertStats(db, 45, 50, 55, 75, 65, 30);
        insertStats(db, 60, 65, 70, 85, 75, 40);
        insertStats(db, 75, 80, 85, 110, 90, 50);
        insertStats(db, 35, 70, 55, 45, 55, 25);
        insertStats(db, 60, 95, 80, 60, 80, 30);
        insertStats(db, 60, 55, 50, 40, 55, 45);
        insertStats(db, 70, 65, 60, 90, 75, 90);
        insertStats(db, 10, 55, 25, 35, 45, 95);
        insertStats(db, 35, 100, 50, 50, 70, 120);
        insertStats(db, 40, 45, 35, 40, 40, 90);
        insertStats(db, 65, 70, 60, 65, 65, 115);
        insertStats(db, 50, 52, 48, 65, 50, 55);
        insertStats(db, 80, 82, 78, 95, 80, 85);
        insertStats(db, 40, 80, 35, 35, 45, 70);
        insertStats(db, 65, 105, 60, 60, 70, 95);
        insertStats(db, 55, 70, 45, 70, 50, 60);
        insertStats(db, 90, 110, 80, 100, 80, 95);
        insertStats(db, 40, 50, 40, 40, 40, 90);
        insertStats(db, 65, 65, 65, 50, 50, 90);
        insertStats(db, 90, 95, 95, 70, 90, 70);
        insertStats(db, 25, 20, 15, 105, 55, 90);
        insertStats(db, 40, 35, 30, 120, 70, 105);
        insertStats(db, 55, 50, 65, 175, 105, 150);
        insertStats(db, 70, 80, 50, 35, 35, 35);
        insertStats(db, 80, 100, 70, 50, 60, 45);
        insertStats(db, 90, 130, 80, 65, 85, 55);
        insertStats(db, 50, 75, 35, 70, 30, 40);
        insertStats(db, 65, 90, 50, 85, 45, 55);
        insertStats(db, 80, 105, 65, 100, 70, 70);
        insertStats(db, 40, 40, 35, 50, 100, 70);
        insertStats(db, 80, 70, 65, 80, 120, 100);
        insertStats(db, 40, 80, 100, 30, 30, 20);
        insertStats(db, 55, 95, 115, 45, 45, 35);
        insertStats(db, 80, 120, 130, 55, 65, 45);
        insertStats(db, 50, 85, 55, 65, 65, 90);
        insertStats(db, 65, 100, 70, 80, 80, 105);
        insertStats(db, 90, 65, 65, 40, 40, 15);
        insertStats(db, 95, 75, 110, 100, 80, 30);
        insertStats(db, 25, 35, 70, 95, 55, 45);
        insertStats(db, 50, 60, 95, 120, 70, 70);
        insertStats(db, 52, 90, 55, 58, 62, 60);
        insertStats(db, 35, 85, 45, 35, 35, 75);
        insertStats(db, 60, 110, 70, 60, 60, 110);
        insertStats(db, 65, 45, 55, 45, 70, 45);
        insertStats(db, 90, 70, 80, 70, 95, 70);
        insertStats(db, 80, 80, 50, 40, 50, 25);
        insertStats(db, 105, 105, 75, 65, 100, 50);
        insertStats(db, 30, 65, 100, 45, 25, 40);
        insertStats(db, 50, 95, 180, 85, 45, 70);
        insertStats(db, 30, 35, 30, 100, 35, 80);
        insertStats(db, 45, 50, 45, 115, 55, 95);
        insertStats(db, 60, 65, 60, 130, 75, 110);
        insertStats(db, 35, 45, 160, 30, 45, 70);
        insertStats(db, 60, 48, 45, 43, 90, 42);
        insertStats(db, 85, 73, 70, 73, 115, 67);
        insertStats(db, 30, 105, 90, 25, 25, 50);
        insertStats(db, 55, 130, 115, 50, 50, 75);
        insertStats(db, 40, 30, 50, 55, 55, 100);
        insertStats(db, 60, 50, 70, 80, 80, 150);
        insertStats(db, 60, 40, 80, 60, 45, 40);
        insertStats(db, 95, 95, 85, 125, 75, 55);
        insertStats(db, 50, 50, 95, 40, 50, 35);
        insertStats(db, 60, 80, 110, 50, 80, 45);
        insertStats(db, 50, 120, 53, 35, 110, 87);
        insertStats(db, 50, 105, 79, 35, 110, 76);
        insertStats(db, 90, 55, 75, 60, 75, 30);
        insertStats(db, 40, 65, 95, 60, 45, 35);
        insertStats(db, 65, 90, 120, 85, 70, 60);
        insertStats(db, 80, 85, 95, 30, 30, 25);
        insertStats(db, 105, 130, 120, 45, 45, 40);
        insertStats(db, 250, 5, 5, 35, 105, 50);
        insertStats(db, 65, 55, 115, 100, 40, 60);
        insertStats(db, 105, 95, 80, 40, 80, 90);
        insertStats(db, 30, 40, 70, 70, 25, 60);
        insertStats(db, 55, 65, 95, 95, 45, 85);
        insertStats(db, 45, 67, 60, 35, 50, 63);
        insertStats(db, 80, 92, 65, 65, 80, 68);
        insertStats(db, 30, 45, 55, 70, 55, 85);
        insertStats(db, 60, 75, 85, 100, 85, 115);
        insertStats(db, 40, 45, 65, 100, 120, 90);
        insertStats(db, 70, 110, 80, 55, 80, 105);
        insertStats(db, 65, 50, 35, 115, 95, 95);
        insertStats(db, 65, 83, 57, 95, 85, 105);
        insertStats(db, 65, 95, 57, 100, 85, 93);
        insertStats(db, 65, 125, 100, 55, 70, 85);
        insertStats(db, 75, 100, 95, 40, 70, 110);
        insertStats(db, 20, 10, 55, 15, 20, 80);
        insertStats(db, 95, 125, 79, 60, 100, 81);
        insertStats(db, 130, 85, 80, 85, 95, 60);
        insertStats(db, 48, 48, 48, 48, 48, 48);
        insertStats(db, 55, 55, 50, 45, 65, 55);
        insertStats(db, 130, 65, 60, 110, 95, 65);
        insertStats(db, 65, 65, 60, 110, 95, 130);
        insertStats(db, 65, 130, 60, 95, 110, 65);
        insertStats(db, 65, 60, 70, 85, 75, 40);
        insertStats(db, 35, 40, 100, 90, 55, 35);
        insertStats(db, 70, 60, 125, 115, 70, 55);
        insertStats(db, 30, 80, 90, 55, 45, 55);
        insertStats(db, 60, 115, 105, 65, 70, 80);
        insertStats(db, 80, 105, 65, 60, 75, 130);
        insertStats(db, 160, 110, 65, 65, 110, 30);
        insertStats(db, 90, 85, 100, 95, 125, 85);
        insertStats(db, 90, 90, 85, 125, 90, 100);
        insertStats(db, 90, 100, 90, 125, 85, 90);
        insertStats(db, 41, 64, 45, 50, 50, 50);
        insertStats(db, 61, 84, 65, 70, 70, 70);
        insertStats(db, 91, 134, 95, 100, 100, 80);
        insertStats(db, 106, 110, 90, 154, 90, 130);
        insertStats(db, 100, 100, 100, 100, 100, 100);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertPokemon(SQLiteDatabase db, int imageID, String name, String type,
                              String abilities, String classification, String level) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("IMAGE_RESOURCE_ID", imageID);
        contentValues.put("NAME", name);
        contentValues.put("TYPE", type);
        contentValues.put("ABILITIES", abilities);
        contentValues.put("CLASSIFICATION", classification);
        contentValues.put("EVOLUTION_LEVEL", level);
        db.insert("POKEDEX", null, contentValues);
    }

    public void insertStats(SQLiteDatabase db, int hp, int attack, int defense, int spattack, int spdefense, int speed) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("HP", hp);
        contentValues.put("ATTACK", attack);
        contentValues.put("DEFENSE", defense);
        contentValues.put("SPATTACK", spattack);
        contentValues.put("SPDEFENSE", spdefense);
        contentValues.put("SPEED", speed);
        db.insert("STATS", null, contentValues);
    }
}