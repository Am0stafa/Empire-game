package units;

import exceptions.FriendlyFireException;

public class Infantry extends Unit implements Cloneable {


    private String type;
    private int level;
    private int maxSoldierCount;
    private int currentSoldierCount;

    public Infantry(int level, int maxSoldierCount, double idleUpkeep, double marchingUpkeep, double siegeUpkeep) {
        super(level, maxSoldierCount, idleUpkeep, marchingUpkeep, siegeUpkeep);
        type = "Infantry";
        this.level = super.getLevel();
        this.maxSoldierCount = super.getMaxSoldierCount();
        currentSoldierCount = super.getCurrentSoldierCount();
    }

    public String getType() {
        return type;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getMaxSoldierCount() {
        return maxSoldierCount;
    }

    @Override
    public int getCurrentSoldierCount() {
        return currentSoldierCount;
    }

    @Override
    public void attack(Unit target) throws FriendlyFireException {
        super.attack(target);
        double factor = 0;
        if (target instanceof Archer) {
            if (getLevel() == 1)
                factor = 0.3;
            else if (getLevel() == 2)
                factor = 0.4;
            else
                factor = 0.5;
        } else if (target instanceof Infantry) {
            if (getLevel() == 1)
                factor = 0.1;
            else if (getLevel() == 2)
                factor = 0.2;
            else
                factor = 0.3;
        } else if (target instanceof Cavalry) {
            if (getLevel() == 1)
                factor = 0.1;
            else if (getLevel() == 2)
                factor = 0.2;

            else
                factor = 0.25;
        }

        target.setCurrentSoldierCount(target.getCurrentSoldierCount() - (int) (factor * getCurrentSoldierCount()));

        target.getParentArmy().handleAttackedUnit(target);
    }

}
