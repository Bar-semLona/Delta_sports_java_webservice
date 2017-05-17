package br.com.senac.tsi.pi4;

public class Produto {

	private int idProduto;
	private String nomeProduto;
	private String descProduto;
	private float precProduto;
	private float descontoPromocao;
	private int idCategoria;
	private boolean ativoProduto;
	private int qtdMinEstoque;
	
	
	
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getDescProduto() {
		return descProduto;
	}
	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}
	public float getPrecProduto() {
		return precProduto;
	}
	public void setPrecProduto(float precProduto) {
		this.precProduto = precProduto;
	}
	public float getDescontoPromocao() {
		return descontoPromocao;
	}
	public void setDescontoPromocao(float descontoPromocao) {
		this.descontoPromocao = descontoPromocao;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public boolean isAtivoProduto() {
		return ativoProduto;
	}
	public void setAtivoProduto(boolean ativoProduto) {
		this.ativoProduto = ativoProduto;
	}
	public int getQtdMinEstoque() {
		return qtdMinEstoque;
	}
	public void setQtdMinEstoque(int qtdMinEstoque) {
		this.qtdMinEstoque = qtdMinEstoque;
	}
}
