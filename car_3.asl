// Agent car_3 in project smartCross.mas2j



/* Initial beliefs and rules */

/* Initial goals */
!move.

/* Plans */

+!move : policestarted<-wait(car_3);!wait.


+!move : true <-move(car_3);!move.


+!wait : policearrived<-!move.

+!wait : true <- !wait.


