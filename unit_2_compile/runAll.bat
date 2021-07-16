cd console_compile
javac -sourcepath ./src -d build/classes -cp ./libs/commons-lang3-3.11.jar;./libs/commons-collections4-4.4.jar src/ua/com/alevel/test2/Test2.java src/ua/com/alevel/test1/Test1.java src/ua/com/alevel/main/Main.java
java -cp build/classes/;./libs/commons-lang3-3.11.jar;./libs/commons-collections4-4.4.jar ua.com.alevel.main.Main
cd ../ant
call setantenv.bat
cd ../ant_compile
call ant clean
call ant compile
call ant jar
call ant run
cd ../maven_compile/app
call mvn clean package
call java -jar target/app.jar
PAUSE