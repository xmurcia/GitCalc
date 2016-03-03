package calc;

import org.junit.Test;

/**

@author Xavi Murcia Daniel Perez
**/

class DivideByZeroException extends Exception{
	
	
	public DivideByZeroException()
	{
		super();
	}
	
	
	public DivideByZeroException(String s)
	{
		super(s);
	}
}