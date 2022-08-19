This is my old semester project, the goal was to create engine for development of simple
text rpgs. There is a lot of ideas which didn't made it to the result, like text communication
or meaningful stats. Also the object design is quite chaotic and there are a lot of things
which should be done better, like loading all string messages and level definitions from separate text files.

You can run simple game, in which you can walk around some insane stranger's house, open
doors with a key you already have in inventory, equip weapon, find new weapons, and fight
the stranger. You need to find and pick lightsabre to defeat him.

To run, first compile using mvn package
Then run "java -cp target/Don_Aman-1.0-SNAPSHOT.jar level_editor.SaveLevel" to create one simple game
level file
Then run "java -cp target/Don_Aman-1.0-SNAPSHOT.jar core.Test"


