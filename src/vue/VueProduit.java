package vue;

import controleur.Produit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class VueProduit extends JFrame implements ActionListener
        
{
    public VueProduit (){
        this.setTitle("Gestion des Stock");
        this.setBounds(200, 200, 500,400);
        this.setResizable(false);
        
        
        
        
        
        
        
        
        
        this.setVisible(true);
        
        
    }
   public static void afficherProduits (String chaine)
   {
       System.out.println("Les produits de la bdd");
       System.out.println(chaine);
   }
   
   public static Produit saisirProduit()
   {
       Produit unProd = new Produit();
       System.out.println("Donner le reference :");
       unProd.setReference(Console.saisirString());
       
       System.out.println("Donner le Designation :");
       unProd.setDesignation(Console.saisirString());
       
       System.out.println("Donner le prix :");
       unProd.setPrix(Console.saisirFloat());
       
       System.out.println("Donner la quantité  :");
       unProd.setQte(Console.saisirInt());
       
       System.out.println("Donner la categorie  :");
       unProd.setCategorie(Console.saisirString());
       
       return unProd;
   }    
   public static String sasirCle ()
   {
       String cle;
       System.out.println("Saisir une Cle : ");
       cle =Console.saisirString();
       
       return cle; 
   }       

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
