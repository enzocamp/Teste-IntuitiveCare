# Teste Técnico - IntuitiveCare

Este repositório contém a resolução dos testes técnicos do processo seletivo da IntuitiveCare. Os testes foram desenvolvidos utilizando diferentes linguagens e ferramentas conforme solicitado em cada etapa.

## Estrutura

```
.
├── teste_1_web_scraping/           # Teste 1: Web Scraping em Python
├── teste_2_transformacao_dados/   # Teste 2: Transformação de Dados (PDF -> CSV)
├── teste_3_banco_dados/           # Teste 3: Criação de banco de dados e consultas analíticas (PostgreSQL)
├── teste_4_api/                   # Teste 4: API com Flask + Frontend Vue.js
│   ├── backend/
│   ├── frontend/
│   └── venv/
└── README.md                      # Este arquivo
```

---

## Testes

### Teste 1 – Web Scraping

- Linguagem: Java
- Objetivo: Obter dados de operadoras diretamente do site da ANS.
- Saída: Arquivo CSV contendo as operadoras ativas.

### Teste 2 – Transformação de Dados

- Linguagem: Java
- Objetivo: Extrair dados de arquivos PDF e convertê-los para CSV.
- Ferramentas: `pdfplumber`, `csv`
- Resultado: Arquivos `.csv` com informações de Demonstrações Contábeis.

### Teste 3 – Banco de Dados

- Banco: PostgreSQL
- Objetivo: Criar tabelas, importar dados e responder consultas analíticas.
- Scripts:
  - `01_create_tables.sql`: Criação das tabelas.
  - `02_import_data.sql`: Importação dos arquivos CSV.
  - `03_queries_analiticas.sql`: Consultas SQL exigidas no teste.

### Teste 4 – API

- Backend: Python com Flask
- Frontend: Vue.js
- Objetivo: Criar uma interface de busca textual sobre os dados das operadoras.
- Funcionalidade: Busca por `Razão Social` ou `Nome Fantasia`.
- Requisições: Via interface ou pelo Postman (coleção incluída).
- Arquivos:
  - `backend/app.py`: Servidor Flask
  - `frontend/`: Projeto Vue
  - `Teste 4 - Busca de Operadoras.postman_collection.json`: Coleção Postman

---

## Como Rodar

Cada teste possui um README próprio com instruções. Certifique-se de ter Python, Node.js, PostgreSQL e dependências instaladas conforme necessário.

---

## Autor

Enzo campolongo
