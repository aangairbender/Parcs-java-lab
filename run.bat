cd out
del Main.jar
del Algo.jar
cd ..

javac -cp out/parcs.jar src/Main.java src/AlgoData.java
jar cf out/Main.jar -C src Main.class -C src AlgoData.class

cd src
del Main.class
del AlgoData.class
cd ..

javac -cp out/parcs.jar src/Algo.java src/AlgoData.java
jar cf out/Algo.jar -C src Algo.class -C src AlgoData.class

cd src
del Algo.class
del AlgoData.class
cd ..

cd out
java -cp "parcs.jar;Main.jar" Main

pause