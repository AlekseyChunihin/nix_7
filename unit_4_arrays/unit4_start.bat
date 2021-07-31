chcp 10000
call mvn clean install
echo -----------------------------------------------------------------------------------
echo ################################start of the program################################
call java -jar target\unit_4_arrays.jar
PAUSE