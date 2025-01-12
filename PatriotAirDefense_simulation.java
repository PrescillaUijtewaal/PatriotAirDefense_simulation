/*
Author: P Uijtewaal
The code below will simulate (20sec) of a Patriot air defense system consisting of three components:
1. Radar
   Scans for incoming threats
2. IFF (identification Friend or Foe)
    Evaluates whether the radar scanned a friend or foe
3. Missile launcher
    Launches a missile when a foe is detected
*/

import java.io.*;

public class PatriotAirDefense_simulation {

    public static void main(String[] args) throws IOException {

        // Simulation time
        int SimTime_s = 20;
        int ScanInterval_s = 1;

        // Missile hit threshold
        double hitThreashold = 0.8;

        // Create Radar, IFF, and missile instances
        Radar radar = new Radar();
        IFF IFF = new IFF();
        missile missile = new missile(hitThreashold);

        // Start the Radar and send data to the IFF and missile
        radar.setIFF(IFF);
        IFF.setMissile(missile);

        // Start 20 sec simulation
        radar.startSimulation(SimTime_s, ScanInterval_s);
    }
      
}

