// Agent lamp_1 in project SmartCross.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!turnoff.
/* Plans */

+!green : true <- .wait(5000);
	switch1;
      -green;
	  !red.

+!red : true <- .wait(5000);
	switch1;
      -red;
	  !green.
	  
+!turnoff : true <- 
	turnoff1;
	.wait(50000);
	-turnoff;
	!green.
	

