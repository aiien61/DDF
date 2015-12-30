package io.ddf2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import io.ddf2.datasource.IDataSource;
import io.ddf2.handlers.IPersistentHandler;

public abstract class DDFManager implements IDDFManager {

	protected IDDFMetaData ddfMetaData;
	protected IPersistentHandler persistentHandler;
	protected Map mapProperties;
	protected DDFManager(Map mapProperties){this.mapProperties = mapProperties;}
	/**
	 * @see io.ddf2.IDDFManager#newDDF(io.ddf2.datasource.IDataSource)
	 */
	public abstract IDDF newDDF(IDataSource ds);

	/**
	 * @see io.ddf2.IDDFManager#newDDF(java.lang.String)
	 */
	public abstract IDDF newDDF(String sql);


	/*
	 	Get concrete DDFManager from className
	 */
	public static DDFManager getInstance(String ddfManagerClsName, Map mapProperties){
		try {
			Class cls = Class.forName(ddfManagerClsName);
			if(cls.isAssignableFrom(DDFManager.class)){
				return getInstance(cls,mapProperties);
			}else{
				throw new IllegalArgumentException("Class " + ddfManagerClsName + " Must extend from DDFManager");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}

	}
	/* get concrete DDFManager for its class */
	public static  <T extends DDFManager> T getInstance(Class<T> ddfManager, Map params){
		try {
			Constructor<T> constructors = ddfManager.getDeclaredConstructor(Map.class);
			constructors.setAccessible(true);
			return constructors.newInstance(params);
		} catch (InstantiationException |IllegalAccessException|InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	public static final DDFManager getDDFManagerByUUID(String uuid) {
		throw new RuntimeException("Not Implement Yet");
	}

	public static List<DDFManager> getAllDDFManager() {
		throw new RuntimeException("Not Implement Yet");
	}

	public static DDF getDDF(String uuid) {
		throw new RuntimeException("Not Implement Yet");
	}



	 
	/**
	 * @see io.ddf2.IDDFManager#getDDFMetaData()
	 */
	public IDDFMetaData getDDFMetaData() {
		return ddfMetaData;
	}
	 
	/**
	 * @see io.ddf2.IDDFManager#getPersistentHandler()
	 */
	public IPersistentHandler getPersistentHandler() {
		return persistentHandler;
	}




}
 