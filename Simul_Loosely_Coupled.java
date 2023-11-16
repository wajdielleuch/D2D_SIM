import MG2D.*;
import MG2D.geometrie.*;

import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class Simul{
	public static int nbr_User = 69;
    public static final int Largeur = 500;
    public static final int Hauteur =500;
	public static  int Speed = 0;
	public static boolean FILE_APPEND = false;
	public static int SIM_DURATION = 7200 ; // 7200 sec (2heures)  10800 3heures
	public static int Mode = 0;  //0 : Loosely not Optimized  1 Loosely coupled optmized	
	public static int rayon = 100; // User Radio Range 
	public static int CQI_diff = 1;
	public static int update_rate = 1;

    public static void main(String[] args){

	if (args.length == 1)
	nbr_User = Integer.parseInt(args[0]);
	// Mettre les Users dans un ArrayList
	ArrayList<User> ArrayUsers = new ArrayList<>();
	ArrayList<User> ArrayWaitingUsers = new ArrayList<>();
	
    ArrayList<ArrayList<Point>> array_Trajet = new ArrayList<ArrayList<Point>>();
	int speed = 1;
	int angle = 0;

	Random random = new Random();		
	for (int i=0; i < 71; i++)
		{	
			//array_Trajet.add(new ArrayList<>()); 
			// angle : 0-11
			//Speed : As you like
			ArrayList<Point> newlist = new ArrayList<>();
			newlist = Generate_Trajet(new Point(random.nextInt(Largeur),random.nextInt(Hauteur)),speed,angle,SIM_DURATION);
			array_Trajet.add(newlist);
			angle = random.nextInt(12) %12;
			speed = random.nextInt(4) + 1 ; // 4 is a max speed    +1 to avoid speed null spee range [1--4]
		}
 	User U0 = new User(0,Couleur.JAUNE, new Point(0,0), random.nextInt(100) + rayon, false);	
	User U1 = new User(1,Couleur.JAUNE, array_Trajet.get(1).get(0), random.nextInt(100) + rayon, false);
	User U2 = new User(2,Couleur.JAUNE, array_Trajet.get(2).get(0), random.nextInt(100) + rayon, false);
	User U3 = new User(3,Couleur.JAUNE, array_Trajet.get(3).get(0), random.nextInt(100) + rayon, false);
	User U4 = new User(4,Couleur.JAUNE, array_Trajet.get(4).get(0), random.nextInt(100) + rayon, false);
	User U5 = new User(5,Couleur.JAUNE, array_Trajet.get(5).get(0),random.nextInt(100) + rayon, false);
	User U6 = new User(6,Couleur.JAUNE, array_Trajet.get(6).get(0), random.nextInt(100) + rayon, false);
	User U7 = new User(7,Couleur.JAUNE, array_Trajet.get(7).get(0), random.nextInt(100) + rayon, false);
	User U8 = new User(8,Couleur.JAUNE,array_Trajet.get(8).get(0), random.nextInt(100) + rayon, false);
	User U9 = new User(9,Couleur.JAUNE, array_Trajet.get(9).get(0), random.nextInt(100) + rayon, false);
	User U10 = new User(10,Couleur.JAUNE, array_Trajet.get(10).get(0), random.nextInt(100) + rayon, false);

	User U11 = new User(11,Couleur.JAUNE, array_Trajet.get(11).get(0), random.nextInt(100) + rayon, false);
	User U12 = new User(12,Couleur.JAUNE, array_Trajet.get(12).get(0), random.nextInt(100) + rayon, false);
	User U13 = new User(13,Couleur.JAUNE, array_Trajet.get(13).get(0), random.nextInt(100) + rayon, false);
	User U14 = new User(14,Couleur.JAUNE, array_Trajet.get(14).get(0), random.nextInt(100) + rayon, false);
	User U15 = new User(15,Couleur.JAUNE, array_Trajet.get(15).get(0),random.nextInt(100) + rayon, false);
	User U16 = new User(16,Couleur.JAUNE, array_Trajet.get(16).get(0), random.nextInt(100) + rayon, false);
	User U17 = new User(17,Couleur.JAUNE, array_Trajet.get(17).get(0), random.nextInt(100) + rayon, false);
	User U18 = new User(18,Couleur.JAUNE,array_Trajet.get(18).get(0), random.nextInt(100) + rayon, false);
	User U19 = new User(19,Couleur.JAUNE, array_Trajet.get(19).get(0), random.nextInt(100) + rayon, false);
	User U20 = new User(20,Couleur.JAUNE, array_Trajet.get(20).get(0), random.nextInt(100) + rayon, false);

	User U21 = new User(21,Couleur.JAUNE, array_Trajet.get(21).get(0), random.nextInt(100) + rayon, false);
	User U22 = new User(22,Couleur.JAUNE, array_Trajet.get(22).get(0), random.nextInt(100) + rayon, false);
	User U23 = new User(23,Couleur.JAUNE, array_Trajet.get(23).get(0), random.nextInt(100) + rayon, false);
	User U24 = new User(24,Couleur.JAUNE, array_Trajet.get(24).get(0), random.nextInt(100) + rayon, false);
	User U25 = new User(25,Couleur.JAUNE, array_Trajet.get(25).get(0),random.nextInt(100) + rayon, false);
	User U26 = new User(26,Couleur.JAUNE, array_Trajet.get(26).get(0), random.nextInt(100) + rayon, false);
	User U27 = new User(27,Couleur.JAUNE, array_Trajet.get(27).get(0), random.nextInt(100) + rayon, false);
	User U28 = new User(28,Couleur.JAUNE,array_Trajet.get(28).get(0), random.nextInt(100) + rayon, false);
	User U29 = new User(29,Couleur.JAUNE, array_Trajet.get(29).get(0), random.nextInt(100) + rayon, false);
	
	User U30 = new User(30,Couleur.JAUNE, array_Trajet.get(30).get(0), random.nextInt(100) + rayon, false);
	User U31 = new User(31,Couleur.JAUNE, array_Trajet.get(31).get(0), random.nextInt(100) + rayon, false);
	User U32 = new User(32,Couleur.JAUNE, array_Trajet.get(32).get(0), random.nextInt(100) + rayon, false);
	User U33 = new User(33,Couleur.JAUNE, array_Trajet.get(33).get(0), random.nextInt(100) + rayon, false);
	User U34 = new User(34,Couleur.JAUNE, array_Trajet.get(34).get(0), random.nextInt(100) + rayon, false);
	User U35 = new User(35,Couleur.JAUNE, array_Trajet.get(35).get(0),random.nextInt(100) + rayon, false);
	User U36 = new User(36,Couleur.JAUNE, array_Trajet.get(36).get(0), random.nextInt(100) + rayon, false);
	User U37 = new User(37,Couleur.JAUNE, array_Trajet.get(37).get(0), random.nextInt(100) + rayon, false);
	User U38 = new User(38,Couleur.JAUNE,array_Trajet.get(38).get(0), random.nextInt(100) + rayon, false);
	User U39 = new User(39,Couleur.JAUNE, array_Trajet.get(39).get(0), random.nextInt(100) + rayon, false);
	User U40 = new User(40,Couleur.JAUNE, array_Trajet.get(40).get(0), random.nextInt(100) + rayon, false);

	User U41 = new User(41,Couleur.JAUNE, array_Trajet.get(41).get(0), random.nextInt(100) + rayon, false);
	User U42 = new User(42,Couleur.JAUNE, array_Trajet.get(42).get(0), random.nextInt(100) + rayon, false);
	User U43 = new User(43,Couleur.JAUNE, array_Trajet.get(43).get(0), random.nextInt(100) + rayon, false);
	User U44 = new User(44,Couleur.JAUNE, array_Trajet.get(44).get(0), random.nextInt(100) + rayon, false);
	User U45 = new User(45,Couleur.JAUNE, array_Trajet.get(45).get(0),random.nextInt(100) + rayon, false);
	User U46 = new User(46,Couleur.JAUNE, array_Trajet.get(46).get(0), random.nextInt(100) + rayon, false);
	User U47 = new User(47,Couleur.JAUNE, array_Trajet.get(47).get(0), random.nextInt(100) + rayon, false);
	User U48 = new User(48,Couleur.JAUNE,array_Trajet.get(48).get(0), random.nextInt(100) + rayon, false);
	User U49 = new User(49,Couleur.JAUNE, array_Trajet.get(49).get(0), random.nextInt(100) + rayon, false);
	User U50 = new User(50,Couleur.JAUNE, array_Trajet.get(50).get(0), random.nextInt(100) + rayon, false);

	User U51 = new User(51,Couleur.JAUNE, array_Trajet.get(51).get(0), random.nextInt(100) + rayon, false);
	User U52 = new User(52,Couleur.JAUNE, array_Trajet.get(52).get(0), random.nextInt(100) + rayon, false);
	User U53 = new User(53,Couleur.JAUNE, array_Trajet.get(53).get(0), random.nextInt(100) + rayon, false);
	User U54 = new User(54,Couleur.JAUNE, array_Trajet.get(54).get(0), random.nextInt(100) + rayon, false);
	User U55 = new User(55,Couleur.JAUNE, array_Trajet.get(55).get(0),random.nextInt(100) + rayon, false);
	User U56 = new User(56,Couleur.JAUNE, array_Trajet.get(56).get(0), random.nextInt(100) + rayon, false);
	User U57 = new User(57,Couleur.JAUNE, array_Trajet.get(57).get(0), random.nextInt(100) + rayon, false);
	User U58 = new User(58,Couleur.JAUNE,array_Trajet.get(58).get(0), random.nextInt(100) + rayon, false);
	User U59 = new User(59,Couleur.JAUNE, array_Trajet.get(59).get(0), random.nextInt(100) + rayon, false);
	User U60 = new User(60,Couleur.JAUNE, array_Trajet.get(60).get(0), random.nextInt(100) + rayon, false);

	User U61 = new User(61,Couleur.JAUNE, array_Trajet.get(61).get(0), random.nextInt(100) + rayon, false);
	User U62 = new User(62,Couleur.JAUNE, array_Trajet.get(62).get(0), random.nextInt(100) + rayon, false);
	User U63 = new User(63,Couleur.JAUNE, array_Trajet.get(63).get(0), random.nextInt(100) + rayon, false);
	User U64 = new User(64,Couleur.JAUNE, array_Trajet.get(64).get(0), random.nextInt(100) + rayon, false);
	User U65 = new User(65,Couleur.JAUNE, array_Trajet.get(65).get(0),random.nextInt(100) + rayon, false);
	User U66 = new User(66,Couleur.JAUNE, array_Trajet.get(66).get(0), random.nextInt(100) + rayon, false);
	User U67 = new User(67,Couleur.JAUNE, array_Trajet.get(67).get(0), random.nextInt(100) + rayon, false);
	User U68 = new User(68,Couleur.JAUNE,array_Trajet.get(68).get(0), random.nextInt(100) + rayon, false);
	User U69 = new User(69,Couleur.JAUNE, array_Trajet.get(69).get(0), random.nextInt(100) + rayon, false);
	User U70 = new User(70,Couleur.JAUNE, array_Trajet.get(70).get(0), random.nextInt(100) + rayon, false);

	ArrayWaitingUsers.add(U1); 	ArrayWaitingUsers.add(U2); 	ArrayWaitingUsers.add(U3); 	ArrayWaitingUsers.add(U4);
	ArrayWaitingUsers.add(U5); 	ArrayWaitingUsers.add(U6);	ArrayWaitingUsers.add(U7);	ArrayWaitingUsers.add(U8);
	ArrayWaitingUsers.add(U9);	ArrayWaitingUsers.add(U10);	ArrayWaitingUsers.add(U11);	ArrayWaitingUsers.add(U12);
	ArrayWaitingUsers.add(U13);	ArrayWaitingUsers.add(U14);	ArrayWaitingUsers.add(U15);	ArrayWaitingUsers.add(U16);
	ArrayWaitingUsers.add(U17);	ArrayWaitingUsers.add(U18);	ArrayWaitingUsers.add(U19);	ArrayWaitingUsers.add(U20);
	ArrayWaitingUsers.add(U21);	ArrayWaitingUsers.add(U22); ArrayWaitingUsers.add(U23);	ArrayWaitingUsers.add(U24);	
	ArrayWaitingUsers.add(U25);	ArrayWaitingUsers.add(U26); ArrayWaitingUsers.add(U27);	ArrayWaitingUsers.add(U28);	
	ArrayWaitingUsers.add(U29);ArrayWaitingUsers.add(U30);	ArrayWaitingUsers.add(U31);	ArrayWaitingUsers.add(U32);
	ArrayWaitingUsers.add(U33);	ArrayWaitingUsers.add(U34);	ArrayWaitingUsers.add(U35);	ArrayWaitingUsers.add(U36);
	ArrayWaitingUsers.add(U37);	ArrayWaitingUsers.add(U38);	ArrayWaitingUsers.add(U39);ArrayWaitingUsers.add(U40);	
	ArrayWaitingUsers.add(U41);	ArrayWaitingUsers.add(U42); ArrayWaitingUsers.add(U43);	ArrayWaitingUsers.add(U44);	
	ArrayWaitingUsers.add(U45);	ArrayWaitingUsers.add(U46);	ArrayWaitingUsers.add(U47);	ArrayWaitingUsers.add(U48);	
	ArrayWaitingUsers.add(U49);ArrayWaitingUsers.add(U50);	ArrayWaitingUsers.add(U51);	ArrayWaitingUsers.add(U52);
	ArrayWaitingUsers.add(U53);	ArrayWaitingUsers.add(U54);	ArrayWaitingUsers.add(U55);	ArrayWaitingUsers.add(U56);
	ArrayWaitingUsers.add(U57);	ArrayWaitingUsers.add(U58);	ArrayWaitingUsers.add(U59);ArrayWaitingUsers.add(U60);
	ArrayWaitingUsers.add(U61);	ArrayWaitingUsers.add(U62);ArrayWaitingUsers.add(U63);	ArrayWaitingUsers.add(U64);	
	ArrayWaitingUsers.add(U65);	ArrayWaitingUsers.add(U66);ArrayWaitingUsers.add(U67);	ArrayWaitingUsers.add(U68);	
	ArrayWaitingUsers.add(U69);ArrayWaitingUsers.add(U70);
 
	//System.out.println("j'ai " + String.valueOf(ArrayUsers.size()+ " Utilistateurs mobiles"));
	//System.out.println("j'ai " + ArrayUsers.get(0));
int[] myArray1 = new int[]{1,2,3,4,5,6,8,10,20};
//int[] myArray1 = new int[]{1};
int[] myArray2 = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,15};
for (int jjj =0; jjj<myArray1.length; jjj++)
{ update_rate = myArray1[jjj];
for (int iii=0; iii<myArray2.length; iii++)
{ CQI_diff = myArray2[iii]; 

//for (CQI_diff = -1; CQI_diff < 0; CQI_diff++)
//{   
	int Total_SIM_STEP_lost_CQI = 0;
	ArrayUsers.clear();
	ArrayUsers.add(U0);
	// Mettre les Lignes dans un ArrayList
	ArrayList<Ligne> ArrayLignes = new ArrayList<>();
Fenetre f;
if (Mode ==0) 
	 f = new Fenetre("Loosely Coupled, Mode : Without optimization", Largeur, Hauteur);
else
	f = new Fenetre("Loosely Coupled, Mode : with optimization", Largeur, Hauteur);

	f.setBounds (0,0,Largeur, Hauteur);
	Clavier clavier = f.getClavier();
	//Souris souris = f.getSouris();
	int cqi_temp =0;
	int sim_step = 0;
	int index_add = 0;
	int stat_groupe_Duration = 0;
	int total_cqi =0;
	int total_nbr_optimization_oper = 0;
	int  stat_0_groupe_Duration = 0 , stat_1_groupe_Duration = 0, stat_2_groupe_Duration = 0, stat_3_groupe_Duration = 0, stat_4_groupe_Duration = 0, stat_5More_groupe_Duration = 0; 
	
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////    DEBUT DE LA SIMULATION     /////////////////
	////////////////////////////////////////////////////////////////////////////

	while(sim_step < SIM_DURATION)
	{	    
		if (sim_step%100 ==0)
		System.out.println(sim_step + "\t  Mode : " + Mode );

		// Add all users ..1 user every 100 seconds
		if  (index_add < nbr_User)
		{	if (sim_step%100 == 0)
			{
				ArrayUsers.add(ArrayWaitingUsers.get(index_add));
				System.out.println("Addiiiing " + ArrayWaitingUsers.get(index_add) + " à " + sim_step);
				index_add ++; 
			}
		}	

		for (User user : ArrayUsers)
		{
		f.supprimer(user);
		f.ajouter(user); 
		f.rafraichir(); 
		}
		sim_step ++;
		try{
		Thread.sleep(Speed);		
	    }catch(Exception e){}

		if(clavier.getHautEnfoncee()&& Speed < 2000)
		Speed= Speed + 50 ;
	    if(clavier.getBasEnfoncee() && Speed>= 50)
		Speed= Speed - 50;
		for (User user : ArrayUsers)	
		user.setO(array_Trajet.get(user.getName()).get(sim_step));
	// Update array_In_Range dor each user
		UpdateNeighbors(ArrayUsers);
		
// EFFACER Tableau des Ligne + enlever from Affichage
		for(Ligne ligne : ArrayLignes)
		{
		f.supprimer(ligne);
		}
		ArrayLignes.clear();
		f.rafraichir();	
		/////////////////////////////////// 
        ////// CONNECT NEW LINKS //////////
		///////////////////////////////////
		int SIM_STEP_lost_CQI = 0;
		cqi_temp = CQI_diff ;
		if (sim_step%update_rate != 0)   // define the update rate
		cqi_temp = 16;

		// SAVE Array_OldConnected_User_Inrange
			for (int i = ArrayUsers.size()-1 ; i >= 0 ; i--)
			  ArrayUsers.get(i).array_OldConnected_User_Inrange = new ArrayList<User>(ArrayUsers.get(i).array_Connected_User_Inrange);


		for (int i = ArrayUsers.size()-1 ; i >= 0 ; i--) 
			{	if (Mode == 0)  //Not Opimized
				{ // Sauvegarder la Liste 
				//ArrayUsers.get(i).array_OldConnected_User_Inrange = new ArrayList<User>(ArrayUsers.get(i).array_Connected_User_Inrange);
				//System.out.println("Liste des Old Connected : " + ArrayUsers.get(i).array_OldConnected_User_Inrange);
				//System.out.println("Liste des Old Connected Original: " + ArrayUsers.get(i).array_Connected_User_Inrange);
				for (int ii =0 ; ii < ArrayUsers.size() ; ii++)
				{  
     				while (ArrayUsers.get(i).check_if_exist_in_array(ArrayUsers.get(ii).array_Connected_User_Inrange))
        				ArrayUsers.get(ii).array_Connected_User_Inrange.remove(ArrayUsers.get(i)); 			
				}
						ArrayUsers.get(i).LooselyConnectNotOpti(cqi_temp);
						SIM_STEP_lost_CQI += ArrayUsers.get(i).lost_CQI;					
				}
				Total_SIM_STEP_lost_CQI += SIM_STEP_lost_CQI;
				if (Mode == 1)  //Opimized
				{
				for (int ii =0 ; ii < ArrayUsers.size() ; ii++)
     				while (ArrayUsers.get(i).check_if_exist_in_array(ArrayUsers.get(ii).array_Connected_User_Inrange))
        				ArrayUsers.get(ii).array_Connected_User_Inrange.remove(ArrayUsers.get(i)); 
					ArrayUsers.get(i).LooselyConnectOpti();
				}
			}
			stat_groupe_Duration = ArrayUsers.get(0).get_nbr_groups(ArrayUsers);


			
		//////////////////////////////////////////////////////////////////////////////////////////////////////						
		///////////////////////////////////////////////////   STAT    ////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////	
		//CREATE Ligne dans le ArrayLines AND STAT 
		int nbr_connections = 0;
		int total_cqi_per_op = 0 ;
		int nbr_optimization_oper =0;
	
		for (User a_user : ArrayUsers) 
		{	//write("Liste des connected user de " + a_user.getName() + " Sont : " + a_user.array_Connected_User_Inrange);
			for (User c_user : a_user.array_Connected_User_Inrange)
			{ 
				ArrayLignes.add(new Ligne(get_ligne_name(a_user, c_user), a_user.getO(),c_user.getO(),Couleur.BLEU));
				nbr_connections ++;
				total_cqi_per_op += a_user.get_CQI(c_user);
				
				//System.out.print("\t CQI : " + a_user.get_CQI(c_user) );
				
				//write ("CQI de " + a_user + " avec " + c_user + " est égale à : " + a_user.get_CQI(c_user));				
			}
			nbr_optimization_oper +=  a_user.number_of_optimization;
			a_user.number_of_optimization = 0;
			
			if (stat_groupe_Duration == 1)
			stat_1_groupe_Duration++;
			if (stat_groupe_Duration == 2)
			stat_2_groupe_Duration++;
			if (stat_groupe_Duration >= 3)
			stat_3_groupe_Duration++;			
		}
		total_nbr_optimization_oper += nbr_optimization_oper;
		total_cqi += total_cqi_per_op;
		///// OUTPUT FILE FOR STAT  ////////////

		if (sim_step == 1)  // prépare l'Entête
		{
			//write("Time (seconds) \t Number of Users \t CQI_per_op \t total_cqi_per_op \t Nbr_Connections_per_op \t Avrg_CQI/connections *100  \t  Global_Total_CQI  \t Nbr of links update_per_Op. \t total_nbr_optimization_oper \t SIM_STEP_lost_CQI \t Total_SIM_STEP_lost_CQI");
			write("sim_ste  \t  ArrayUsers.size()  \t  total_cqi_per_op  \t  nbr_connections  \t   total_cqi_per_op/nbr_connections  \t   total_cqi  \t nbr_optimization_oper  \t  total_nbr_optimization_oper  ");

			FILE_APPEND =  true;
		}
		if (nbr_connections == 0)
		write(sim_step +"\t" + ArrayUsers.size() + "\t" + total_cqi_per_op + "\t" + nbr_connections + "\t" + 0 +"\t "+ total_cqi + "\t" + nbr_optimization_oper +"\t" +total_nbr_optimization_oper);
		else
		write(sim_step +"\t" + ArrayUsers.size() + "\t" + total_cqi_per_op + "\t"+ nbr_connections + "\t" + total_cqi_per_op /nbr_connections + "\t "+  total_cqi    + "\t" + nbr_optimization_oper  + "\t" + total_nbr_optimization_oper  );
		

		//Ajouter les Lignes dans l'Affichage
		 for (Ligne ligne : ArrayLignes)
		 {  f.ajouter(ligne);
		 }
		//f.rafraichir();

 		//Gérer le texte des utilisateurs
		 for (User user : ArrayUsers)
		 {
			f.supprimer(user.getText());
			user.Update_Text();
			f.ajouter(user.getText());
			//f.ajouter(user);
		 }
	
	    f.rafraichir();
		// Adding new user to the graph
 
	}
	if (sim_step == SIM_DURATION) 
	 System.out.println("Fin normale de la Simulation, " + sim_step + " Opérations traitées ! ");

	f.effacer();
	f.fermer();
	
		FILE_APPEND= false;
		for (User user : ArrayUsers)
		{
			user.array_Connected_User_Inrange.clear();
			user.array_User_Inrange.clear();
			user.array_OldConnected_User_Inrange.clear();
			user.number_of_optimization =0;
			user.lost_CQI=0;
		}

}}

}
	public static int get_ligne_name(User userA, User userB){
		return Integer.parseInt(String.valueOf(userA.getName()) + "9999" + String.valueOf(userB.getName()));
	}

