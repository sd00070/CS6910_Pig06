# Assumptions

## Your Initial Commit
> Same as the last week, for some reason, I can see your original commit, and git diff cannot find any file changes, but the git CLI is still requiring me to recommit those original files. As it wasn't an issue last week, I'm assuming it won't be an issue this week to recommit the initial files.

## Not all commits will be an MVP
> I traditionally try to make sure all of my commits pass CheckStyle and all of their unit tests, but, in order to show the work of this week, in the correct order, many of my commits will have failing tests. I am assuming that is the best way to go in order to present the Behavior Driven Development.

## Saving optimization to the end
> I'm taking "simplest possible code" as literally as I can, to the extent some of the code is not optimized. Traditionally in BDD and TDD, it's a fail-pass-refactor loop, so I'm going to leave the refactoring until last (since we're really only working on the one method). Hopefully this won't be an issue. Also, hopefully it is alright for me to refactor and optimized the code at the end of this exercise.

## Extra tests
> I'm finding that some of my initial tests are a bit flakey, and they don't interfere with each other enough. Instead of changing or removing the tests I already have (as they are valid & useful for regression testing), I'm going to add more tests to challenge the model's implementation. Example: the computer player should always roll if the player is within 7 points of winning, even if the computer is ahead. I'm assuming it wouldn't be a problem to make my tests more robust.

## Computer Always Rolls at least once unless the Game is Over
> I'm assuming the computer player should always roll the dice at least once as long as the game is not over. It would not do the computer any good to not roll the dice at all. As such, a test must be made to back that assumption.

## Some of my tests required changing
> The instructions state not to change previous, valid tests, but one of the requirements invalidated some of my tests. Changing those specific tests should not change the results, but it will allow for more tests to be added in the future. In specific, many of my tests were passing 0 into the `numberOfRollsSoFar` parameter (even on tests expecting the method to return false). Adding the "always roll at least once as long as the game isn't over" rule caused a contradiction.
