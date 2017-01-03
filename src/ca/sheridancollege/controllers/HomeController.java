package ca.sheridancollege.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.LobCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import ca.sheridancollege.beans.Product;
import ca.sheridancollege.beans.Product;
import ca.sheridancollege.dao.DAO;

@Controller
public class HomeController {
	
	
	DAO dao = new DAO();
	
	@RequestMapping("/")
	public String showHome(){
		return "index";
	}

	@RequestMapping(value = "/addProduct")
	public String addProducts(Model model, @ModelAttribute Product product){
	
		
		//File image = new File(servletContext.getRealPath("/") + "/" + file.getOriginalFilename());
		//FileUtils.writeByteArrayToFile(image, file.getBytes());

		//to save into the mysql db
			/*FileOutputStream stream = new FileOutputStream(image);
			stream.write(file.getBytes());*/
			
			dao.addProduct(product);
			//to get a new fresh Product 
			product = new Product();
			model.addAttribute("product", product);
	
		return "addProduct";  
	}
	
	@RequestMapping("/allProduct")
	public String getProduts(Model model, @ModelAttribute Product product){
		ArrayList<Product> products = (ArrayList<Product>) dao.viewProducts();
		model.addAttribute("products", products);
		return "allProduct";
		
	}
	
	/*@RequestMapping("/fill")
	public String viewContact(Model model){
		dao.generateProducts();
		model.addAttribute("contact", new Product());
		return "addContact";
	}*/
	
	@RequestMapping(value="edit/{id}")
	public String edit(Model model, @PathVariable Integer id){
		
		List<Product> products = dao.viewProducts();
		
		for(int i=0; i<products.size();i++){
			if(products.get(i).getId() == id){
				model.addAttribute("product", products.get(i));
				dao.deleteProduct(products.get(i));
			}
		}
		
		return "addProduct";
		
	}
	
	@RequestMapping(value="delete/{id}")
	public String delete(Model model, @PathVariable Integer id){
		
		List<Product> products = dao.viewProducts();
		
		for(int i=0; i<products.size();i++){
			if(products.get(i).getId() == id){
				dao.deleteProduct(products.get(i));
				products.remove(i);
			}
		}
		model.addAttribute("products", products);
		return "allProduct";
		
	}
}
