// Agent lamp_4 in project SmartCross.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!turnoff.

/* Plans */

+!green : true <-.wait(5000);
	switch4;
      -green;
	  !red.

+!red : true <-	.wait(5000);
	switch4;
      -red;
	  !green.
	  
+!turnoff : true <- 
	turnoff4;
	.wait(50000);
	-turnoff;
	!red.
