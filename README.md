# OEA-Trab-Final

O arquivo de base de dados usado para execução desse programa é o disponibilizado pelo professor no dropbox (bolsa familia)

O programa ordena o arquivo base por nome (em ordem alfabética), após isso ele gera um arquivo de índices com 26 linhas, esse arquivo contém apenas a primeira entrada pertencente a cada letra (primeira entrada com letra A, primeira com letra B, e assim por diante) a partir do arquivo ordenado.

A finalidade do programa é fazer uma busca por nome no arquivo de forma mais otimizada. Essa busca é binária, e é feita tendo em vista somente os indices que começam com a letra do nome digitado (se todos os nomes que começam com A estão entre 0 e 100, e você procurar um nome que começa com A, a busca será limitada apenas a esses 100)

Instruções para uso do programa:
1. Abra o código fonte na classe Main e mude os endereços dos arquivos f, fi e hash, para o devido lugar onde eles devem ser salvos, ou onde eles se encontram.
2. Execute o código e aguarde os 2 primeiros processos terminarem (primeiro é feita a ordenação do arquivo base e após a indexação), o processo pode demorar algum tempo.
3. Digite o nome inteiro que deseja procurar, separando nome e sobrenomes por espaços, todas letras maiúsculas
4. O programa deve listar todos os dados do nome digitado (ou não encontrar dependendo do que foi digitado)



OBS:A ordenação funciona apenas até a entrada numero 1048575, mas mesmo assim achei válido testar isso, creio que com intercalação e uma otimização melhor do meu código a diferença do tempo de buscar por nome é mais do que significativa, até mesmo num arquivo de menor escala