public static void UpdateNeighbors(ArrayList <User> ArrayUsers)
{
	for (int i = 0 ; i < ArrayUsers.size(); i++) 
		{int j = i+1;  // pour éviter les doublons
			while(j < ArrayUsers.size())
			{
				if (ArrayUsers.get(i).intersection(ArrayUsers.get(j)))
					{  			
					if (!ArrayUsers.get(i).check_if_Neighboor_Exist(ArrayUsers.get(j)))
						{	
							ArrayUsers.get(i).array_User_Inrange.add(ArrayUsers.get(j));
							ArrayUsers.get(j).array_User_Inrange.add(ArrayUsers.get(i));
							} 
				}
				else 
				{
					if (ArrayUsers.get(i).check_if_Neighboor_Exist(ArrayUsers.get(j)))
						{	ArrayUsers.get(i).array_User_Inrange.remove(ArrayUsers.get(j));
							ArrayUsers.get(j).array_User_Inrange.remove(ArrayUsers.get(i));					
						}
				}
					j++;
							}
		}
}

///////////////////////////////////////////////
///////// VOID Write to File //////////////////
///////////////////////////////////////////////
	public static void write( String text)
	{
		FileWriter fw = null; 
		BufferedWriter bw = null; 
		PrintWriter pw = null; 
		try {
		//fw = new FileWriter(new String("loosely... User Progress " + "Mode " + Mode + " with " + Largeur + " sur " + Hauteur + ".txt"), FILE_APPEND);  
		fw = new FileWriter(new String("loosely" + nbr_User + "Mode " + Mode + "with " + "CQI_diff" + CQI_diff + "update" + update_rate +" Dim " + Largeur + " sur " + Hauteur + ".txt"), FILE_APPEND); 
		//fw = new FileWriter(new String("Loosely Coupled " + nbr_User + "Mode " + Mode + "with " + "CQI_diff" + CQI_diff + " Dim " + Largeur + " sur " + Hauteur + ".txt"), FILE_APPEND); 
		//fw = new FileWriter(new String("loosely" + nbr_User + "Mode " + Mode + ".txt"), FILE_APPEND); 
		bw = new BufferedWriter(fw); 
		pw = new PrintWriter(bw); 
		pw.println(text); 
		
		//System.out.println("Data Successfully appended into file"); 
		pw.flush(); } 
			catch (IOException io) {
				System.out.println("PROBLEM WITH FILE" + io.getMessage());			}
	}
	/* Utilitaire pour le Trajet */
