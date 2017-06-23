package bank;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bank.ATM;
import bank.ATMRepository;

@Controller
@RequestMapping(path = "/ATM")
public class ATMController{
	
	@Autowired
	private ATMRepository ATMrepo;
	
	@RequestMapping(value="/Info", method=RequestMethod.GET)
	public String info(Model model){
		model.addAttribute("users",new ATM());
		return "Info";
	}
	
	
	@RequestMapping(value = "/Info", method = RequestMethod.POST)
	public String foodTypo(@ModelAttribute ATM users, Model model){
		//ATM users;
		
		model.addAttribute(users);
		ATMrepo.save(users);
		Iterable<ATM> transac = ATMrepo.findAll();
		model.addAttribute("acctSummary", transac);
		return "Summary";
	}

	
	
	
}
	

