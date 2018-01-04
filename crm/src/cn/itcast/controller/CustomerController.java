package cn.itcast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.constant.UtilConstants;
import cn.itcast.pojo.BaseDict;
import cn.itcast.pojo.Customer;
import cn.itcast.pojo.CustomerQueryVo;
import cn.itcast.service.CustomerService;
import cn.itcast.service.DictService;
import cn.itcast.utils.Page;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private DictService dictService;
	
	@Autowired
	private CustomerService customerService;
	
	@Value(value="${resource.cust.industry}")
	private String CustomerIndustry;
	@Value(value="${resource.cust.source}")
	private String CustomerSource;
	@Value(value="${resource.cust.level}")
	private String CustomerLevel;
	
	/**
	 * 下拉选的查询 ----客户行业，客户来源，客户级别
	 * @throws Exception 
	 */
	@RequestMapping("/list")
	public String findCodeInfoByTypeCode(CustomerQueryVo vo, Model model) throws Exception{
		List<BaseDict> custIndustry = dictService.findCodeInfoByTypeCode(UtilConstants.DICT.CUST_INDUSTRY);//行业
		List<BaseDict> custSource = dictService.findCodeInfoByTypeCode(CustomerSource);//来源
		List<BaseDict> custLevel = dictService.findCodeInfoByTypeCode(CustomerLevel);//级别
		
		if(vo != null){
			//解决汉字乱码问题
			String custName = vo.getCustName();
			if(custName != null && !"".equals(custName)){
				vo.setCustName(new String(custName.getBytes("iso8859-1"),"utf-8"));
			}
			//计算开始行号
			if(vo.getPage() == null || vo.getPage() <= 0){
				vo.setPage(1);
			}
			vo.setStart((vo.getPage()-1) * vo.getSize());
		}
		//查询客户信息一览
		List<Customer> list = customerService.findCustomerByQueryVo(vo);
		//查询客户信息总件数
		Integer count = customerService.findCustomerByQueryVoCount(vo);
		
		// 创建分页对象,并将结果放到其中
		Page<Customer> page = new Page<>();
		page.setTotal(count);
		page.setRows(list);
		page.setSize(vo.getSize());
		page.setPage(vo.getPage());
		
		//将分页对象返回页面
		model.addAttribute("page", page);
		
		//将三个下拉选的数据 返回给页面
		model.addAttribute("industryType", custIndustry);
		model.addAttribute("fromType", custSource);
		model.addAttribute("levelType", custLevel);
		
		//为了查询过后的数据回显，进行model传值
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	/*@RequestMapping("/list")
	public String findCodeInfoByTypeCode(CustomerQueryVo vo, Model model) throws Exception{
		List<BaseDict> custIndustry = dictService.findCodeInfoByTypeCode(CustomerIndustry);//行业
		List<BaseDict> custSource = dictService.findCodeInfoByTypeCode(CustomerSource);//来源
		List<BaseDict> custLevel = dictService.findCodeInfoByTypeCode(CustomerLevel);//级别
		
		//将三个下拉选的数据 返回给页面
		model.addAttribute("industryType", custIndustry);
		model.addAttribute("fromType", custSource);
		model.addAttribute("levelType", custLevel);
		
		
		return "customer";
	}*/
	/**
	 * 根据id查询客户信息  ---修改页面的数据回显
	 */
	@RequestMapping("/toEdit")
	@ResponseBody
	public Customer findCustomerById(Long id){
		return customerService.findCustomerById(id);
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String updateCustomerById(Customer customer){
		customerService.updateCustomerById(customer);
		return UtilConstants.Result.SUCCESS;
	}
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteCustomerById(Long id){
		customerService.deleteCustomerById(id);
		return UtilConstants.Result.SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
