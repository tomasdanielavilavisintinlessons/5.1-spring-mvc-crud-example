package com.z9devs.springmvccrud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.z9devs.springmvccrud.models.Customer;
import com.z9devs.springmvccrud.services.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController 
{
	@Autowired
	private CustomerService service;
	
	@RequestMapping("")
	public ModelAndView home() 
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		
		List<Customer> lc = service.listAll();
		mav.addObject("customers", lc);
		
		return mav;
	}
	
	@RequestMapping("new")
	public String newCustomerForm(Map<String, Object> model)
	{
		model.put("customer", new Customer());
		return "new_customer";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer)
	{
		service.save(customer);
		
		return "redirect:/customer";
	}
	
	@RequestMapping("edit/{customerId}")
	public ModelAndView editCustomer(@PathVariable long customerId)
	{
		ModelAndView mv = new ModelAndView("edit_customer");
		Customer c = service.get(customerId);
		System.out.println("Fatto con path " + customerId);
		mv.addObject("customer", c);
		return mv;
		
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam("id") long id)
	{
		service.delete(id);
		return "redirect:/customer";
	}
	
	@RequestMapping("search")
	public ModelAndView search(@RequestParam("keyword") String keyword)
	{
		ModelAndView mav = new ModelAndView("search");
		List<Customer> result = service.search(keyword);
		
		mav.addObject("result", result);
		
		return mav;
	}
}