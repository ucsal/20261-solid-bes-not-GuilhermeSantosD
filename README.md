 Refatoração do Sistema das Olimpíadas | Aplicação dos Princípios SOLID

Este projeto documenta a refatoração de um sistema legado de gerenciamento de Olimpíadas. O código original, embora funcional, centralizava muitas responsabilidades em uma única classe (God Class), o que dificultava a manutenção e a criação de testes automatizados. O objetivo desta atualização foi aplicar os cinco princípios do SOLID para tornar a arquitetura mais modular, flexível e fácil de manter.

Abaixo, eu detalho como cada princípio foi aplicado na prática:

1. SRP – Single Responsibility Principle (Princípio da Responsabilidade Única)
O Problema: A classe "App.java" concentrava múltiplas funções, desde a leitura de dados do usuário e impressão do tabuleiro até o cálculo das notas e o armazenamento em memória.
A Solução: O código foi dividido para que cada classe tenha apenas uma razão para mudar:
Repositórios: Classes específicas (ex: "ParticipanteRepository") foram criadas para lidar exclusivamente com o armazenamento e a listagem de entidades.
Serviços: A regra de negócio principal, como o cálculo de notas e a coordenação de cadastros, foi isolada no OlimpiadaService".
UI/Formatação: A lógica visual de imprimir o tabuleiro de xadrez a partir de uma string FEN foi extraída para a classe "ChessboardPrinter".

2. OCP – Open/Closed Principle (Princípio Aberto/Fechado)
A Solução:O sistema agora depende de Interfaces para os repositórios e serviços, tornando-se "aberto para extensões, mas fechado para modificações".
Benefício: Se no futuro for necessário substituir o armazenamento em memória por um banco de dados real (como MySQL ou PostgreSQL), não será preciso alterar uma única linha lógica do "OlimpiadaService". Basta criar uma nova implementação da interface de repositório e injetá-la.

3. LSP – Liskov Substitution Principle (Princípio da Substituição de Liskov)
A Solução:Foram criados contratos claros através de interfaces, como a "IParticipanteRepository".
Benefício: O "OlimpiadaService" depende desses contratos, garantindo que qualquer implementação válida (seja em memória, arquivo ou banco de dados) possa ser usada de forma intercambiável, sem que o serviço base precise conhecer os detalhes internos e sem quebrar o sistema.

4. ISP – Interface Segregation Principle (Princípio da Segregação da Interface)
A Solução: Em vez de uma interface "mestra" gigantesca para acessar todos os dados, o sistema utiliza interfaces menores e focadas.
Benefício: Isso evita que as classes sejam obrigadas a implementar métodos inúteis para o seu contexto. O repositório de participantes só conhece os métodos de participantes, e o de questões lida apenas com questões, garantindo alta coesão.

5. DIP – Dependency Inversion Principle (Princípio da Inversão de Dependência)
A Solução: Classes de alto nível, como o "OlimpiadaService" e o "App.java", deixaram de depender de implementações concretas e passaram a depender estritamente de abstrações (interfaces).
Benefício: O serviço não "sabe" como os dados estão sendo guardados, apenas que existe um contrato (ex: "IProvaRepository") capaz de realizar as operações necessárias. Esse desacoplamento foi fundamental para viabilizar a criação de testes unitários eficientes.

 Como Executar o Projeto

O arquivo "pom.xml" foi ajustado para garantir o funcionamento correto e a compatibilidade com a versão atual do Java 22. Siga os passos abaixo no terminal:

1. Compilar o projeto:
bash
./mvnw clean compile


2. Rodar os Testes(Validação da testabilidade pós-refatoração):
bash
./mvnw test


3. Executar a Aplicação:
bash
./mvnw exec:java -Dexec.mainClass="br.com.ucsal.olimpiadas.App"

