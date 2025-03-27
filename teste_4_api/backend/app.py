from flask import Flask, request, jsonify, make_response
from flask_cors import CORS
import csv
import json

app = Flask(__name__)
CORS(app)

# Carrega os dados CSV
operadoras = []
with open('../../teste_3_banco_dados/dados/operadoras_ativas.csv', newline='', encoding='utf-8') as csvfile:
    reader = csv.DictReader(csvfile, delimiter=';')
    operadoras = list(reader)

@app.route('/search')
def search_operadoras():
    query = request.args.get('q', '').lower()
    if not query:
        return make_response(json.dumps([], ensure_ascii=False), 200, {"Content-Type": "application/json; charset=utf-8"})

    resultados = [
        op for op in operadoras
        if query in op['Razao_Social'].lower() or query in op['Nome_Fantasia'].lower()
    ]

    return make_response(json.dumps(resultados[:10], ensure_ascii=False), 200, {"Content-Type": "application/json; charset=utf-8"})

if __name__ == '__main__':
    app.run(debug=True)
