package com.eksad.latihanspringmvc.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.latihanspringmvc.model.Brand;
import com.eksad.latihanspringmvc.repository.BrandRepositoryDAO;

@Controller
@RequestMapping("/brand")
public class BrandController {
	
	@Autowired
	BrandRepositoryDAO brandRepositoryDAO;
	
	@RequestMapping("")
	public String index(Model model) {
		
		List<Brand> list = brandRepositoryDAO.findAll();
		
		model.addAttribute("listBrand", list);
		
		return "listbr";
	}
	
	@RequestMapping("/add")
	public String addProduct(Model model) {
		Brand brand = new Brand();
		
		model.addAttribute("brand", brand);
		
		return "addbr"; 
				
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Brand brand) {
		brandRepositoryDAO.save(brand);
		
		return "redirect:/brand"; 
	}
	
//	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
//	public String update(@RequestBody Brand brand, @PathVariable Long id) {
//		Brand brandSelected = brandRepositoryDAO.getOne(id);
//		
//		if (brandSelected !=null) {
//			brandSelected.setName(brand.getName());
//			brandSelected.setProduct_type(brand.getProduct_type());
//			brandRepositoryDAO.save(brandSelected);
//			
//			return "redirect:/brand";
//		}else {
//			return null;
//		}
//	}
	
	//delete
		@RequestMapping(value="delete/{id}",method = RequestMethod.GET)
	    public String deleteBrand(@PathVariable ("id") Long id) {
	        Brand brand = brandRepositoryDAO.getOne(id);
	        if(brand==null)
	        {
	        	throw new EntityNotFoundException("entity.departement.NotFound");
	        }
	        brandRepositoryDAO.delete(brand);;
	        return "redirect:/brand/";
	        
		}
		
		@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
		public String editBrand(@PathVariable Long id, Model model) {
			Brand brand = brandRepositoryDAO.getOne(id);	
			model.addAttribute("brand", brand);
			
			return "editbr"; 
		}
}

