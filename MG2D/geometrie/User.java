/*********************************************************************/
/*                                                                   */
/* Copyright 2023 Wajdi ELLEUCH                                     */
/*                                                                   */
/*********************************************************************/

package MG2D.geometrie;

import MG2D.Couleur;

import java.awt.Font;

import java.util.ArrayList;

/**
 * THis Class will create a user .<br />
 * This class is a particular case of  class Ovale. 
 * 
An oval is described using a central point, Width and Height. The circle is described using a central point and a diameter (Width=Height)
 * <br /><br />
 * It inherits from the Oval class so that all methods of the Oval class also apply to this one.
 * @author Equipe 2D, Rémi Synave
 * @version 2.9
 */
public class User extends Ovale {

    private int name;
    private Texte texte;
    public ArrayList<User> array_User_Inrange;
    public ArrayList<User> array_Connected_User_Inrange;
    public ArrayList<User> array_OldConnected_User_Inrange;
    public ArrayList<Integer> array_Signal_Strenth;
    public ArrayList<User> Old_GC_array_Connected_User_Inrange;
    // For Stat Purpose
    public int number_of_optimization;
    public int lost_CQI;
    public int number_of_connected_users;

    // Constructeur //

    /**
     * Construit un cercle noir centré en (1,1) et de transmission_range 1.
     */
    public User(){
	super(new Point(1,1),2,2);
    }

    /**
     * Construit un cercle à partir d'un modèle de cercle.<br />
     * Il s'agit du constructeur sans couleur, ainsi l'objet sera noir.
     * @param c Cercle.
     */
    public User ( Cercle c ) {

	super ( c.getCouleur(),
		c.getO(),
		c.getDiametre(),
		c.getDiametre(),
		c.getPlein()
		);
    }

    // Sans couleur //

    /**
     * Construit un Cercle à partir d'un Point et d'un transmission_range.<br />
     * Il s'agit du constructeur sans couleur, ainsi l'objet sera noir.
     * @param o Point correspondant au centre du Cercle.
     * @param transmission_range int correspondant au transmission_range du Cercle.
     * @see Point
     */
    public User ( Point o, int transmission_range ) {

	super ( o, transmission_range*2, transmission_range*2 );
    }

    /**
     * Construit un Cercle à partir d'un Point et d'un transmission_range.<br />
     * Il s'agit du constructeur sans couleur, ainsi l'objet sera noir.
     * @param o Point correspondant au centre du Cercle.
     * @param transmission_range int correspondant au transmission_range du Cercle.
     * @param plein Défini si la forme doit être dessinée pleine ou non.
     * @see Point
     */
    public User ( Point o, int transmission_range, boolean plein ) {

	super ( o, transmission_range*2, transmission_range*2, plein );
    array_User_Inrange = new ArrayList<>();
    array_Signal_Strenth = new ArrayList<>(); 
    array_Connected_User_Inrange = new ArrayList<>();
    array_OldConnected_User_Inrange = new ArrayList<>();
    Old_GC_array_Connected_User_Inrange = new ArrayList<>();
    number_of_optimization = 0;
    lost_CQI =0;
    }

    /**
     * Construit un cercle à partir d'un carré.<br />
     * Il s'agit du constructeur sans couleur, ainsi l'objet sera noir.
     * <br /><br />
     * Le centre du cercle sera obtenue via les coordonnées du Point min du Carre auxquelles on ajoute la moitié de la dimension des côtés.
     * @param c Carre qui défini le Cercle.
     * @see Carre
     */
    public User ( Carre c ) {

	super ( new Point ( ( c.getA().getX() + c.getTaille() / 2 ), ( c.getA().getY() + c.getTaille() / 2 ) ),
		c.getTaille(),
		c.getTaille()
		);
    }

    /**
     * Construit un cercle à partir d'un carré.<br />
     * Il s'agit du constructeur sans couleur, ainsi l'objet sera noir.
     * <br /><br />
     * Le centre du cercle sera obtenue via les coordonnées du Point min du Carre auxquelles on ajoute la moitié de la dimension des côtés.
     * @param c Carre qui défini le Cercle.
     * @param plein Défini si la forme doit être dessinée pleine ou non.
     * @see Carre
     */
    public User ( Carre c, boolean plein ) {

	super ( new Point ( ( c.getA().getX() + c.getTaille() / 2 ), ( c.getA().getY() + c.getTaille() / 2 ) ),
		c.getTaille(),
		c.getTaille(),
		plein
		);
    }

