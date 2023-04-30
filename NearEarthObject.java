import java.sql.Date;

/**
Michael Kawwa
114883610 
R02 - Recitation section
*/

public class NearEarthObject {

    private int referenceID;
    private String name;
    private double absoluteMagnitude;
    private double averageDiameter;
    private boolean isDangerous;
    private Date closestApproachDate;
    private double missDistance;
    private String orbitingBody;

    /**
     * Default Constructor.
     * @param referenceID - Unique the ID of the NEO.
     * @param name - Unique name of the asteroid or orbital body.
     * @param absoluteMagnitude - Absolute brightness of the asteroid or orbital body in the sky.
     * @param minDiameter - Estimated minimum diameter of the asteroid or orbital body in kilometers.
     * @param maxDiameter - Estimated maximum diameter of the asteroid or orbital body in kilometers.
     * @param isDangerous - Boolean value indicating whether the astroid or orbital body is a potential impact threat.
     * @param closestDateTimestamp - Unix timestamp representing the date of closest approach.
     * @param missDistance - Distance in kilometers at which the asteroid or orbital body will pass by the Earth on the date of it's closest approach.
     * @param orbitingBody - Planet or other orbital body which this NEO orbits.
     */
    public NearEarthObject(int referenceID, String name, double absoluteMagnitude, double minDiameter, double maxDiameter, boolean isDangerous, long closestDateTimestamp, double missDistance, String orbitingBody) {
        this.referenceID = referenceID;
        this.name = name;
        this.absoluteMagnitude = absoluteMagnitude;
        this.averageDiameter = (minDiameter + maxDiameter)/2;
        this.isDangerous = isDangerous;
        Date date = new Date(closestDateTimestamp);
        this.closestApproachDate = date;
        this.missDistance = missDistance;
        this.orbitingBody = orbitingBody;
    }

    //getters
    public int getReferenceID() {
        return this.referenceID;
    }

    public String getName() {
        return this.name;
    }

    public double getAbsoluteMagnitude() {
    return this.absoluteMagnitude;
    }

    public double averageDiameter() {
        return this.averageDiameter;
    }

    public boolean getIsDangerous() {
        return this.isDangerous;
    }

    public Date getClosestDateTimestamp() {
        return this.closestApproachDate;
    }

    public double getMissDinstance() {
        return this.missDistance;
    }

    public String getOrbitingBody() {
        return this.orbitingBody;
    }

    //setters 
    public void setReferenceID(int referenceID) {
        this.referenceID = referenceID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbsoluteMagnitude(double absoluteMagnitude) {
        this.absoluteMagnitude = absoluteMagnitude;
    }

    public void averageDiameter(double minDiameter, double maxDiameter) {
        double averageDiameter = (minDiameter + maxDiameter)/2;
        this.averageDiameter = averageDiameter;
    }

    public void setIsDangerous(boolean isDangerous) {
        this.isDangerous = isDangerous;
    }
    public void setClosestDateTimeStamp(long closestDateTimestamp) {
        Date date = new Date(closestDateTimestamp);
        this.closestApproachDate = date;
    }

    public void setMissDistance(double missDistance) {
        this.missDistance = missDistance;
    }

    public void setOrbitBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }

  

}