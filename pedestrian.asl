// Agent pedestrian in project smartCross.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <-
	.wait(4000);
	move(pedestrian);
	.wait(1000);
	-start;
	!firststep.

+!firststep : true <-
	move(pedestrian);
	.wait(1000);
	-firststep;
	!secondstep.

+!secondstep : true <-
	move(pedestrian);
	.wait(1000);
	-secondstep;
	!start.
