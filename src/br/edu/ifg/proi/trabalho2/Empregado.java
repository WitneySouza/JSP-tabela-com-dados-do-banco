package br.edu.ifg.proi.trabalho2;

public class Empregado {

		private int matricula;
		private String nome;
		private String endereco;
		
		public Empregado() {
			super();
		}
		
		public Empregado(int matricula) {
			this.matricula = matricula;
		}
		
		
		public Empregado(int matricula, String nome, String endereco) {
	
			this.matricula = matricula;
			this.nome = nome;
			this.endereco = endereco;
		}
		
		public int getMatricula() {
			return matricula;
		}
		public void setMatricula(int matricula) {
			this.matricula = matricula;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		@Override
		public String toString() {
			return "Empregado [matricula=" + matricula + ", nome=" + nome + ", endereco=" + endereco + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
			result = prime * result + matricula;
			result = prime * result + ((nome == null) ? 0 : nome.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Empregado other = (Empregado) obj;
			if (endereco == null) {
				if (other.endereco != null)
					return false;
			} else if (!endereco.equals(other.endereco))
				return false;
			if (matricula != other.matricula)
				return false;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			return true;
		}

			
		
}
