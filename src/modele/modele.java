 package modele;

import java.util.LinkedList;
import controleur.Produit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modele {
    
    public static LinkedList<Produit> selectAll ()
    {
        LinkedList<Produit> uneListe = new LinkedList<Produit>();
        BDD uneBDD = new BDD("localhost", "stock", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        String requete ="Select * from produit;";
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            while (unRes.next())
            {
                String reference = unRes.getString("reference");
                String designation = unRes.getString("designation");
                String categorie = unRes.getString("categorie");
                float prix = unRes.getFloat("prix");
                int qte = unRes.getInt("qte");
                Produit unProd = new Produit (reference, designation, categorie, prix, qte);
                uneListe.add(unProd);
                
            }
            unStat.close();
            unRes.close();
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur d'execution :"+ requete);
        }
        
        uneBDD.seDeconnecter();
        return uneListe;
    }
    public static void insertProduit (Produit unProd)
    {
        //permet d'inserer produit dans la table produit.
        String requete ="insert into produit(reference, designation,"
                +"prix, qte, categorie) values ('"+unProd.getReference()
                +"','"+unProd.getDesignation()+"',"+unProd.getPrix()
                +","+unProd.getQte()+",'"+unProd.getCategorie()+"');";
                BDD uneBDD = new BDD("localhost", "stock", "root", "");
                uneBDD.chargerPilote();
                uneBDD.seConnecter();
        try {
                Statement unStat = uneBDD.getMaconnexion().createStatement();
                unStat.execute(requete);
                unStat.close();
            
            unStat.close();
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur d'execution :"+ requete);
        }        
        
    }   
    public static LinkedList<Produit> selectWhere(String cle)
    {
        //faire une requête select
         LinkedList<Produit> uneListe = new LinkedList<Produit>();
        BDD uneBDD = new BDD("localhost", "stock", "root", "");
        uneBDD.chargerPilote();
        uneBDD.seConnecter();
        String requete ="Select * from produit where reference like '%"+cle+"%'"
                + "or designation like '%"+cle+"%'"
                + " or categorie like '%"+cle+"';";
        try {
            Statement unStat = uneBDD.getMaconnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            while (unRes.next())
            {
                String reference = unRes.getString("reference");
                String designation = unRes.getString("designation");
                String categorie = unRes.getString("categorie");
                float prix = unRes.getFloat("prix");
                int qte = unRes.getInt("qte");
                Produit unProd = new Produit (reference, designation, categorie, prix, qte);
                uneListe.add(unProd);
                
            }
            unStat.close();
            unRes.close();
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur d'execution :"+ requete);
        }
        uneBDD.seDeconnecter();
        return uneListe;
    }    
    
    
}
