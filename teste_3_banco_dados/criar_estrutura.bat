@echo off
echo Criando estrutura do Teste 3 - Banco de Dados...

mkdir scripts
mkdir dados
mkdir dados\demonstracoes_2023
mkdir dados\demonstracoes_2024

type nul > scripts\01_create_tables.sql
type nul > scripts\02_import_data.sql
type nul > scripts\03_queries_analiticas.sql
type nul > README.md

echo Estrutura criada com sucesso!
pause
