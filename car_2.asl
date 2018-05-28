// Agent car_2 in project smartCross.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!move.

/* Plans */

+!move : policeontheway<-
	wait(car_2).

+!move : true <-
	move(car_2);
	!move.

+policearrived:true<- 
	!move.



