/**
Michael Kawwa
114883610 
R02 - Recitation section
*/

import java.util.Collections;
import java.util.Comparator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import big.data.DataSource;

public class NeoDatabase {

    public static final String API_KEY = "US5x52891H3yc9zXXyFB0wHEVix2Z53KizMhm0x1";

    public static final String API_ROOT = "https://api.nasa.gov/neo/rest/v1/neo/browse?";

    ArrayList<NearEarthObject> database = new ArrayList<NearEarthObject>();

    /*
     * Default Constructor.
     */
    public NeoDatabase() {
        
    }

    /**
     * Builds a query URL given a page number. 
     * @param pageNumber - Integer ranging from 0 to 715 indicating the page the user wishes to load.
     * @return - query string
     * @throws IllegalArgumentException - If pageNumber is not in the valid range.
     */
    public String buildQueryURL(int pageNumber) throws IllegalArgumentException {
        return (API_ROOT + "page=" + pageNumber + "&api_key=" + API_KEY);
    }

    /**
     * Opens a connection to the data source indicated by queryURL and adds all NearEarthObjects found in the dataset.
     * @param queryURL - String containing the URL requesting a dataset from the NASA NeoW service
     * @throws IllegalArgumentException - If queryURL is null or cound not be resolved by the server.
     */
    public void addAll(String queryURL) throws IllegalArgumentException {
        if (queryURL != null) {
        DataSource ds = DataSource.connectJSON(queryURL);
        ds.load();

        NearEarthObject[] nearEarthObjects = ds.fetchArray(
        "NearEarthObject",                    // Name of the class as a String.
        "near_earth_objects/neo_reference_id",    
        "near_earth_objects/name",
        "near_earth_objects/absolute_magnitude_h",
        "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_min",
        "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_max",
        "near_earth_objects/is_potentially_hazardous_asteroid",
        "near_earth_objects/close_approach_data/epoch_date_close_approach",
        "near_earth_objects/close_approach_data/miss_distance/kilometers",
        "near_earth_objects/close_approach_data/orbiting_body"
    );

    for(int i = 0; i < nearEarthObjects.length; ++i) {
        database.add(nearEarthObjects[i]);
    }

} else {
    throw new IllegalArgumentException("queryURL is null or cound not be resolved by the server.");
}

    }

    /**
     * Sorts the database using the specified Comparator of NearEarthObjects.
     * @param comp - Comparator of NearEarthObjects which will be used to sort the database. 
     * @throws IllegalArgumentException - If comp is null.
     */
    public void sort(Comparator<NearEarthObject> comp) throws IllegalArgumentException {
        Collections.sort(database, comp);
    }

    public void printTable() {
        System.out.println("     ID   |      Name    | Mag. | Diameter | Danger | Close Date | Miss Dist | Orbits");
        System.out.println("======================================================================================");
        for (int i = 0; i < database.size(); i++) {
            System.out.print(database.get(i).getReferenceID() + "   ");
            String upToNCharacters = database.get(i).getName().substring(0, Math.min(database.get(i).getName().length(), 26));
            System.out.print(upToNCharacters + "   ");
            System.out.printf("%.1f", database.get(i).getAbsoluteMagnitude());
            System.out.print("   ");
            System.out.printf("%.3f", database.get(i).averageDiameter());
            System.out.print("   ");
            System.out.print(database.get(i).getIsDangerous() + "   ");
            SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
            System.out.print(formatter.format(database.get(i).getClosestDateTimestamp()) + "   ");
            System.out.print((int) Math.round(database.get(i).getMissDinstance()));
            System.out.print("   ");
            System.out.print(database.get(i).getOrbitingBody() + "   ");
            System.out.println();
        }
    }


}