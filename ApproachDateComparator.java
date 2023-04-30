import java.util.Date;

/**
Michael Kawwa
114883610 
R02 - Recitation section
*/

public class ApproachDateComparator implements java.util.Comparator<NearEarthObject> {

    @Override
    public int compare(NearEarthObject left, NearEarthObject right) {
        return left.getClosestDateTimestamp().compareTo(right.getClosestDateTimestamp());
    }
}
