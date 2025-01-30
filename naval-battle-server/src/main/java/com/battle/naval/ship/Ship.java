package com.battle.naval.ship;


public sealed abstract class Ship permits Destroyer, Submarine  {

    public abstract int size();

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;
        Destroyer that = (Destroyer) obj;
        return this.size() == that.size();
    }

}
