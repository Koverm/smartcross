// Agent lamp_2 in project SmartCross.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start: true<-
	!turnoff.
	
+!green : true <-.wait(5000);
	switch2;
	  !red.

+!red : true <-	.wait(5000);
	switch2;
	  !green.
	  
+!turnoff : true <- 
	turnoff2;
	.wait(20000);
	!red.
