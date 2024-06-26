# OpenGroupAPI

| INTEGRANTES                    | RM      | 
|--------------------------------|---------|
| Amanda Bomfim De Oliveira      | RM99741 |
| Cauã Alencar Rojas Romero      | RM98638 |   
| Jaci Teixeira Santos           | RM99627 | 
| Leonardo dos Santos Guerra     | RM99738 | 
| Maria Eduarda Ferreira da Mata | RM99004 | 

## LINK DO REPOSITORIO NO GITHUB
[Link](https://github.com/jaciteixeira/OpenGroupAPI)


## SUMÁRIO

[RESUMO](#_RESUMO) 

[DIAGRAMA DE CLASSES ](#_DIAGRAMA_DE_CLASSES)

[DIAGRAMA UML ](##_DIAGRAMA_UML)

[DIAGRAMA DER ](##_DIAGRAMA_DER)

[INSTRUÇÕES PARA IMPORTAR ](##_INSTRUÇÕES_PARA_IMPORTAR)

[ENDPOINTS DA API ](##_ENDPOINTS_DA_API)

[LINK VÍDEO APRESENTAÇÃO DA PROPOSTA ](##_LINK_VÍDEO_APRESENTAÇÃO_DA_PROPOSTA)



# RESUMO
Num cenário onde a crescente dependência em dados impõe desafios às empresas, surge a problemática da interpretação de vastos conjuntos de dados desorganizados. O custo e a imprevisibilidade associados às consultorias tradicionais, que dependem de mão de obra qualificada, tornam-se barreiras significativas. A ineficiência na análise desses dados pode resultar em perda de competitividade e na tomada de decisões inadequadas.

Para enfrentar esse desafio, surge a solução inovadora: a Consulting Insights with Deep Analysis (CIDA), uma IA projetada para processar dados e gerar insights empresariais de forma rápida e previsível. A CIDA opera em duas fases distintas: inicialmente, processa dados brutos e os refina, e em seguida, utiliza IA generativa para analisá-los e fornecer insights acionáveis e recomendações para melhorias internas.

Comparada às consultorias tradicionais, a CIDA oferece diversas vantagens, incluindo custo reduzido, ausência de supervisão humana, facilidade de uso e tempos de processamento mais rápidos. Seu público-alvo principal são as pequenas e médias empresas (PMEs) e startups, que podem não ter estruturas de documentação interna estabelecidas ou recursos para consultorias tradicionais. Além disso, empreendedores, departamentos individuais e empresas de consultoria também podem se beneficiar da plataforma.

Embora existam ferramentas de Business Intelligence (BI) semelhantes no mercado, como Board e ThoughtSpot, a CIDA se destaca por sua capacidade de processar dados brutos e gerar insights sem exigir entrada manual de dados ou integração complexa com sistemas de BI.

O potencial de mercado para a CIDA é vasto, especialmente considerando que a maioria das empresas no Brasil são PMEs. Com milhões de possíveis clientes, a CIDA tem a oportunidade de impactar positivamente o panorama empresarial, capacitando empresas de todos os tamanhos a utilizar dados de forma mais eficaz para impulsionar o crescimento e a competitividade.

Em resumo, a CIDA representa uma abordagem inovadora e acessível para transformar dados em insights acionáveis, oferecendo uma solução ágil e eficaz para as necessidades de análise de dados das empresas modernas.

# DIAGRAMA DE CLASSES
![](documentacao/diagrama_classes.png)

## DIAGRAMA UML
![](documentacao/diagrama_uml.png)

## DIAGRAMA DER
![](documentacao/diagrama_entidade.png)

## INSTRUÇÕES PARA IMPORTAR 

### Importar Testes no Postman

Para importar testes no Postman, siga estas etapas:

1. Abra o Postman: Inicie o aplicativo Postman no seu computador.
2. Acesse a aba "Collections": Clique na aba "Collections" no painel esquerdo do Postman.
3. Clique em "Import": Na parte superior do painel "Collections", clique no botão "Import".
4. Selecione o arquivo: Na janela de importação que aparece, clique em "Upload Files" e selecione o arquivo contendo os testes que você deseja importar. Certifique-se de que o arquivo esteja no formato adequado para importação no Postman, como um arquivo JSON ou uma coleção Postman.
5. Confirme a importação: Depois de selecionar o arquivo, clique em "Import" para confirmar e importar os testes.
6. Acesse os testes importados: Após a importação ser concluída com sucesso, você poderá encontrar os testes importados na coleção correspondente no painel esquerdo do Postman, dentro da aba "Collections".




### Clonar e Executar um Projeto no IntelliJ IDEA

Este guia fornece instruções passo a passo sobre como clonar e executar um projeto no IntelliJ IDEA.

#### Clonar o Repositório Git

1. Abra o IntelliJ IDEA.
2. Clique em "Get from Version Control" na tela inicial ou vá em "VCS" > "Get from Version Control" no menu.
3. Na janela "Get from Version Control", cole o URL do repositório Git que você deseja clonar.
4. Escolha o diretório onde deseja clonar o repositório.
5. Clique em "Clone".

#### Importar o Projeto

1. Quando o IntelliJ terminar de clonar o repositório, ele deve detectar automaticamente o tipo de projeto e abrir uma janela de importação.
2. Selecione "Import project" na janela de importação.
3. Escolha a opção "Import project from external model" e selecione "Maven" ou "Gradle", dependendo do tipo de projeto que está sendo importado.
4. Clique em "Next".
5. Selecione as configurações de importação adequadas e clique em "Next" novamente.
6. Clique em "Finish" para concluir a importação do projeto.

#### Executar o Projeto

1. Após importar o projeto, localize o arquivo de configuração principal do seu aplicativo, como uma classe com um método `main`.
2. Clique com o botão direito do mouse no arquivo de configuração e escolha "Run <nome do arquivo>" para executar o aplicativo.


## ENDPOINTS DA API
1. ### DADOSCLIENTE
    1. #### POST /dados
    
       Criar um novo conjunto de dados para um cliente.<br>
       Body:
    ~~~json
    {
    "nome": "Tech Solutions",
    "segmento": "Tecnologia",
    "localizacao": "São Paulo",
    "tempoAtuacao": 5,
    "numFuncionarios": 100,
    "faturamentoAnual": 5000000.0,
    "canaisVenda": "Online, Físico",
    "produtosServicos": "Software, Consultoria",
    "tipo": "PME",
    "porte": "Médio",
    "concorrentes": "Empresa A, Empresa B",
    "desafios": "Expandir mercado internacional",
    "objetivos": "Aumentar market share"
    }
    ~~~
    2. #### GET /dados
       Obter todos os dados dos clientes.
    3. #### GET /dados/:id
    Obter dados de um cliente pelo seu ID.
    4. #### GET /dados?tipo=pme&nome=Tech Solutions
       Obter dados filtrados por tipo e nome.

2. ### ARQUIVO
    1. #### POST /arquivo
       Enviar um novo arquivo relacionado a um cliente. <br>
       Body:
    ~~~json
    
    {
    "nome": "relatorio_trimestral.pdf",
    "tipo": "PDF",
    "tamanho": 1024,
    "palavrasChave": "relatório",
    "link": "http://www.example.com/relatorio_trimestral.pdf",
    "resumo": "Este é um resumo do relatório trimestral",
    "dadosClienteId": 2
    }
    ~~~
    2. #### GET /arquivo 
       Obter todos os arquivos relacionados aos clientes. <br>
    3. #### GET /arquivo/:id
       Obter um arquivo pelo seu ID.
    4. #### GET /arquivo?nome=Relatorio_compras
       Obter arquivos filtrados por nome.<br>

3. ### USUARIO
    1. #### POST /usuario
        Criar um novo usuário. <br>
        Body:
    ~~~ json
    {
    "nome": "Ana Pitanga",
    "email": "ana@gmail.com",
    "dataCriacao": "2024-04-16",
    "identificacao": "pitanga_",
    "telefone": "(21) 99341-5788",
    "senha": "Senha@456",
    "status": "ativo",
    "dadosId": 2
    }
    ~~~
    2. #### GET /usuario
       Obter todos os usuários.
    3. #### GET /usuario/:id
       Obter um usuário pelo seu ID.
    4. #### GET /usuario?identificacao=pitanga_
       Obter usuários filtrados por identificação.

4. ### INSIGHT
    1. #### GET /insight/recomendacoes/:id
       Obter recomendações de insights pelo ID do cliente. <br>
       *__Este endpoint simula a interação com a IA, onde ela analisa os arquivos e os dados do cliente, proporcionando insights personalizados e sob medida para cada usuário. Essa interação visa fornecer uma experiência mais relevante e valiosa para os clientes, ajudando-os a obter insights significativos a partir de seus dados.__*

Essas são as instruções para acessar cada endpoint da API OpenGroup.


## LINK VÍDEO APRESENTAÇÃO DA PROPOSTA
### https://www.youtube.com/watch?v=pDfH7w8DIk4
