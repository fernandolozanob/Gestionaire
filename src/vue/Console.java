package vue;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Console {
    //buffer
    private static BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
    
    public static int saisirInt() // nexInt()
    {
        int nb =0;
        String chaine="";
        boolean ok;
        do{
            ok = false;
            try {
                chaine = entree.readLine();
                nb = Integer.parseInt(chaine);
                ok =true;
                }
                catch (IOException exp)
                {
                    System.out.println("Lecture impossible sur le clavier");
                }  
                catch (NumberFormatException exp)
                {
                System.out.println("format de nombre non respecté !");
                }
        } while  (ok == false);
        return nb;
    }
    public static float saisirFloat() // nextFloat()
    {
        float nb =0;
        String chaine="";
        boolean ok;
        do{
            ok = false;
            try {
                chaine = entree.readLine();
                nb = Float.parseFloat(chaine);
                ok =true;
                }
                catch (IOException exp)
                {
                    System.out.println("Lecture impossible sur le clavier");
                }  
                catch (NumberFormatException exp)
                {
                System.out.println("format de nombre non respecté !");
                }
        } while  (ok == false);
        return nb;
    }
    public static String saisirString() // nextString()
    {
        
        String chaine="";
              try {
                chaine = entree.readLine();
                
                }
              catch (IOException exp)
                {
                    System.out.println("Lecture impossible sur le clavier");
                }  
              catch (NumberFormatException exp)
                {
                System.out.println("format de nombre non respecté !");
                }
        
        return chaine;
    } 
    public static char saisirChar() // nextChar()
    {
        
        String chaine="";
              try {
                chaine = entree.readLine();
                
                }
              catch (IOException exp)
                {
                    System.out.println("Lecture impossible sur le clavier");
                }    
        
        return chaine.charAt(0);
    }  
}

