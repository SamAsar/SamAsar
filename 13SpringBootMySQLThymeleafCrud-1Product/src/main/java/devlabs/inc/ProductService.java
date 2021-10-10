package devlabs.inc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> listProduct() {
		
		return productRepository.findAll();
		
	}
	
	public void saveProduct(Product product) {
		
		productRepository.save(product);
		
	}
	
	public Product get(Long id) {
		
		return productRepository.getById(id);
		
	}
	
	public void delete(Long id) {
		
		productRepository.deleteById(id);;
		
	}
}
