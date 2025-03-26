# Teste-IntuitiveCare
Desafio técnico para processo seletivo da IntuitiveCare

# Teste 1 – Web Scraping

Este projeto faz parte do processo seletivo da IntuitiveCare e tem como objetivo realizar o download dos documentos "Anexo I" e "Anexo II" da ANS, diretamente da página oficial, e compactá-los em um arquivo `.zip`.

---

## O que o projeto faz

1. Acessa a página da ANS com o [Rol de Procedimentos e Eventos em Saúde](https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos)
2. Localiza os arquivos PDF referentes aos anexos I e II
3. Realiza o download dos arquivos para a pasta `downloads/`
4. Compacta os dois arquivos em um único arquivo chamado `anexos.zip` na pasta downloads

---

## Como executar

### Requisitos

- Java 8 ou superior (testado até Java 20)
- Eclipse ou qualquer IDE com suporte a projetos Java
- Biblioteca externa:
  - [`jsoup-1.17.x.jar`](https://jsoup.org/download) (inclusa em `/libs`)

### Instruções

1. Clone o repositório ou baixe o projeto
2. Importe o projeto no Eclipse
3. Execute a classe:

4. Após a execução, verifique a pasta `downloads/`, onde estarão:
   - Os arquivos PDF
   - O arquivo `anexos.zip` com os dois anexos compactados

---

## Estrutura de pastas
teste_1_web_scraping/ 
├── libs/ │└── jsoup-1.17.x.jar 
├── downloads/ │ ├── Anexo_I_.pdf │ ├── Anexo_II_.pdf │ └── anexos.zip 
├── src/ │ └── br/com/intuitivecare/teste1/ │ ├── Scraper.java │ └── ZipCompressor.java	

## Observações

- A aplicação usa `java.util.logging` para registrar as mensagens de execução.
- O método `downloadFile` foi mantido com padrão Java 8
- O código está padronizado com nomes e mensagens em inglês para consistência internacional.

---

## 👨‍💻 Autor

Enzo [@enzocamp](https://github.com/enzocamp)