package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;

/**
 *
 * @param <T>
 */
public class AbstractDAO<T> {
	protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
	private final Class<T> type;
	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	private String createSelectQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM `");
		sb.append(type.getSimpleName());
		sb.append("` WHERE " + field + " =?");
		return sb.toString();
	}
	public List<T> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = new String ("SELECT * FROM `" + type.getSimpleName() + "`");
		System.out.println(query);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			System.out.println(statement.toString());
			resultSet = statement.executeQuery();
			List<T> resultList = createObjects(resultSet);
			return resultList;

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findALL " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	public T findById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectQuery("id");
		System.out.println(query);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id); /// from query replace ? with id
			resultSet = statement.executeQuery();
			return createObjects(resultSet).get(0);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
		} catch (NullPointerException  | IndexOutOfBoundsException e) {
			LOGGER.log(Level.WARNING, type.getSimpleName() + "Does Not Exist " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	private List<T> createObjects(ResultSet resultSet) {
		List<T> list = new ArrayList<T>();

		Constructor[] constructors = type.getDeclaredConstructors();// constructors
		try {
			while (resultSet.next())
			{
				System.out.println();
				int index = 0 ;
				Object[] arguements = new Object[constructors[0].getGenericParameterTypes().length]; // take the first constructor
				for (Field field : type.getDeclaredFields()) { // iterate class fields

					Object value = resultSet.getObject(field.getName()); // extract an Obj - A String that contains the column name
					//System.out.println(value+"/");
					if (value instanceof Integer){
						Integer aux = (Integer) value;
						arguements[index] = aux ;
					}
					else{
						String aux = (String) value;
						arguements[index] = aux ;
					}
					index++;
				}
				T newObject = (T)constructors[0].newInstance(arguements);//create a new instance of obj <->Client newClient = new Constructor(lalalala , lalalal )
				list.add(newObject);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void insert(T t) throws IllegalAccessException, IntrospectionException {
		Connection connection = null;
		PreparedStatement statement = null;

		String query = "INSERT INTO `" + type.getSimpleName() + "` values (";
		for (Field field : type.getDeclaredFields()){
			field.setAccessible(true);
			Object value = field.get(t);// get the value of that field
			//System.out.println("val-" + value);
			if (value instanceof String)
				query = query + "'" + value.toString() + "',";
			else
				query = query + value.toString() + ",";
		}
		char[] queryCh = query.toCharArray();
		queryCh[query.length()-1] = ')';
		query = String.valueOf(queryCh);
		System.out.println(query);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.executeUpdate();/// for Update / INSERT OR DELETE
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	public T update(T t) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
		int idobj = 0 ;
		PropertyDescriptor propertyDescriptor = new PropertyDescriptor("id", t.getClass());
		Method method = propertyDescriptor.getReadMethod();
		idobj = (int) method.invoke(t);
		System.out.println("is id " + idobj);
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "UPDATE `" + type.getSimpleName() + "` SET ";
		for (Field field : type.getDeclaredFields()){
			field.setAccessible(true);
			Object value = field.get(t);// get the value of that field
			
			if (value instanceof Integer){
				query = query + field.getName() + "=" + value.toString() + ",";
			}
			else{
				query = query + field.getName() + "='" + value.toString() + "',";
			}
		}
		char[] queryCh = query.toCharArray();
		queryCh[query.length()-1] = ' ';
		query = String.valueOf(queryCh);
		query = query + " WHERE ID=" + idobj;
		System.out.println(query);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.executeUpdate();/// for Update / INSERT OR DELETE
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return t;
	}
	public void delete(T t) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
		int idobj = 0 ;
		PropertyDescriptor propertyDescriptor = new PropertyDescriptor("id", t.getClass());
		Method method = propertyDescriptor.getReadMethod();
		idobj = (int) method.invoke(t);
		System.out.println("is id " + idobj);
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "DELETE FROM `" + type.getSimpleName() + "` WHERE id= " + idobj;
		System.out.println(query);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.executeUpdate();/// for Update / INSERT OR DELETE
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	public Object createTableData() throws IllegalAccessException {
		List <T> content = findAll();
		Object[][] table = new Object[content.size()][type.getDeclaredFields().length];
		for (int row = 0 ; row < content.size() ; row++){
			Field[] fields = content.get(row).getClass().getDeclaredFields();

			for (int col = 0 ; col <fields.length ; col++){
				fields[col].setAccessible(true);
				table[row][col] = fields[col].get(content.get(row));
			}
		}
		System.out.println("TABLE PRINTING");
		for(int i = 0 ; i < content.size() ; i++){
			for(int j = 0 ; j< type.getDeclaredFields().length;j++){
				System.out.print (table[i][j]+" ");
			}
			System.out.println();
		}
		return table;
	}
}
