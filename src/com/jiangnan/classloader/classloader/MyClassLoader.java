package com.jiangnan.classloader.classloader;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {
	private String name;
	/**加载路径*/
	private String loadPath;
	private static final String EXTENSION = ".class";
	
	public MyClassLoader(String name, String loadPath) {
		super();
		this.name = name;
		this.loadPath = loadPath;
	}
	
	public MyClassLoader(String name, String loadPath, ClassLoader parent) {
		super(parent);
		this.name = name;
		this.loadPath = loadPath;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] b = loadClassData(name);
		if (null == b || b.length == 0) {
			throw new ClassNotFoundException();
		}
		return defineClass(name, b, 0, b.length);
	}
	
	/**
	 * 加载读取class文件
	 * @param name
	 * @return
	 */
	private byte[] loadClassData(String name) {
		String dir = name.replace(".", File.separator);
		String realPath = this.loadPath + File.separator + dir + EXTENSION;
		ByteArrayOutputStream baos = null;
		DataInputStream dis = null;
		int end = 0;
		try {
			baos = new ByteArrayOutputStream();
			dis = new DataInputStream(new FileInputStream(realPath));
			while ((end = dis.read()) != -1) {
				baos.write(end);
			}
		} catch (IOException e) {
			//e.printStackTrace();
		} finally {
			if (null != baos) {
				try {
					baos.close();
				} catch (IOException e) {
				}
			}
			if (null != dis) {
				try {
					dis.close();
				} catch (IOException e) {
				}
			}
		}
		return baos.toByteArray();
	}

	@Override
	public String toString() {
		return this.name;
	}
}
