import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.*;

/*
    all unit testing is done here
*/
public class UnitTests
{
    @Test
    /*
        Ensures that what is imported into a calendar object is exactly the same
        as what is exported
    */
    public void evaluateImportExport()
    {
        System.out.println("\n\n");
        System.out.println("--------------------------------------------");
        MD5Checksum myCheckSum = new MD5Checksum();
        String sampleInput = "testInput.ics";
        String sampleOutput = sampleInput;
        String sum1, sum2;
        sum1 = sum2 = "";

        //retrieves an MD5 hash of sample input
        try
        {
            System.out.println("Using MD5 to hash " + sampleInput);
            sum1 = myCheckSum.getMD5Checksum(sampleInput);
            System.out.println("MD5 is " + sum1);
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }

        //import input into calendar object
        Calendar calendar = new Calendar(sampleInput);
        System.out.println("Imported .ics file into new Calendar object");

        //export from calendar object
        calendar.exportIcs();
        System.out.println("Exporting .ics file");

        //hash the output
        try
        {
            System.out.println("Using MD5 to hash " + sampleOutput);
            sum2 = myCheckSum.getMD5Checksum(sampleOutput);
            System.out.println("MD5 is " + sum2);
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }

        //compare the old hash and the new hash
        //if they are different, then import did not export perfectly
        System.out.println("Comparing " + sum1 + " and " + sum2 + "...");
        if(sum1.equals(sum2))
        {
            System.out.println("The import and export file are the same\nTestPassed");
        }
        else
        {
            System.out.println("The import and export file are not the same\nTestFailed");
        }

        //use junit to compare
        assertEquals(sum1, sum2);
        System.out.println("--------------------------------------------");
        System.out.println("\n\n");
    }
}
