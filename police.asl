// Agent police in project smartCross.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start :true<-
	.wait(5000);
	.send(car_1,tell,policestarted);
	.send(car_2,tell,policestarted);
	.send(car_3,tell,policestarted);
	!move.

+!move: arrived<-.send(car_1,untell,policestarted);
	.send(car_2,untell,policestarted);
	.send(car_3,untell,policestarted);
	.send(car_1,tell,policearrived);
	.send(car_2,tell,policearrived);
	.send(car_3,tell,policearrived).
	
+!move :true <- move(police);!move.



