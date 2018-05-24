// Agent car_1 in project smartCross.mas2j


/* Initial beliefs and rules */

/* Initial goals */

!move.

/* Plans */


+!move : policestarted<-wait(car_1);!wait.


+!move : true <-move(car_1);!move.


+!wait : policearrived<-!move.

+!wait : true <- !wait.

