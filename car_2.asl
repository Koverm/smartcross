// Agent car_2 in project smartCross.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!move.

/* Plans */


+!move : policestarted<-wait(car_2);!wait.


+!move : true <-move(car_2);!move.


+!wait : policearrived<-!move.

+!wait : true <- !wait.

