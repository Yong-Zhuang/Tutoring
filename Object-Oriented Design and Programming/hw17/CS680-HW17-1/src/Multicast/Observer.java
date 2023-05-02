package Multicast;

import java.lang.reflect.*;

public abstract class Observer<T> {

	protected String monitorName; 
	public Observer(){
		
	}
	public void update(T arg) throws IllegalArgumentException, IllegalAccessException
	{
		Field fieldlist[] = arg.getClass().getDeclaredFields();
		StringBuffer buffer = new StringBuffer();
		for(Field f : fieldlist)
		{
			buffer.append(f.getName()+": "+f.get(arg).toString());
		}
		System.out.println(monitorName+": "+ buffer.toString());
	}
}
