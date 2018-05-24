// Agent car_3 in project smartCross.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <- .wait(1000); move(car_3);!start.

