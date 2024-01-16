//Anthony Cu
//Created on January 16, 2024


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("------------------------------------------------------");
        System.out.println("Welcome to the ReGex Credit Card Application");
        System.out.println();
        System.out.println("          Type exit to end program.");
        System.out.println("------------------------------------------------------");
        System.out.println();
        String userCCnum="";

        while(!userCCnum.equals("exit")){

            System.out.print("Please enter your credit card number: ");
            userCCnum = input.nextLine();

            boolean mastercard = checkMastercard(userCCnum);
            boolean visa = checkVisa(userCCnum);
            boolean amex = checkAmex(userCCnum);
            boolean discover = checkDiscover(userCCnum);
            boolean diners = checkDiners(userCCnum);
            boolean jcb = checkJCB(userCCnum);

            if(mastercard){
                System.out.println("Your card is a MASTERCARD");
            }
            else if(visa){
                System.out.println("Your card is a VISA");
            }
            else if(amex){
                System.out.println("Your card is an AMERICAN EXPRESS");
            }
            else if(discover){
                System.out.println("Your card is a DISCOVER");
            }
            else if(diners){
                System.out.println("Your card is a DINERS CLUB INTERNATIONAL");
            }
            else if(jcb){
                System.out.println("Your card is a JCB");
            }
            else if(userCCnum.equals("exit")){
                break;
            }
            else{
                System.out.println("**INVALID CARD NUMBER**");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println("Thank you for using the ReGex Credit Card Application.");
        System.out.println("------------------------------------------------------");

    }

    public static boolean checkMastercard(String ccNum){
        /*

        The Mastercard format is:
            - 16 digits long
            - start with either 2 digits [51-55] and next 14 digit is any number
              OR
            - start with 4 digits [2221-2720] and next 12 digit is any number
         */

        String mastercardReGex = "^5[1-5][0-9]{14}|"
                               + "^(222[1-9]|22[3-9]\\d|"
                               + "2[3-6]\\d{2}|27[0-1]\\d|"
                               + "2720)[0-9]{12}$";
        Pattern mastercardPattern = Pattern.compile(mastercardReGex);
        Matcher mastercardMatcher = mastercardPattern.matcher(ccNum);
        return mastercardMatcher.matches();
    }

    public static boolean checkVisa(String ccNum){
        /*

        The Visa format is:
            - Starts with the number 4
            - Either 13 or 16 digits long
            - The rest of the digits can be any number.
         */

        String visaReGex = "^4[0-9]{12}|^4[0-9]{15}";

        Pattern visaPattern = Pattern.compile(visaReGex);
        Matcher visaMatcher = visaPattern.matcher(ccNum);
        return visaMatcher.matches();
    }

    public static boolean checkAmex(String ccNum){
        /*
        The American Express format is:
            - Starts with either 34 or 37
            - 15 digits long
         */

        String amexReGex = "^34[0-9]{13}|^37[0-9]{13}";

        Pattern amexPattern = Pattern.compile(amexReGex);
        Matcher amexMatcher = amexPattern.matcher(ccNum);
        return amexMatcher.matches();
    }

    public static boolean checkDiscover(String ccNum){
        /*
        The Discover format is:
            - Starts with 6
            - 16 digigts long
         */

        String discoverReGex = "^6[0-9]{15}";

        Pattern discoverPattern = Pattern.compile(discoverReGex);
        Matcher discoverMatcher = discoverPattern.matcher(ccNum);
        return discoverMatcher.matches();
    }

    public static boolean checkDiners(String ccNum){
        /*
        The Diners Club International format is;
            - Starts with 30, 36, 38, or 39
            - Is 14 digits long
         */

        String dinersReGex = "^3[0689][0-9]{12}";

        Pattern dinersPattern = Pattern.compile(dinersReGex);
        Matcher dinersMatcher = dinersPattern.matcher(ccNum);
        return dinersMatcher.matches();
    }

    public static boolean checkJCB(String ccNum){
        /*
        - 16 digit long
        - starts with 3528 or 3589
         */

        String jcbReGex = "^3528[0-9]{12}|^3528[0-9]{12}";

        Pattern jcbPattern = Pattern.compile(jcbReGex);
        Matcher jcbMatcher = jcbPattern.matcher(ccNum);
        return jcbMatcher.matches();
    }

}
