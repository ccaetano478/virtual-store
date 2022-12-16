package com.dev.virtualStore.service;

import br.com.caelum.stella.validation.CPFValidator;
import com.dev.virtualStore.entity.Estado;
import com.dev.virtualStore.entity.Pessoa;
import com.dev.virtualStore.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> buscaTodas(){
        return pessoaRepository.findAll();
    }
    public Pessoa inserir (Pessoa pessoa){
        if (!validaCpf(pessoa.getCpf())) return null;
        if (!validaEmail(pessoa.getEmail())) return null;
        pessoa.setDataCriacao(new Date());
        return pessoaRepository.saveAndFlush(pessoa);
    }
    public Pessoa alterar (Pessoa pessoa){
        if (!validaCpf(pessoa.getCpf())) return null;
        if (!validaEmail(pessoa.getEmail())) return null;
        pessoa.setDataAtualizacao(new Date());
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public void excluir (Long id){
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
    }
    public static boolean validaCpf (String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        try{ cpfValidator.assertValid(cpf);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean validaEmail(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }
}
