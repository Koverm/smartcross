// Agent lamp_4 in project SmartCross.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!red.

/* Plans */

+!green : true <-.wait(5000);
	switch4;
      -green;
	  !red.

+!red : true <-	.wait(5000);
	switch4;
      -red;
	  !green.

