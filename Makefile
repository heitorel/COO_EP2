all: EP2

EP2: 
	javac *.java -Xlint:unchecked

clean:
	rm -f *.class *.exe