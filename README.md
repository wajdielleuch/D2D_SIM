# D2D_SIM
Simulator for D2D Network based on MG2D library. The first version enable the simulation of large number of nodes in a loosely coupled model.
The default parameters are :

SIM_DURATION = 7200 ; // 7200 seconds (2 hours)  

nbr_User = 70; // completely customized. the implemented strategy will ad new user every 100 seconds

Area_Width = 500 ; // the width of the simulmation area in meters :   

Area_Height = 500; //  the height of the simulmation area in meters 

Speed = 10;  // Simulation speed  it is possible to adjust the initial speed by holding the up or down buttons on the keyboard 

Mode = 0;  //  0 : not Optimized "less cost" approach and  1 for "optimized tree" approach	

transmission_range  = 100; // This is the minimum  transmission Range of the node. and randmon values will be attrubuted to UE in 100 to 200 meters 

CQI_diff = 1; // this is the CQI threshold used in mode 0 to enable the optimization of the network updates and the average CQI 

update_rate = 1; //  this is the optimisation interval expressed in seconds ... we can shoose different values

The resulted files are generated in .txt files including many key information abour each simulation scenario. 

the code includes some comments in French which will be translated into English as soon as possible.

You can contact me for any help : wajdi.elleuch@univ-littoral.fr 


