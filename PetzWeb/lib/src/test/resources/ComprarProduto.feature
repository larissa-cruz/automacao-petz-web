#language: pt
Funcionalidade: Adicionar Produto
	# Fluxo de compras no site Petz
	# Envolve as páginas Home, Resultado da Consulta e Detalhes Paginas

	Cenario: Adicionar produto a partir de uma busca
	Dado que acesso o site Petz
	Quando busco por "coleira" e pressiono enter
	Entao exibe uma lista de produtos relacionados com "coleira"
	Quando escolho "Coleira Zee.Dog Ella para Cães"
	Entao exibe para o "Tamanho M" o preço de "R$ 59,00"
	E clico no botão Adicionar ao Carrinho