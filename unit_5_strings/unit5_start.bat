chcp 1251
cd ../reversestring
call mvn clean package install
cd ../unit_5_strings
call mvn clean install
echo -----------------------------------------------------------------------------------
call java -jar target\unit_5_strings.jar
PAUSE