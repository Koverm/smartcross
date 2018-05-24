// Agent police in project smartCross.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start :true<-
	-arrive;
	.wait(15000);
	.send(car_1,tell,policeontheway);
	.send(car_2,tell,policeontheway);
	.send(car_3,tell,policeontheway);
	+domove;
	!move.

	
+arrived: true<-
	.send(car_1,untell,policeontheway);
	.send(car_2,untell,policeontheway);
	.send(car_3,untell,policeontheway);
	.send(car_1,tell,policearrived);
	.send(car_2,tell,policearrived);
	.send(car_3,tell,policearrived);
	-domove.	
		
+!move :domove <- 
	move(police);
	!move.

+!move: not domove<-
	
	!start;
	police_arrived.



