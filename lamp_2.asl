// Agent lamp_2 in project SmartCross.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!turnoff.

/* Plans */

+!green : true <-.wait(5000);
	switch2;
      -green;
	  !red.

+!red : true <-	.wait(5000);
	switch2;
      -red;
	  !green.
	  
+!turnoff : true <- 
	turnoff2;
	.wait(50000);
	-turnoff;
	!red.
