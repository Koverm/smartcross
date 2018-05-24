// Agent lamp_2 in project SmartCross.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!red.

/* Plans */

+!green : true <-.wait(5000);
	switch2;
      -green;
	  !red.

+!red : true <-	.wait(5000);
	switch2;
      -red;
	  !green.

