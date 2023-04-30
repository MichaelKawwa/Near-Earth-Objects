/**
Michael Kawwa
114883610 
R02 - Recitation section
*/

public class DiameterComparator implements java.util.Comparator<NearEarthObject>
{

    @Override
    public int compare(NearEarthObject left, NearEarthObject right) {
        if (left.averageDiameter() == right.averageDiameter())
        return 0;
        else if (left.averageDiameter() > right.averageDiameter())
        return 1;
        else
        return -1;
    }
  

}