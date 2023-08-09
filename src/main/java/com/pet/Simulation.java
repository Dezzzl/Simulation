package com.pet;

import com.pet.Actions.Actions;

public class Simulation {
    private final Map map;

    public Simulation(Map map) {
        this.map = map;
    }

    public void startSimulation() {
        Actions actions = new Actions(map);
        Renderer renderer = new Renderer();
        renderer.render(map);
        while (true) {
            System.out.println();
            actions.turnActions();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            renderer.render(map);
        }
    }
}
