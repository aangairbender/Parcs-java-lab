all: run

clean:
	rm -f out/Main.jar out/Algo.jar

out/Main.jar: out/parcs.jar src/Main.java src/AlgoData.java
	@javac -cp out/parcs.jar src/Main.java src/AlgoData.java
	@jar cf out/Main.jar -C src Main.class -C src AlgoData.class
	@rm -f src/Main.class src/AlgoData.class

out/Algo.jar: out/parcs.jar src/Algo.java src/AlgoData.java
	@javac -cp out/parcs.jar src/Algo.java src/AlgoData.java
	@jar cf out/Algo.jar -C src Algo.class -C src AlgoData.class
	@rm -f src/Algo.class src/AlgoData.class

build: out/Main.jar out/Algo.jar

run: out/Main.jar out/Algo.jar
	@cd out && java -cp 'parcs.jar:Main.jar' Main