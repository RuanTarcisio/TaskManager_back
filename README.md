# TaskManager API - Gerenciamento de Tarefas (Todo)
#### -- EM DESENVOLVIMENTO / ON DEVELOPMENT --

TaskManager é uma API RESTful projetada para gerenciar tarefas (Todos), com funcionalidades de criação, atualização, exclusão e consulta de tarefas, além de suporte a auditoria e uso do padrão State para gerenciar o ciclo de vida de cada tarefa.

## Tecnologias usadas neste projeto:

<div style="display: inline_block">
	<img align="center" alt="java" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
	<img align="center" alt="spring" src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" />
	<img align="center" alt="postgresql" src="https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=black" />
	<img align="center" alt="hibernate" src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=black" />
</div>

<br/>

Funcionalidades Principais
Criação de Tarefas: Permite adicionar novas tarefas com título, descrição, data de previsão para conclusão e tags.
Atualização de Tarefas: Modifique detalhes como título, descrição e data de uma tarefa existente.
Listagem de Tarefas: Exibe todas as tarefas ou apenas as do usuário autenticado.
Mudança de Estado: Utiliza o padrão State para alternar entre os estados NEW, IN_PROGRESS, e COMPLETED, CANCELED e REOPENED.
Auditoria: Monitora e registra alterações nos dados de tarefas, identificando quem fez as modificações e quando ocorreram.
Endpoints:

Auditoria com Hibernate Envers
A API implementa auditoria com o Hibernate Envers para rastrear todas as modificações feitas nas entidades Todo. Isso permite monitorar quem realizou as alterações e quais campos foram modificados. Uma tabela de auditoria separada (Todo_AUD) é criada para armazenar essas informações, ajudando na rastreabilidade.

Exemplo de Auditoria:
Modificações capturadas: Título, descrição, estado, data de previsão de conclusão.
Quem fez a modificação: Usuário autenticado responsável pela mudança.
Quando ocorreu: Data e hora da modificação.
Padrão de Projeto: State
Para gerenciar o ciclo de vida das tarefas, o padrão State foi aplicado, facilitando a transição de estados (PENDING, IN_PROGRESS, COMPLETED). Cada tarefa passa por uma sequência de estados claramente definidos, garantindo um controle organizado das etapas de execução.

Ciclo de Vida do Todo:

Tecnologias Utilizadas
Java 17+
Spring Boot 3.3.3
Hibernate 6.6.1.Final com Envers
Maven para gerenciamento de dependências
PostgreSQL
Como Rodar o Projeto
Clone o repositório:

bash
Copiar código
git clone https://github.com/RuanTarcisio/TaskManager_back.git
Navegue até o diretório do projeto:

bash
Copiar código
cd TaskManager_back
Execute o projeto:

bash
Copiar código
mvn spring-boot:run
Acesse a documentação interativa:

Acesse http://localhost:8080/swagger-ui.html para testar os endpoints.
Licença
Este projeto está licenciado sob os termos da licença MIT.

### __________________________________________________________________________________


TaskManager API - Todo Management
TaskManager is a RESTful API designed to manage Todos (tasks), providing functionalities to create, update, delete, and query tasks, along with auditing features and the use of the State design pattern to handle the task's lifecycle.

Main Features
Create Todos: Add new tasks with title, description, expected completion date, and tags.
Update Todos: Modify details such as title, description, and due date of an existing task.
List Todos: Display all tasks or filter by the authenticated user.
State Transitions: Uses the State pattern to switch between NEW, IN_PROGRESS, and COMPLETED, CANCELED and REOPEND task states.
Auditing: Tracks and records changes made to task data, identifying who made the modifications and when.

** Endpoints

Auditing with Hibernate Envers
The API implements auditing with Hibernate Envers to track all modifications made to Todo entities. This enables monitoring of who made the changes and which fields were modified. A separate audit table (Todo_AUD) is created to store this information, ensuring data traceability.

Audit Example:
Captured changes: Title, description, state, and expected completion date.
Who made the change: The authenticated user responsible for the modification.
When it occurred: Date and time of the modification.
Design Pattern: State
The State design pattern is used to manage the lifecycle of a Todo, enabling clear transitions between task states (PENDING, IN_PROGRESS, and COMPLETED). This ensures an organized flow for task execution.

Todo Lifecycle:
PENDING: When the task is created.
IN_PROGRESS: When the task is being worked on.
COMPLETED: When the task is completed.
Technologies Used
Java 17+
Spring Boot 3.3.3
Hibernate 6.6.1.Final with Envers
Maven for dependency management
PostgreSQL
How to Run the Project
Clone the repository:

bash
git clone https://github.com/RuanTarcisio/TaskManager_back.git
Navigate to the project directory:

bash
cd TaskManager_back
Run the project:

bash
mvn spring-boot:run
Access the interactive documentation:

Go to http://localhost:8080/swagger-ui.html to test the API endpoints.
License
This project is licensed under the terms of the MIT License.


