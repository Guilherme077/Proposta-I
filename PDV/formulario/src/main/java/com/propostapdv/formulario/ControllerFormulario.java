package com.propostapdv.formulario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerFormulario {

        @GetMapping("/home")
        public ModelAndView home(){
            ModelAndView mv = new ModelAndView("index-TEST"); // Mudar para "index" no final
            String tituloNovo = "PDV";
            mv.addObject("titulo", tituloNovo);
            return mv;
        }

        @PostMapping("/cadproduto")
        public ModelAndView cadProduto(String nome, int preco, int quantidade){
            PDV.AddProduto(nome, preco, quantidade);
            ModelAndView mv = new ModelAndView("produtos");
            mv.addObject("listaDeProdutos", PDV.ListaProdutosStr);
            return mv;

        }
        @PostMapping("/vendaproduto")
        public ModelAndView vendaProduto(String nome, int quantidade){
            PDV.VenderProduto(nome, quantidade);
            ModelAndView mv = new ModelAndView("produtos");
            mv.addObject("listaDeProdutos", PDV.ListaProdutosStr);
            return mv;

        }
        @PostMapping("/lista")
        public ModelAndView lista(){
            ModelAndView mv = new ModelAndView("produtos");
            mv.addObject("listaDeProdutos", PDV.ListaProdutosStr);
            return mv;

        }
}