    // Avec couleur //

    /**
     * Construit un cercle à partir d'un Point, d'un transmission_range et d'une couleur.<br />
     * @param couleur Couleur de l'objet.
     * @param o Point correspondant au centre du Cercle.
     * @param transmission_range transmission_range du Cercle.
     * @see Couleur
     * @see Point
     */
    public User ( Couleur couleur, Point o, int transmission_range ) {

	super ( couleur, o, transmission_range*2, transmission_range*2 );
    array_User_Inrange = new ArrayList<>();
    array_Signal_Strenth = new ArrayList<>();
    }

    /**
     * Construit un cercle à partir d'un Point, d'un transmission_range et d'une couleur.<br />
     * @param couleur Couleur de l'objet.
     * @param o Point correspondant au centre du Cercle.
     * @param transmission_range transmission_range du Cercle.
     * @param plein Défini si la forme doit être dessinée pleine ou non.
     * @see Couleur
     * @see Point
     */
    public User (int name, Couleur couleur, Point o, int transmission_range, boolean plein ) {

	super ( couleur, o, transmission_range*2, transmission_range*2, plein );
    this.array_User_Inrange = new ArrayList<>();
    this.array_Connected_User_Inrange = new ArrayList<>();
    this.array_Signal_Strenth = new ArrayList<>(); 

    this.name = name;
    Font font1 = new Font("Calibri", Font.TYPE1_FONT, 10);
    this.texte = new Texte(Couleur.BLEU, String.valueOf(this.getName()), font1, this.getO());

    }

    /**
     * Construit un cercle à partir d'un carré et d'une couleur.<br />
     * Le centre du cercle sera obtenu via les coordonnées du Point min du Carre auxquelles on ajoute la moitié de la dimension des côtés.
     * @param couleur Couleur de l'objet.
     * @param c Carré qui défini le cercle.
     * @see Couleur
     * @see Carre
     */
    public User ( Couleur couleur, Carre c ) {

	super ( couleur,
		new Point ( ( c.getA().getX() + c.getTaille()/2 ), ( c.getA().getY() + c.getTaille()/2 ) ),
		c.getTaille(),
		c.getTaille()
		);
    }

    /**
     * Construit un cercle à partir d'un carré et d'une couleur.<br />
     * Le centre du cercle sera obtenu via les coordonnées du Point min du Carre auxquelles on ajoute la moitié de la dimension des côtés.
     * @param couleur Couleur de l'objet.
     * @param c Carre qui défini le Cercle.
     * @param plein Défini si la forme doit être dessinée pleine ou non.
     * @see Couleur
     * @see Carre
     */
    public User ( Couleur couleur, Carre c, boolean plein ) {

	super ( couleur,
		new Point ( ( c.getA().getX() + c.getTaille()/2 ), ( c.getA().getY() + c.getTaille()/2 ) ),
		c.getTaille(),
		c.getTaille(),
		plein
		);
    }

    // Accesseurs //

    // Getter //


     /**
     * Retourne le point central de l'ovale.
     * @return Point central de l'ovale.
     * @see Point
     */
    public Point getO () {
        return super.getO();
        }
   /**
     * Retourne la couleur de l'utilisateur.
     * @return Couleur de Utilisateur.
     */
    public Couleur getCouleurs () {

        return super.getCouleur();
        }

   /**
     * Retourne le nom de l'utilisateur.
     * @return Nom Utilisateur.
     */
    public int getName () {

        return this.name;
        }
    /**
     * Retourne la valeur du transmission_range.
     * @return transmission_range du cercle.
     */
    public int gettransmission_range () {

	return getArea_Width()/2;
    }
    /**
     * Retourne le Texte .
     * @return Texte.
     */
    public Texte getText () {

        return this.texte;
        }


    /**
     * Retourne la valeur du diamètre.
     * @return Diamètre du cercle.
     */
    public int getDiametre () {

	return getArea_Width();
    }

    // Setter //

     /**
     * Permet d'attribuer un Nom .<br />
     * @param le nom de l'Utilisateur.
     */
    public void setName ( int name ) {

        this.name = name;
        }

        
    /**
     * Permet d'attribuer une nouvelle valeur au transmission_range.<br />
     * Le centre du cercle ne bouge pas.
     * @param transmission_range Nouveau transmission_range du cercle.
     */
    public void settransmission_range ( int transmission_range ) {

	setArea_Width(transmission_range*2);
    }

