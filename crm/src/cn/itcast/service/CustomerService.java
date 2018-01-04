package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.Customer;
import cn.itcast.pojo.CustomerQueryVo;

public interface CustomerService {

	// 根据综合条件查询客户信息
	public List<Customer> findCustomerByQueryVo(CustomerQueryVo vo);
	// 根据综合条件查询客户信息 的总件数
	public Integer findCustomerByQueryVoCount(CustomerQueryVo vo);

	// 根据id查询客户信息 ---修改页面的数据回显
	public Customer findCustomerById(Long id);
	// 修改
	public void updateCustomerById(Customer customer);
	
	// 删除
	public void deleteCustomerById(Long id);

}
