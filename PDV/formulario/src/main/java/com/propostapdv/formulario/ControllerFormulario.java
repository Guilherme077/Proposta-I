package com.propostapdv.formulario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerFormulario {

        @GetMapping("/home")
        public ModelAndView home(){
            ModelAndView mv = new ModelAndView("index");
            String tituloNovo = "PDV";
            mv.addObject("titulo", tituloNovo);
            return mv;
        }

        @PostMapping("/cadproduto")
        public ModelAndView cadProduto(String nome, int preco){
            ModelAndView mv = new ModelAndView("produtos");
            mv.addObject("nome", nome);
            System.out.println(nome);
            return mv;

        }
}
