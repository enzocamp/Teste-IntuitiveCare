<template>
  <div id="app">
    <h1>🔍 Busca de Operadoras</h1>
    <input
      v-model="query"
      @input="buscarOperadoras"
      placeholder="Digite o nome da operadora"
    />

    <ul v-if="operadoras.length > 0" class="lista-resultados">
      <li v-for="op in operadoras" :key="op['CNPJ']" class="card-operadora">
        <strong>{{ op['Razao_Social'] }}</strong><br />
        CNPJ: {{ op['CNPJ'] }}<br />
        Nome Fantasia: {{ op['Nome_Fantasia'] || 'Não informado' }}
      </li>
    </ul>

    <p v-else-if="query.length >= 2" class="nenhum">Nenhum resultado encontrado.</p>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      query: '',
      operadoras: []
    }
  },
  methods: {
    buscarOperadoras() {
      if (this.query.length < 2) {
        this.operadoras = []
        return
      }

      fetch(`http://127.0.0.1:5000/search?q=${this.query}`)
        .then(response => response.json())
        .then(data => {
          this.operadoras = data
        })
        .catch(err => {
          console.error('Erro ao buscar operadoras:', err)
        })
    }
  }
}
</script>

<style>
body {
  background-color: #f9f9f9;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

#app {
  text-align: center;
  margin: 40px auto;
  max-width: 800px;
}

input {
  width: 80%;
  max-width: 600px;
  padding: 12px;
  border: 2px solid #ccc;
  border-radius: 8px;
  font-size: 16px;
  margin-bottom: 20px;
}

.lista-resultados {
  list-style-type: none;
  padding: 0;
  margin-top: 20px;
}

.card-operadora {
  background-color: #fff;
  padding: 15px;
  margin-bottom: 10px;
  border-radius: 8px;
  text-align: left;
  box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
}

.nenhum {
  color: #999;
  font-style: italic;
}
</style>
