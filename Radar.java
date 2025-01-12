/*
Author: P Uijtewaal
Radar Component
    scans for incoming threats every second by reading a line from CSV file
*/

import java.io.*;
import java.util.concurrent.TimeUnit;

public class Radar {

    // Create reference to IFF 
    private IFF IFF;
    public void setIFF(IFF IFF) {
        this.IFF = IFF;
    }


    // Radar simulation
    public void startSimulation(int SimTime_s, int ScanInterval_s) throws FileNotFoundException, IOException {
        // Get current working director
        String currentDirectory = System.getProperty("user.dir");

        // Define CSV file path
        String csvFilePath = currentDirectory + "/radar_data.csv";   
        
        // Open and close CSV file
        try(BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {

            // Initiate timer
            int elapsedTime = 0;

            // Read CSV file line by line and stop when all lines have been read
            var line = reader.readLine();
            while (line != null && elapsedTime < SimTime_s) {
                
                // Split the line into separate variables (Delimeter = ;)
                String[] CSVvariables = line.split(";");

                // Stream data to IFF only if IFF exists
                IFF.streamRadarData(CSVvariables);
                

                // Add a 1 sec delay to system
                try {
                    TimeUnit.SECONDS.sleep(ScanInterval_s);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }

                // Change elapsed time
                elapsedTime+= ScanInterval_s;

                // Read the next line
                line = reader.readLine();
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        } 
       
    }

}