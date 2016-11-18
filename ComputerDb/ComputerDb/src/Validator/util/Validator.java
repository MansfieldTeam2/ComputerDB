package Validator.util;
import java.util.Scanner;
public class Validator {

    /**
     * This method gets input from the user in the form of a string.
     * @param sc
     * @param prompt
     * @return 
     */
    public static String getLine(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    /**
     * This method gets input from the user in the form of a string and checks the input type for correctness.
     * @param sc
     * @param prompt
     * @param regex
     * @return 
     */
    public static String getLine(Scanner sc, String prompt, String regex) {
        boolean isValid = false;
        String s = "";
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextLine()) {
                s = sc.nextLine();
                if (s.matches(regex)) {
                    isValid = true;
                } else {
                    System.out.println("\nError! Invalid value. Try again.\n");
                }
            }
        }
        return s;
    }

   /**
    * This method gets user input in the form of an int.
    * @param sc
    * @param prompt
    * @return 
    */
    public static int getInt(Scanner sc, String prompt) {
        boolean isValid = false;
        int i = 0;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid integer value. Try again.");
            }
            sc.nextLine();
        }
        return i;
    }

    /**
     * This method gets user input in the form of an int between the minimum and maximum values.
     * @param sc
     * @param prompt
     * @param min
     * @param max
     * @return 
     */
    public static int getInt(Scanner sc, String prompt, int min, int max) {
        boolean isValid = false;
        int i = 0;
        while (isValid == false) {
            i = getInt(sc, prompt);
            if (i < min) {
                System.out.println("\nError! Must be greater than or equal to " + min);
            } else if (i > max) {
                System.out.println("\nError! Must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return i;
    }

    /**
     * This method gets user input in the form of a long and checks that the input is indeed a long.
     * @param sc
     * @param prompt
     * @return 
     */
    public static long getLong(Scanner sc, String prompt) {
        boolean isValid = false;
        long i = 0;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextLong()) {
                i = sc.nextLong();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid long value. Try again.");
            }
            sc.nextLine();
        }
        return i;
    }

    /**
     * This method gets user input in the form of a long and checks that the input is indeed a long, as well as between the minimum and maximum values.
     * @param sc
     * @param prompt
     * @param min
     * @param max
     * @return 
     */
    public static long getLong(Scanner sc, String prompt, long min, long max) {
        boolean isValid = false;
        long i = 0;
        while (isValid == false) {
            i = getLong(sc, prompt);
            if (i < min) {
                System.out.println("\nError! Must be greater than or equal to " + min);
            } else if (i > max) {
                System.out.println("\nError! Must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return i;
    }

    /**
     * This method gets user input in the form of a double and checks that it is infact a double.
     * @param sc
     * @param prompt
     * @return 
     */
    public static double getDouble(Scanner sc, String prompt) {
        boolean isValid = false;
        double d = 0;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid double value. Try again.");
            }
            sc.nextLine();
        }
        return d;
    }

    /**
     * This method gets user input in the form of a double and checks that it is infact a double, as well as within the minimum and maximum values.
     * @param sc
     * @param prompt
     * @param min
     * @param max
     * @return 
     */
    public static double getDouble(Scanner sc, String prompt, double min, double max) {
        boolean isValid = false;
        double d = 0;
        while (isValid == false) {
            d = getDouble(sc, prompt);
            if (d < min) {
                System.out.println("\nError! Must be greater than or equal to " + min);
            } else if (d > max) {
                System.out.println("\nError! Must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return d;
    }
}