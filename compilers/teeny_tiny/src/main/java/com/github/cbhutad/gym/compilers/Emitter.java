package com.github.cbhutad.gym.compilers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Emitter {

	private String source;
	private String header;
	private String code;

	public Emitter(String source) {
		this.source = source;
		this.header = "";
		this.code = "";
	}

	public void emit(String code) {
		this.code += code; 
	}

	public void emitLine(String code) {
		this.code += code + "\n";
	}

	public void headerLine(String code) {
		this.header += code + "\n";
	}

	public void writeFile() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(this.source));
		writer.write(this.header + this.code);
		writer.close();
	}
}
