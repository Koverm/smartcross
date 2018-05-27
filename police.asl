// Agent police in project smartCross.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start :true<-
	.wait(30000);
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
	!restart;
	police_arrived.

+!restart :true<-
	.wait(10000);
	.send(car_1,untell,policearrived);
	.send(car_2,untell,policearrived);
	.send(car_3,untell,policearrived);
	.send(car_1,tell,policeontheway);
	.send(car_2,tell,policeontheway);
	.send(car_3,tell,policeontheway);
	+domove;
	!move.

