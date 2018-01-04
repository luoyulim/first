package cn.itcast.dao;

import java.util.List;

import cn.itcast.pojo.BaseDict;

public interface DictDao {
	
	public List<BaseDict> findCodeInfoByTypeCode(String typeCode);

}
