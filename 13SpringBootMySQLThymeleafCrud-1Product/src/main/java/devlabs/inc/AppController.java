package devlabs.inc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	

	@Autowired
	private ProductService productService;
	
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product> products = productService.listProduct();
		
		model.addAttribute("products", products);
		return "index";
		
	}
	
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		
		Product product = new Product();
		
		model.addAttribute("product", product);
		
		return "new_product";
		
	}
	
	@RequestMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product product) {
		
		productService.saveProduct(product);
		return "redirect:/";
		
		
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
		
	ModelAndView mav = new ModelAndView("edit_product");
		
	Product product = productService.get(id);
	
	mav.addObject("product", product);
	
		return mav;
		
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") Long id) {
		
		productService.delete(id);
  
		return "redirect:/";
	
		
	}
}
