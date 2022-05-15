# Manual Tests

Main functionalit and so-called happy path of the game was tested manually with the following 10 test scenarios. All the tested have passed, but some bugs were found along the way.

## Tes cases:

# Game start

Objective: initialize the game by setting up the field size and number of players

## Instructions
<table>
<tr><th>Step No.</th><th>Step description</th><th>Expected result</th></tr>
<tr><td>1.</td><td>run the project</td><td>game window pops up</td></tr>
  <tr><td>1.</td><td>select 1 player</td><td></td></tr>
  <tr><td>1.</td><td>leave the default field size and click ready to play</td><td>the main game window is opened, asteroid appeared, asteroid info present</td></tr>
</table>

## Notes

Setup:

- ![](./images/start-game.png)

Expected Result:

- ![](./images/main.png)

## Result
pass

# Drill

Objective: check that the resource with mantel bigger than 0 is drillable

## Prerequisites

-Game start test

## Instructions

<table>
<tr><th>Step No.</th><th>Step description</th><th>Expected result</th></tr>
<tr><td>1.</td><td>observe that the asteroid is not drilled through</td><td>there is nothing visible in the center of the asteroid</td></tr>
  <tr><td>1.</td><td>press drill till the resource appears</td><td>resource is visible in the center of asteroid</td></tr>
</table>

## Notes

Expected Result:

- ![](./images/drill.png)

## Result
pass

# Mine

Objective: check that the drilled through asteroid is minable 

## Prerequisites

-Game start test

-Drill test

## Instructions
<table>
<tr><th>Step No.</th><th>Step description</th><th>Expected result</th></tr>
<tr><td>1.</td><td>observe resource is visible</td><td>there is something in the middle of the asteroid</td></tr>
  <tr><td>1.</td><td>press mine button</td><td>resource is added to the resource list in the bottom right corner, hollow parameter is set to true and mined message pops up</td></tr>
</table>

## Notes

Expected Result:

- ![](./images/mine.png)

## Result
pass, but mined window pops up behind the main game window

# Travel fail

Objective: <check that player cannot travel to the asteroid not in the neighborhood>

## Prerequisites

-Game start test

## Instructions
<table>
<tr><th>Step No.</th><th>Step description</th><th>Expected result</th></tr>
<tr><td>1.</td><td>press travel button</td><td>destination selection window pops up</td></tr>
  <tr><td>1.</td><td>enter coordinates where xyz coordinates differs with the current coordinate at least by 3</td><td>asteroid is not in the neighbourhood error pops up</td></tr>
</table>

## Notes

Expected Result:

- ![](./images/travelFail.png)

## Result
pass

# Travel success

Objective: <check that player can travel to the asteroid in the neighborhood >

## Prerequisites

-Game start test

## Instructions
<table>
<tr><th>Step No.</th><th>Step description</th><th>Expected result</th></tr>
<tr><td>1.</td><td>press travel button</td><td>destination selection window pops up</td></tr>
  <tr><td>1.</td><td>enter coordinates where xyz coordinates differs with the current coordinate at least by 1</td><td>asteroid changes, asteroid coordinates in the top right corner match the entered ones</td></tr>
</table>

## Result
pass

# Change settler

Objective: <check that player can switch between settlers>

## Prerequisites

-Game start test

## Instructions

  <table>
<tr><th>Step No.</th><th>Step description</th><th>Expected result</th></tr>
<tr><td>1.</td><td>choose another settler in drop-down menu</td><td>settler badge and resource list updates accordingly</td></tr>
</table>


## Result
pass, but drop-down list selected value is not updated

# Leave resource fail

Objective: <check that the player cannot leave resource on the asteroid if they do not have it >

## Prerequisites

-Game start test
-Drill test
-Mine test

## Instructions
<table>
<tr><th>Step No.</th><th>Step description</th><th>Expected result</th></tr>
<tr><td>1.</td><td>press leave</td><td>recource choice window pops up</td></tr>
  <tr><td>1.</td><td>choose resource that you dont have, press ok</td><td>you dont have resource window pops up</td></tr>
</table>
  
## Notes

Expected Result:

- ![](./images/leaveFail.png)

## Result
pass

# Leave resource success

Objective: <check that the player can leave resource on the asteroid if they have it >

## Prerequisites

-Game start test
-Drill test
-Mine test

## Instructions
<table>
<tr><th>Step No.</th><th>Step description</th><th>Expected result</th></tr>
<tr><td>1.</td><td>press leave</td><td>recource choice window pops up</td></tr>
  <tr><td>1.</td><td>choose resource that you have, press ok</td><td>observe resource placed on the asteroid</td></tr>
</table>

## Notes

Expected Result:

- ![](./images/leaveSuccess.png)

## Result
pass

# Pick up

Objective: <check that the resource with mantel bigger than 0 is drillable >
## Prerequisites

-Game start test
-Drill test
-Mine test
-Leave resource success test

## Instructions
<table>
<tr><th>Step No.</th><th>Step description</th><th>Expected result</th></tr>
<tr><td>1.</td><td>press pick up</td><td>pick up message pops up and resource is added to resource list</td></tr>
</table>

## Notes

Expected Result:

- ![](./images/pick.png)

## Result
pass

# Help

Objective: <check that help menu works>

## Instructions
<table>
<tr><th>Step No.</th><th>Step description</th><th>Expected result</th></tr>
<tr><td>1.</td><td>press help on the top bar</td><td>you're alone in space message pops up</td></tr>
</table>

## Notes

Expected Result:

- ![](./images/help.png)

## Result
pass

# New game

Objective: <check that the player can start a new game >

## Prerequisites

-Game start test

## Instructions
<table>
<tr><th>Step No.</th><th>Step description</th><th>Expected result</th></tr>
<tr><td>1.</td><td>press menu - start new game</td><td>initialize game dialog pops up</td></tr>
</table>

## Notes

Setup:

- ![](./images/new.png)

## Result
pass

## Lessons learnt

Manual tests allowed us to spot the issues not visible with automated tests and spot the unintuitive UI/UX.
