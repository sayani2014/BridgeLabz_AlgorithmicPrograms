/**
 * Customize Message Demonstration using String Function and RegEx
 * Desc -> Read in the following message: Hello <<name>>, We have your full name as <<full name>> in our system. your contact number is 91-xxxxxxxxxx.
 * Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016.
 * Use Regex to replace name, full name, Mobile#, and Date with proper value.
 * I/P -> read in the Message
 * Logic -> Use Regex to do the following
 * Replace <<name>> by first name of the user ( assume you are the user)
 * Replace <<full name>> by user full name.
 * Replace any occurance of mobile number that should be in format 91-xxxxxxxxxx by your contact number.
 * Replace any date in the format XX/XX/XXXX by current date.
 * O/P -> Print the Modified Message.
 *
 * @author: SAYANI KOLEY
 * @since: 24/06/2021
 */

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDemonstration {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String message = "Hello <<name>>, We have your full name as <<full name>> in our system. your contact number is 91-xxxxxxxxxx."
             +   "Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016.";

        System.out.println("Enter your first name: ");
        String firstName = input.next();

        System.out.println("Enter your last name: ");
        String lastName = input.next();

        System.out.println("Enter your phone number: ");
        String phoneNumber = input.next();

        String REGEX1 = "<<name>>";
        String REGEX2 = "<<full name>>";
        String REGEX3 = "xxxxxxxxxx";

        String replaceFirstName = firstName;
        String replaceFullName = firstName + " " + lastName;
        String replacePhone = phoneNumber;

        Pattern p1 = Pattern.compile(REGEX1);
        Pattern p2 = Pattern.compile(REGEX2);
        Pattern p3 = Pattern.compile(REGEX3);

        Matcher m1 = p1.matcher(message);
        message = m1.replaceAll(replaceFirstName);

        Matcher m2 = p2.matcher(message);
        message = m2.replaceAll(replaceFullName);

        Matcher m3 = p3.matcher(message);
        message = m3.replaceAll(replacePhone);

        String[] messageArray = message.split("\\s");

        String REGEX4 = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
        Pattern DATE_PATTERN = Pattern.compile(REGEX4);

        for(int i=0; i< messageArray.length; i++) {
            String message1 = messageArray[i].replace(".", "");
            Matcher m4 = DATE_PATTERN.matcher(message1);
            if(m4.matches()) {
                Date d = new Date();
                message1 = m4.replaceAll(d.toString());
                messageArray[i] = message1;
            }
        }

        message = Arrays.toString(messageArray).replaceAll("," ,"");
        System.out.println(message.replace("[","").replace("]",""));

    }
}
