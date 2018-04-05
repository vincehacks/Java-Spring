/****************************************************************************** 
Created by Vince Chang	

This interface is like a contract
As a developer, we don't need to see some parts, aka a DB might be talking
to us here, but we don't need to see that code!
******************************************************************************/

package com.di.helloworld;

public interface HelloSpring {
	// Declarations of the methods that will be implemented by the developer
	// in any class that utilizes this interface!
	void setMessage(String m);
	String getMessage();
}