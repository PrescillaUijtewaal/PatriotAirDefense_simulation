/*
Author: P Uijtewaal
Missile launcher
    If there is a threat, launch a missile
    Missile only receives signal when a Foe has been detected
    A random number generator simulates the effect of the missile
    If the effect>0.8, there is no hit
    If the effect smaller or equal to 0.8, there is a hit
*/

public class missile {

    // Create reference to PatriotAirDefense
    private double hitThreshold; 
    public missile(double hitThreshold) {
        this.hitThreshold = hitThreshold;
    }

    // Method to receive and process Foe detection results
    public void streamFoeDetection(boolean Foe_detection_result) {

        double missile_effect = 1;

        // Generate random numbers to simulate the missile's effect if foe was detected
        missile_effect = Math.random();

        // Check if the missile missed(>hitThreshold) or hit
        if (missile_effect > hitThreshold) {
            System.out.println("Missile launched, No hit");
        } else {
            System.out.println("Missile launched, Threat Hit");
        }

    }
}