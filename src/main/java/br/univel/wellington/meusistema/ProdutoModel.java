package br.univel.wellington.meusistema;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProdutoModel extends AbstractTableModel {




		private List<Produto> lista;
		
		public ProdutoModel() {
			this((List<Produto>)null);
			
			for (int i = 0; i < 10; i++) {
				Produto p = new Produto();
				p.setId(i + 1);
				p.setDescrcao("Contato " + (i+1));
				p.setQuantidade(90 + i);
				this.lista.add(p);
			}		
		}
		
		public ProdutoModel(List<Produto> _lista) {
			if (_lista == null) {
				this.lista = new ArrayList<>();
			} else {
				this.lista = _lista;
			}
		}
		
		public int getColumnCount() {
			return 3;
		}

		
		public int getRowCount() {
			return lista.size();
		}

		
		public String getColumnName(int column) {
			switch (column) {
			case 0:
				return "Id";
			case 1:
				return "Descricao";
			case 2:
				return "Quantidade";
			}
			return super.getColumnName(column);
		}

		
		public Object getValueAt(int row, int column) {
			
			Produto c = this.lista.get(row);
			
			switch (column) {
			case 0:
				return c.getId();
			case 1:
				return c.getDescrcao();
			case 2:
				return c.getQuantidade();
			}
			
			// return "inexistente";
			throw new RuntimeException("Coluna " + column +
					" solicitada, não existe.");
		}

		public void adicionar(Produto p) {
			this.lista.add(p);

			// Dispara um evento para a JTable
			// atualizar sua estrutura/tela.
			super.fireTableDataChanged();
		}

		public Produto getContato(int idx) {
			return lista.get(idx);
		}

		public void remover(Produto contatoSelecionado) {
			this.lista.remove(contatoSelecionado);
			super.fireTableDataChanged();
		}
		
		
		


}
