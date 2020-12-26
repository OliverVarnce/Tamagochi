package world.ucode.Hero;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Pet {
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
            put(HeroAction.PLAY, Pet.class.getDeclaredMethod("play"));
            put(HeroAction.FEED, Pet.class.getDeclaredMethod("feed"));
            put(HeroAction.GIVE_WATER, Pet.class.getDeclaredMethod("giveWater"));
            put(HeroAction.GIVE_MEDICINE, Pet.class.getDeclaredMethod("giveMedicine"));
            put(HeroAction.CLEAN_UP, Pet.class.getDeclaredMethod("cleanUp"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }};

    public Pet(HeroType type, String name) {
        this.type = type;
        this.name = name;
    }
    public Pet(ResultSet Pet) {
        try {
            type = toType(Pet.getString("type"));
            name = Pet.getString("name");
            health = Double.parseDouble(Pet.getString("health"));
            happiness = Double.parseDouble(Pet.getString("happiness"));
            hunger = Double.parseDouble(Pet.getString("hunger"));
            thirst = Double.parseDouble(Pet.getString("thirst"));
            cleanliness = Double.parseDouble(Pet.getString("cleanliness"));
        }
        catch(SQLException ignored) {
            System.err.println("SQLException");
        }
    }

    public HeroType toType(String type) {
        if (type.equals("Dog"))
            return HeroType.DOG;
        if (type.equals("Monkey"))
            return HeroType.MONKEY;
        return null;
    }

    public void ActionHandler(HeroAction action, Pet Pet) throws InvocationTargetException, IllegalAccessException {
        actions.get(action).invoke(Pet);
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
    private void giveMedicine() {
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
