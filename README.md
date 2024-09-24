# Talking-clock

This repository has 

1. A talking-clock script that returns time in Human Friendly Text . This script perfoms two things, the first one is if we execute the script without any input it would show the current time.

 Example -> If the current time is 16:30 then it outputs as “Half past four”. 

 The second one is if the script takes numeric time parameter as input ,then it returns equivalent human friendly text.
 Example -> $talking-clock 16:00 outputs as Four o’clock.

 Script path : src/main/resources/talking-clock

2. It has a REST service that exposes the clock with a parameter and returns a Human Friendly text in JSON format.
Once you run the service it will hit the  endpoint (/time/{time}) and returns you will get the expected output.

