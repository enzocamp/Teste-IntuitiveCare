# Teste 3 — Banco de Dados - IntuitiveCare

Este teste consiste em processar dados públicos da ANS, criando estruturas de banco de dados relacionais, importando arquivos CSV e realizando consultas analíticas.

---

## ✅ Objetivo

1. **Estruturar tabelas** com base nos arquivos fornecidos.
2. **Importar os dados** das operadoras ativas e das demonstrações contábeis (últimos 2 anos).
3. **Realizar consultas analíticas**:
   - Top 10 operadoras com maiores despesas com *SINISTROS* no último trimestre.
   - Top 10 operadoras com maiores despesas com *SINISTROS* no último ano.

---

## ⚙️ Requisitos

- PostgreSQL (>= 10.0)
- `psql` instalado e configurado no terminal
- Banco de dados criado: `intuitivecare_db`

---

## Estrutura do projeto
teste_3_banco_dados/ 
├── dados/ │ ├── demonstracoes_2023/ │ │ ├── 1T2023.csv │ │ ├── 2t2023.csv │ │ ├── 3T2023.csv │ │ └── 4T2023.csv │ 
			 ├── demonstracoes_2024/ │ │ ├── 1T2024.csv │ │ ├── 2T2024.csv │ │ ├── 3T2024.csv │ │ └── 4T2024.csv │ 
			 └── operadoras_ativas.csv 
├── scripts/ │ ├── 01_create_tables.sql │ ├── 02_import_data.sql │ └── 03_queries_analiticas.sql 
├── criar_estrutura.bat 
└── README.md

## Etapas de execução

1. Acesse o PostgreSQL com `psql`:

```bash
psql -U postgres -d intuitivecare_db

2. Execute os scripts em ordem:

\i 'CAMINHO_ABSOLUTO/scripts/01_create_tables.sql'
\i 'CAMINHO_ABSOLUTO/scripts/02_import_data.sql'
\i 'CAMINHO_ABSOLUTO/scripts/03_queries_analiticas.sql'

### 1. Criar as tabelas

```sql
\i scripts/01_create_tables.sql

\i scripts/02_import_data.sql

scripts/03_queries_analiticas.sql

Importante: os caminhos no 02_import_data.sql são absolutos e devem refletir o local onde os arquivos estão salvos na máquina.

Consultas analíticas

1. Top 10 operadoras com maiores despesas com SINISTROS no último trimestre
A consulta identifica o último trimestre com base nos dados importados (MAX(data)).

Filtra apenas as linhas com descrição contendo "SINISTROS" (case-insensitive).

Agrupa por operadora e soma os saldos finais.

2. Top 10 operadoras com maiores despesas com SINISTROS no último ano
Baseado no EXTRACT(YEAR FROM data) mais recente.

Mesmo filtro por "SINISTROS" e agrupamento.

Observações
Alguns arquivos CSV exigem encoding UTF8 com separador ;.

Os campos valor_saldo_inicial e valor_saldo_final são importados como texto por conterem vírgula decimal. As queries usam REPLACE(..., ',', '.')::NUMERIC para tratamento.

