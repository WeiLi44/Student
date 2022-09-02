package sg.edu.iss.club.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import sg.edu.iss.club.student.service.MoneyTransfer;

@Controller
public class TransferController {
	
	// introduce service class into Controller
	@Autowired
	MoneyTransfer mtrsf;
	
	@GetMapping()
	public String loadTransferForm(Model model) {
		// create empty model
		return "transferform"; 
	}
	
	@PostMapping("/transfer")
	public String transferMoney(Model model) {
		// read data and call the service class
		return "success";
	}

}
