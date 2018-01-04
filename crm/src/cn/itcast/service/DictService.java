package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.BaseDict;

public interface DictService {
	
	public List<BaseDict> findCodeInfoByTypeCode(String typeCode) throws Exception;

}
