import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.*;

public class UnitTests 
{
    @Test
    public void evaluateImportExport() 
    {
        MD5Checksum myCheckSum = new MD5Checksum();
        String sampleInput = "testinput.ics";
        String sampleOutput = sampleInput;
        String sum1, sum2;
        sum1 = sum2 = "";
        
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
        
        Calendar calendar = new Calendar(sampleInput);
        calendar.exportIcs();
        
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
        
        System.out.println("Comparing " + sum1 + " and " + sum2 + "...");
        if(sum1.equals(sum2))
        {
            System.out.println("The import and export file are the same\nTestPassed");
        }
        else
        {
            System.out.println("The import and export file are not the same\nTestFailed");
        }
        
        assertEquals(sum1, sum2);
    }
}