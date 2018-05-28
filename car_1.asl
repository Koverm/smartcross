// Agent car_1 in project smartCross.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!move.

/* Plans */

+!move : policeontheway<-
	wait(car_1).

+!move : true <-
	move(car_1);
	!move.

+policearrived:true<-
	!move.

