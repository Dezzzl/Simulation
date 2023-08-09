package com.pet;

import com.pet.Actions.Actions;
import com.pet.BreadthFirstSearch;
import com.pet.Coordinates;
import com.pet.Entity.Entity;
import com.pet.Entity.Grass;
import com.pet.Entity.Herbivore;
import com.pet.Entity.Tree;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Simulation simulation = new Simulation(new Map(10, 10));
        simulation.startSimulation();
    }
}

