package com.cg;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.dao.ProductJPARepository;
import com.cg.model.Product;
import com.cg.service.ProductServiceImpl;

@SpringBootTest
class SpringDataJpaDemoApplicationTests {
	
	@Autowired
	private ProductServiceImpl prdService;

	/*We can use the @MockBean to add mock objects to the Spring application context. 
	 * The mock will replace any existing bean of the same type in the application context.
	 */
	@MockBean
	private ProductJPARepository prodRepo;
	
	@Test
	public void saveProductTest() {
		Product p=new Product(27,"HD",45,900000,null);
		//Product p2=new Product(29,"HD",45,900000,null);
		when(prodRepo.save(p)).thenReturn(p);
		assertEquals(p,prdService.saveProduct2(p));
	
	}
	
	@Test
	public void deleteProductTest() {
		Product p=new Product(103,"HD",45,900000,null);
		prdService.deleteProduct(4);
		verify(prodRepo,times(1)).deleteById(4);
	
	}

}
