// Agent lamp_3 in project SmartCross.mas2j
/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */
+!start: true<-
	!turnoff.
	
+!green : true <-.wait(5000);
	switch3;
	  !red.

+!red : true <-	.wait(5000);
	switch3;
	  !green.


+!turnoff : true <- 
	turnoff3;
	.wait(20000);
	!green.