    /**
     * Permet d'attribuer une nouvelle valeur au diametre.<br />
     * Le centre du cercle ne bouge pas.
     * @param diametre Nouveau diamètre du cercle.
     */
    public void setDiametre ( int diametre ) {

	setArea_Width(diametre);
    }

    /**
     * <strong>Redéfinition !</strong> Permet d'attribuer une nouvelle valeur au diamètre.
     * @param diametre Nouveau diamètre du cercle.
     */
    public void setArea_Width ( int diametre ) {

	super.setArea_Width(diametre);
	super.setArea_Height(diametre);
    }

    /**
     * <strong>Redéfinition !</strong> Permet d'attribuer une nouvelle valeur au diamètre.
     * @param diametre Nouveau diamètre du Cercle.
     */
    public void setArea_Height ( int diametre ) {

	super.setArea_Width(diametre);
	super.setArea_Height(diametre);
    }

    // Méthodes //
public void Update_Text(){
Font font1 = new Font("Calibri", Font.TYPE1_FONT, 20);
this.texte = new Texte(Couleur.BLEU, String.valueOf(this.getName()), font1, this.getO());

}
    // Intersections //

    // Cercle - Point //

    /**
     * Méthode d'intersection précise entre un Cercle et un Point.<br />
     * Retourne vrai s'il y a collision.
     * @param p Point.
     * @return boolean Résultat du test.
     */
    public boolean intersection ( Point p ) {

	boolean collision = false;

	int dx = p.getX() - this.getO().getX();
	int dy = p.getY() - this.getO().getY();

	if ( ( dx * dx ) + ( dy * dy ) < ( gettransmission_range() * gettransmission_range() ) )
	    collision = true;

	return collision;
    }

    // Cercle - Ligne //

    /**
     * Méthode d'intersection précise entre un Cercle et une Ligne.<br />
     * Retourne vrai s'il y a collision.
     * @param l Ligne.
     * @return boolean Résultat du test.
     */
    public boolean intersection ( Ligne l ) {

	boolean collision = false;

	int ux = l.getB().getX() - l.getA().getX();
	int uy = l.getB().getY() - l.getA().getY();
	int acx = this.getO().getX() - l.getA().getX();
	int acy = this.getO().getY() - l.getA().getY();

	int numerateur = ux * acy - uy * acx;

	if ( numerateur < 0 )
	    numerateur = -numerateur;

	int denominateur = ( int ) ( Math.sqrt ( ux * ux + uy * uy ) );
	int ci = numerateur / denominateur;

	if ( ci < gettransmission_range() )
	    collision = true;

	return collision;
    }

    // Cercle - Rectangle //

    /**
     * Méthode d'intersection précise entre un Cercle et un Rectangle.<br />
     * Retourne vrai s'il y a collision.
     * @param r Rectangle.
     * @return boolean Résultat du test.
     */
    public boolean intersection ( Rectangle r ) {

	boolean collision = false;

	int x = this.getO().getX();
	int y = this.getO().getY();

	if ( x < r.getA().getX() )
	    x = r.getA().getX();

	if ( x > ( r.getA().getX() + r.getArea_Width() ) )
	    x = ( r.getA().getX() + r.getArea_Width() );

	if ( y <  r.getA().getY() )
	    y = r.getA().getY();

	if ( y > ( r.getA().getY() + r.getArea_Height() ) )
	    y = ( r.getA().getY() + r.getArea_Height() );

	if ( ( this.getO().getX() - x ) * ( this.getO().getX() - x ) + ( this.getO().getY() - y ) * ( this.getO().getY() - y ) < gettransmission_range() * gettransmission_range() )
	    collision = true;

	return collision;
    }

    // Cercle - Ovale //

    // TODO : travail à faire, si l'envie vous prend :) //

    // Cercle - Cercle //

    /**
     * Méthode d'intersection précise entre un Cercle et un Cercle.<br />
     * Retourne vrai s'il y a collision.
     * @param c Cercle.
     * @return boolean Résultat du test.
     */
    public boolean intersection ( User u ) {

	boolean collision = false;

	int dx = u.getO().getX() - this.getO().getX();
	int dy = u.getO().getY() - this.getO().getY();
	//int ra = u.gettransmission_range() + gettransmission_range();

	if ( ( dx * dx ) + ( dy * dy ) <= ( u.gettransmission_range() * u.gettransmission_range() ) && ( dx * dx ) + ( dy * dy ) <= ( gettransmission_range() * gettransmission_range() ))
	    collision = true;
   
       // if ( ( dx * dx ) + ( dy * dy ) <= ( gettransmission_range() * gettransmission_range() ) )
	  //  collision = true;
        


	return collision;
    }

