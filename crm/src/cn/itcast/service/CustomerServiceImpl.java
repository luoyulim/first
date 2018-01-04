package cn.itcast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.dao.CustomerDao;
import cn.itcast.pojo.Customer;
import cn.itcast.pojo.CustomerQueryVo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	/**
	 * 根据综合条件查询客户信息
	 */
	@Override
	public List<Customer> findCustomerByQueryVo(CustomerQueryVo vo) {
		return customerDao.findCustomerByQueryVo(vo);
	}
	/**
	 * 根据综合条件查询客户信息 的总件数
	 */
	@Override
	public Integer findCustomerByQueryVoCount(CustomerQueryVo vo) {
		return customerDao.findCustomerByQueryVoCount(vo);
	}
	/**
	 * 根据id查询客户信息  ---修改页面的数据回显
	 */
	@Override
	public Customer findCustomerById(Long id) {
		return customerDao.findCustomerById(id);
	}
	/**
	 * 修改
	 */
	@Override
	public void updateCustomerById(Customer customer) {
		customerDao.updateCustomerById(customer);
	}
	/**
	 * 删除
	 */
	@Override
	public void deleteCustomerById(Long id) {
		customerDao.deleteCustomerById(id);
	}

}
