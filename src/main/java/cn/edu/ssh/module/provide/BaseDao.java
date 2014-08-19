package cn.edu.ssh.module.provide;

import java.io.Serializable;
import java.util.List;

/**
 * 
* @ClassName: BaseDao
* @Description: TODO
* @author Tangyinbo
* @date 2014-8-18 上午10:46:43
* 
* @param <T> 实体类型
* @param <S> ID 类型
 */
public interface BaseDao<T,S extends Serializable> {
	T getById(S s);
	List<T> query();
	Integer save(T t);
	void delete(T t);
	void delteById(S s);
	void update(T t);
}
