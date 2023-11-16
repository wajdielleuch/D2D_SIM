# D2D_SIM
Simulator for D2D Network based on MG2D library. The first version enable the simulation of large number of nodes in a loosely coupled model.
The default parameters are :
nbr_User = 70;
width = 500 ; // the width of the simulmation area in meters :   
height =500; //  the height of the simulmation area in meters 
Speed = 0;  // Simulation speed  it is possible to adjust the initial speed by holding the up or down buttons on the keyboard 
SIM_DURATION = 7200 ; // 7200 sec (2heures)  
Mode = 0;  //  0 : not Optimized approach   1 optimized tree approach	
radius  = 100; // the radio transmission Range of the node 
CQI_diff = 1; // this is the CQI threshold used in mode 0 to enable the optimization of the network updates and the average CQI 
update_rate = 1; //  this is the optimisation interval ... we can shoose different values

The resulted files are generated in .txt files including many key information abour each simulation scenario. 

the code includes comments in French which will be translated into English as soon as possible.

You can contact me for any help : wajdi.elleuch@univ-littoral.fr 


