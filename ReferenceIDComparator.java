/**
Michael Kawwa
114883610 
R02 - Recitation section
*/

public class ReferenceIDComparator implements java.util.Comparator<NearEarthObject> {

    @Override
    public int compare(NearEarthObject left, NearEarthObject right) {
        if (left.getReferenceID() == right.getReferenceID())
        return 0;
        else if (left.getReferenceID() > right.getReferenceID())
        return 1;
        else
        return -1;
    }

}

