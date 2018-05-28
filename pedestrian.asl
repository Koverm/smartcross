// Agent pedestrian in project smartCross.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!firststep.

/* Plans */

+!firststep : true <-
	.wait(4000);
	move(pedestrian);
	!secondstep.

+!secondstep : true <-
	.wait(1000);
	move(pedestrian);
	!thirdstep.

+!thirdstep : true <-
	.wait(1000);
	move(pedestrian);
	!firststep.
