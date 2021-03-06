package comet_dashboard;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CometModuleFactory
{
	static private Map<String,Class<? extends CometModule >> catalog = new HashMap<String,Class<? extends CometModule >>();
	static public void registerModule(String name, Class<? extends CometModule > mod) throws DuplicateModuleNameException
	{
		if(catalog.containsKey(name) == true)
		{
			throw new DuplicateModuleNameException(name);
		}
		catalog.put(name, mod);

		//CometModule m = new catalog.get("test")();
		System.out.println("Added " + name + " to CometModuleFactory");
		Class<? extends CometModule> m = catalog.get("test");
		
		try
		{
			Constructor<? extends CometModule> cons = m.getConstructor(String.class);
			CometModule mod1 = cons.newInstance("test");
		} catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//@SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	static public void registerModules()
	{
		ClassLoader classLoader = Main.class.getClassLoader();
		try {
			//Class<?> unchecked_class = classLoader.loadClass("comet_dashboard.stock_modules.TestModule");
			Class<?> unchecked_class = classLoader.loadClass("comet_dashboard.stock_modules.TestModule");
			Class<? extends CometModule> add_class = (Class<? extends CometModule>) unchecked_class;
			registerModule("test", add_class);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (DuplicateModuleNameException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
