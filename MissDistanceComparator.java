/**
Michael Kawwa
114883610 
R02 - Recitation section
*/

public class MissDistanceComparator implements java.util.Comparator<NearEarthObject> {

    @Override
    public int compare(NearEarthObject left, NearEarthObject right) {
        if (left.getMissDinstance() == right.getMissDinstance())
        return 0;
        else if (left.getMissDinstance() > right.getMissDinstance())
        return 1;
        else
        return -1;
    }
    
}
