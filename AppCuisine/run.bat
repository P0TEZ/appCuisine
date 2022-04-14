@echo off
echo:
echo Compilation du projet...
@echo on

javac -classpath AppCuisine/src AppCuisine/src/app/AppCuisine.java

@echo off
echo:
echo Lancement du projet...
@echo on

java -classpath AppCuisine/src AppCuisine/src/app/AppCuisine.java

@echo off
echo:
echo FIN
@echo on
