// Agent car_3 in project smartCross.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!move.

/* Plans */

+!move : policeontheway<-
	wait(car_3);
	-policearrived.

+!move : true <-
	move(car_3);
	!move.

+policearrived:true<- 
	!!move.


