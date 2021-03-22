package persistencia;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import modelos.Empresa;
import modelos.Usuario;

public class Banco {
	
	private static List<Empresa> Empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	private static int idSequencial = 1;
	

	public void adciona(Empresa empresa) {
		empresa.setId(idSequencial);
		Banco.Empresas.add(empresa);
		Banco.idSequencial++;
	}
	
	public void adciona(Usuario usuario) {
		Banco.usuarios.add(usuario);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.Empresas;
	}
	
	public List<Usuario> getUsuario(){
		return Banco.usuarios;
	}
	
	public Empresa getEmpresa(int id) {
		for(Empresa empresa: Empresas)
			if(empresa.getId() == id)
				return empresa;
		return null;
	}
	
	public Boolean Login(String Login,String Senha) {
		for(Usuario usuario: usuarios)
			 if(usuario.igual(Senha, Login))
				 return true;
		return false;
	}
	
	public void remove(int id) {
		Iterator<Empresa> it = Banco.Empresas.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id)
				it.remove();
		}
		
	}
	
	public void updateEmpresa(int id, String nome, Date data) {
	       for(Empresa empresa: Empresas) {
	    	   if(empresa.getId() == id) {
	    		   empresa.setDataAbertura(data);
	    		   empresa.setNome(nome);
	    	   }
	       }
	}
	
	
}