public static ArrayList<Point> Generate_Trajet(Point start, int speed, int a_angle, int Sim_Limit) 
{
        // Speed peut être 0, 1, 2 ou 3 trés rapide
       // int Max_Position = Sim_Limit;
	   	int angle = a_angle;
        ArrayList<Point> trajet = new ArrayList<>();
        Point point = new Point(start);
        trajet.add(point);

        // Random to generete to change angle 
        Random rand = new Random(); 
        int upperbound = 3;
		int to_add = 0;
        int i =0;
   while (i <= Sim_Limit )
    {       
        //point = NextMove(point, speed, angle);
        while (is_in_border(NextMove(point, speed, angle))) // détecter le bord           
        // période de repos   
		{ //System.out.println ("In border SIM" + i);
			//for (int j=0; j< 100 ; j++)
			 //trajet.add(point);
			 if (angle%3 == 2)
			 to_add = 4;
			 if (angle%3 == 1)
			 to_add = 5;
			 if (angle%3 == 0)
			 to_add = 6;

			angle = ((angle + rand.nextInt(3) + to_add)%12);
/**
			if ((point.getX() < 0) )
			 point.setX(10);
			if ((point.getY() < 0) )
			 point.setY(10);
			if ((point.getX() > Largeur) )
			 point.setX(Largeur-10);
			if ((point.getY() > Hauteur) )
			 point.setX(Hauteur-10);
**/
			//if ((point.getX() < 0) )
			//point.setX(0);
			//Random random = new Random();	
			//angle = rand.nextInt(12) %12;
          //  point = NextMove(point, speed, angle);
			//trajet.add(point); 			 
		}
		point = NextMove(point, speed, angle);
		trajet.add(point);
		i++;
	}	
    return trajet;
}
////////////////////// nextmove    
public static Point NextMove(Point a_point, int speed, int angle)
{ Point point = new Point(a_point);
// angle : 0-11
//Speed : As you like
//System.out.println("AVANT : " +point);
    if (angle == 0)
     point.translater(speed+2, speed);
    if (angle == 1)
     point.translater(speed, speed);
    if (angle == 2)
     point.translater(speed, speed+2);

	if (angle == 3)
     point.translater(-speed, speed+2);
    if (angle == 4)
     point.translater(-speed, speed);
    if (angle == 5)
     point.translater(-(speed+2), speed);
    if (angle == 6)
     point.translater(-(speed+2), -speed);
    if (angle == 7)
     point.translater(-speed, -speed);
    if (angle == 8)
     point.translater(-speed, -(speed+2));
     if (angle == 9)
     point.translater(speed,-(speed+2));
    if (angle == 10)
     point.translater(speed, -speed);
    if (angle == 11)
     point.translater(speed+2, -speed);
return point;
}

public static boolean is_in_border (Point point)
{
    if ((point.getX() < 0) || (point.getX() > Largeur ))
    return true;

    if ((point.getY() < 0) || (point.getY() > Hauteur ))
    return true;

    return false;
}
	
}