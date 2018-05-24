// Agent lamp_3 in project SmartCross.mas2j
/* Initial beliefs and rules */

/* Initial goals */

!turnoff.

/* Plans */

+!green : true <-.wait(5000);
	switch3;
      -green;
	  !red.

+!red : true <-	.wait(5000);
	switch3;
      -red;
	  !green.


+!turnoff : true <- 
	turnoff3;
	.wait(50000);
	-turnoff;
	!green.
