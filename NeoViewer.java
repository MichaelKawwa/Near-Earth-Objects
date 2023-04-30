import java.util.Comparator;
import java.util.Scanner;


/**
Michael Kawwa
114883610 
R02 - Recitation section
*/


public class NeoViewer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ReferenceIDComparator referenceIDComparator = new ReferenceIDComparator();
        DiameterComparator diameterComparator = new DiameterComparator();
        MissDistanceComparator missDistanceComparator = new MissDistanceComparator();
        ApproachDateComparator approachDateComparator = new ApproachDateComparator();


        System.out.println();
        System.out.println("Welcome to NEO Viewer!");
        System.out.println();
        System.out.println("Option Menu: ");
        System.out.println("    A) Add a page to the database\n    S) Sort the database \n    P) Print the database as a table.\n    Q) Quit");

        System.out.print("Select a menu option: ");

        String option = sc.nextLine();

        NeoDatabase nDatabase = new NeoDatabase();       

        while(true) {
            switch(option) { 
                case "A":
                System.out.println();
                System.out.print("Enter the page to load: ");
                int page = sc.nextInt();
                nDatabase.addAll(nDatabase.buildQueryURL(page));
                System.out.println();
                break;

                case "S":
                System.out.println();
                System.out.println("R) Sort by referenceID\n D) Sort by diameter\n A) Sort by approach date\n M) Sort by miss distance");
                System.out.print("Select a menu option: ");
                String choice = sc.nextLine();
                switch(choice) {
                    case "R":
                    nDatabase.sort(referenceIDComparator);
                    System.out.println();
                    System.out.println("Table sorted on referenceID.");
                    break;
                    case "D":
                    nDatabase.sort(diameterComparator);
                    System.out.println();
                    System.out.println("Table sorted on diameter.");
                    break;
                    case "A":
                    nDatabase.sort(approachDateComparator);
                    System.out.println();
                    System.out.println("Table sorted on approach date.");
                    break;
                    case "M":
                    nDatabase.sort(missDistanceComparator);
                    System.out.println();
                    System.out.println("Table sorted on miss distance.");
                    break;
                }
                break;

                case "P":
                nDatabase.printTable();
                break;

                case "Q":
                System.out.println("Program terminating normally...");
                return;
        }
        System.out.print("Select a menu option: ");
            if (sc.hasNext()) { 
            option = sc.nextLine();
            }
    }
  }
}
