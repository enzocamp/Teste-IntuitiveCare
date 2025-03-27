# Teste 4 - Busca de Operadoras

Este projeto é uma aplicação web simples composta por um backend em Python (Flask) e um frontend em Vue.js. Ele permite realizar buscas textuais sobre uma lista de operadoras de planos de saúde.

---

## 🧠 Objetivo do Teste

Criar uma **interface web** que consuma uma **API em Python** capaz de:

- Realizar **busca textual** por nome de operadoras a partir de um arquivo CSV.
- Exibir os registros mais relevantes com dados como: razão social, nome fantasia e CNPJ.

---

## 📁 Estrutura do Projeto

```
teste_4_api/
├── backend/             # API em Flask
│   └── app.py           # Servidor Flask que carrega e busca no CSV
├── frontend/            # Projeto Vue.js (busca-operadoras)
│   └── src/App.vue      # Componente principal com campo de busca e exibição de resultados
└── venv/                # Ambiente virtual Python
```

---

## Como Executar

### Pré-requisitos

- Python 3.10+
- Node.js + NPM
- Vue CLI
- Postman (para testar a API)

---

### 1. Clonar o projeto

git clone https://github.com/enzocamp/Teste-IntuitiveCare
cd teste_4_api

---

### 2. Backend (Python - Flask)

#### a. Criar ambiente virtual

```bash
python -m venv venv
venv\Scripts\activate  # Windows
```

#### b. Instalar dependências

```bash
pip install flask
```

#### c. Executar o servidor

```bash
cd backend
python app.py
```

A API estará acessível em:  
📍 `http://127.0.0.1:5000/search?q=amil`

---

### 3. Frontend (Vue.js)

#### a. Criar projeto com Vue CLI

```bash
vue create busca-operadoras
```

#### b. Substituir conteúdo de `App.vue` pelo componente de busca

```vue
<!-- src/App.vue -->
<template>...</template>
<script>...</script>
<style>...</style>
```

#### c. Rodar o servidor Vue

npm run serve


A interface estará acessível em:  
 `http://localhost:8080`

---

## Testes com Postman

- A requisição `GET /search?q=amil` foi testada com sucesso.
- Testes automáticos foram incluídos na aba `Tests`:
  - Código de status 200
  - Retorno em JSON
  - Até 10 operadoras retornadas

## Coleção Postman

A coleção de testes para o Teste 4 está disponível na pasta [`postman/`](./postman/).

- Arquivo: `Teste 4 - Busca de Operadoras.postman_collection.json`
## Observações

- Os dados foram carregados diretamente do CSV: `operadoras_ativas.csv`.
- Foram tratados problemas de acentuação e encoding com `utf-8`.
- Estilo do frontend aplicado com foco em clareza, responsividade e usabilidade.

---

## 💻 Tecnologias Utilizadas

- Python 3 + Flask
- Vue.js 3
- JavaScript (ES6)
- HTML5 + CSS3
- Postman

---

## Autor

- Enzo Campolongo
