// Agent lamp_1 in project SmartCross.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!start.
/* Plans */

+!start: true<-
	!turnoff.
	
+!green : true <- .wait(5000);
	switch1;
	  !red.

+!red : true <- .wait(5000);
	switch1;
	  !green.
	  
+!turnoff : true <- 
	turnoff1;
	.wait(20000);
	!green.
	

