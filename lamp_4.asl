// Agent lamp_4 in project SmartCross.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */
+!start: true<-
	!turnoff.
	
+!green : true <-
	.wait(5000);
	switch4;
	  !red.

+!red : true <-	
	.wait(5000);
	switch4;
	  !green.
	  
+!turnoff : true <- 
	turnoff4;
	.wait(20000);
	!red.
