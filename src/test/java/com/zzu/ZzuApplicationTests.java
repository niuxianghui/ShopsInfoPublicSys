package com.zzu;

import com.zzu.model.Good;
import com.zzu.model.Merchant;
import com.zzu.model.User;
import com.zzu.repository.GoodRepository;
import com.zzu.repository.MerchantRepository;
import com.zzu.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ZzuApplicationTests {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	MerchantRepository merchantRepository;
	@Autowired
	GoodRepository goodRepository;

	@Test
	public void contextLoads() {
		User user =  new User();
		user.setUserName("niu");
		user.setPassWd("niu");
		userRepository.save(user);
		Merchant merchant = new Merchant();
		merchant.setPassWd("test");
		merchant.setUserName("merchant1");
		merchantRepository.save(merchant);
		Good good1 = new Good();
		good1.setIntroduction("白菜");
		good1.setMerchantId(merchantRepository.findByUserName("merchant1").get(0).getId());
		goodRepository.save(good1);
	}

}
