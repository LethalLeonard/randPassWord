import javax.swing.JOptionPane;
import java.io.*;
import java.util.Random;

public class randPassGen
{
   public static void main(String[] args) throws IOException
   {  //sets all required variables
      Random rand = new Random();
      int passLength, randNum = 0, passNum;
      String pass = "", pass0 = "", pass1 = "", pass2 = "", passOutput;
      PrintWriter outputFile = new PrintWriter("password.txt");
      
      //recieves pass length
      passLength = Integer.parseInt(JOptionPane.showInputDialog("How long would you like the password?"));
      
      //ensures three passwords are generated
      for(int i = 0; i<3; i++)
      {
         if(i == 0)
         {
            for(int k = 0; k < passLength; k++)
            {
               randNum = rand.nextInt(94) + 33;
               pass0 += Character.toString((char)randNum);
            }
         }
         else if(i == 1)
         {
            for(int k = 0; k < passLength; k++)
            {
               randNum = rand.nextInt(94) + 33;
               pass1 += Character.toString((char)randNum);
            }
         }
         else
         {
            for(int k = 0; k < passLength; k++)
            {
               randNum = rand.nextInt(94) + 33;
               pass2 += Character.toString((char)randNum);
            }
         }
      }
      //formats the output of the three passwords
      passOutput = "1) " + pass0 + "\n2) " + pass1 + "\n3) " + pass2;
      //recieves input for which password to write
      passNum = Integer.parseInt(JOptionPane.showInputDialog("What password would you like to use? (1, 2, or 3)\n" + passOutput));
      //depending on user input, writes the correct password
      switch(passNum)
      {
         case 1:
            passOutput = pass0;
            break;
         case 2:
            passOutput = pass1;
            break;
         case 3:
            passOutput = pass2;
            break;
      }
      
      outputFile.println("Your password is: " + passOutput);
      
      //notifies password was written and to what file
      JOptionPane.showMessageDialog(null, "Password written to password.txt");
      
      outputFile.close();
      System.exit(0);
   }
}