    // Cercle - Triangle //

    // TODO : travail à faire, si l'envie vous prend :) //

    /**
     * Méthode toString retournant une descirption du cercle.<br />
     * La chaine de caractères retournée est de la forme "Cercle de centre (x1,y1) et de transmission_range r".
     * @return Une chaîne de caractères décrivant le cercle.
     */
    public String toString(){
	//return new String("User position is : "+getO()+" with Range : "+gettransmission_range());
    return new String("User : " + getName());
}

    /**
     * Méthode equals permettant de tester l'égalité entre un cercle et un objet passé en paramètre.
     * @return Vrai si l'objet passé en paramètre est un cercle dont les caractéristiques sont les mêmes que le cercle sur lequel la méthode est appelée.
     */
    public boolean equals(Object obj){
	if (obj==this) {
            return true;
        }

        // Vérification du type du paramètre
        if (obj instanceof User) {
            // Vérification des valeurs des attributs
             User other = (User) obj;
	     return super.equals(other) && gettransmission_range()==other.gettransmission_range();
	}
	return false;
    }
     /**
     * Méthode Display_Neighbors permettant d'ajouter dans le champs array_UserInrange 
     * les autres utilisateurs.
     * 
     */
    public void display_Neighbors()
    {//System.out.println(" \n \n Mes Voisins de" + this.getName() + "Sont :  \n");
        for (User user : this.array_User_Inrange)
         System.out.print("   -" + user.getName() );
    } 
     /**
     * Méthode check_if_Neighboor permettant de vérifier si l'utilisateur donné en argument 
     * est déjà dans la liste des neighboors.
     * @return Boolean true s'il existe sinon false.
     */
   
    public int get_distance(User user)
    {       
            int a = this.getO().getX() - user.getO().getX();
            int b = this.getO().getY() - user.getO().getY();
            return (int) Math.sqrt((a*a) + (b*b));
    }
    public int get_CQI(User user)
    {
        int val = 0;
        if (this.get_distance(user) > this.gettransmission_range())
           return val ;
        if (this.get_distance(user) == this.gettransmission_range())
           return val ;
        else 
        return 16 - this.get_distance(user) * 16 / this.gettransmission_range() ;
    }
     public boolean check_if_Neighboor_Exist(User new_user)
    {
        for (User a_user : this.array_User_Inrange)
          if (a_user.getName() == new_user.getName())
            return true;
         return false;
    } 

    ///// Remove from a list given user //////
    public ArrayList<User> get_remove_from_list( ArrayList<User> user_list,  User user)
    {
    ArrayList<User> temp_list = new ArrayList<>(user_list);
    if (user_list != null)
    while (user.check_if_exist_in_array(user_list))
    temp_list.remove(user);
    return temp_list;
    }

////////////////////////////////////////////////////////////////////////////////////
                        // check_if_connected ////
////////////////////////////////////////////////////////////////////////////////////

    public boolean  check_if_connected(User a_user1, User a_user2)
    {  
        if  ((a_user2.array_Connected_User_Inrange == null) || (a_user1.array_Connected_User_Inrange == null)) 
        return false;

        ArrayList<User> visited_users = new ArrayList<User>();
        User new_user2 = new User();
        visited_users.add(new_user2);
        ArrayList<User> array;
        ArrayList<User> temp;
        array = new ArrayList<>(a_user2.array_Connected_User_Inrange); 
       // visited_users.add(new_user2);
        
        // si jamais ils sont directement connectés
        if (a_user1.check_if_exist_in_array(a_user2.array_Connected_User_Inrange)) 
                return true;

        // sino n on fait le tour et on marque les visites dans le visited_users

       // while (check_if_all_users_exist_in_array(array,visited_users) )
        while (array.size() != 0)
        {
            temp= new ArrayList<User>();
            for (User a_user : array)
        {
                if (a_user1.check_if_exist_in_array( a_user.array_Connected_User_Inrange)  ) 
                return true;
                else
                if (a_user.array_Connected_User_Inrange != null)
                for (User user : a_user.array_Connected_User_Inrange)
                if (! user.check_if_exist_in_array(visited_users))
                    {temp.add(user); 
                    visited_users.add(a_user);
                    }              
        }
        array = new ArrayList<User>(temp);
        
        }
        // System.out.println(" -------------- JE TROUVE AUCUNE CONNEXTION ENTRE : " + a_user1 +"  et  " + a_user2); 
        return false;
    }


