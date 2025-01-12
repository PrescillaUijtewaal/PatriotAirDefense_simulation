/*
Author: P Uijtewaal
IFF (identification Friend or Foe)
    Converts CSV file line from binary to decimal numbers
    Rapports if there is a threat (>uneven entries than even entries)
    And signals that there is a threat to missile
*/

public class IFF{

    // Create reference to missile
    private missile missile;
    public void setMissile(missile missile) {
        this.missile = missile;
    }

    // Receive Data from Radar
    public void streamRadarData(String[] RadarData) {

        int oddCount = 0;
        int evenCount = 0;
        boolean Foe_detection_result;

        // Iterate through each binary number from line csv file
        for (int i = 0; i<RadarData.length; i++) {
           
            // Extract last character as char.
            // If last digit = 1, number is uneven.
            // If last digit !=1, number is even.
            String RadarDataPulse = RadarData[i];
            char LastRadarPulse = RadarDataPulse.charAt(RadarDataPulse.length() -1);
            int LastRadarPulse_numeric = Character.getNumericValue(LastRadarPulse);
            
            // Check if LastRadarPulse is uneven (1)
            if (LastRadarPulse_numeric == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        } 

        // Determine if oddCount>evenCount = foe
        if (oddCount > evenCount) {
            Foe_detection_result = true;
            System.out.print("Foe detected, ");
        } else {
            Foe_detection_result = false;
            System.out.println("Friendly detected, No missile launched");
        }

        // Stream Foe detection results to Missile
        if (Foe_detection_result) {
            if (missile != null) {
                missile.streamFoeDetection(Foe_detection_result);
            }
        } 
         

    }

}





