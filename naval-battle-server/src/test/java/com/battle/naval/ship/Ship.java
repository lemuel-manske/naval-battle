package com.battle.naval.ship;


public abstract class Ship {

    public abstract int size();

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        Ship ship = (Ship) obj;
        return ship.size() == size();
    }

}