    ////////////////////////////////////////////////////////////////////////////////////
    //////////////////// LOOSELY CONNECT NOT OPTIMIZED  ////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////

public void Update_Links(int CQI_Threshold)
{   
       // array_OldConnected_User_Inrange = new ArrayList<>(this.array_Connected_User_Inrange);
        ArrayList<User> Gc = new ArrayList<>();
        ArrayList<ArrayList<User>> Big_Gc = new ArrayList<ArrayList<User>>();
        this.lost_CQI = 0;
        
       // System.out.println("\n TRAITEMENT ELEMENT  : " + this.getName());
       // System.out.println(" SES VOISINS  SONT : " + this.array_User_Inrange);
       // System.out.println(" le Array Connected contient : " + this.array_Connected_User_Inrange);
       // System.out.println(" Les Détails des connected users ");
       // for (User user :  this.array_Connected_User_Inrange)
       // System.out.println("array_connected de " + user + "Sont : " +user.array_Connected_User_Inrange);

        // No neighbor
       if (this.array_User_Inrange.size() == 0)
       {///ystem.out.println("\t FROM MAIN- LES VOISINS DE "+this.getName() + "SONT : " + this.array_User_Inrange);
        //System.out.println(this.getName() + " n'a aucun voisin connecté pour le moment");
       }
      // if only one neighbor
    if (this.array_User_Inrange.size() == 1)
        {  // System.out.println("\t FROM MAIN- LES VOISINS DE "+this.getName() + "SONT : " + this.array_User_Inrange);
            this.array_Connected_User_Inrange.clear();
            for (User a_user : this.array_User_Inrange)
            {  this.array_Connected_User_Inrange.add(a_user);         
               //if (! this.check_if_exist_in_array(a_user.array_Connected_User_Inrange)) 
               a_user.array_Connected_User_Inrange.add(this);
            }
        }
        // beaucoup de voisin :) ca se complique et on doit ne pas Optimized dans cette méthode

        if (this.array_User_Inrange.size() > 1)               
        {
            for (int i = 0 ; i < this.array_User_Inrange.size(); i++) 
            {int j = i+1;  // pour éviter les doublons
                while(j < this.array_User_Inrange.size())
                { 
                if (this.check_if_connected(this.array_User_Inrange.get(i), this.array_User_Inrange.get(j)))
                {   //System.out.println("Check if Connected " + this.array_User_Inrange.get(i) + " And " + this.array_User_Inrange.get(j) + "are connected");
                  //  System.out.println("Vérifier si " + this.array_User_Inrange.get(i) + " existe dans " + this.array_Connected_User_Inrange);       
                    if (! this.array_User_Inrange.get(i).check_if_exist_in_array(Gc) )
                    Gc.add(this.array_User_Inrange.get(i));
                    if (! this.array_User_Inrange.get(j).check_if_exist_in_array(Gc) )
                    Gc.add(this.array_User_Inrange.get(j));                 
                 }
                  
                // System.out.println("Check if Connected " + this.array_User_Inrange.get(i) + " And " + this.array_User_Inrange.get(j) + "are NOT connected");
                    j++;
                }    
            } //System.out.println("GC Groupe de  " + this.getName() + " est : " +  Gc);
       
        if (Gc.size() == 0)
          // System.out.println("Gc est vide");
                    
        if (Gc.size() == 1)
        {   //System.out.println("un seul Gc élément trouvé" + Gc.get(0));
            this.array_Connected_User_Inrange.clear(); // je nettoie avant
            if (!Gc.get(0).check_if_exist_in_array(this.array_Connected_User_Inrange))
            this.array_Connected_User_Inrange.add(Gc.get(0));
             if (! this.check_if_exist_in_array(Gc.get(0).array_Connected_User_Inrange))
            Gc.get(0).array_Connected_User_Inrange.add(this);
        }
        if (Gc.size() == 2)   
        {   //System.out.println(Gc.size() + "  éléments dans Gc trouvés et le meilleur est " + this.Get_Best_NeighboorNot_Opti_Old_Gc(Gc));
            this.array_Connected_User_Inrange.clear(); // je nettoie avant
            boolean find_old = false;
            

                // Nouveau meilleur user trouvé !!
                  // Le meilleur n'était pas connecté     
                for (User user : Gc)
                 if ((!find_old) &&(user.getName() != Get_Best_Neighboor(Gc).getName()) && (user.check_if_exist_in_array(this.array_OldConnected_User_Inrange))) 
                    { // on garde l'ancien 
                   // System.out.println("CQI_New : " + this.get_CQI(Get_Best_Neighboor(Gc)) + " CQI_Old : " + this.get_CQI(user));
                    //if ((this.get_CQI(Get_Best_Neighboor(Gc)) - this.get_CQI(user) >= CQI_Threshold) || (this.get_CQI(Get_Best_Neighboor(Gc)) - this.get_CQI(user) == 0))
                    
                    if ((this.get_CQI(Get_Best_Neighboor(Gc)) - this.get_CQI(user) <= CQI_Threshold)) 
                    {
                    this.array_Connected_User_Inrange.add(user);
                    if (!this.check_if_exist_in_array(user.array_Connected_User_Inrange))
                    user.array_Connected_User_Inrange.add(this);
                    find_old = true;
                    
                     }
                     else 
                     {number_of_optimization ++;
                     //System.out.println("Have MADE OPTIMIZATION  with GC == 2");
                     }
                    }
                  
                if (!find_old)
                {   this.array_Connected_User_Inrange.add(Get_Best_Neighboor(Gc));
                    if (! this.check_if_exist_in_array(this.Get_Best_Neighboor(Gc).array_Connected_User_Inrange))
                    Get_Best_Neighboor(Gc).array_Connected_User_Inrange.add(this);
                }
        }
         if (Gc.size() == 3)   
         {   //System.out.println(Gc.size() + "  éléments dans Gc trouvés et le meilleur est " + this.Get_Best_NeighboorNot_Opti_Old_Gc(Gc));
            this.array_Connected_User_Inrange.clear(); // je nettoie avant
            boolean find_old = false;
                // Nouveau meilleur user trouvé !!
                  // Le meilleur n'était pas connecté     
                for (User user : Gc)
                 if ((!find_old) && (user.getName() != Get_Best_Neighboor(Gc).getName()) && (user.check_if_exist_in_array(this.array_OldConnected_User_Inrange))) 
                    {//System.out.println("CQI_New : " + this.get_CQI(Get_Best_Neighboor(Gc)) + " CQI_Old : " + this.get_CQI(user));

                   if (this.get_CQI(Get_Best_Neighboor(Gc)) - this.get_CQI(user) <= CQI_Threshold)    // on garde l'ancien 
                  //  if ((this.get_CQI(Get_Best_Neighboor(Gc)) - this.get_CQI(user) >= CQI_Threshold) || (this.get_CQI(Get_Best_Neighboor(Gc)) - this.get_CQI(user) == 0))
                    {
                        this.array_Connected_User_Inrange.add(user);
                        if (!this.check_if_exist_in_array(user.array_Connected_User_Inrange))
                            user.array_Connected_User_Inrange.add(this);
                         find_old = true;
                        this.lost_CQI += (this.get_CQI(Get_Best_Neighboor(Gc)) - this.get_CQI(user));
                       //  System.out.println("Have MADE OPTIMIZATION  with GC == 3");
                     }
                     else
                    {number_of_optimization ++;
                     //System.out.println("Have MADE OPTIMIZATION  with GC == 3");
                     }
                    }
                  
                if (!find_old)
                {   this.array_Connected_User_Inrange.add(Get_Best_Neighboor(Gc));
                    if (! this.check_if_exist_in_array(this.Get_Best_Neighboor(Gc).array_Connected_User_Inrange))
                    Get_Best_Neighboor(Gc).array_Connected_User_Inrange.add(this);
                }
        }
        if (Gc.size() >= 4)   
        {   //System.out.println(Gc.size() + "  éléments et plus dans Gc trouvés ");                     
            ArrayList<User> Gc1 = new ArrayList<User>(Gc);
            Big_Gc.add(Gc1);
            int index = 0;
            boolean end = true;
            while (end)
            {   Big_Gc.add(new ArrayList<>());  
                end = false;
                for (int j = 1 ; j < Big_Gc.get(index).size(); j++) 
                {   
                    //System.out.println("BigGC Array numéro "+ index + "    contient " + Big_Gc.get(index));    
                    //System.out.println("Big_GC_Vérifier la connection entre  "+ Big_Gc.get(index).get(0) + "    EST  " + Big_Gc.get(index).get(j)); 
                    if (!check_if_connected(Big_Gc.get(index).get(0),Big_Gc.get(index).get(j)))
                    { 
                    //System.out.println("Big_GC  : " + Big_Gc.get(index).get(0) + " et   " + Big_Gc.get(index).get(j) + "NE SONT PAS CONNECTES " );
                   // System.out.println("Les connected de " + Big_Gc.get(index).get(0) + " Sont : " + Big_Gc.get(index).get(0).array_Connected_User_Inrange);
                    //System.out.println("Les connected de " + Big_Gc.get(index).get(j) + " Sont : " + Big_Gc.get(index).get(j).array_Connected_User_Inrange);
                    end = true;
                    User user_to_move = new User();
                    user_to_move = Big_Gc.get(index).get(j);
                    Big_Gc.get(index+1).add(user_to_move);
                    Big_Gc.get(index).remove(user_to_move);
                    j--; //  pou récupéré le user effacé ..sinon, il sera oublié
                    }
                }
                //System.out.println("BigGC Array numéro "+ index + " contient " + Big_Gc.get(index));    
                if (end == true)
                 {   
                  index++;                  
                 } 
            }
            
            // array_OldConnected_User_Inrange
            this.array_Connected_User_Inrange.clear();
            for (ArrayList<User> array : Big_Gc)
            {   //System.out.println("Mon array to check contient : " + array );
                if ((!array.isEmpty()) && (array != null))
                {   
                boolean find_old = false;
                // Nouveau meilleur user trouvé !!              
                for (User user : array)
                { if ((!find_old) && (user.getName() != Get_Best_Neighboor(array).getName()) && (user.check_if_exist_in_array(this.array_OldConnected_User_Inrange)))                     
                    {
                   // System.out.println("CQI_New : " + this.get_CQI(Get_Best_Neighboor(Gc)) + " CQI_Old : " + this.get_CQI(user));
                    if ((this.get_CQI(Get_Best_Neighboor(array)) - this.get_CQI(user) <= CQI_Threshold))
                  //  if ((this.get_CQI(Get_Best_Neighboor(array)) - this.get_CQI(user) >= CQI_Threshold) || (this.get_CQI(Get_Best_Neighboor(array)) - this.get_CQI(user) == 0))
                    {
                        this.array_Connected_User_Inrange.add(user);
                        if (!this.check_if_exist_in_array(user.array_Connected_User_Inrange))
                        user.array_Connected_User_Inrange.add(this);
                        find_old = true;
                        this.lost_CQI += (this.get_CQI(Get_Best_Neighboor(array)) - this.get_CQI(user));
                        
                        //System.out.println("Have MADE OPTIMIZATION  with GC > 3");
                    }
                    else 
                      {number_of_optimization ++;
                    // System.out.println("Have MADE OPTIMIZATION  with GC > 3");
                     }
                    }
                }
                if ((!find_old) && (array.isEmpty() == false))
                {   
                    this.array_Connected_User_Inrange.add(Get_Best_Neighboor(array));
                    if (! this.check_if_exist_in_array(this.Get_Best_Neighboor(array).array_Connected_User_Inrange))
                    {
                                    
                    if (Get_Best_Neighboor(array).array_Connected_User_Inrange == null)
                    Get_Best_Neighboor(array).array_Connected_User_Inrange = new ArrayList<User>();

                    if ((Get_Best_Neighboor(array) != null) && (Get_Best_Neighboor(array).array_Connected_User_Inrange != null))
                    Get_Best_Neighboor(array).array_Connected_User_Inrange.add(this);
                    }   
                }
            }
        }
       
         Old_GC_array_Connected_User_Inrange = new ArrayList<User>(this.array_Connected_User_Inrange);
        //System.out.println("FIN AJOUT : " + this.getName() + "Possède les direct connected array : " + this.array_Connected_User_Inrange );
}
        /// STAT ////
// Manage and check  Old_Best_Gc and compare with Gc Groupe and Keep OLD Gc


        // Remove Gc group from this.array_User_Inrange to avoid bad verification
        // create Gnc groupe from neighbor - Gc
     
        for (User a_user : this.array_User_Inrange)
          if (!a_user.check_if_exist_in_array(Gc)) // SI a_user n'est pas dans le Gc
            {
            if (! a_user.check_if_exist_in_array( this.array_Connected_User_Inrange) )
                this.array_Connected_User_Inrange.add(a_user);
            if (! this.check_if_exist_in_array(a_user.array_Connected_User_Inrange) )
                a_user.array_Connected_User_Inrange.add(this);
                     
            }
            //System.out.println( "Gc + Gnc contiennent : " + this.array_Connected_User_Inrange);  
        
    }
 }
    ////////////////////////////////////////////////////////////////////////////////////
    // get_best_Nighbors_to_connect() fill the list array_Connected_User_Inrange 
    ////////////////////////////////////////////////////////////////////////////////////
    public User Get_Best_Neighboor(ArrayList<User> array)
    {   int best_CQI = 0;
        User best_User = new User();
        if (array != null)
         for (User a_user : array)
         {
            if (this.get_CQI(a_user) == best_CQI)           
              if (a_user.getName() < best_User.getName())
                best_User = a_user ;
            if (this.get_CQI(a_user) > best_CQI)
            {
            best_CQI = this.get_CQI(a_user);
            best_User = a_user;
            }
        }
        return best_User;
    }
    ////////////////////////////////////////////////////////////////////////////////////
    // get_best_Nighbors_to_connect_Not_Opti_Old_Gc() remplit la liste array_Connected_User_Inrange 
    ////////////////////////////////////////////////////////////////////////////////////
    public User Get_Best_NeighboorNot_Opti_Old_Gc(ArrayList<User> array)
    {   int best_CQI = 0;
        User best_User = new User();

        if(array != null) 
         for (User a_user : array)
         {            
            if (this.get_CQI(a_user) == best_CQI)
            {            
              if (a_user.getName() < best_User.getName())
                best_User = a_user ;
            }
            if (this.get_CQI(a_user) > best_CQI)
            {
            best_CQI = this.get_CQI(a_user);
            best_User = a_user;
            }
           if (a_user.check_if_exist_in_array(array_OldConnected_User_Inrange))
           best_User = a_user;

        }
        return best_User;
    }
    public boolean check_if_exist_in_array (ArrayList<User> array)
    {
        if ( array == null)
        return false;
        if ( array != null)
        for (User a_user : array)
        if (a_user != null)
        if (this.getName() == a_user.getName())
            return true;
        return false;      
    }
 public boolean check_if_all_users_exist_in_array (ArrayList<User> array_to_find, ArrayList<User> verifier_array)
    {
        if ( array_to_find != null)
        for (User a_user : array_to_find)
        if (! a_user.check_if_exist_in_array(verifier_array))      
            return false;
        return true;      
    }
    
