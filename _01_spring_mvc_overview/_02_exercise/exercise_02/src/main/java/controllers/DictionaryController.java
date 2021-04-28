package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.DictionaryService;
import service.impl.DictionaryServiceImpl;

@Controller
public class DictionaryController {
    DictionaryService dictionaryService = new DictionaryServiceImpl();

    @PostMapping("/dictionary")
    public String searchWord(@RequestParam String englishWord, Model model) {
        String vietnamese = dictionaryService.translate(englishWord);
        if (vietnamese != null) {
            model.addAttribute("vietnamese", vietnamese);
            return "result";
        }
        model.addAttribute("englishWord", englishWord);
        return "notfoundpage";
    }
}
