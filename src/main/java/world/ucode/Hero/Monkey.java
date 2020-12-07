package world.ucode.Hero;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Monkey {
    private String name;
    private HeroType type;
    private double maxHealth = 10;

    private double health = 10;
    private double happiness = 10;
    private double hunger = 10;
    private double thirst = 10;
    private double cleanliness = 10;
    private final Map<HeroAction, Method> actions = new HashMap<HeroAction, Method>() {{
        try {
            put(HeroAction.PLAY, Monkey.class.getDeclaredMethod("play"));
            put(HeroAction.FEED, Monkey.class.getDeclaredMethod("feed"));
            put(HeroAction.GIVE_WATER, Monkey.class.getDeclaredMethod("giveWater"));
            put(HeroAction.GIVE_MEDICINE, Monkey.class.getDeclaredMethod("giveMedicine"));
            put(HeroAction.CLEAN_UP, Monkey.class.getDeclaredMethod("cleanUp"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }};

    public Monkey(HeroType type, String name) {
        this.type = type;
        this.name = name;
    }
    public Monkey(ResultSet Monkey) {
        try {
            type = toType(Monkey.getString("type"));
            name = Monkey.getString("name");
            health = Double.parseDouble(Monkey.getString("health"));
            happiness = Double.parseDouble(Monkey.getString("happiness"));
            hunger = Double.parseDouble(Monkey.getString("hunger"));
            thirst = Double.parseDouble(Monkey.getString("thirst"));
            cleanliness = Double.parseDouble(Monkey.getString("cleanliness"));
        }
        catch(SQLException ignored) {
            System.err.println("SQLException");
        }
    }

    public HeroType toType(String type) {
        if (type.equals("Stuart"))
            return HeroType.STUART;
        if (type.equals("Kevin"))
            return HeroType.KEVIN;
        if (type.equals("Bob"))
            return HeroType.BOB;
        return null;
    }

    public void ActionHandler(HeroAction action, Monkey Monkey) throws InvocationTargetException, IllegalAccessException {
        actions.get(action).invoke(Monkey);
    }

    public String GetName() {
        return name;
    }
    public HeroType GetType() {
        return type;
    }
    public double GetMaxHealth() {return maxHealth;}
    public double GetHealth() {return health;}
    public double GetHappiness() {return happiness;}
    public double GetHunger() {return hunger;}
    public double GetThirst() {return thirst;}
    public double GetCleanliness() {return cleanliness;}

    public int LiveCycle() {
        if (GetHealth() > 0) {
            SetHappiness(GetHappiness() - 0.005);
            SetHunger(GetHunger() - 0.005);
            SetThirst(GetThirst() - 0.005);
            SetCleanliness(GetCleanliness() - 0.005);
            SetHealth(GetHealth() - 0.005);
            return 0;
        }
        return -1;
    }
    private void play() {
        SetHappiness(GetHappiness() + 1);
        SetHunger(GetHunger() - 0.5);
        SetThirst(GetThirst() - 0.5);
        SetCleanliness(GetCleanliness() - 0.5);
        SetHealth(GetHealth() - 0.5);
    }
    private void feed() {
        SetHunger(GetHunger() + 1);
        SetHealth(GetHealth() + 1);
    }
    private void giveWater() {
        SetThirst(GetThirst() + 1);
        SetHealth(GetHealth() + 1);
    }
    private void giveMadicine() {
        SetHealth(GetHealth() + 1);
    }
    private void cleanUp() {
        SetCleanliness(GetCleanliness() + 1);
    }
    public void SetHealth(double value) {
        health = value;
    }
    public void SetHappiness(double value) {
        if (value < 1)
            SetHealth(GetHealth() - 0.05);
        else
            happiness = value;
    }
    public void SetHunger(double value) {
        if (value < 1)
            SetHealth(GetHealth() - 0.05);
        else
            hunger = value;
    }
    public void SetThirst(double value) {
        if (value < 1)
            SetHealth(GetHealth() - 0.05);
        else
            thirst = value;
    }
    public void SetCleanliness(double value) {
        if (value < 1)
            SetHealth(GetHealth() - 0.05);
        else
            cleanliness = value;
    }
}
