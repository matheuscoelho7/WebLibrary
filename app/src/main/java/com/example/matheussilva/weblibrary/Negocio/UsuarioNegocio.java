package com.example.matheussilva.weblibrary.Negocio;

import android.content.Context;

import com.example.matheussilva.weblibrary.ClassesBasicas.Usuario;
import com.example.matheussilva.weblibrary.DAO.UsuarioDAO;
import com.example.matheussilva.weblibrary.Util.NegocioException;

/**
 * Created by matheus.silva on 24/11/2017.
 */

public class UsuarioNegocio {

    UsuarioDAO usuarioDAO;

    public UsuarioNegocio(Context context) {
        usuarioDAO = new UsuarioDAO(context);
    }

    public Usuario logar(String email, String senha) throws NegocioException {
        validarLogin(email, senha);
        return usuarioDAO.logar(email, senha);
    }

    public void alterar(Usuario usuario) {
        usuarioDAO.atualizar(usuario);
    }

    public void inserir(Usuario usuario){
        usuarioDAO.salvar(usuario);
    }

    public Usuario usuarioLogado(){ return usuarioDAO.Logado(); }
    public void usuarioExcluirLogado(){ usuarioDAO.excluirLogado(); }
    public void usuarioAtualizarUsuarioLogado(Usuario usuario){usuarioDAO.atualizarUsuarioLogado(usuario);}


    //Validate dos campos
    public void validarLogin(String login, String senha) throws NegocioException {
        if (((login == null) || (login.isEmpty())) && ((senha == null) || (senha.isEmpty()))) {
            throw new NegocioException("Os campos \"Login\" e \"Senha\" precisam ser preenchidos!");
        }
        if ((login == null) || (login.isEmpty()))
        {
            throw new NegocioException("O campo \"Login\" está vazio!");
        }
        if ((senha == null) || (senha.isEmpty()))
        {
            throw new NegocioException("O campo \"Senha\" está vazio!");
        }
    }
}
