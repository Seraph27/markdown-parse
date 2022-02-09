test: MarkdownParse.class
	javac MarkdownParse.java
	touch test

MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java

clean:
	rm -f MarkdownParse.class