    public int get_size (ArrayList<ArrayList<User>> big_Gc)
    {int size = 0;
     for (ArrayList<User> array : big_Gc)
     size += array.size();
    return size;
    }
    ////////////////////////////////////////////////////////////
    ///////////////  Remove_my_Self ////////////////////////////
    ////////////////////////////////////////////////////////////
    public void remove_my_Self(ArrayList<User> arrayUsers)
    {
    for (int i =0 ; i < arrayUsers.size() ; i++)
     if (this.check_if_exist_in_array(arrayUsers.get(i).array_Connected_User_Inrange))
        arrayUsers.get(i).array_Connected_User_Inrange.remove(this); 
    }

 public ArrayList<User> get_array_without_User(ArrayList<User> arrayUsers, User user)
    {
    ArrayList<User> to_return = new ArrayList<>(arrayUsers);   
    for (int i =0 ; i < to_return.size() ; i++)
     while (user.check_if_exist_in_array(to_return))
        to_return.remove(user); 
    return to_return;
    }


    public int get_nbr_groups(ArrayList<User> users)
    {   ArrayList<ArrayList<User>> Big_Gc = new ArrayList<ArrayList<User>>();
            
            ArrayList<User> Gc1 = new ArrayList<>(users);       
            Big_Gc.add(Gc1);
            int index = 0;
            boolean end = true;
            if (Gc1.size() == 1)
            return 1;
            while (end)
            {   Big_Gc.add(new ArrayList<>());  
                end = false;
                for (int j = 1 ; j < Big_Gc.get(index).size(); j++) 
                {   
                 if (!check_if_connected(Big_Gc.get(index).get(0),Big_Gc.get(index).get(j)))
                    { 
                    end = true;
                    User user_to_move = new User();
                    user_to_move = Big_Gc.get(index).get(j);
                    Big_Gc.get(index+1).add(user_to_move);
                    Big_Gc.get(index).remove(user_to_move);
                    j--; //  pou récupéré le user effacé ..sinon, il sera oublié
                    }
                }
                if (end == true)
                  index++;                           
            }   
            return Big_Gc.size()-1;        
    }
}
