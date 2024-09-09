package vue;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modele.ModeleUser;

public class Connexion extends JFrame implements ActionListener
{
    private JPanel unPanel = new JPanel();
    private JTextField tfEmail = new JTextField();
    private JPasswordField tfMdp = new JPasswordField()  ;
    private JButton btAnnuler = new JButton("Annuler");
    private JButton btValider = new JButton("Valider");
    public Connexion(){
        this.setBounds(200, 200, 400, 200);
        this.setTitle("Connexion à la gestion de stock");
        this.setResizable(false);
        
        //placement des objets dans le panel
        this.unPanel.setBounds(0, 0, 400, 200);
        this.unPanel.setBackground(Color.cyan);
        this.unPanel.setLayout(new GridLayout(5, 2));
        this.unPanel.add(new JLabel(""));
        this.unPanel.add(new JLabel(""));
        this.unPanel.add(new JLabel("Email : "));
        this.unPanel.add(this.tfEmail);
        this.unPanel.add(new JLabel("Mot de passe : "));
        this.unPanel.add(this.tfMdp);
        this.unPanel.add(this.btAnnuler);
        this.unPanel.add(this.btValider);
        this.unPanel.add(new JLabel(""));
        this.unPanel.add(new JLabel(""));
        this.add(this.unPanel);
        this.btAnnuler.addActionListener(this);
        this.btValider.addActionListener(this);
        
        
        this.setVisible(true);
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
      
        if (e.getSource()==this.btAnnuler)
        {
            this.tfEmail.setText("");
            this.tfMdp.setText("");
        }    
        else if (e.getSource()==this.btValider)
        {
            String email = this.tfEmail.getText();
            String mdp = new String (this.tfMdp.getPassword());
            //test de la  connexion?
            String tab[] = ModeleUser.selectWhere(email, mdp);
            if (tab[0]==null)
            {
                JOptionPane.showMessageDialog(null, "Impossible de se connecter","Erreur", JOptionPane.ERROR_MESSAGE);
            }    
            else
            {
                JOptionPane.showMessageDialog(null, "bonjour"+tab[0],"Bienvenue", JOptionPane.INFORMATION_MESSAGE);
                //destruction de l'interface connection
                this.dispose();
                //lancement du menu
                new VueProduit();
            }    
        }    
             
    
    }
    
}
