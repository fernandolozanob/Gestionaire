/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import controleur.Produit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author rojomihaja
 */
public class ModeleUser {
    public static String[] selectWhere(String email, String mdp)
    {
        //faire une requête select
         String [] tab = new String [2];
        BDD uneBDD = new BDD("localhost", "stock", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        String requete ="Select count(email) as nb, nom,prenom from user where  "
                + "email='"+email+"' and mdp ='"+mdp+"';";
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.next();
            int nb = unRes.getInt("nb");
            if (nb>0)
            {
                tab[0] = unRes.getString("nom");
                tab[1] = unRes.getString("prenom");
                         
            }
            else{
                tab[0]=null;
                tab[1]=null;
            }
            unStat.close();
            unRes.close();
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur d'execution :"+ requete);
        }
        uneBDD.seDeconnecter();
        return tab;
    }    
    
    
}
