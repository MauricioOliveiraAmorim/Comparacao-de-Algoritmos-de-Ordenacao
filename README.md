# 📊 Análise Comparativa de Algoritmos de Ordenação

## 🎯 Objetivo do Projeto

Este projeto realiza uma **análise comparativa rigorosa** entre três dos principais algoritmos de ordenação: **Merge Sort**, **Quick Sort** e **Heap Sort**. O objetivo é avaliar o desempenho desses algoritmos sob diferentes condições, medindo tempo de execução, número de comparações e trocas realizadas.

## 📖 Sobre os Algoritmos

### **Merge Sort**
- **Complexidade**: O(n log n) em todos os casos
- **Características**: Algoritmo estável, divide-e-conquista
- **Melhor para**: Dados que precisam ser ordenados de forma consistente

### **Quick Sort**
- **Complexidade**: O(n log n) em média, O(n²) no pior caso
- **Características**: In-place, muito eficiente na prática
- **Estratégias de Pivô**: 
  - Primeiro elemento
  - Elemento aleatório
  - Mediana de três
- **Melhor para**: Conjuntos de dados gerais com excelente desempenho médio

### **Heap Sort**
- **Complexidade**: O(n log n) em todos os casos
- **Características**: In-place, eficiente em espaço
- **Melhor para**: Situações onde o pior caso deve ser evitado

## 📁 Estrutura do Projeto

```
Ordenação/
├── src/
│   ├── App.java              # Programa principal
│   ├── MergeSort.java        # Implementação do Merge Sort
│   ├── QuickSort.java        # Implementação do Quick Sort
│   ├── HeapSort.java         # Implementação do Heap Sort
│   └── MatrizCSV.java        # Gerenciador de dados CSV
├── Colab/
│   └── Grafico.ipynb         # Análise visual e gráficos
├── bin/                      # Arquivos compilados
├── Ordenação.csv             # Dados gerados pela execução
└── README.md                 # Este arquivo
```

## 🚀 Como Usar

### Pré-requisitos
- Java JDK 8 ou superior instalado

### Compilação e Execução

1. **Compile o projeto**:
```bash
javac -d bin src/*.java
```

2. **Execute o programa**:
```bash
java -cp bin App
```

3. **Siga as instruções do programa**:
   - Digite o tamanho do vetor a testar (ex: 1000, 10000, 100000)
   - Digite o número de repetições (K) para cada teste
   - Escolha a estratégia de pivô para o Quick Sort

### Saída
O programa gerará um arquivo **Ordenação.csv** com os seguintes dados:
- Tamanho do vetor (n)
- Tipo de distribuição dos dados
- Algoritmo utilizado
- Complexidade teórica
- Tempo de execução (ms)
- Número de comparações
- Número de trocas

## 📊 Análise de Resultados

### Google Colab
Os resultados são analisados e visualizados através de gráficos interativos no Jupyter Notebook (`Colab/Grafico.ipynb`):

- **Gráficos de barras**: Comparação de tempo médio entre algoritmos
- **Análise por distribuição**: Avaliação de desempenho em diferentes cenários
- **Métricas de desempenho**: Visualização de comparações e trocas realizadas

Para usar o notebook:
1. Acesse [Google Colab](https://colab.research.google.com/)
2. Faça upload do arquivo **Ordenação.csv**
3. Execute o notebook para gerar os gráficos

## 📈 Insights Esperados

Durante a execução do projeto, é possível observar:

✅ **Merge Sort**: Desempenho consistente O(n log n) em todos os cenários  
✅ **Quick Sort**: Excelente desempenho médio com diferentes estratégias de pivô  
✅ **Heap Sort**: Proteção contra o pior caso, mantendo sempre O(n log n)  

## 🔍 Detalhes da Implementação

- Cada algoritmo mede separadamente o número de **comparações** e **trocas**
- Os testes utilizam dados com distribuição **aleatória**
- As medições de tempo utilizam nanosegundos para precisão
- Múltiplas repetições (K) são executadas para gerar uma média confiável

## 📝 Autor

Projeto desenvolvido como análise educacional de algoritmos de ordenação.

---

**Última atualização**: 2026
