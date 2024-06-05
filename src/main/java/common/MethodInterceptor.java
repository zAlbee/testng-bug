package common;

import java.util.ArrayList;
import java.util.List;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		String filterValue = System.getProperty("filter");
		
		if (filterValue == null) {
			return methods;
		}

		List<IMethodInstance> filteredList = new ArrayList<>();
		
		for (IMethodInstance method : methods) {
			String className = method.getMethod().getTestClass().getName();
			if (className.startsWith(filterValue)) {
				filteredList.add(method);
			}
		}
		return filteredList;
	}

}
