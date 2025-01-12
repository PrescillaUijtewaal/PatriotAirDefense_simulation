# Patriot Air Defence simulation

## Introduction

The PatriotAirDefense code simulates a Patriot air defense system consisting of three components:
1. A Radar
  The radar scans for threats every second.
  It does this by reading a line per second from radar_data.csv.

2. A IFF (Identification Friend or Foe)
  The IFF checks if the radar scanned a foe object.
  It does this by checking if there are more uneven than even entries in the radar output.

3. A Missile launcher
  If a foe has been detected, a missile will be launched.
  The missile has a probability of kill-ratio of 0.8

## Files

The PatriotAirDefense simulation requires 5 files:
 - PatriotAirDefense_simulation.java
 - Radar.java
 - IFF.java
 - missile.java
 - radar_data.csv

### How-to

The simulation can be started from: PatriotAirDefense_simulation.java

*Note, navigate to the correct file folder before running the code.