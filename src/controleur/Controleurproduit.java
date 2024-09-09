package controleur;

import java.util.LinkedList;
import java.util.Scanner;
import modele.Modele;
import vue.VueProduit;

public class ControleurProduit 
{
 private LinkedList<Produit> lesProduits;
 
 public ControleurProduit()
 {
     this.lesProduits=null;
 }
 
 public void chargerLesProduits ()
 {
     this.lesProduits = Modele.selectAll();
 }
 

 @Override
 public String toString()
 {
     String chaine ="";
     for(Produit unProd : this.lesProduits)
     {
         chaine += unProd.toString();
         chaine += "\n\n";
     }
     return chaine;
 }
 public void ajouter(Produit unProd)
 {
     Modele.insertProduit(unProd);
 }        
 public String afficherRecherche()
 {
     this.lesProduits=Modele.selectWhere(VueProduit.sasirCle());
     return this.toString();
 }        
 public void menu ()
 {
     Scanner sc = new Scanner (System.in);
     int choix = 0;
     do{
         System.out.println("1- Afficher les produits");
         System.out.println("2- Ajouter");
         System.out.println("3- Cherche un produit par cle");
         System.out.println("0- Quitter");
         choix = sc.nextInt();
         switch (choix)
         {
             case 1 : this.chargerLesProduits();
                      //appel de la vue
                      VueProduit.afficherProduits(this.toString());
             break;
             case 2 : this.ajouter(VueProduit.saisirProduit());
                 System.out.println("votre produit a été inserer");
             break ;
             case 3 : VueProduit.afficherProduits(this.afficherRecherche());

//appeler la vue
         }
     }while (choix !=0);
 }
         
}
